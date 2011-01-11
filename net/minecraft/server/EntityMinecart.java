package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class EntityMinecart extends Entity implements IInventory {

    private ItemStack ai[];
    public int a;
    public int b;
    public int ad;
    private boolean aj;
    public int ae;
    public int af;
    public double ag;
    public double ah;
    private static final int ak[][][] = {
        {
            {
                0, 0, -1
            }, {
                0, 0, 1
            }
        }, {
            {
                -1, 0, 0
            }, {
                1, 0, 0
            }
        }, {
            {
                -1, -1, 0
            }, {
                1, 0, 0
            }
        }, {
            {
                -1, 0, 0
            }, {
                1, -1, 0
            }
        }, {
            {
                0, 0, -1
            }, {
                0, -1, 1
            }
        }, {
            {
                0, -1, -1
            }, {
                0, 0, 1
            }
        }, {
            {
                0, 0, 1
            }, {
                1, 0, 0
            }
        }, {
            {
                0, 0, 1
            }, {
                -1, 0, 0
            }
        }, {
            {
                0, 0, -1
            }, {
                -1, 0, 0
            }
        }, {
            {
                0, 0, -1
            }, {
                1, 0, 0
            }
        }
    };
    private int al;
    private double am;
    private double an;
    private double ao;
    private double ap;
    private double aq;

    public EntityMinecart(World world) {
        super(world);
        ai = new ItemStack[36];
        a = 0;
        b = 0;
        ad = 1;
        aj = false;
        e = true;
        a(0.98F, 0.7F);
        C = E / 2.0F;
        H = false;
    }

    public AxisAlignedBB d(Entity entity) {
        return entity.v;
    }

    public AxisAlignedBB n() {
        return v;
    }

    public boolean r() {
        return true;
    }

    public EntityMinecart(World world, double d1, double d2, double d3, int i) {
        this(world);
        a(d1, d2 + (double) C, d3);
        o = 0.0D;
        p = 0.0D;
        q = 0.0D;
        this.i = d1;
        j = d2;
        k = d3;
        ae = i;
    }

    public double h() {
        return (double) E * 0.0D - 0.30000001192092896D;
    }

    public boolean a(Entity entity, int i) {
        ad = -ad;
        b = 10;
        a += i * 10;
        if (a > 40) {
            a(Item.ax.aS, 1, 0.0F);
            if (ae == 1) {
                a(Block.av.bc, 1, 0.0F);
            } else if (ae == 2) {
                a(Block.aC.bc, 1, 0.0F);
            }
            j();
        }
        return true;
    }

    public boolean c_() {
        return !B;
    }

    public void j() {
        label0:
        for (int i = 0; i < a(); i++) {
            ItemStack itemstack = a(i);

            if (itemstack == null) {
                continue;
            }
            float f = R.nextFloat() * 0.8F + 0.1F;
            float f1 = R.nextFloat() * 0.8F + 0.1F;
            float f2 = R.nextFloat() * 0.8F + 0.1F;

            do {
                if (itemstack.a <= 0) {
                    continue label0;
                }
                int k = R.nextInt(21) + 10;

                if (k > itemstack.a) {
                    k = itemstack.a;
                }
                itemstack.a -= k;
                EntityItem entityitem = new EntityItem(h, l + (double) f, m + (double) f1, n + (double) f2, new ItemStack(itemstack.c, k, itemstack.d));
                float f3 = 0.05F;

                entityitem.o = (float) R.nextGaussian() * f3;
                entityitem.p = (float) R.nextGaussian() * f3 + 0.2F;
                entityitem.q = (float) R.nextGaussian() * f3;
                h.a(((Entity) (entityitem)));
            } while (true);
        }

        super.j();
    }

    public void b_() {
        if (h.x) {
            if (al > 0) {
                double d1 = this.l + (am - this.l) / (double) al;
                double d2 = m + (an - m) / (double) al;
                double d3 = n + (ao - n) / (double) al;
                double d4;

                for (d4 = ap - (double) r; d4 < -180D; d4 += 360D) {
                    ;
                }
                for (; d4 >= 180D; d4 -= 360D) {
                    ;
                }
                r += ((float) (d4 / (double) al));
                s += ((float) ((aq - (double) s) / (double) al));
                al--;
                a(d1, d2, d3);
                b(r, s);
            } else {
                a(this.l, m, n);
                b(r, s);
            }
            return;
        }
        if (b > 0) {
            b--;
        }
        if (a > 0) {
            a--;
        }
        this.i = this.l;
        j = m;
        this.k = n;
        p -= 0.039999999105930328D;
        int i = MathHelper.b(this.l);
        int k = MathHelper.b(m);
        int l = MathHelper.b(n);

        if (h.a(i, k - 1, l) == Block.aH.bc) {
            k--;
        }
        double d6 = 0.40000000000000002D;
        boolean flag = false;
        double d5 = 0.0078125D;

        if (h.a(i, k, l) == Block.aH.bc) {
            Vec3D vec3d = g(this.l, m, n);
            int i1 = h.b(i, k, l);

            m = k;
            if (i1 >= 2 && i1 <= 5) {
                m = k + 1;
            }
            if (i1 == 2) {
                o -= d5;
            }
            if (i1 == 3) {
                o += d5;
            }
            if (i1 == 4) {
                q += d5;
            }
            if (i1 == 5) {
                q -= d5;
            }
            int ai1[][] = ak[i1];
            double d7 = ai1[1][0] - ai1[0][0];
            double d8 = ai1[1][2] - ai1[0][2];
            double d9 = Math.sqrt(d7 * d7 + d8 * d8);
            double d10 = o * d7 + q * d8;

            if (d10 < 0.0D) {
                d7 = -d7;
                d8 = -d8;
            }
            double d11 = Math.sqrt(o * o + q * q);

            o = (d11 * d7) / d9;
            q = (d11 * d8) / d9;
            double d14 = 0.0D;
            double d15 = (double) i + 0.5D + (double) ai1[0][0] * 0.5D;
            double d16 = (double) l + 0.5D + (double) ai1[0][2] * 0.5D;
            double d17 = (double) i + 0.5D + (double) ai1[1][0] * 0.5D;
            double d18 = (double) l + 0.5D + (double) ai1[1][2] * 0.5D;

            d7 = d17 - d15;
            d8 = d18 - d16;
            if (d7 == 0.0D) {
                this.l = (double) i + 0.5D;
                d14 = n - (double) l;
            } else if (d8 == 0.0D) {
                n = (double) l + 0.5D;
                d14 = this.l - (double) i;
            } else {
                double d19 = this.l - d15;
                double d21 = n - d16;
                double d23 = (d19 * d7 + d21 * d8) * 2D;

                d14 = d23;
            }
            this.l = d15 + d7 * d14;
            n = d16 + d8 * d14;
            a(this.l, m + (double) C, n);
            double d20 = o;
            double d22 = q;

            if (f != null) {
                d20 *= 0.75D;
                d22 *= 0.75D;
            }
            if (d20 < -d6) {
                d20 = -d6;
            }
            if (d20 > d6) {
                d20 = d6;
            }
            if (d22 < -d6) {
                d22 = -d6;
            }
            if (d22 > d6) {
                d22 = d6;
            }
            c(d20, 0.0D, d22);
            if (ai1[0][1] != 0 && MathHelper.b(this.l) - i == ai1[0][0] && MathHelper.b(n) - l == ai1[0][2]) {
                a(this.l, m + (double) ai1[0][1], n);
            } else if (ai1[1][1] != 0 && MathHelper.b(this.l) - i == ai1[1][0] && MathHelper.b(n) - l == ai1[1][2]) {
                a(this.l, m + (double) ai1[1][1], n);
            }
            if (f != null) {
                o *= 0.99699997901916504D;
                p *= 0.0D;
                q *= 0.99699997901916504D;
            } else {
                if (ae == 2) {
                    double d24 = MathHelper.a(ag * ag + ah * ah);

                    if (d24 > 0.01D) {
                        flag = true;
                        ag /= d24;
                        ah /= d24;
                        double d25 = 0.040000000000000001D;

                        o *= 0.80000001192092896D;
                        p *= 0.0D;
                        q *= 0.80000001192092896D;
                        o += ag * d25;
                        q += ah * d25;
                    } else {
                        o *= 0.89999997615814209D;
                        p *= 0.0D;
                        q *= 0.89999997615814209D;
                    }
                }
                o *= 0.95999997854232788D;
                p *= 0.0D;
                q *= 0.95999997854232788D;
            }
            Vec3D vec3d1 = g(this.l, m, n);

            if (vec3d1 != null && vec3d != null) {
                double d26 = (vec3d.b - vec3d1.b) * 0.050000000000000003D;
                double d12 = Math.sqrt(o * o + q * q);

                if (d12 > 0.0D) {
                    o = (o / d12) * (d12 + d26);
                    q = (q / d12) * (d12 + d26);
                }
                a(this.l, vec3d1.b, n);
            }
            int j1 = MathHelper.b(this.l);
            int k1 = MathHelper.b(n);

            if (j1 != i || k1 != l) {
                double d13 = Math.sqrt(o * o + q * q);

                o = d13 * (double) (j1 - i);
                q = d13 * (double) (k1 - l);
            }
            if (ae == 2) {
                double d27 = MathHelper.a(ag * ag + ah * ah);

                if (d27 > 0.01D && o * o + q * q > 0.001D) {
                    ag /= d27;
                    ah /= d27;
                    if (ag * o + ah * q < 0.0D) {
                        ag = 0.0D;
                        ah = 0.0D;
                    } else {
                        ag = o;
                        ah = q;
                    }
                }
            }
        } else {
            if (o < -d6) {
                o = -d6;
            }
            if (o > d6) {
                o = d6;
            }
            if (q < -d6) {
                q = -d6;
            }
            if (q > d6) {
                q = d6;
            }
            if (w) {
                o *= 0.5D;
                p *= 0.5D;
                q *= 0.5D;
            }
            c(o, p, q);
            if (!w) {
                o *= 0.94999998807907104D;
                p *= 0.94999998807907104D;
                q *= 0.94999998807907104D;
            }
        }
        s = 0.0F;
        double d28 = this.i - this.l;
        double d29 = this.k - n;

        if (d28 * d28 + d29 * d29 > 0.001D) {
            r = (float) ((Math.atan2(d29, d28) * 180D) / 3.1415926535897931D);
            if (aj) {
                r += 180F;
            }
        }
        double d30;

        for (d30 = r - t; d30 >= 180D; d30 -= 360D) {
            ;
        }
        for (; d30 < -180D; d30 += 360D) {
            ;
        }
        if (d30 < -170D || d30 >= 170D) {
            r += 180F;
            aj = !aj;
        }
        b(r, s);
        List list = h.b(((Entity) (this)), v.b(0.20000000298023224D, 0.0D, 0.20000000298023224D));

        if (list != null && list.size() > 0) {
            for (int l1 = 0; l1 < list.size(); l1++) {
                Entity entity = (Entity) list.get(l1);

                if (entity != f && entity.r() && (entity instanceof EntityMinecart)) {
                    entity.c(((Entity) (this)));
                }
            }
        }
        if (f != null && f.B) {
            f = null;
        }
        if (flag && R.nextInt(4) == 0) {
            af--;
            if (af < 0) {
                ag = ah = 0.0D;
            }
            h.a("largesmoke", this.l, m + 0.80000000000000004D, n, 0.0D, 0.0D, 0.0D);
        }
    }

    public Vec3D g(double d1, double d2, double d3) {
        int i = MathHelper.b(d1);
        int k = MathHelper.b(d2);
        int l = MathHelper.b(d3);

        if (h.a(i, k - 1, l) == Block.aH.bc) {
            k--;
        }
        if (h.a(i, k, l) == Block.aH.bc) {
            int i1 = h.b(i, k, l);

            d2 = k;
            if (i1 >= 2 && i1 <= 5) {
                d2 = k + 1;
            }
            int ai1[][] = ak[i1];
            double d4 = 0.0D;
            double d5 = (double) i + 0.5D + (double) ai1[0][0] * 0.5D;
            double d6 = (double) k + 0.5D + (double) ai1[0][1] * 0.5D;
            double d7 = (double) l + 0.5D + (double) ai1[0][2] * 0.5D;
            double d8 = (double) i + 0.5D + (double) ai1[1][0] * 0.5D;
            double d9 = (double) k + 0.5D + (double) ai1[1][1] * 0.5D;
            double d10 = (double) l + 0.5D + (double) ai1[1][2] * 0.5D;
            double d11 = d8 - d5;
            double d12 = (d9 - d6) * 2D;
            double d13 = d10 - d7;

            if (d11 == 0.0D) {
                d1 = (double) i + 0.5D;
                d4 = d3 - (double) l;
            } else if (d13 == 0.0D) {
                d3 = (double) l + 0.5D;
                d4 = d1 - (double) i;
            } else {
                double d14 = d1 - d5;
                double d15 = d3 - d7;
                double d16 = (d14 * d11 + d15 * d13) * 2D;

                d4 = d16;
            }
            d1 = d5 + d11 * d4;
            d2 = d6 + d12 * d4;
            d3 = d7 + d13 * d4;
            if (d12 < 0.0D) {
                d2++;
            }
            if (d12 > 0.0D) {
                d2 += 0.5D;
            }
            return Vec3D.b(d1, d2, d3);
        } else {
            return null;
        }
    }

    protected void a(NBTTagCompound nbttagcompound) {
        nbttagcompound.a("Type", ae);
        if (ae == 2) {
            nbttagcompound.a("PushX", ag);
            nbttagcompound.a("PushZ", ah);
            nbttagcompound.a("Fuel", (short) af);
        } else if (ae == 1) {
            NBTTagList nbttaglist = new NBTTagList();

            for (int i = 0; i < ai.length; i++) {
                if (ai[i] != null) {
                    NBTTagCompound nbttagcompound1 = new NBTTagCompound();

                    nbttagcompound1.a("Slot", (byte) i);
                    ai[i].a(nbttagcompound1);
                    nbttaglist.a(((NBTBase) (nbttagcompound1)));
                }
            }

            nbttagcompound.a("Items", ((NBTBase) (nbttaglist)));
        }
    }

    protected void b(NBTTagCompound nbttagcompound) {
        ae = nbttagcompound.d("Type");
        if (ae == 2) {
            ag = nbttagcompound.g("PushX");
            ah = nbttagcompound.g("PushZ");
            af = ((int) (nbttagcompound.c("Fuel")));
        } else if (ae == 1) {
            NBTTagList nbttaglist = nbttagcompound.k("Items");

            ai = new ItemStack[a()];
            for (int i = 0; i < nbttaglist.b(); i++) {
                NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.a(i);
                int k = nbttagcompound1.b("Slot") & 0xff;

                if (k >= 0 && k < ai.length) {
                    ai[k] = new ItemStack(nbttagcompound1);
                }
            }
        }
    }

    public void c(Entity entity) {
        if (entity == f) {
            return;
        }
        if ((entity instanceof EntityLiving) && !(entity instanceof EntityPlayer) && ae == 0 && o * o + q * q > 0.01D && f == null && entity.g == null) {
            entity.e(((Entity) (this)));
        }
        double d1 = entity.l - l;
        double d2 = entity.n - n;
        double d3 = d1 * d1 + d2 * d2;

        if (d3 >= 9.9999997473787516E-005D) {
            d3 = MathHelper.a(d3);
            d1 /= d3;
            d2 /= d3;
            double d4 = 1.0D / d3;

            if (d4 > 1.0D) {
                d4 = 1.0D;
            }
            d1 *= d4;
            d2 *= d4;
            d1 *= 0.10000000149011612D;
            d2 *= 0.10000000149011612D;
            d1 *= 1.0F - P;
            d2 *= 1.0F - P;
            d1 *= 0.5D;
            d2 *= 0.5D;
            if (entity instanceof EntityMinecart) {
                double d5 = entity.o + o;
                double d6 = entity.q + q;

                if (((EntityMinecart) entity).ae == 2 && ae != 2) {
                    o *= 0.20000000298023224D;
                    q *= 0.20000000298023224D;
                    f(entity.o - d1, 0.0D, entity.q - d2);
                    entity.o *= 0.69999998807907104D;
                    entity.q *= 0.69999998807907104D;
                } else if (((EntityMinecart) entity).ae != 2 && ae == 2) {
                    entity.o *= 0.20000000298023224D;
                    entity.q *= 0.20000000298023224D;
                    entity.f(o + d1, 0.0D, q + d2);
                    o *= 0.69999998807907104D;
                    q *= 0.69999998807907104D;
                } else {
                    d5 /= 2D;
                    d6 /= 2D;
                    o *= 0.20000000298023224D;
                    q *= 0.20000000298023224D;
                    f(d5 - d1, 0.0D, d6 - d2);
                    entity.o *= 0.20000000298023224D;
                    entity.q *= 0.20000000298023224D;
                    entity.f(d5 + d1, 0.0D, d6 + d2);
                }
            } else {
                f(-d1, 0.0D, -d2);
                entity.f(d1 / 4D, 0.0D, d2 / 4D);
            }
        }
    }

    public int a() {
        return 27;
    }

    public ItemStack a(int i) {
        return ai[i];
    }
}
