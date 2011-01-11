package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class EntityArrow extends Entity {

    private int b;
    private int ad;
    private int ae;
    private int af;
    private boolean ag;
    public int a;
    private EntityLiving ah;
    private int ai;
    private int aj;

    public EntityArrow(World world) {
        super(world);
        b = -1;
        ad = -1;
        ae = -1;
        af = 0;
        ag = false;
        a = 0;
        aj = 0;
        a(0.5F, 0.5F);
    }

    public EntityArrow(World world, EntityLiving entityliving) {
        super(world);
        b = -1;
        ad = -1;
        ae = -1;
        af = 0;
        ag = false;
        a = 0;
        aj = 0;
        ah = entityliving;
        a(0.5F, 0.5F);
        c(entityliving.l, entityliving.m, entityliving.n, entityliving.r, entityliving.s);
        l -= MathHelper.b((r / 180F) * 3.141593F) * 0.16F;
        m -= 0.10000000149011612D;
        n -= MathHelper.a((r / 180F) * 3.141593F) * 0.16F;
        a(l, m, n);
        C = 0.0F;
        o = -MathHelper.a((r / 180F) * 3.141593F) * MathHelper.b((s / 180F) * 3.141593F);
        q = MathHelper.b((r / 180F) * 3.141593F) * MathHelper.b((s / 180F) * 3.141593F);
        p = -MathHelper.a((s / 180F) * 3.141593F);
        a(o, p, q, 1.5F, 1.0F);
    }

    public void a(double d, double d1, double d2, float f, float f1) {
        float f2 = MathHelper.a(d * d + d1 * d1 + d2 * d2);

        d /= f2;
        d1 /= f2;
        d2 /= f2;
        d += R.nextGaussian() * 0.0074999998323619366D * (double) f1;
        d1 += R.nextGaussian() * 0.0074999998323619366D * (double) f1;
        d2 += R.nextGaussian() * 0.0074999998323619366D * (double) f1;
        d *= f;
        d1 *= f;
        d2 *= f;
        o = d;
        p = d1;
        q = d2;
        float f3 = MathHelper.a(d * d + d2 * d2);

        t = r = (float) ((Math.atan2(d, d2) * 180D) / 3.1415927410125732D);
        u = s = (float) ((Math.atan2(d1, f3) * 180D) / 3.1415927410125732D);
        ai = 0;
    }

    public void b_() {
        super.b_();
        if (a > 0) {
            a--;
        }
        if (ag) {
            int i = h.a(b, ad, ae);

            if (i != af) {
                ag = false;
                o *= R.nextFloat() * 0.2F;
                p *= R.nextFloat() * 0.2F;
                q *= R.nextFloat() * 0.2F;
                ai = 0;
                aj = 0;
            } else {
                ai++;
                if (ai == 1200) {
                    j();
                }
                return;
            }
        } else {
            aj++;
        }
        Vec3D vec3d = Vec3D.b(l, m, n);
        Vec3D vec3d1 = Vec3D.b(l + o, m + p, n + q);
        MovingObjectPosition movingobjectposition = h.a(vec3d, vec3d1);

        vec3d = Vec3D.b(l, m, n);
        vec3d1 = Vec3D.b(l + o, m + p, n + q);
        if (movingobjectposition != null) {
            vec3d1 = Vec3D.b(movingobjectposition.f.a, movingobjectposition.f.b, movingobjectposition.f.c);
        }
        Entity entity = null;
        List list = h.b(((Entity) (this)), v.a(o, p, q).b(1.0D, 1.0D, 1.0D));
        double d = 0.0D;

        for (int j = 0; j < list.size(); j++) {
            Entity entity1 = (Entity) list.get(j);

            if (!entity1.c_() || entity1 == ah && aj < 5) {
                continue;
            }
            float f3 = 0.3F;
            AxisAlignedBB axisalignedbb = entity1.v.b(f3, f3, f3);
            MovingObjectPosition movingobjectposition1 = axisalignedbb.a(vec3d, vec3d1);

            if (movingobjectposition1 == null) {
                continue;
            }
            double d1 = vec3d.a(movingobjectposition1.f);

            if (d1 < d || d == 0.0D) {
                entity = entity1;
                d = d1;
            }
        }

        if (entity != null) {
            movingobjectposition = new MovingObjectPosition(entity);
        }
        if (movingobjectposition != null) {
            if (movingobjectposition.g != null) {
                if (movingobjectposition.g.a(((Entity) (ah)), 4)) {
                    h.a(((Entity) (this)), "random.drr", 1.0F, 1.2F / (R.nextFloat() * 0.2F + 0.9F));
                    j();
                } else {
                    o *= -0.10000000149011612D;
                    p *= -0.10000000149011612D;
                    q *= -0.10000000149011612D;
                    r += 180F;
                    t += 180F;
                    aj = 0;
                }
            } else {
                b = movingobjectposition.b;
                ad = movingobjectposition.c;
                ae = movingobjectposition.d;
                af = h.a(b, ad, ae);
                o = (float) (movingobjectposition.f.a - l);
                p = (float) (movingobjectposition.f.b - m);
                q = (float) (movingobjectposition.f.c - n);
                float f = MathHelper.a(o * o + p * p + q * q);

                l -= (o / (double) f) * 0.05000000074505806D;
                m -= (p / (double) f) * 0.05000000074505806D;
                n -= (q / (double) f) * 0.05000000074505806D;
                h.a(((Entity) (this)), "random.drr", 1.0F, 1.2F / (R.nextFloat() * 0.2F + 0.9F));
                ag = true;
                a = 7;
            }
        }
        l += o;
        m += p;
        n += q;
        float f1 = MathHelper.a(o * o + q * q);

        r = (float) ((Math.atan2(o, q) * 180D) / 3.1415927410125732D);
        for (s = (float) ((Math.atan2(p, f1) * 180D) / 3.1415927410125732D); s - u < -180F; u -= 360F) {
            ;
        }
        for (; s - u >= 180F; u += 360F) {
            ;
        }
        for (; r - t < -180F; t -= 360F) {
            ;
        }
        for (; r - t >= 180F; t += 360F) {
            ;
        }
        s = u + (s - u) * 0.2F;
        r = t + (r - t) * 0.2F;
        float f2 = 0.99F;
        float f4 = 0.03F;

        if (o()) {
            for (int k = 0; k < 4; k++) {
                float f5 = 0.25F;

                h.a("bubble", l - o * (double) f5, m - p * (double) f5, n - q * (double) f5, o, p, q);
            }

            f2 = 0.8F;
        }
        o *= f2;
        p *= f2;
        q *= f2;
        p -= f4;
        a(l, m, n);
    }

    public void a(NBTTagCompound nbttagcompound) {
        nbttagcompound.a("xTile", (short) b);
        nbttagcompound.a("yTile", (short) ad);
        nbttagcompound.a("zTile", (short) ae);
        nbttagcompound.a("inTile", (byte) af);
        nbttagcompound.a("shake", (byte) a);
        nbttagcompound.a("inGround", (byte) (ag ? 1 : 0));
    }

    public void b(NBTTagCompound nbttagcompound) {
        b = ((int) (nbttagcompound.c("xTile")));
        ad = ((int) (nbttagcompound.c("yTile")));
        ae = ((int) (nbttagcompound.c("zTile")));
        af = nbttagcompound.b("inTile") & 0xff;
        a = nbttagcompound.b("shake") & 0xff;
        ag = nbttagcompound.b("inGround") == 1;
    }

    public void a(EntityPlayer entityplayer) {
        if (ag && ah == entityplayer && a <= 0 && entityplayer.aj.a(new ItemStack(Item.j.aS, 1))) {
            h.a(((Entity) (this)), "random.pop", 0.2F, ((R.nextFloat() - R.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            entityplayer.c(((Entity) (this)), 1);
            j();
        }
    }
}
