package net.minecraft.server;

import java.util.Random;

public class BlockSand extends Block {

    public static boolean a = false;

    public BlockSand(int i, int j) {
        super(i, j, Material.m);
    }

    public void e(World world, int i, int j, int k) {
        world.i(i, j, k, bi);
    }

    public void b(World world, int i, int j, int k, int l) {
        world.i(i, j, k, bi);
    }

    public void a(World world, int i, int j, int k, Random random) {
        h(world, i, j, k);
    }

    private void h(World world, int i, int j, int k) {
        int l = i;
        int i1 = j;
        int j1 = k;

        if (g(world, l, i1 - 1, j1) && i1 >= 0) {
            byte byte0 = 32;

            if (a || !world.a(i - byte0, j - byte0, k - byte0, i + byte0, j + byte0, k + byte0)) {
                world.e(i, j, k, 0);
                for (; g(world, i, j - 1, k) && j > 0; j--) {
                    ;
                }
                if (j > 0) {
                    world.e(i, j, k, bi);
                }
            } else {
                EntityFallingSand entityfallingsand = new EntityFallingSand(world, (float) i + 0.5F, (float) j + 0.5F, (float) k + 0.5F, bi);

                world.a(((Entity) (entityfallingsand)));
            }
        }
    }

    public int b() {
        return 3;
    }

    public static boolean g(World world, int i, int j, int k) {
        int l = world.a(i, j, k);

        if (l == 0) {
            return true;
        }
        if (l == Block.ar.bi) {
            return true;
        }
        Material material = Block.m[l].bt;

        if (material == Material.f) {
            return true;
        }
        return material == Material.g;
    }
}
