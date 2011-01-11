package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class EntitySnowball extends Entity {

    private int b;
    private int ad;
    private int ae;
    private int af;
    private boolean ag;
    public int a;
    private EntityLiving ah;
    private int ai;
    private int aj;

    public EntitySnowball(World world) {
        super(world);
        b = -1;
        ad = -1;
        ae = -1;
        af = 0;
        ag = false;
        a = 0;
        aj = 0;
        a(0.25F, 0.25F);
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
        Vec3D vec3d = Vec3D.b(this.l, m, n);
        Vec3D vec3d1 = Vec3D.b(this.l + o, m + p, n + q);
        MovingObjectPosition movingobjectposition = h.a(vec3d, vec3d1);

        vec3d = Vec3D.b(this.l, m, n);
        vec3d1 = Vec3D.b(this.l + o, m + p, n + q);
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
            float f2 = 0.3F;
            AxisAlignedBB axisalignedbb = entity1.v.b(f2, f2, f2);
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
                if (!movingobjectposition.g.a(((Entity) (ah)), 0)) {
                    ;
                }
            }
            for (int k = 0; k < 8; k++) {
                h.a("snowballpoof", this.l, m, n, 0.0D, 0.0D, 0.0D);
            }

            j();
        }
        this.l += o;
        m += p;
        n += q;
        float f = MathHelper.a(o * o + q * q);

        r = (float) ((Math.atan2(o, q) * 180D) / 3.1415927410125732D);
        for (s = (float) ((Math.atan2(p, f) * 180D) / 3.1415927410125732D); s - u < -180F; u -= 360F) {
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
        float f1 = 0.99F;
        float f3 = 0.03F;

        if (o()) {
            for (int l = 0; l < 4; l++) {
                float f4 = 0.25F;

                h.a("bubble", this.l - o * (double) f4, m - p * (double) f4, n - q * (double) f4, o, p, q);
            }

            f1 = 0.8F;
        }
        o *= f1;
        p *= f1;
        q *= f1;
        p -= f3;
        a(this.l, m, n);
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
