package net.minecraft.server;

import java.util.Random;

public class BlockFire extends Block {

    private int a[];
    private int b[];

    protected BlockFire(int i, int j) {
        super(i, j, Material.l);
        a = new int[256];
        b = new int[256];
        a(Block.y.bc, 5, 20);
        a(Block.K.bc, 5, 5);
        a(Block.L.bc, 30, 60);
        a(Block.ao.bc, 30, 20);
        a(Block.an.bc, 15, 100);
        a(Block.ac.bc, 30, 60);
        a(true);
    }

    private void a(int i, int j, int k) {
        a[i] = j;
        b[i] = k;
    }

    public AxisAlignedBB d(World world, int i, int j, int k) {
        return null;
    }

    public boolean b() {
        return false;
    }

    public int a() {
        return 3;
    }

    public int a(Random random) {
        return 0;
    }

    public int c() {
        return 10;
    }

    public void a(World world, int i, int j, int k, Random random) {
        int l = world.b(i, j, k);

        if (l < 15) {
            world.b(i, j, k, l + 1);
            world.h(i, j, k, bc);
        }
        if (!g(world, i, j, k)) {
            if (!world.d(i, j - 1, k) || l > 3) {
                world.d(i, j, k, 0);
            }
            return;
        }
        if (!b(((IBlockAccess) (world)), i, j - 1, k) && l == 15 && random.nextInt(4) == 0) {
            world.d(i, j, k, 0);
            return;
        }
        if (l % 2 == 0 && l > 2) {
            a(world, i + 1, j, k, 300, random);
            a(world, i - 1, j, k, 300, random);
            a(world, i, j - 1, k, 200, random);
            a(world, i, j + 1, k, 250, random);
            a(world, i, j, k - 1, 300, random);
            a(world, i, j, k + 1, 300, random);
            for (int i1 = i - 1; i1 <= i + 1; i1++) {
                for (int j1 = k - 1; j1 <= k + 1; j1++) {
                    for (int k1 = j - 1; k1 <= j + 4; k1++) {
                        if (i1 == i && k1 == j && j1 == k) {
                            continue;
                        }
                        int l1 = 100;

                        if (k1 > j + 1) {
                            l1 += (k1 - (j + 1)) * 100;
                        }
                        int i2 = h(world, i1, k1, j1);

                        if (i2 > 0 && random.nextInt(l1) <= i2) {
                            world.d(i1, k1, j1, bc);
                        }
                    }
                }
            }
        }
    }

    private void a(World world, int i, int j, int k, int l, Random random) {
        int i1 = b[world.a(i, j, k)];

        if (random.nextInt(l) < i1) {
            boolean flag = world.a(i, j, k) == Block.an.bc;

            if (random.nextInt(2) == 0) {
                world.d(i, j, k, bc);
            } else {
                world.d(i, j, k, 0);
            }
            if (flag) {
                Block.an.a(world, i, j, k, 0);
            }
        }
    }

    private boolean g(World world, int i, int j, int k) {
        if (b(((IBlockAccess) (world)), i + 1, j, k)) {
            return true;
        }
        if (b(((IBlockAccess) (world)), i - 1, j, k)) {
            return true;
        }
        if (b(((IBlockAccess) (world)), i, j - 1, k)) {
            return true;
        }
        if (b(((IBlockAccess) (world)), i, j + 1, k)) {
            return true;
        }
        if (b(((IBlockAccess) (world)), i, j, k - 1)) {
            return true;
        }
        return b(((IBlockAccess) (world)), i, j, k + 1);
    }

    private int h(World world, int i, int j, int k) {
        int l = 0;

        if (world.a(i, j, k) != 0) {
            return 0;
        } else {
            l = f(world, i + 1, j, k, l);
            l = f(world, i - 1, j, k, l);
            l = f(world, i, j - 1, k, l);
            l = f(world, i, j + 1, k, l);
            l = f(world, i, j, k - 1, l);
            l = f(world, i, j, k + 1, l);
            return l;
        }
    }

    public boolean e() {
        return false;
    }

    public boolean b(IBlockAccess iblockaccess, int i, int j, int k) {
        return a[iblockaccess.a(i, j, k)] > 0;
    }

    public int f(World world, int i, int j, int k, int l) {
        int i1 = a[world.a(i, j, k)];

        if (i1 > l) {
            return i1;
        } else {
            return l;
        }
    }

    public boolean a(World world, int i, int j, int k) {
        return world.d(i, j - 1, k) || g(world, i, j, k);
    }

    public void b(World world, int i, int j, int k, int l) {
        if (!world.d(i, j - 1, k) && !g(world, i, j, k)) {
            world.d(i, j, k, 0);
            return;
        } else {
            return;
        }
    }

    public void e(World world, int i, int j, int k) {
        if (!world.d(i, j - 1, k) && !g(world, i, j, k)) {
            world.d(i, j, k, 0);
            return;
        } else {
            world.h(i, j, k, bc);
            return;
        }
    }
}
