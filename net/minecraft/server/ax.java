package net.minecraft.server;

public class ax extends EntityCreature implements IAnimals {

    public ax(World world) {
        super(world);
    }

    public boolean d_() {
        return true;
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
    }

    public boolean b() {
        return l.a(z);
    }

    public int c() {
        return 120;
    }
}
