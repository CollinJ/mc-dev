package net.minecraft.server;

import java.util.Random;

public class EntitySkeleton extends EntityMobs {

    public EntitySkeleton(World world) {
        super(world);
        aC = "/mob/skeleton.png";
    }

    protected String c() {
        return "mob.skeleton";
    }

    protected String d() {
        return "mob.skeletonhurt";
    }

    protected String e() {
        return "mob.skeletonhurt";
    }

    public void y() {
        if (h.a()) {
            float f = b(1.0F);

            if (f > 0.5F && h.g(MathHelper.b(l), MathHelper.b(m), MathHelper.b(n)) && R.nextFloat() * 30F < (f - 0.4F) * 2.0F) {
                U = 300;
            }
        }
        super.y();
    }

    protected void a(Entity entity, float f) {
        if (f < 10F) {
            double d1 = entity.l - l;
            double d2 = entity.n - n;

            if (aS == 0) {
                EntityArrow entityarrow = new EntityArrow(h, ((EntityLiving) (this)));

                entityarrow.m += 1.3999999761581421D;
                double d3 = entity.m - 0.20000000298023224D - entityarrow.m;
                float f1 = MathHelper.a(d1 * d1 + d2 * d2) * 0.2F;

                h.a(((Entity) (this)), "random.bow", 1.0F, 1.0F / (R.nextFloat() * 0.4F + 0.8F));
                h.a(((Entity) (entityarrow)));
                entityarrow.a(d1, d3 + (double) f1, d2, 0.6F, 12F);
                aS = 30;
            }
            r = (float) ((Math.atan2(d2, d1) * 180D) / 3.1415927410125732D) - 90F;
            ah = true;
        }
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
    }

    protected int g() {
        return Item.j.aS;
    }
}
