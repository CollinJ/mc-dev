package net.minecraft.server;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;

public class ServerConfigurationManager {

    public static Logger a = Logger.getLogger("Minecraft");
    public List b;
    private MinecraftServer c;
    private PlayerManager d;
    private int e;
    private Set f;
    private Set g;
    private Set h;
    private File i;
    private File j;
    private File k;
    private PlayerNBTManager l;

    public ServerConfigurationManager(MinecraftServer minecraftserver) {
        b = ((List) (new ArrayList()));
        f = ((Set) (new HashSet()));
        g = ((Set) (new HashSet()));
        h = ((Set) (new HashSet()));
        c = minecraftserver;
        i = minecraftserver.a("banned-players.txt");
        j = minecraftserver.a("banned-ips.txt");
        k = minecraftserver.a("ops.txt");
        d = new PlayerManager(minecraftserver);
        e = minecraftserver.d.a("max-players", 20);
        e();
        g();
        i();
        f();
        h();
        j();
    }

    public void a(WorldServer worldserver) {
        l = new PlayerNBTManager(new File(worldserver.s, "players"));
    }

    public int a() {
        return d.b();
    }

    public void a(EntityPlayerMP entityplayermp) {
        b.add(((entityplayermp)));
        l.b(entityplayermp);
        c.e.y.d((int) entityplayermp.l >> 4, (int) entityplayermp.n >> 4);
        for (; c.e.a(((Entity) (entityplayermp)), entityplayermp.v).size() != 0; entityplayermp.a(entityplayermp.l, entityplayermp.m + 1.0D, entityplayermp.n)) {
            ;
        }
        c.e.a(((Entity) (entityplayermp)));
        d.a(entityplayermp);
    }

    public void b(EntityPlayerMP entityplayermp) {
        d.c(entityplayermp);
    }

    public void c(EntityPlayerMP entityplayermp) {
        d.b(entityplayermp);
        l.a(entityplayermp);
        c.e.d(((Entity) (entityplayermp)));
        b.remove(((entityplayermp)));
    }

    public EntityPlayerMP a(NetLoginHandler netloginhandler, String s, String s1) {
        if (f.contains(((s.trim().toLowerCase())))) {
            netloginhandler.b("You are banned from this server!");
            return null;
        }
        String s2 = ((netloginhandler.b.b())).toString();

        s2 = s2.substring(s2.indexOf("/") + 1);
        s2 = s2.substring(0, s2.indexOf(":"));
        if (g.contains(((s2)))) {
            netloginhandler.b("Your IP address is banned from this server!");
            return null;
        }
        if (b.size() >= e) {
            netloginhandler.b("The server is full!");
            return null;
        }
        for (int i1 = 0; i1 < b.size(); i1++) {
            EntityPlayerMP entityplayermp = (EntityPlayerMP) b.get(i1);

            if (entityplayermp.aq.equalsIgnoreCase(s)) {
                entityplayermp.a.c("You logged in from another location");
            }
        }

        return new EntityPlayerMP(c, ((World) (c.e)), s, new ItemInWorldManager(((World) (c.e))));
    }

    public void b() {
        d.a();
    }

    public void a(int i1, int j1, int k1) {
        d.a(i1, j1, k1);
    }

    public void a(Packet packet) {
        for (int i1 = 0; i1 < b.size(); i1++) {
            EntityPlayerMP entityplayermp = (EntityPlayerMP) b.get(i1);

            entityplayermp.a.b(packet);
        }
    }

    public String c() {
        String s = "";

        for (int i1 = 0; i1 < b.size(); i1++) {
            if (i1 > 0) {
                s = (new StringBuilder()).append(s).append(", ").toString();
            }
            s = (new StringBuilder()).append(s).append(((EntityPlayerMP) b.get(i1)).aq).toString();
        }

        return s;
    }

    public void a(String s) {
        f.add(((s.toLowerCase())));
        f();
    }

    public void b(String s) {
        f.remove(((s.toLowerCase())));
        f();
    }

    private void e() {
        try {
            f.clear();
            BufferedReader bufferedreader = new BufferedReader(((java.io.Reader) (new FileReader(i))));

            for (String s = ""; (s = bufferedreader.readLine()) != null;) {
                f.add(((s.trim().toLowerCase())));
            }

            bufferedreader.close();
        } catch (Exception exception) {
            a.warning((new StringBuilder()).append("Failed to load ban list: ").append(((exception))).toString());
        }
    }

