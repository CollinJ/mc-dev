package net.minecraft.server;

import java.util.Random;

public class EntityCreeper extends EntityMobs {

    int a;
    int b;
    int ad;
    int ae;

    public EntityCreeper(World world) {
        super(world);
        ad = 30;
        ae = -1;
        aC = "/mob/creeper.png";
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
    }

    protected void d_() {
        b = a;
        if (a > 0 && ae < 0) {
            a--;
        }
        if (ae >= 0) {
            ae = 2;
        }
        super.d_();
        if (ae != 1) {
            ae = -1;
        }
    }

    protected String d() {
        return "mob.creeper";
    }

    protected String e() {
        return "mob.creeperdeath";
    }

    public void f(Entity entity) {
        super.f(entity);
        if (entity instanceof EntitySkeleton) {
            a(Item.aQ.aS + R.nextInt(2), 1);
        }
    }

    protected void a(Entity entity, float f1) {
        if (ae <= 0 && f1 < 3F || ae > 0 && f1 < 7F) {
            if (a == 0) {
                h.a(((Entity) (this)), "random.fuse", 1.0F, 0.5F);
            }
            ae = 1;
            a++;
            if (a == ad) {
                h.a(((Entity) (this)), l, m, n, 3F);
                j();
            }
            ah = true;
        }
    }

    protected int g() {
        return Item.K.aS;
    }
}
