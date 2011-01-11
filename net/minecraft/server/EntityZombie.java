package net.minecraft.server;

import java.util.Random;

public class EntityZombie extends EntityMobs {

    public EntityZombie(World world) {
        super(world);
        aC = "/mob/zombie.png";
        bi = 0.5F;
        af = 5;
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

    protected String c() {
        return "mob.zombie";
    }

    protected String d() {
        return "mob.zombiehurt";
    }

    protected String e() {
        return "mob.zombiedeath";
    }

    protected int g() {
        return Item.J.aS;
    }
}
