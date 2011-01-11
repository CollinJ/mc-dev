package net.minecraft.server;

import java.util.Random;

public class EntityCreature extends EntityLiving {

    private PathEntity a;
    protected Entity ag;
    protected boolean ah;

    public EntityCreature(World world) {
        super(world);
        ah = false;
    }

    protected void d_() {
        ah = false;
        float f = 16F;

        if (ag == null) {
            ag = i();
            if (ag != null) {
                a = h.a(((Entity) (this)), ag, f);
            }
        } else if (!ag.t()) {
            ag = null;
        } else {
            float f1 = ag.a(((Entity) (this)));

            if (g(ag)) {
                a(ag, f1);
            }
        }
        if (!ah && ag != null && (a == null || R.nextInt(20) == 0)) {
            a = h.a(((Entity) (this)), ag, f);
        } else if (a == null && R.nextInt(80) == 0 || R.nextInt(80) == 0) {
            boolean flag = false;
            int k = -1;
            int l = -1;
            int i1 = -1;
            float f2 = -99999F;

            for (int j1 = 0; j1 < 10; j1++) {
                int k1 = MathHelper.b((this.l + (double) R.nextInt(13)) - 6D);
                int l1 = MathHelper.b((m + (double) R.nextInt(7)) - 3D);
                int i2 = MathHelper.b((n + (double) R.nextInt(13)) - 6D);
                float f3 = a(k1, l1, i2);

                if (f3 > f2) {
                    f2 = f3;
                    k = k1;
                    l = l1;
                    i1 = i2;
                    flag = true;
                }
            }

            if (flag) {
                a = h.a(((Entity) (this)), k, l, i1, 10F);
            }
        }
        int j = MathHelper.b(v.b);
        boolean flag1 = o();
        boolean flag2 = q();

        s = 0.0F;
        if (a == null || R.nextInt(100) == 0) {
            super.d_();
            a = null;
            return;
        }
        Vec3D vec3d = a.a(((Entity) (this)));

        for (double d = D * 2.0F; vec3d != null && vec3d.d(this.l, vec3d.b, n) < d * d;) {
            a.a();
            if (a.b()) {
                vec3d = null;
                a = null;
            } else {
                vec3d = a.a(((Entity) (this)));
            }
        }

        bg = false;
        if (vec3d != null) {
            double d1 = vec3d.a - this.l;
            double d2 = vec3d.c - n;
            double d3 = vec3d.b - (double) j;
            float f4 = (float) ((Math.atan2(d2, d1) * 180D) / 3.1415927410125732D) - 90F;
            float f5 = f4 - r;

            be = bi;
            for (; f5 < -180F; f5 += 360F) {
                ;
            }
            for (; f5 >= 180F; f5 -= 360F) {
                ;
            }
            if (f5 > 30F) {
                f5 = 30F;
            }
            if (f5 < -30F) {
                f5 = -30F;
            }
            r += f5;
            if (ah && ag != null) {
                double d4 = ag.l - this.l;
                double d5 = ag.n - n;
                float f7 = r;

                r = (float) ((Math.atan2(d5, d4) * 180D) / 3.1415927410125732D) - 90F;
                float f6 = (((f7 - r) + 90F) * 3.141593F) / 180F;

                bd = -MathHelper.a(f6) * be * 1.0F;
                be = MathHelper.b(f6) * be * 1.0F;
            }
            if (d3 > 0.0D) {
                bg = true;
            }
        }
        if (ag != null) {
            b(ag, 30F);
        }
        if (x) {
            bg = true;
        }
        if (R.nextFloat() < 0.8F && (flag1 || flag2)) {
            bg = true;
        }
    }

    protected void a(Entity entity, float f) {}

    protected float a(int j, int k, int l) {
        return 0.0F;
    }

    protected Entity i() {
        return null;
    }

    public boolean a() {
        int j = MathHelper.b(this.l);
        int k = MathHelper.b(v.b);
        int l = MathHelper.b(n);

        return super.a() && a(j, k, l) >= 0.0F;
    }
}
