package net.minecraft.server;

public abstract class BlockContainer extends Block {

    protected BlockContainer(int i, Material material) {
        super(i, material);
        p[i] = true;
    }

    protected BlockContainer(int i, int j, Material material) {
        super(i, j, material);
        p[i] = true;
    }

    public void e(World world, int i, int j, int k) {
        super.e(world, i, j, k);
        world.a(i, j, k, a_());
    }

    public void b(World world, int i, int j, int k) {
        super.b(world, i, j, k);
        world.n(i, j, k);
    }

    protected abstract TileEntity a_();
}
