package net.minecraft.server;

import java.util.Random;

public class WorldGenTaiga2 extends WorldGenerator {

    public WorldGenTaiga2() {}

    public boolean a(World world, Random random, int i, int j, int k) {
        int l = random.nextInt(4) + 6;
        int i1 = 1 + random.nextInt(2);
        int j1 = l - i1;
        int k1 = 2 + random.nextInt(2);
        boolean flag = true;

        if (j < 1 || j + l + 1 > 128) {
            return false;
        }
        for (int l1 = j; l1 <= j + 1 + l && flag; l1++) {
            int j2 = 1;

            if (l1 - j < i1) {
                j2 = 0;
            } else {
                j2 = k1;
            }
            for (int l2 = i - j2; l2 <= i + j2 && flag; l2++) {
                for (int j3 = k - j2; j3 <= k + j2 && flag; j3++) {
                    if (l1 >= 0 && l1 < 128) {
                        int k3 = world.a(l2, l1, j3);

                        if (k3 != 0 && k3 != Block.K.bi) {
                            flag = false;
                        }
                    } else {
                        flag = false;
                    }
                }
            }
        }

        if (!flag) {
            return false;
        }
        int i2 = world.a(i, j - 1, k);

        if (i2 != Block.u.bi && i2 != Block.v.bi || j >= 128 - l - 1) {
            return false;
        }
        world.b(i, j - 1, k, Block.v.bi);
        int k2 = random.nextInt(2);
        int i3 = 1;
        boolean flag1 = false;

        for (int l3 = 0; l3 <= j1; l3++) {
            int j4 = (j + l) - l3;

            for (int l4 = i - k2; l4 <= i + k2; l4++) {
                int j5 = l4 - i;

                for (int k5 = k - k2; k5 <= k + k2; k5++) {
                    int l5 = k5 - k;

                    if ((Math.abs(j5) != k2 || Math.abs(l5) != k2 || k2 <= 0) && !Block.o[world.a(l4, j4, k5)]) {
                        world.a(l4, j4, k5, Block.K.bi, 1);
                    }
                }
            }

            if (k2 >= i3) {
                k2 = flag1 ? 1 : 0;
                flag1 = true;
                if (++i3 > k1) {
                    i3 = k1;
                }
            } else {
                k2++;
            }
        }

        int i4 = random.nextInt(3);

        for (int k4 = 0; k4 < l - i4; k4++) {
            int i5 = world.a(i, j + k4, k);

            if (i5 == 0 || i5 == Block.K.bi) {
                world.a(i, j + k4, k, Block.J.bi, 1);
            }
        }

        return true;
    }
}
