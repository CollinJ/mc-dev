package net.minecraft.server;

import java.util.Random;

public class BlockRedstoneOre extends Block {

    private boolean a;

    public BlockRedstoneOre(int i, int j, boolean flag) {
        super(i, j, Material.d);
        if (flag) {
            a(true);
        }
        a = flag;
    }

    public int b() {
        return 30;
    }

    public void b(World world, int i, int j, int k, EntityPlayer entityplayer) {
        g(world, i, j, k);
        super.b(world, i, j, k, entityplayer);
    }

    public void b(World world, int i, int j, int k, Entity entity) {
        g(world, i, j, k);
        super.b(world, i, j, k, entity);
    }

    public boolean a(World world, int i, int j, int k, EntityPlayer entityplayer) {
        g(world, i, j, k);
        return super.a(world, i, j, k, entityplayer);
    }

    private void g(World world, int i, int j, int k) {
        h(world, i, j, k);
        if (bi == Block.aN.bi) {
            world.e(i, j, k, Block.aO.bi);
        }
    }

    public void a(World world, int i, int j, int k, Random random) {
        if (bi == Block.aO.bi) {
            world.e(i, j, k, Block.aN.bi);
        }
    }

    public int a(int i, Random random) {
        return Item.aA.ba;
    }

    public int a(Random random) {
        return 4 + random.nextInt(2);
    }

    private void h(World world, int i, int j, int k) {
        Random random = world.l;
        double d = 0.0625D;

        for (int l = 0; l < 6; l++) {
            double d1 = (float) i + random.nextFloat();
            double d2 = (float) j + random.nextFloat();
            double d3 = (float) k + random.nextFloat();

            if (l == 0 && !world.d(i, j + 1, k)) {
                d2 = (double) (j + 1) + d;
            }
            if (l == 1 && !world.d(i, j - 1, k)) {
                d2 = (double) (j + 0) - d;
            }
            if (l == 2 && !world.d(i, j, k + 1)) {
                d3 = (double) (k + 1) + d;
            }
            if (l == 3 && !world.d(i, j, k - 1)) {
                d3 = (double) (k + 0) - d;
            }
            if (l == 4 && !world.d(i + 1, j, k)) {
                d1 = (double) (i + 1) + d;
            }
            if (l == 5 && !world.d(i - 1, j, k)) {
                d1 = (double) (i + 0) - d;
            }
            if (d1 < (double) i || d1 > (double) (i + 1) || d2 < 0.0D || d2 > (double) (j + 1) || d3 < (double) k || d3 > (double) (k + 1)) {
                world.a("reddust", d1, d2, d3, 0.0D, 0.0D, 0.0D);
            }
        }
    }
}
