package net.minecraft.server;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

public class NetServerHandler extends NetHandler implements ICommandListener {

    public static Logger a = Logger.getLogger("Minecraft");
    public NetworkManager b;
    public boolean c;
    private MinecraftServer d;
    private EntityPlayerMP e;
    private int f;
    private double g;
    private double h;
    private double i;
    private boolean j;
    private ItemStack k;

    public NetServerHandler(MinecraftServer minecraftserver, NetworkManager networkmanager, EntityPlayerMP entityplayermp) {
        c = false;
        f = 0;
        j = true;
        k = null;
        d = minecraftserver;
        b = networkmanager;
        networkmanager.a(((NetHandler) (this)));
        e = entityplayermp;
        entityplayermp.a = this;
    }

    public void a() {
        b.a();
        if (f++ % 20 == 0) {
            b.a(((Packet) (new Packet0KeepAlive())));
        }
    }

    public void c(String s) {
        b.a(((Packet) (new Packet255KickDisconnect(s))));
        b.c();
        d.f.c(e);
        c = true;
    }

    public void a(Packet10Flying packet10flying) {
        if (!j) {
            double d1 = packet10flying.b - h;

            if (packet10flying.a == g && d1 * d1 < 0.01D && packet10flying.c == i) {
                j = true;
            }
        }
        if (j) {
            g = e.l;
            h = e.m;
            i = e.n;
            double d2 = e.l;
            double d3 = e.m;
            double d4 = e.n;
            float f1 = e.r;
            float f2 = e.s;

            if (packet10flying.h) {
                d2 = packet10flying.a;
                d3 = packet10flying.b;
                d4 = packet10flying.c;
                double d5 = packet10flying.d - packet10flying.b;

                if (d5 > 1.6499999999999999D || d5 < 0.10000000000000001D) {
                    c("Illegal stance");
                    a.warning((new StringBuilder()).append(e.aq).append(" had an illegal stance: ").append(d5).toString());
                }
                e.ai = packet10flying.d;
            }
            if (packet10flying.i) {
                f1 = packet10flying.e;
                f2 = packet10flying.f;
            }
            e.i();
            e.M = 0.0F;
            e.b(g, h, i, f1, f2);
            double d6 = d2 - e.l;
            double d7 = d3 - e.m;
            double d8 = d4 - e.n;
            float f3 = 0.0625F;
            boolean flag = d.e.a(((Entity) (e)), e.v.b().e(f3, f3, f3)).size() == 0;

            e.c(d6, d7, d8);
            d6 = d2 - e.l;
            d7 = d3 - e.m;
            if (d7 > -0.5D || d7 < 0.5D) {
                d7 = 0.0D;
            }
            d8 = d4 - e.n;
            double d9 = d6 * d6 + d7 * d7 + d8 * d8;
            boolean flag1 = false;

            if (d9 > 0.0625D) {
                flag1 = true;
                a.warning((new StringBuilder()).append(e.aq).append(" moved wrongly!").toString());
            }
            e.b(d2, d3, d4, f1, f2);
            boolean flag2 = d.e.a(((Entity) (e)), e.v.b().e(f3, f3, f3)).size() == 0;

            if (flag && (flag1 || !flag2)) {
                a(g, h, i, f1, f2);
                return;
            }
            e.w = packet10flying.g;
            d.f.b(e);
        }
    }

    public void a(double d1, double d2, double d3, float f1, float f2) {
        j = false;
        g = d1;
        h = d2;
        i = d3;
        e.b(d1, d2, d3, f1, f2);
        e.a.b(((Packet) (new Packet13PlayerLookMove(d1, d2 + 1.6200000047683716D, d2, d3, f1, f2, false))));
    }

