package net.minecraft.server;

import java.io.PrintStream;

public class MetadataChunkBlock {

    public final EnumSkyBlock a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;

    public MetadataChunkBlock(EnumSkyBlock enumskyblock, int i, int j, int k, int l, int i1, int j1) {
        a = enumskyblock;
        b = i;
        c = j;
        d = k;
        e = l;
        f = i1;
        g = j1;
    }

    public void a(World world) {
        int i = (e - b) + 1;
        int j = (f - c) + 1;
        int k = (g - d) + 1;
        int l = i * j * k;

        if (l > 32768) {
            System.out.println("Light too large, skipping!");
            return;
        }
        int i1 = 0;
        int j1 = 0;
        boolean flag = false;
        boolean flag1 = false;

        for (int k1 = b; k1 <= e; k1++) {
            for (int l1 = d; l1 <= g; l1++) {
                int i2 = k1 >> 4;
                int j2 = l1 >> 4;
                boolean flag2 = false;

                if (flag && i2 == i1 && j2 == j1) {
                    flag2 = flag1;
                } else {
                    flag2 = world.a(k1, 0, l1, 1);
                    if (flag2) {
                        Chunk chunk = world.c(k1 >> 4, l1 >> 4);

                        if (chunk.g()) {
                            flag2 = false;
                        }
                    }
                    flag1 = flag2;
                    i1 = i2;
                    j1 = j2;
                }
                if (!flag2) {
                    continue;
                }
                if (c < 0) {
                    c = 0;
                }
                if (f >= 128) {
                    f = 127;
                }
                for (int k2 = c; k2 <= f; k2++) {
                    int l2 = world.a(a, k1, k2, l1);
                    int i3 = 0;
                    int j3 = world.a(k1, k2, l1);
                    int k3 = Block.q[j3];

                    if (k3 == 0) {
                        k3 = 1;
                    }
                    int l3 = 0;

                    if (a == EnumSkyBlock.a) {
                        if (world.k(k1, k2, l1)) {
                            l3 = 15;
                        }
                    } else if (a == EnumSkyBlock.b) {
                        l3 = Block.s[j3];
                    }
                    if (k3 >= 15 && l3 == 0) {
                        i3 = 0;
                    } else {
                        int i4 = world.a(a, k1 - 1, k2, l1);
                        int k4 = world.a(a, k1 + 1, k2, l1);
                        int l4 = world.a(a, k1, k2 - 1, l1);
                        int i5 = world.a(a, k1, k2 + 1, l1);
                        int j5 = world.a(a, k1, k2, l1 - 1);
                        int k5 = world.a(a, k1, k2, l1 + 1);

                        i3 = i4;
                        if (k4 > i3) {
                            i3 = k4;
                        }
                        if (l4 > i3) {
                            i3 = l4;
                        }
                        if (i5 > i3) {
                            i3 = i5;
                        }
                        if (j5 > i3) {
                            i3 = j5;
                        }
                        if (k5 > i3) {
                            i3 = k5;
                        }
                        i3 -= k3;
                        if (i3 < 0) {
                            i3 = 0;
                        }
                        if (l3 > i3) {
                            i3 = l3;
                        }
                    }
                    if (l2 == i3) {
                        continue;
                    }
                    world.b(a, k1, k2, l1, i3);
                    int j4 = i3 - 1;

                    if (j4 < 0) {
                        j4 = 0;
                    }
                    world.a(a, k1 - 1, k2, l1, j4);
                    world.a(a, k1, k2 - 1, l1, j4);
                    world.a(a, k1, k2, l1 - 1, j4);
                    if (k1 + 1 >= e) {
                        world.a(a, k1 + 1, k2, l1, j4);
                    }
                    if (k2 + 1 >= f) {
                        world.a(a, k1, k2 + 1, l1, j4);
                    }
                    if (l1 + 1 >= g) {
                        world.a(a, k1, k2, l1 + 1, j4);
                    }
                }
            }
        }
    }

    public boolean a(int i, int j, int k, int l, int i1, int j1) {
        if (i >= b && j >= c && k >= d && l <= e && i1 <= f && j1 <= g) {
            return true;
        }
        int k1 = 1;

        if (i >= b - k1 && j >= c - k1 && k >= d - k1 && l <= e + k1 && i1 <= f + k1 && j1 <= g + k1) {
            int l1 = e - b;
            int i2 = f - c;
            int j2 = g - d;

            if (i > b) {
                i = b;
            }
            if (j > c) {
                j = c;
            }
            if (k > d) {
                k = d;
            }
            if (l < e) {
                l = e;
            }
            if (i1 < f) {
                i1 = f;
            }
            if (j1 < g) {
                j1 = g;
            }
            int k2 = l - i;
            int l2 = i1 - j;
            int i3 = j1 - k;
            int j3 = l1 * i2 * j2;
            int k3 = k2 * l2 * i3;

            if (k3 - j3 <= 2) {
                b = i;
                c = j;
                d = k;
                e = l;
                f = i1;
                g = j1;
                return true;
            }
        }
        return false;
    }
}
