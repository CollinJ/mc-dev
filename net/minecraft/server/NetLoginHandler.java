package net.minecraft.server;

import java.net.Socket;
import java.util.Random;
import java.util.logging.Logger;

public class NetLoginHandler extends NetHandler {

    public static Logger a = Logger.getLogger("Minecraft");
    private static Random d = new Random();
    public NetworkManager b;
    public boolean c;
    private MinecraftServer e;
    private int f;
    private String g;
    private Packet1Login h;
    private String i;

    public NetLoginHandler(MinecraftServer minecraftserver, Socket socket, String s) {
        c = false;
        f = 0;
        g = null;
        h = null;
        i = "";
        e = minecraftserver;
        b = new NetworkManager(socket, s, ((NetHandler) (this)));
        b.d = 0;
    }

    public void a() {
        if (h != null) {
            b(h);
            h = null;
        }
        if (f++ == 600) {
            a("Took too long to log in");
        } else {
            b.a();
        }
    }

    public void a(String s) {
        try {
            a.info((new StringBuilder()).append("Disconnecting ").append(b()).append(": ").append(s).toString());
            b.a(((Packet) (new Packet255KickDisconnect(s))));
            b.c();
            c = true;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void a(Packet2Handshake packet2handshake) {
        if (e.l) {
            i = Long.toHexString(d.nextLong());
            b.a(((Packet) (new Packet2Handshake(i))));
        } else {
            b.a(((Packet) (new Packet2Handshake("-"))));
        }
    }

    public void a(Packet1Login packet1login) {
        g = packet1login.b;
        if (packet1login.a != 8) {
            if (packet1login.a > 8) {
                a("Outdated server!");
            } else {
                a("Outdated client!");
            }
            return;
        }
        if (!e.l) {
            b(packet1login);
        } else {
            (new ThreadLoginVerifier(this, packet1login)).start();
        }
    }

    public void b(Packet1Login packet1login) {
        EntityPlayerMP entityplayermp = e.f.a(this, packet1login.b, packet1login.c);

        if (entityplayermp != null) {
            a.info((new StringBuilder()).append(b()).append(" logged in with entity id ").append(entityplayermp.g).toString());
            NetServerHandler netserverhandler = new NetServerHandler(e, b, entityplayermp);

            netserverhandler.b(((Packet) (new Packet1Login("", "", entityplayermp.g, e.e.u, (byte) e.e.q.g))));
            netserverhandler.b(((Packet) (new Packet6SpawnPosition(e.e.m, e.e.n, e.e.o))));
            e.f.a(((Packet) (new Packet3Chat((new StringBuilder()).append("\247e").append(entityplayermp.aw).append(" joined the game.").toString()))));
            e.f.a(entityplayermp);
            netserverhandler.a(entityplayermp.p, entityplayermp.q, entityplayermp.r, entityplayermp.v, entityplayermp.w);
            e.c.a(netserverhandler);
            netserverhandler.b(((Packet) (new Packet4UpdateTime(e.e.e))));
            entityplayermp.l();
        }
        c = true;
    }

    public void a(String s, Object aobj[]) {
        a.info((new StringBuilder()).append(b()).append(" lost connection").toString());
        c = true;
    }

    public void a(Packet packet) {
        a("Protocol error");
    }

    public String b() {
        if (g != null) {
            return (new StringBuilder()).append(g).append(" [").append(((b.b())).toString()).append("]").toString();
        } else {
            return ((b.b())).toString();
        }
    }

    static String a(NetLoginHandler netloginhandler) {
        return netloginhandler.i;
    }

    static Packet1Login a(NetLoginHandler netloginhandler, Packet1Login packet1login) {
        return netloginhandler.h = packet1login;
    }
}
