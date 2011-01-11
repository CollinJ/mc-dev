package net.minecraft.server;

import java.util.Random;

public class BlockStep extends Block {

    private boolean a;

    public BlockStep(int i, boolean flag) {
        super(i, 6, Material.d);
        a = flag;
        if (!flag) {
            a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
        }
        c(255);
    }

    public int a(int i) {
        return i > 1 ? 5 : 6;
    }

    public boolean b() {
        return a;
    }

    public void b(World world, int i, int j, int k, int l) {
        if (this != Block.al) {
            return;
        } else {
            return;
        }
    }

    public void e(World world, int i, int j, int k) {
        if (this != Block.al) {
            super.e(world, i, j, k);
        }
        int l = world.a(i, j - 1, k);

        if (l == al.bc) {
            world.d(i, j, k, 0);
            world.d(i, j - 1, k, Block.ak.bc);
        }
    }

    public int a(int i, Random random) {
        return Block.al.bc;
    }

    public boolean a(IBlockAccess iblockaccess, int i, int j, int k, int l) {
        if (this != Block.al) {
            super.a(iblockaccess, i, j, k, l);
        }
        if (l == 1) {
            return true;
        }
        if (!super.a(iblockaccess, i, j, k, l)) {
            return false;
        }
        if (l == 0) {
            return true;
        } else {
            return iblockaccess.a(i, j, k) != bc;
        }
    }
}
