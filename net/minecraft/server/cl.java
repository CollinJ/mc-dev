package net.minecraft.server;

import java.util.Random;

public class cl extends WorldGenerator {

    public cl() {}

    public boolean a(World world, Random random, int i, int j, int k) {
        int l = random.nextInt(5) + 7;
        int i1 = l - random.nextInt(2) - 3;
        int j1 = l - i1;
        int k1 = 1 + random.nextInt(j1 + 1);
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
                for (int k3 = k - j2; k3 <= k + j2 && flag; k3++) {
                    if (l1 >= 0 && l1 < 128) {
                        int j4 = world.a(l2, l1, k3);

                        if (j4 != 0 && j4 != Block.K.bi) {
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
        int k2 = 0;

        for (int i3 = j + l; i3 >= j + i1; i3--) {
            for (int l3 = i - k2; l3 <= i + k2; l3++) {
                int k4 = l3 - i;

                for (int l4 = k - k2; l4 <= k + k2; l4++) {
                    int i5 = l4 - k;

                    if ((Math.abs(k4) != k2 || Math.abs(i5) != k2 || k2 <= 0) && !Block.o[world.a(l3, i3, l4)]) {
                        world.a(l3, i3, l4, Block.K.bi, 1);
                    }
                }
            }

            if (k2 >= 1 && i3 == j + i1 + 1) {
                k2--;
                continue;
            }
            if (k2 < k1) {
                k2++;
            }
        }

        for (int j3 = 0; j3 < l - 1; j3++) {
            int i4 = world.a(i, j + j3, k);

            if (i4 == 0 || i4 == Block.K.bi) {
                world.a(i, j + j3, k, Block.J.bi, 1);
            }
        }

        return true;
    }
}
