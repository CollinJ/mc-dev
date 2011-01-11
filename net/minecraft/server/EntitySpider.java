package net.minecraft.server;

import java.util.Random;

public class EntitySpider extends EntityMobs {

    public EntitySpider(World world) {
        super(world);
        aC = "/mob/spider.png";
        a(1.4F, 0.9F);
        bi = 0.8F;
    }

    public double h() {
        return (double) E * 0.75D - 0.5D;
    }

    protected Entity i() {
        float f = b(1.0F);

        if (f < 0.5F) {
            double d1 = 16D;

            return ((Entity) (h.a(((Entity) (this)), d1)));
        } else {
            return null;
        }
    }

    protected String c() {
        return "mob.spider";
    }

    protected String d() {
        return "mob.spider";
    }

    protected String e() {
        return "mob.spiderdeath";
    }

    protected void a(Entity entity, float f) {
        float f1 = b(1.0F);

        if (f1 > 0.5F && R.nextInt(100) == 0) {
            ag = null;
            return;
        }
        if (f > 2.0F && f < 6F && R.nextInt(10) == 0) {
            if (w) {
                double d1 = entity.l - l;
                double d2 = entity.n - n;
                float f2 = MathHelper.a(d1 * d1 + d2 * d2);

                o = (d1 / (double) f2) * 0.5D * 0.80000001192092896D + o * 0.20000000298023224D;
                q = (d2 / (double) f2) * 0.5D * 0.80000001192092896D + q * 0.20000000298023224D;
                p = 0.40000000596046448D;
            }
        } else {
            super.a(entity, f);
        }
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
    }

    protected int g() {
        return Item.I.aS;
    }
}
