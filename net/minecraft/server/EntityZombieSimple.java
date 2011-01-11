package net.minecraft.server;

public class EntityZombieSimple extends EntityMobs {

    public EntityZombieSimple(World world) {
        super(world);
        aC = "/mob/zombie.png";
        bi = 0.5F;
        af = 50;
        aM *= 10;
        C *= 6F;
        a(D * 6F, E * 6F);
    }

    protected float a(int i, int j, int k) {
        return h.j(i, j, k) - 0.5F;
    }
}
