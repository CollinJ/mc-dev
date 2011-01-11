package net.minecraft.server;

import java.io.PrintStream;
import java.util.*;
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
    private Map k;

    public NetServerHandler(MinecraftServer minecraftserver, NetworkManager networkmanager, EntityPlayerMP entityplayermp) {
        c = false;
        f = 0;
        j = true;
        k = ((Map) (new HashMap()));
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

    public void a(String s) {
        b.a(((Packet) (new Packet255KickDisconnect(s))));
        b.c();
        d.f.a(((Packet) (new Packet3Chat((new StringBuilder()).append("\247e").append(e.aw).append(" left the game.").toString()))));
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
            if (e.k != null) {
                float f1 = e.v;
                float f2 = e.w;

                e.k.A();
                double d3 = e.p;
                double d5 = e.q;
                double d7 = e.r;
                double d9 = 0.0D;
                double d10 = 0.0D;

                if (packet10flying.i) {
                    f1 = packet10flying.e;
                    f2 = packet10flying.f;
                }
                if (packet10flying.h && packet10flying.b == -999D && packet10flying.d == -999D) {
                    d9 = packet10flying.a;
                    d10 = packet10flying.c;
                }
                e.A = packet10flying.g;
                e.F();
                e.c(d9, 0.0D, d10);
                e.b(d3, d5, d7, f1, f2);
                e.s = d9;
                e.u = d10;
                if (e.k != null) {
                    d.e.b(e.k, true);
                }
                if (e.k != null) {
                    e.k.A();
                }
                d.f.b(e);
                g = e.p;
                h = e.q;
                i = e.r;
                d.e.f(((Entity) (e)));
                return;
            }
            double d2 = e.q;

            g = e.p;
            h = e.q;
            i = e.r;
            double d4 = e.p;
            double d6 = e.q;
            double d8 = e.r;
            float f3 = e.v;
            float f4 = e.w;

            if (packet10flying.h && packet10flying.b == -999D && packet10flying.d == -999D) {
                packet10flying.h = false;
            }
            if (packet10flying.h) {
                d4 = packet10flying.a;
                d6 = packet10flying.b;
                d8 = packet10flying.c;
                double d11 = packet10flying.d - packet10flying.b;

                if (d11 > 1.6499999999999999D || d11 < 0.10000000000000001D) {
                    a("Illegal stance");
                    a.warning((new StringBuilder()).append(e.aw).append(" had an illegal stance: ").append(d11).toString());
                }
                e.ak = packet10flying.d;
            }
            if (packet10flying.i) {
                f3 = packet10flying.e;
                f4 = packet10flying.f;
            }
            e.F();
            e.R = 0.0F;
            e.b(g, h, i, f3, f4);
            double d12 = d4 - e.p;
            double d13 = d6 - e.q;
            double d14 = d8 - e.r;
            float f5 = 0.0625F;
            boolean flag = d.e.a(((Entity) (e)), e.z.b().e(f5, f5, f5)).size() == 0;

            e.c(d12, d13, d14);
            d12 = d4 - e.p;
            d13 = d6 - e.q;
            if (d13 > -0.5D || d13 < 0.5D) {
                d13 = 0.0D;
            }
            d14 = d8 - e.r;
            double d15 = d12 * d12 + d13 * d13 + d14 * d14;
            boolean flag1 = false;

            if (d15 > 0.0625D) {
                flag1 = true;
                a.warning((new StringBuilder()).append(e.aw).append(" moved wrongly!").toString());
                System.out.println((new StringBuilder()).append("Got position ").append(d4).append(", ").append(d6).append(", ").append(d8).toString());
                System.out.println((new StringBuilder()).append("Expected ").append(e.p).append(", ").append(e.q).append(", ").append(e.r).toString());
            }
            e.b(d4, d6, d8, f3, f4);
            boolean flag2 = d.e.a(((Entity) (e)), e.z.b().e(f5, f5, f5)).size() == 0;

            if (flag && (flag1 || !flag2)) {
                a(g, h, i, f3, f4);
                return;
            }
            e.A = packet10flying.g;
            d.f.b(e);
            e.b(e.q - d2, packet10flying.g);
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
        if (packet14blockdig.e == 4) {
            e.L();
            return;
        }
        boolean flag = d.e.B = d.f.g(e.aw);
        boolean flag1 = false;

        if (packet14blockdig.e == 0) {
            flag1 = true;
        }
        if (packet14blockdig.e == 1) {
            flag1 = true;
        }
        int l = packet14blockdig.a;
        int i1 = packet14blockdig.b;
        int j1 = packet14blockdig.c;

        if (flag1) {
            double d1 = e.p - ((double) l + 0.5D);
            double d2 = e.q - ((double) i1 + 0.5D);
            double d3 = e.r - ((double) j1 + 0.5D);
            double d4 = d1 * d1 + d2 * d2 + d3 * d3;

            if (d4 > 36D) {
                return;
            }
            double d5 = e.q;

            e.q = e.ak;
            e.q = d5;
        }
        int k1 = packet14blockdig.d;
        int l1 = (int) MathHelper.e(l - d.e.m);
        int i2 = (int) MathHelper.e(j1 - d.e.o);

        if (l1 > i2) {
            i2 = l1;
        }
        if (packet14blockdig.e == 0) {
            if (i2 > 16 || flag) {
                e.c.a(l, i1, j1);
            }
        } else if (packet14blockdig.e == 2) {
            e.c.a();
        } else if (packet14blockdig.e == 1) {
            if (i2 > 16 || flag) {
                e.c.a(l, i1, j1, k1);
            }
        } else if (packet14blockdig.e == 3) {
            double d6 = e.p - ((double) l + 0.5D);
            double d7 = e.q - ((double) i1 + 0.5D);
            double d8 = e.r - ((double) j1 + 0.5D);
            double d9 = d6 * d6 + d7 * d7 + d8 * d8;

            if (d9 < 256D) {
                e.a.b(((Packet) (new Packet53BlockChange(l, i1, j1, ((World) (d.e))))));
            }
        }
        d.e.B = false;
    }

    public void a(Packet15Place packet15place) {
        ItemStack itemstack = e.an.e();
        boolean flag = d.e.B = d.f.g(e.aw);

        if (packet15place.d == 255) {
            if (itemstack == null) {
                return;
            }
            e.c.a(((EntityPlayer) (e)), ((World) (d.e)), itemstack);
        } else {
            int l = packet15place.a;
            int i1 = packet15place.b;
            int j1 = packet15place.c;
            int k1 = packet15place.d;
            int l1 = (int) MathHelper.e(l - d.e.m);
            int i2 = (int) MathHelper.e(j1 - d.e.o);

            if (l1 > i2) {
                i2 = l1;
            }
            if (i2 > 16 || flag) {
                e.c.a(((EntityPlayer) (e)), ((World) (d.e)), itemstack, l, i1, j1, k1);
            }
            e.a.b(((Packet) (new Packet53BlockChange(l, i1, j1, ((World) (d.e))))));
            if (k1 == 0) {
                i1--;
            }
            if (k1 == 1) {
                i1++;
            }
            if (k1 == 2) {
                j1--;
            }
            if (k1 == 3) {
                j1++;
            }
            if (k1 == 4) {
                l--;
            }
            if (k1 == 5) {
                l++;
            }
            e.a.b(((Packet) (new Packet53BlockChange(l, i1, j1, ((World) (d.e))))));
        }
        if (itemstack != null && itemstack.a == 0) {
            e.an.a[e.an.c] = null;
        }
        e.am = true;
        e.an.a[e.an.c] = ItemStack.a(e.an.a[e.an.c]);
        Slot slot = e.ap.a(((IInventory) (e.an)), e.an.c);

        e.ap.a();
        e.am = false;
        if (!ItemStack.a(e.an.e(), packet15place.e)) {
            b(((Packet) (new Packet103(e.ap.f, slot.c, e.an.e()))));
        }
        d.e.B = false;
    }

    public void a(String s, Object aobj[]) {
        a.info((new StringBuilder()).append(e.aw).append(" lost connection: ").append(s).toString());
        d.f.a(((Packet) (new Packet3Chat((new StringBuilder()).append("\247e").append(e.aw).append(" left the game.").toString()))));
        d.f.c(e);
        c = true;
    }

    public void a(Packet packet) {
        a.warning((new StringBuilder()).append((((this).getClass()))).append(" wasn't prepared to deal with a ").append(((((packet)).getClass()))).toString());
        a("Protocol error, unexpected packet");
    }

    public void b(Packet packet) {
        b.a(packet);
    }

    public void a(Packet16BlockItemSwitch packet16blockitemswitch) {
        e.an.c = packet16blockitemswitch.a;
    }

    public void a(Packet3Chat packet3chat) {
        String s = packet3chat.a;

        if (s.length() > 100) {
            a("Chat message too long");
            return;
        }
        s = s.trim();
        for (int l = 0; l < s.length(); l++) {
            if (FontAllowedCharacters.a.indexOf(((int) (s.charAt(l)))) < 0) {
                a("Illegal characters in chat");
                return;
            }
        }

        if (s.startsWith("/")) {
            c(s);
        } else {
            s = (new StringBuilder()).append("<").append(e.aw).append("> ").append(s).toString();
            a.info(s);
            d.f.a(((Packet) (new Packet3Chat(s))));
        }
    }

    private void c(String s) {
        if (s.toLowerCase().startsWith("/me ")) {
            s = (new StringBuilder()).append("* ").append(e.aw).append(" ").append(s.substring(s.indexOf(" ")).trim()).toString();
            a.info(s);
            d.f.a(((Packet) (new Packet3Chat(s))));
        } else if (s.toLowerCase().startsWith("/kill")) {
            e.a(((Entity) (null)), 1000);
        } else if (s.toLowerCase().startsWith("/tell ")) {
            String as[] = s.split(" ");

            if (as.length >= 3) {
                s = s.substring(s.indexOf(" ")).trim();
                s = s.substring(s.indexOf(" ")).trim();
                s = (new StringBuilder()).append("\2477").append(e.aw).append(" whispers ").append(s).toString();
                a.info((new StringBuilder()).append(s).append(" to ").append(as[1]).toString());
                if (!d.f.a(as[1], ((Packet) (new Packet3Chat(s))))) {
                    b(((Packet) (new Packet3Chat("\247cThere's no player by that name online."))));
                }
            }
        } else if (d.f.g(e.aw)) {
            String s1 = s.substring(1);

            a.info((new StringBuilder()).append(e.aw).append(" issued server command: ").append(s1).toString());
            d.a(s1, ((ICommandListener) (this)));
        } else {
            String s2 = s.substring(1);

            a.info((new StringBuilder()).append(e.aw).append(" tried command: ").append(s2).toString());
        }
    }

    public void a(Packet18ArmAnimation packet18armanimation) {
        if (packet18armanimation.b == 1) {
            e.H();
        } else if (packet18armanimation.b == 104) {
            e.al = true;
        } else if (packet18armanimation.b == 105) {
            e.al = false;
        }
    }

    public void a(Packet255KickDisconnect packet255kickdisconnect) {
        b.a("disconnect.quitting", new Object[0]);
    }

    public int b() {
        return b.d();
    }

    public void b(String s) {
        b(((Packet) (new Packet3Chat((new StringBuilder()).append("\2477").append(s).toString()))));
    }

    public String c() {
        return e.aw;
    }

    public void a(Packet7 packet7) {
        Entity entity = d.e.a(packet7.b);

        if (entity != null && e.i(entity)) {
            if (packet7.c == 0) {
                e.g(entity);
            } else if (packet7.c == 1) {
                e.h(entity);
            }
        }
    }

    public void a(Packet9 packet9) {
        if (e.ba > 0) {
            return;
        } else {
            e = d.f.d(e);
            return;
        }
    }

    public void a(Packet101 packet101) {
        e.K();
    }

    public void a(Packet102 packet102) {
        if (e.ap.f == packet102.a && e.ap.c(((EntityPlayer) (e)))) {
            ItemStack itemstack = e.ap.a(packet102.b, packet102.c, ((EntityPlayer) (e)));

            if (ItemStack.a(packet102.e, itemstack)) {
                e.a.b(((Packet) (new Packet106(packet102.a, packet102.d, true))));
                e.am = true;
                e.ap.a();
                e.J();
                e.am = false;
            } else {
                k.put(((Integer.valueOf(e.ap.f))), ((Short.valueOf(packet102.d))));
                e.a.b(((Packet) (new Packet106(packet102.a, packet102.d, false))));
                e.ap.a(((EntityPlayer) (e)), false);
                ArrayList arraylist = new ArrayList();

                for (int l = 0; l < e.ap.e.size(); l++) {
                    ((List) (arraylist)).add(((((Slot) e.ap.e.get(l)).c())));
                }

                e.a(e.ap, ((List) (arraylist)));
            }
        }
    }

    public void a(Packet106 packet106) {
        Short short1 = (Short) k.get(((Integer.valueOf(e.ap.f))));

        if (short1 != null && packet106.b == short1.shortValue() && e.ap.f == packet106.a && !e.ap.c(((EntityPlayer) (e)))) {
            e.ap.a(((EntityPlayer) (e)), true);
        }
    }

    public void a(Packet130 packet130) {
        if (d.e.f(packet130.a, packet130.b, packet130.c)) {
            TileEntity tileentity = d.e.l(packet130.a, packet130.b, packet130.c);

            for (int l = 0; l < 4; l++) {
                boolean flag = true;

                if (packet130.d[l].length() > 15) {
                    flag = false;
                } else {
                    for (int k1 = 0; k1 < packet130.d[l].length(); k1++) {
                        if (FontAllowedCharacters.a.indexOf(((int) (packet130.d[l].charAt(k1)))) < 0) {
                            flag = false;
                        }
                    }
                }
                if (!flag) {
                    packet130.d[l] = "!?";
                }
            }

            if (tileentity instanceof TileEntitySign) {
                int i1 = packet130.a;
                int j1 = packet130.b;
                int l1 = packet130.c;
                TileEntitySign tileentitysign = (TileEntitySign) tileentity;

                for (int i2 = 0; i2 < 4; i2++) {
                    tileentitysign.e[i2] = packet130.d[i2];
                }

                tileentitysign.d();
                d.e.g(i1, j1, l1);
            }
        }
    }
}
