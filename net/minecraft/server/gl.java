package net.minecraft.server;

public class gl extends TileEntity {

    public byte e;
    public boolean f;

    public gl() {
        e = 0;
        f = false;
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.a("note", e);
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        e = nbttagcompound.b("note");
        if (e < 0) {
            e = 0;
        }
        if (e > 24) {
            e = 24;
        }
    }

    public void a() {
        e = (byte) ((e + 1) % 25);
        d();
    }

    public void a(World world, int i, int j, int k) {
        if (world.c(i, j + 1, k) != Material.a) {
            return;
        }
        Material material = world.c(i, j - 1, k);
        byte byte0 = 0;

        if (material == Material.d) {
            byte0 = 1;
        }
        if (material == Material.m) {
            byte0 = 2;
        }
        if (material == Material.o) {
            byte0 = 3;
        }
        if (material == Material.c) {
            byte0 = 4;
        }
        world.c(i, j, k, ((int) (byte0)), ((int) (e)));
    }
}