    public void a(Packet14BlockDig packet14blockdig) {
        e.aj.a[e.aj.d] = k;
        boolean flag = d.e.z = d.f.g(e.aq);
        boolean flag1 = false;

        if (packet14blockdig.e == 0) {
            flag1 = true;
        }
        if (packet14blockdig.e == 1) {
            flag1 = true;
        }
        if (flag1) {
            double d1 = e.m;

            e.m = e.ai;
            MovingObjectPosition movingobjectposition = e.a(4D, 1.0F);

            e.m = d1;
            if (movingobjectposition == null) {
                return;
            }
            if (movingobjectposition.b != packet14blockdig.a || movingobjectposition.c != packet14blockdig.b || movingobjectposition.d != packet14blockdig.c || movingobjectposition.e != packet14blockdig.d) {
                return;
            }
        }
        int i1 = packet14blockdig.a;
        int j1 = packet14blockdig.b;
        int l = packet14blockdig.c;
        int k1 = packet14blockdig.d;
        int l1 = (int) MathHelper.e(i1 - d.e.n);
        int i2 = (int) MathHelper.e(l - d.e.p);

        if (l1 > i2) {
            i2 = l1;
        }
        if (packet14blockdig.e == 0) {
            if (i2 > 16 || flag) {
                e.ad.a(i1, j1, l);
            }
        } else if (packet14blockdig.e == 2) {
            e.ad.a();
        } else if (packet14blockdig.e == 1) {
            if (i2 > 16 || flag) {
                e.ad.a(i1, j1, l, k1);
            }
        } else if (packet14blockdig.e == 3) {
            double d2 = e.l - ((double) i1 + 0.5D);
            double d3 = e.m - ((double) j1 + 0.5D);
            double d4 = e.n - ((double) l + 0.5D);
            double d5 = d2 * d2 + d3 * d3 + d4 * d4;

            if (d5 < 256D) {
                e.a.b(((Packet) (new Packet53BlockChange(i1, j1, l, ((World) (d.e))))));
            }
        }
        d.e.z = false;
    }

    public void a(Packet15Place packet15place) {
        boolean flag = d.e.z = d.f.g(e.aq);
        int l = packet15place.b;
        int i1 = packet15place.c;
        int j1 = packet15place.d;
        int k1 = packet15place.e;
        int l1 = (int) MathHelper.e(l - d.e.n);
        int i2 = (int) MathHelper.e(j1 - d.e.p);

        if (l1 > i2) {
            i2 = l1;
        }
        if (i2 > 16 || flag) {
            ItemStack itemstack = packet15place.a < 0 ? null : new ItemStack(packet15place.a);

            e.ad.a(((EntityPlayer) (e)), ((World) (d.e)), itemstack, l, i1, j1, k1);
        }
        e.a.b(((Packet) (new Packet53BlockChange(l, i1, j1, ((World) (d.e))))));
        d.e.z = false;
    }

    public void a(String s) {
        a.info((new StringBuilder()).append(e.aq).append(" lost connection: ").append(s).toString());
        d.f.c(e);
        c = true;
    }

    public void a(Packet packet) {
        a.warning((new StringBuilder()).append((((this).getClass()))).append(" wasn't prepared to deal with a ").append(((((packet)).getClass()))).toString());
        c("Protocol error, unexpected packet");
    }

    public void b(Packet packet) {
        b.a(packet);
    }

    public void a(Packet16BlockItemSwitch packet16blockitemswitch) {
        int l = packet16blockitemswitch.b;

        e.aj.d = e.aj.a.length - 1;
        if (l == 0) {
            k = null;
        } else {
            k = new ItemStack(l);
        }
        e.aj.a[e.aj.d] = k;
        d.k.a(((Entity) (e)), ((Packet) (new Packet16BlockItemSwitch(e.c, l))));
    }

    public void a(Packet21PickupSpawn packet21pickupspawn) {
        double d1 = (double) packet21pickupspawn.b / 32D;
        double d2 = (double) packet21pickupspawn.c / 32D;
        double d3 = (double) packet21pickupspawn.d / 32D;
        EntityItem entityitem = new EntityItem(((World) (d.e)), d1, d2, d3, new ItemStack(packet21pickupspawn.h, packet21pickupspawn.i));

        entityitem.o = (double) packet21pickupspawn.e / 128D;
        entityitem.p = (double) packet21pickupspawn.f / 128D;
        entityitem.q = (double) packet21pickupspawn.g / 128D;
        entityitem.ad = 10;
        d.e.a(((Entity) (entityitem)));
    }

    public void a(Packet3Chat packet3chat) {
        String s = packet3chat.a;

        if (s.length() > 100) {
            c("Chat message too long");
            return;
        }
        s = s.trim();
        for (int l = 0; l < s.length(); l++) {
            if (" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_'abcdefghijklmnopqrstuvwxyz{|}~\u2302\307\374\351\342\344\340\345\347\352\353\350\357\356\354\304\305\311\346\306\364\366\362\373\371\377\326\334\370\243\330\327\u0192\341\355\363\372\361\321\252\272\277\256\254\275\274\241\253\273".indexOf(((int) (s.charAt(l)))) < 0) {
                c("Illegal characters in chat");
                return;
            }
        }

        if (s.startsWith("/")) {
            d(s);
        } else {
            s = (new StringBuilder()).append("<").append(e.aq).append("> ").append(s).toString();
            a.info(s);
            d.f.a(((Packet) (new Packet3Chat(s))));
        }
    }

