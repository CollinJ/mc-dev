package net.minecraft.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

class NetworkAcceptThread extends Thread {

    final MinecraftServer a; /* synthetic field */
    final NetworkListenThread b; /* synthetic field */

    NetworkAcceptThread(NetworkListenThread networklistenthread, String s, MinecraftServer minecraftserver) {
        super(s);
        b = networklistenthread;
        a = minecraftserver;
    }

    public void run() {
        HashMap hashmap = new HashMap();

        do {
            if (!b.b) {
                break;
            }
            try {
                Socket socket = NetworkListenThread.a(b).accept();

                if (socket != null) {
                    java.net.InetAddress inetaddress = socket.getInetAddress();

                    if (hashmap.containsKey(((inetaddress))) && System.currentTimeMillis() - ((Long) hashmap.get(((inetaddress)))).longValue() < 5000L) {
                        hashmap.put(((inetaddress)), ((Long.valueOf(System.currentTimeMillis()))));
                        socket.close();
                    } else {
                        hashmap.put(((inetaddress)), ((Long.valueOf(System.currentTimeMillis()))));
                        NetLoginHandler netloginhandler = new NetLoginHandler(a, socket, (new StringBuilder()).append("Connection #").append(NetworkListenThread.b(b)).toString());

                        NetworkListenThread.a(b, netloginhandler);
                    }
                }
            } catch (IOException ioexception) {
                ioexception.printStackTrace();
            }
        } while (true);
    }
}
