package net.minecraft.server;

import java.util.Random;

public class BlockLog extends Block {

    protected BlockLog(int i) {
        super(i, Material.c);
        bh = 20;
    }

    public int a(Random random) {
        return 1;
    }

    public int a(int i, Random random) {
        return Block.J.bi;
    }

    public void b(World world, int i, int j, int k) {
        byte byte0 = 4;
        int l = byte0 + 1;

        if (world.a(i - l, j - l, k - l, i + l, j + l, k + l)) {
            for (int i1 = -byte0; i1 <= byte0; i1++) {
                for (int j1 = -byte0; j1 <= byte0; j1++) {
                    for (int k1 = -byte0; k1 <= byte0; k1++) {
                        int l1 = world.a(i + i1, j + j1, k + k1);

                        if (l1 != Block.K.bi) {
                            continue;
                        }
                        int i2 = world.b(i + i1, j + j1, k + k1);

                        if ((i2 & 4) == 0) {
                            world.d(i + i1, j + j1, k + k1, i2 | 4);
                        }
                    }
                }
            }
        }
    }

    protected int b(int i) {
        return i;
    }
}
