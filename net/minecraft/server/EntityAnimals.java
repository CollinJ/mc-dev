package net.minecraft.server;

public abstract class EntityAnimals extends EntityCreature implements IAnimals {

    public EntityAnimals(World world) {
        super(world);
    }

    protected float a(int i, int j, int k) {
        if (h.a(i, j - 1, k) == Block.v.bc) {
            return 10F;
        } else {
            return h.j(i, j, k) - 0.5F;
        }
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
    }

    public boolean a() {
        int i = MathHelper.b(l);
        int j = MathHelper.b(v.b);
        int k = MathHelper.b(n);

        return h.a(i, j - 1, k) == Block.v.bc && h.h(i, j, k) > 8 && super.a();
    }

    public int b() {
        return 120;
    }
}