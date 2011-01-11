package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class EntityBoat extends Entity {

    public int a;
    public int b;
    public int ad;

    public EntityBoat(World world) {
        super(world);
        a = 0;
        b = 0;
        ad = 1;
        e = true;
        a(1.5F, 0.6F);
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

    public double h() {
        return (double) E * 0.0D - 0.30000001192092896D;
    }

    public boolean a(Entity entity, int i) {
        ad = -ad;
        b = 10;
        a += i * 10;
        if (a > 40) {
            for (int j = 0; j < 3; j++) {
                a(Block.y.bc, 1, 0.0F);
            }

            for (int k = 0; k < 2; k++) {
                a(Item.B.aS, 1, 0.0F);
            }

            j();
        }
        return true;
    }

    public boolean c_() {
        return !B;
    }

    public void b_() {
        super.b_();
        if (b > 0) {
            b--;
        }
        if (a > 0) {
            a--;
        }
        this.i = this.l;
        this.j = m;
        this.k = n;
        int i = 5;
        double d1 = 0.0D;

        for (int j = 0; j < i; j++) {
            double d2 = (v.b + ((v.e - v.b) * (double) (j + 0)) / (double) i) - 0.125D;
            double d3 = (v.b + ((v.e - v.b) * (double) (j + 1)) / (double) i) - 0.125D;
            AxisAlignedBB axisalignedbb = AxisAlignedBB.b(v.a, d2, v.c, v.d, d3, v.f);

            if (h.b(axisalignedbb, Material.f)) {
                d1 += 1.0D / (double) i;
            }
        }

        double d4 = d1 * 2D - 1.0D;

        p += 0.039999999105930328D * d4;
        if (f != null) {
            o += f.o * 0.20000000000000001D;
            q += f.q * 0.20000000000000001D;
        }
        double d5 = 0.40000000000000002D;

        if (o < -d5) {
            o = -d5;
        }
        if (o > d5) {
            o = d5;
        }
        if (q < -d5) {
            q = -d5;
        }
        if (q > d5) {
            q = d5;
        }
        if (w) {
            o *= 0.5D;
            p *= 0.5D;
            q *= 0.5D;
        }
        c(o, p, q);
        double d6 = Math.sqrt(o * o + q * q);

        if (d6 > 0.14999999999999999D) {
            double d7 = Math.cos(((double) r * 3.1415926535897931D) / 180D);
            double d9 = Math.sin(((double) r * 3.1415926535897931D) / 180D);

            for (int k = 0; (double) k < 1.0D + d6 * 60D; k++) {
                double d11 = R.nextFloat() * 2.0F - 1.0F;
                double d12 = (double) (R.nextInt(2) * 2 - 1) * 0.69999999999999996D;

                if (R.nextBoolean()) {
                    double d13 = (this.l - d7 * d11 * 0.80000000000000004D) + d9 * d12;
                    double d15 = n - d9 * d11 * 0.80000000000000004D - d7 * d12;

                    h.a("splash", d13, m - 0.125D, d15, o, p, q);
                } else {
                    double d14 = this.l + d7 + d9 * d11 * 0.69999999999999996D;
                    double d16 = (n + d9) - d7 * d11 * 0.69999999999999996D;

                    h.a("splash", d14, m - 0.125D, d16, o, p, q);
                }
            }
        }
        if (x && d6 > 0.14999999999999999D) {
            j();
            for (int l = 0; l < 3; l++) {
                a(Block.y.bc, 1, 0.0F);
            }

            for (int i1 = 0; i1 < 2; i1++) {
                a(Item.B.aS, 1, 0.0F);
            }
        } else {
            o *= 0.99000000953674316D;
            p *= 0.94999998807907104D;
            q *= 0.99000000953674316D;
        }
        s = 0.0F;
        double d8 = r;
        double d10 = this.i - this.l;
        double d17 = this.k - n;

        if (d10 * d10 + d17 * d17 > 0.001D) {
            d8 = (float) ((Math.atan2(d17, d10) * 180D) / 3.1415926535897931D);
        }
        double d18;

        for (d18 = d8 - (double) r; d18 >= 180D; d18 -= 360D) {
            ;
        }
        for (; d18 < -180D; d18 += 360D) {
            ;
        }
        if (d18 > 20D) {
            d18 = 20D;
        }
        if (d18 < -20D) {
            d18 = -20D;
        }
        r += ((float) (d18));
        b(r, s);
        List list = h.b(((Entity) (this)), v.b(0.20000000298023224D, 0.0D, 0.20000000298023224D));

        if (list != null && list.size() > 0) {
            for (int j1 = 0; j1 < list.size(); j1++) {
                Entity entity = (Entity) list.get(j1);

                if (entity != f && entity.r() && (entity instanceof EntityBoat)) {
                    entity.c(((Entity) (this)));
                }
            }
        }
        if (f != null && f.B) {
            f = null;
        }
    }

    protected void w() {
        double d1 = Math.cos(((double) r * 3.1415926535897931D) / 180D) * 0.40000000000000002D;
        double d2 = Math.sin(((double) r * 3.1415926535897931D) / 180D) * 0.40000000000000002D;

        f.a(l + d1, m + h() + f.x(), n + d2);
    }

    protected void a(NBTTagCompound nbttagcompound) {}

    protected void b(NBTTagCompound nbttagcompound) {}
}
