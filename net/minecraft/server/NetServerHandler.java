package net.minecraft.server;

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
    private String color;
    private ItemStack k;

    public NetServerHandler(MinecraftServer paramMinecraftServer, NetworkManager parambb, EntityPlayerMP paramea) {
        c = false;
        f = 0;
        j = true;
        k = null;
        d = paramMinecraftServer;
        b = parambb;
        parambb.a(((NetHandler) (this)));
        e = paramea;
        paramea.a = this;
        color = Integer.toHexString((int) (Math.random() * 15D));
    }

    public void a() {
        b.a();
        if (f++ % 20 == 0) {
            b.a(((Packet) (new Packet0KeepAlive())));
        }
    }

    public void c(String paramString) {
        b.a(((Packet) (new Packet255KickDisconnect(paramString))));
        b.c();
        d.f.c(e);
        c = true;
    }

    public void a(Packet10Flying paramgf) {
        if (!j) {
            double d1 = paramgf.b - h;

            if (paramgf.a == g && d1 * d1 < 0.01D && paramgf.c == i) {
                j = true;
            }
        }
        if (j) {
            g = e.l;
            h = e.m;
            i = e.n;
            double d1 = e.l;
            double d2 = e.m;
            double d3 = e.n;
            float f1 = e.r;
            float f2 = e.s;
            double d4;

            if (paramgf.h) {
                d1 = paramgf.a;
                d2 = paramgf.b;
                d3 = paramgf.c;
                d4 = paramgf.d - paramgf.b;
                if (d4 > 1.6499999999999999D || d4 < 0.10000000000000001D) {
                    c("Illegal stance");
                    a.warning((new StringBuilder()).append(e.aq).append(" had an illegal stance: ").append(d4).toString());
                }
                e.ai = paramgf.d;
            }
            if (paramgf.i) {
                f1 = paramgf.e;
                f2 = paramgf.f;
            }
            e.i();
            e.M = 0.0F;
            e.b(g, h, i, f1, f2);
            d4 = d1 - e.l;
            double d5 = d2 - e.m;
            double d6 = d3 - e.n;
            float f3 = 0.0625F;
            int l = ((int) (d.e.a(((Entity) (e)), e.v.b().e(f3, f3, f3)).size() != 0 ? 0 : 1));

            e.c(d4, d5, d6);
            d4 = d1 - e.l;
            d5 = d2 - e.m;
            if (d5 > -0.5D || d5 < 0.5D) {
                d5 = 0.0D;
            }
            d6 = d3 - e.n;
            double d7 = d4 * d4 + d5 * d5 + d6 * d6;
            int i1 = 0;

            if (d7 > 0.0625D) {
                i1 = 1;
                a.warning((new StringBuilder()).append(e.aq).append(" moved wrongly!").toString());
            }
            e.b(d1, d2, d3, f1, f2);
            int i2 = ((int) (d.e.a(((Entity) (e)), e.v.b().e(f3, f3, f3)).size() != 0 ? 0 : 1));

            if (l != 0 && (i1 != 0 || i2 == 0)) {
                a(g, h, i, f1, f2);
                return;
            }
            e.w = paramgf.g;
            d.f.b(e);
        }
    }

    public void a(double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat1, float paramFloat2) {
        j = false;
        g = paramDouble1;
        h = paramDouble2;
        i = paramDouble3;
        e.b(paramDouble1, paramDouble2, paramDouble3, paramFloat1, paramFloat2);
        e.a.b(((Packet) (new Packet13PlayerLookMove(paramDouble1, paramDouble2 + 1.620000004768372D, paramDouble2, paramDouble3, paramFloat1, paramFloat2, false))));
    }

    public void a(Packet14BlockDig paramhd) {
        e.aj.a[e.aj.d] = k;
        boolean bool = d.e.z = d.f.g(e.aq);
        int l = 0;

        if (paramhd.e == 0) {
            l = 1;
        }
        if (paramhd.e == 1) {
            l = 1;
        }
        if (l != 0) {
            double d1 = e.m;

            e.m = e.ai;
            MovingObjectPosition localfr = e.a(4D, 1.0F);

            e.m = d1;
            if (localfr == null) {
                return;
            }
            if (localfr.b != paramhd.a || localfr.c != paramhd.b || localfr.d != paramhd.c || localfr.e != paramhd.d) {
                return;
            }
        }
        int i1 = paramhd.a;
        int i2 = paramhd.b;
        int i3 = paramhd.c;
        int i4 = paramhd.d;
        int i5 = (int) MathHelper.e(i1 - d.e.n);
        int i6 = (int) MathHelper.e(i3 - d.e.p);

        if (i5 > i6) {
            i6 = i5;
        }
        if (paramhd.e == 0) {
            if (i6 > 16 || bool) {
                e.ad.a(i1, i2, i3);
            }
        } else if (paramhd.e == 2) {
            e.ad.a();
        } else if (paramhd.e == 1) {
            if (i6 > 16 || bool) {
                e.ad.a(i1, i2, i3, i4);
            }
        } else if (paramhd.e == 3) {
            double d2 = e.l - ((double) i1 + 0.5D);
            double d3 = e.m - ((double) i2 + 0.5D);
            double d4 = e.n - ((double) i3 + 0.5D);
            double d5 = d2 * d2 + d3 * d3 + d4 * d4;

            if (d5 < 256D) {
                e.a.b(((Packet) (new Packet53BlockChange(i1, i2, i3, ((World) (d.e))))));
            }
        }
        d.e.z = false;
    }

    public void a(Packet15Place paramfe) {
        boolean bool = d.e.z = d.f.g(e.aq);
        int l = paramfe.b;
        int i1 = paramfe.c;
        int i2 = paramfe.d;
        int i3 = paramfe.e;
        int i4 = (int) MathHelper.e(l - d.e.n);
        int i5 = (int) MathHelper.e(i2 - d.e.p);

        if (i4 > i5) {
            i5 = i4;
        }
        if (i5 > 16 || bool) {
            ItemStack localgp = paramfe.a < 0 ? null : new ItemStack(paramfe.a);

            e.ad.a(((EntityPlayer) (e)), ((World) (d.e)), localgp, l, i1, i2, i3);
        }
        e.a.b(((Packet) (new Packet53BlockChange(l, i1, i2, ((World) (d.e))))));
        d.e.z = false;
    }

    public void a(String paramString) {
        a.info((new StringBuilder()).append(e.aq).append(" lost connection: ").append(paramString).toString());
        d.f.c(e);
        c = true;
    }

    public void a(Packet paramhp) {
        a.warning((new StringBuilder()).append((((this).getClass()))).append(" wasn't prepared to deal with a ").append(((((paramhp)).getClass()))).toString());
        c("Protocol error, unexpected packet");
    }

    public void b(Packet paramhp) {
        b.a(paramhp);
    }

    public void a(Packet16BlockItemSwitch paramfv) {
        int l = paramfv.b;

        e.aj.d = e.aj.a.length - 1;
        if (l == 0) {
            k = null;
        } else {
            k = new ItemStack(l);
        }
        e.aj.a[e.aj.d] = k;
        d.k.a(((Entity) (e)), ((Packet) (new Packet16BlockItemSwitch(e.c, l))));
    }

    public void a(Packet21PickupSpawn paramk) {
        double d1 = (double) paramk.b / 32D;
        double d2 = (double) paramk.c / 32D;
        double d3 = (double) paramk.d / 32D;
        EntityItem localfn = new EntityItem(((World) (d.e)), d1, d2, d3, new ItemStack(paramk.h, paramk.i));

        localfn.o = (double) paramk.e / 128D;
        localfn.p = (double) paramk.f / 128D;
        localfn.q = (double) paramk.g / 128D;
        localfn.ad = 10;
        d.e.a(((Entity) (localfn)));
    }

    public void a(Packet3Chat paramba) {
        String str = paramba.a;

        if (str.length() > 100) {
            c("Chat message too long");
            return;
        }
        str = str.trim();
        for (int l = 0; l < str.length(); l++) {
            if (" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_'abcdefghijklmnopqrstuvwxyz{|}~\u2302\307\374\351\342\344\340\345\347\352\353\350\357\356\354\304\305\311\346\306\364\366\362\373\371\377\326\334\370\243\330\327\u0192\341\355\363\372\361\321\252\272\277\256\254\275\274\241\253\273".indexOf(((int) (str.charAt(l)))) < 0) {
                c("Illegal characters in chat");
                return;
            }
        }

        if (str.startsWith("/")) {
            d(str);
        } else {
            str = (new StringBuilder()).append("<\247").append(color).append(e.aq).append("\247f> ").append(str).toString();
            a.info(str);
            d.f.a(((Packet) (new Packet3Chat(str))));
        }
    }

    private void d(String paramString) {
        if (paramString.toLowerCase().startsWith("/me ")) {
            paramString = (new StringBuilder()).append("* ").append(e.aq).append(" ").append(paramString.substring(paramString.indexOf(" ")).trim()).toString();
            a.info(paramString);
            d.f.a(((Packet) (new Packet3Chat(paramString))));
        } else if (paramString.toLowerCase().startsWith("/tell ")) {
            String arrayOfString[] = paramString.split(" ");

            if (arrayOfString.length >= 3) {
                paramString = paramString.substring(paramString.indexOf(" ")).trim();
                paramString = paramString.substring(paramString.indexOf(" ")).trim();
                paramString = (new StringBuilder()).append("\2477").append(e.aq).append(" whispers ").append(paramString).toString();
                a.info((new StringBuilder()).append(paramString).append(" to ").append(arrayOfString[1]).toString());
                if (!d.f.a(arrayOfString[1], ((Packet) (new Packet3Chat(paramString))))) {
                    b(((Packet) (new Packet3Chat("\247cThere's no player by that name online."))));
                }
            }
        } else if (paramString.toLowerCase().startsWith("/color ")) {
            String ctst = paramString.substring(paramString.indexOf(" ")).trim();

            if (ctst.matches("[0123456789abcdefABCDEF]")) {
                color = ctst;
                b(((Packet) (new Packet3Chat((new StringBuilder()).append("\247").append(ctst).append("Your color has changed to ").append(ctst).toString()))));
            } else {
                b(((Packet) (new Packet3Chat("\247c/color only accepts a single hex digit."))));
                b(((Packet) (new Packet3Chat("Values: \24700\24711\24722\24733\24744\24755\24766\24777\24788\24799\247AA\247BB\247CC\247DD\247EE\247FF"))));
            }
        } else if (paramString.toLowerCase().equalsIgnoreCase("/color")) {
            b(((Packet) (new Packet3Chat("\247cUse /color to change the color of your name."))));
            b(((Packet) (new Packet3Chat("Values: \24700\24711\24722\24733\24744\24755\24766\24777\24788\24799\247AA\247BB\247CC\247DD\247EE\247FF"))));
        } else if (paramString.toLowerCase().equalsIgnoreCase("/playerlist")) {
            for (int i1 = 0; i1 < d.f.b.size(); i1++) {
                EntityPlayerMP pl = (EntityPlayerMP) d.f.b.get(i1);

                b(((Packet) (new Packet3Chat((new StringBuilder()).append("\247").append(pl.a.color).append(pl.aq).toString()))));
            }
        } else if (paramString.toLowerCase().equalsIgnoreCase("/help")) {
            b(((Packet) (new Packet3Chat("\247e/home - return to the spawn point"))));
            b(((Packet) (new Packet3Chat("\247e/playerlist - list the players on the server"))));
            b(((Packet) (new Packet3Chat("\247e/tell - whisper to a player"))));
            b(((Packet) (new Packet3Chat("\247e/color - change your name's color"))));
        } else if (paramString.toLowerCase().equalsIgnoreCase("/home")) {
            a.info((new StringBuilder()).append(e.aq).append(" returned home").toString());
            int l = d.e.d(d.e.n, d.e.p);

            a((double) d.e.n + 0.5D, (double) l + 1.5D, (double) d.e.p + 0.5D, 0.0F, 0.0F);
        } else if (d.f.g(e.aq)) {
            String str = paramString.substring(1);

            a.info((new StringBuilder()).append(e.aq).append(" issued server command: ").append(str).toString());
            d.a(str, ((ICommandListener) (this)));
        } else {
            String str = paramString.substring(1);

            a.info((new StringBuilder()).append(e.aq).append(" tried command: ").append(str).toString());
        }
    }

    public void a(Packet18ArmAnimation paramo) {
        if (paramo.b == 1) {
            e.z();
        }
    }

    public void a(Packet255KickDisconnect paramio) {
        b.a("Quitting");
    }

    public int b() {
        return b.d();
    }

    public void b(String paramString) {
        b(((Packet) (new Packet3Chat((new StringBuilder()).append("\2477").append(paramString).toString()))));
    }

    public String c() {
        return e.aq;
    }

    public void a(Packet5PlayerInventory paramr) {
        if (paramr.a == -1) {
            e.aj.a = paramr.b;
        }
        if (paramr.a == -2) {
            e.aj.c = paramr.b;
        }
        if (paramr.a != -3) {
            return;
        } else {
            e.aj.b = paramr.b;
            return;
        }
    }

    public void d() {
        b.a(((Packet) (new Packet5PlayerInventory(-1, e.aj.a))));
        b.a(((Packet) (new Packet5PlayerInventory(-2, e.aj.c))));
        b.a(((Packet) (new Packet5PlayerInventory(-3, e.aj.b))));
    }

    public void a(Packet59ComplexEntity paramib) {
        TileEntity localas = d.e.k(paramib.a, paramib.b, paramib.c);

        if (localas != null) {
            localas.a(paramib.e);
            localas.c();
        }
    }
}
