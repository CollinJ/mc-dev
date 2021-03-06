package net.minecraft.server;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NetworkListenThread {

    public static Logger a = Logger.getLogger("Minecraft");
    private ServerSocket d;
    private Thread e;
    public volatile boolean b;
    private int f;
    private ArrayList g;
    private ArrayList h;
    public MinecraftServer c;

    public NetworkListenThread(MinecraftServer minecraftserver, InetAddress inetaddress, int i) {
        b = false;
        f = 0;
        g = new ArrayList();
        h = new ArrayList();
        c = minecraftserver;
        d = new ServerSocket(i, 0, inetaddress);
        d.setPerformancePreferences(0, 2, 1);
        b = true;
        e = ((Thread) (new NetworkAcceptThread(this, "Listen thread", minecraftserver)));
        e.start();
    }

    public void a(NetServerHandler netserverhandler) {
        h.add(((netserverhandler)));
    }

    private void a(NetLoginHandler netloginhandler) {
        if (netloginhandler == null) {
            throw new IllegalArgumentException("Got null pendingconnection!");
        } else {
            g.add(((netloginhandler)));
            return;
        }
    }

    public void a() {
        for (int i = 0; i < g.size(); i++) {
            NetLoginHandler netloginhandler = (NetLoginHandler) g.get(i);

            try {
                netloginhandler.a();
            } catch (Exception exception) {
                netloginhandler.a("Internal server error");
                a.log(Level.WARNING, (new StringBuilder()).append("Failed to handle packet: ").append(((exception))).toString(), ((Throwable) (exception)));
            }
            if (netloginhandler.c) {
                g.remove(i--);
            }
        }

        for (int j = 0; j < h.size(); j++) {
            NetServerHandler netserverhandler = (NetServerHandler) h.get(j);

            try {
                netserverhandler.a();
            } catch (Exception exception1) {
                a.log(Level.WARNING, (new StringBuilder()).append("Failed to handle packet: ").append(((exception1))).toString(), ((Throwable) (exception1)));
                netserverhandler.a("Internal server error");
            }
            if (netserverhandler.c) {
                h.remove(j--);
            }
        }
    }

    static ServerSocket a(NetworkListenThread networklistenthread) {
        return networklistenthread.d;
    }

    static int b(NetworkListenThread networklistenthread) {
        return networklistenthread.f++;
    }

    static void a(NetworkListenThread networklistenthread, NetLoginHandler netloginhandler) {
        networklistenthread.a(netloginhandler);
    }
}