    private void d(String s) {
        if (s.toLowerCase().startsWith("/me ")) {
            s = (new StringBuilder()).append("* ").append(e.aq).append(" ").append(s.substring(s.indexOf(" ")).trim()).toString();
            a.info(s);
            d.f.a(((Packet) (new Packet3Chat(s))));
        } else if (s.toLowerCase().startsWith("/tell ")) {
            String as[] = s.split(" ");

            if (as.length >= 3) {
                s = s.substring(s.indexOf(" ")).trim();
                s = s.substring(s.indexOf(" ")).trim();
                s = (new StringBuilder()).append("\2477").append(e.aq).append(" whispers ").append(s).toString();
                a.info((new StringBuilder()).append(s).append(" to ").append(as[1]).toString());
                if (!d.f.a(as[1], ((Packet) (new Packet3Chat(s))))) {
                    b(((Packet) (new Packet3Chat("\247cThere's no player by that name online."))));
                }
            }
        } else if (s.toLowerCase().equalsIgnoreCase("/home")) {
            a.info((new StringBuilder()).append(e.aq).append(" returned home").toString());
            int l = d.e.d(d.e.n, d.e.p);

            a((double) d.e.n + 0.5D, (double) l + 1.5D, (double) d.e.p + 0.5D, 0.0F, 0.0F);
        } else if (s.toLowerCase().equalsIgnoreCase("/iron")) {
            if (MinecraftServer.b.containsKey(((e.aq)))) {
                a.info((new StringBuilder()).append(e.aq).append(" failed to iron!").toString());
                b(((Packet) (new Packet3Chat("\247cYou can't /iron again so soon!"))));
            } else {
                MinecraftServer.b.put(((e.aq)), ((Integer.valueOf(6000))));
                a.info((new StringBuilder()).append(e.aq).append(" ironed!").toString());
                for (int i1 = 0; i1 < 4; i1++) {
                    e.a(new ItemStack(Item.m, 1));
                }
            }
        } else if (s.toLowerCase().equalsIgnoreCase("/wood")) {
            if (MinecraftServer.b.containsKey(((e.aq)))) {
                a.info((new StringBuilder()).append(e.aq).append(" failed to wood!").toString());
                b(((Packet) (new Packet3Chat("\247cYou can't /wood again so soon!"))));
            } else {
                MinecraftServer.b.put(((e.aq)), ((Integer.valueOf(6000))));
                a.info((new StringBuilder()).append(e.aq).append(" wooded!").toString());
                for (int j1 = 0; j1 < 4; j1++) {
                    e.a(new ItemStack(Block.z, 1));
                }
            }
        } else if (d.f.g(e.aq)) {
            String s1 = s.substring(1);

            a.info((new StringBuilder()).append(e.aq).append(" issued server command: ").append(s1).toString());
            d.a(s1, ((ICommandListener) (this)));
        } else {
            String s2 = s.substring(1);

            a.info((new StringBuilder()).append(e.aq).append(" tried command: ").append(s2).toString());
        }
    }

    public void a(Packet18ArmAnimation packet18armanimation) {
        if (packet18armanimation.b == 1) {
            e.z();
        }
    }

    public void a(Packet255KickDisconnect packet255kickdisconnect) {
        b.a("Quitting");
    }

    public int b() {
        return b.d();
    }

    public void b(String s) {
        b(((Packet) (new Packet3Chat((new StringBuilder()).append("\2477").append(s).toString()))));
    }

    public String c() {
        return e.aq;
    }

    public void a(Packet5PlayerInventory packet5playerinventory) {
        if (packet5playerinventory.a == -1) {
            e.aj.a = packet5playerinventory.b;
        }
        if (packet5playerinventory.a == -2) {
            e.aj.c = packet5playerinventory.b;
        }
        if (packet5playerinventory.a == -3) {
            e.aj.b = packet5playerinventory.b;
        }
    }

    public void d() {
        b.a(((Packet) (new Packet5PlayerInventory(-1, e.aj.a))));
        b.a(((Packet) (new Packet5PlayerInventory(-2, e.aj.c))));
        b.a(((Packet) (new Packet5PlayerInventory(-3, e.aj.b))));
    }

    public void a(Packet59ComplexEntity packet59complexentity) {
        TileEntity tileentity = d.e.k(packet59complexentity.a, packet59complexentity.b, packet59complexentity.c);

        if (tileentity != null) {
            tileentity.a(packet59complexentity.e);
            tileentity.c();
        }
    }
}