    private void f() {
        try {
            PrintWriter printwriter = new PrintWriter(((java.io.Writer) (new FileWriter(i, false))));
            String s;

            for (Iterator iterator = f.iterator(); iterator.hasNext(); printwriter.println(s)) {
                s = (String) iterator.next();
            }

            printwriter.close();
        } catch (Exception exception) {
            a.warning((new StringBuilder()).append("Failed to save ban list: ").append(((exception))).toString());
        }
    }

    public void c(String s) {
        g.add(((s.toLowerCase())));
        h();
    }

    public void d(String s) {
        g.remove(((s.toLowerCase())));
        h();
    }

    private void g() {
        try {
            g.clear();
            BufferedReader bufferedreader = new BufferedReader(((java.io.Reader) (new FileReader(j))));

            for (String s = ""; (s = bufferedreader.readLine()) != null;) {
                g.add(((s.trim().toLowerCase())));
            }

            bufferedreader.close();
        } catch (Exception exception) {
            a.warning((new StringBuilder()).append("Failed to load ip ban list: ").append(((exception))).toString());
        }
    }

    private void h() {
        try {
            PrintWriter printwriter = new PrintWriter(((java.io.Writer) (new FileWriter(j, false))));
            String s;

            for (Iterator iterator = g.iterator(); iterator.hasNext(); printwriter.println(s)) {
                s = (String) iterator.next();
            }

            printwriter.close();
        } catch (Exception exception) {
            a.warning((new StringBuilder()).append("Failed to save ip ban list: ").append(((exception))).toString());
        }
    }

    public void e(String s) {
        h.add(((s.toLowerCase())));
        j();
    }

    public void f(String s) {
        h.remove(((s.toLowerCase())));
        j();
    }

    private void i() {
        try {
            h.clear();
            BufferedReader bufferedreader = new BufferedReader(((java.io.Reader) (new FileReader(k))));

            for (String s = ""; (s = bufferedreader.readLine()) != null;) {
                h.add(((s.trim().toLowerCase())));
            }

            bufferedreader.close();
        } catch (Exception exception) {
            a.warning((new StringBuilder()).append("Failed to load ip ban list: ").append(((exception))).toString());
        }
    }

    private void j() {
        try {
            PrintWriter printwriter = new PrintWriter(((java.io.Writer) (new FileWriter(k, false))));
            String s;

            for (Iterator iterator = h.iterator(); iterator.hasNext(); printwriter.println(s)) {
                s = (String) iterator.next();
            }

            printwriter.close();
        } catch (Exception exception) {
            a.warning((new StringBuilder()).append("Failed to save ip ban list: ").append(((exception))).toString());
        }
    }

    public boolean g(String s) {
        return h.contains(((s.trim().toLowerCase())));
    }

    public EntityPlayerMP h(String s) {
        for (int i1 = 0; i1 < b.size(); i1++) {
            EntityPlayerMP entityplayermp = (EntityPlayerMP) b.get(i1);

            if (entityplayermp.aq.equalsIgnoreCase(s)) {
                return entityplayermp;
            }
        }

        return null;
    }

    public void a(String s, String s1) {
        EntityPlayerMP entityplayermp = h(s);

        if (entityplayermp != null) {
            entityplayermp.a.b(((Packet) (new Packet3Chat(s1))));
        }
    }

    public void i(String s) {
        Packet3Chat packet3chat = new Packet3Chat(s);

        for (int i1 = 0; i1 < b.size(); i1++) {
            EntityPlayerMP entityplayermp = (EntityPlayerMP) b.get(i1);

            if (g(entityplayermp.aq)) {
                entityplayermp.a.b(((Packet) (packet3chat)));
            }
        }
    }

    public boolean a(String s, Packet packet) {
        EntityPlayerMP entityplayermp = h(s);

        if (entityplayermp != null) {
            entityplayermp.a.b(packet);
            return true;
        } else {
            return false;
        }
    }

    public void a(int i1, int j1, int k1, TileEntity tileentity) {
        d.a(((Packet) (new Packet59ComplexEntity(i1, j1, k1, tileentity))), i1, j1, k1);
    }

    public void d() {
        for (int i1 = 0; i1 < b.size(); i1++) {
            l.a((EntityPlayerMP) b.get(i1));
        }
    }
}