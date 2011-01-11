package net.minecraft.server;

import java.util.Random;

public class BlockFlowing extends BlockFluids {

    int a;
    boolean b[];
    int c[];

    protected BlockFlowing(int paramInt, Material paramiq) {
        super(paramInt, paramiq);
        a = 0;
        b = new boolean[4];
        c = new int[4];
    }

    private void i(World paramdy, int paramInt1, int paramInt2, int paramInt3) {
        int i = paramdy.b(paramInt1, paramInt2, paramInt3);

        paramdy.a(paramInt1, paramInt2, paramInt3, bc + 1, i);
        paramdy.b(paramInt1, paramInt2, paramInt3, paramInt1, paramInt2, paramInt3);
        paramdy.f(paramInt1, paramInt2, paramInt3);
    }

    public void a(World paramdy, int paramInt1, int paramInt2, int paramInt3, Random paramRandom) {
        if ((bc == 10 || bc == 11) && paramdy.a(paramInt1, paramInt2 - 1, paramInt3) > 1) {
            return;
        }
        int i = g(paramdy, paramInt1, paramInt2, paramInt3);
        int j = 1;

        if (i > 0) {
            int k = -100;

            a = 0;
            k = e(paramdy, paramInt1 - 1, paramInt2, paramInt3, k);
            k = e(paramdy, paramInt1 + 1, paramInt2, paramInt3, k);
            k = e(paramdy, paramInt1, paramInt2, paramInt3 - 1, k);
            k = e(paramdy, paramInt1, paramInt2, paramInt3 + 1, k);
            int l = k + d;

            if (l >= 8 || k < 0) {
                l = -1;
            }
            if (g(paramdy, paramInt1, paramInt2 + 1, paramInt3) >= 0) {
                int i1 = g(paramdy, paramInt1, paramInt2 + 1, paramInt3);

                if (i1 >= 8) {
                    l = i1;
                } else {
                    l = i1 + 8;
                }
            }
            if (a >= 2 && bn == Material.f) {
                if (paramdy.d(paramInt1, paramInt2 - 1, paramInt3)) {
                    l = 0;
                } else if (paramdy.c(paramInt1, paramInt2 - 1, paramInt3) == bn && paramdy.b(paramInt1, paramInt2, paramInt3) == 0) {
                    l = 0;
                }
            }
            if (bn == Material.g && i < 8 && l < 8 && l > i && paramRandom.nextInt(4) != 0) {
                l = i;
                j = 0;
            }
            if (l != i) {
                i = l;
                if (i < 0) {
                    paramdy.d(paramInt1, paramInt2, paramInt3, 0);
                } else {
                    paramdy.b(paramInt1, paramInt2, paramInt3, i);
                    paramdy.h(paramInt1, paramInt2, paramInt3, bc);
                    paramdy.g(paramInt1, paramInt2, paramInt3, bc);
                }
            } else if (j != 0) {
                i(paramdy, paramInt1, paramInt2, paramInt3);
            }
        } else {
            i(paramdy, paramInt1, paramInt2, paramInt3);
        }
        if (l(paramdy, paramInt1, paramInt2 - 1, paramInt3)) {
            if (i >= 8) {
                paramdy.b(paramInt1, paramInt2 - 1, paramInt3, bc, i);
            } else {
                paramdy.b(paramInt1, paramInt2 - 1, paramInt3, bc, i + 8);
            }
        } else if (i >= 0 && (i == 0 || k(paramdy, paramInt1, paramInt2 - 1, paramInt3))) {
            boolean arrayOfBoolean[] = j(paramdy, paramInt1, paramInt2, paramInt3);
            int l = i + d;

            if (i >= 8) {
                l = 1;
            }
            if (l >= 8) {
                return;
            }
            if (arrayOfBoolean[0]) {
                f(paramdy, paramInt1 - 1, paramInt2, paramInt3, l);
            }
            if (arrayOfBoolean[1]) {
                f(paramdy, paramInt1 + 1, paramInt2, paramInt3, l);
            }
            if (arrayOfBoolean[2]) {
                f(paramdy, paramInt1, paramInt2, paramInt3 - 1, l);
            }
            if (!arrayOfBoolean[3]) {
                return;
            }
            f(paramdy, paramInt1, paramInt2, paramInt3 + 1, l);
        }
    }

    private void f(World paramdy, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        if (l(paramdy, paramInt1, paramInt2, paramInt3)) {
            int i = paramdy.a(paramInt1, paramInt2, paramInt3);

            if (i > 0) {
                if (bn == Material.g) {
                    h(paramdy, paramInt1, paramInt2, paramInt3);
                } else {
                    Block.n[i].a_(paramdy, paramInt1, paramInt2, paramInt3, paramdy.b(paramInt1, paramInt2, paramInt3));
                }
            }
            paramdy.b(paramInt1, paramInt2, paramInt3, bc, paramInt4);
        }
    }

    private int a(World paramdy, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
        int i = 1000;

        for (int j = 0; j < 4; j++) {
            if (j == 0 && paramInt5 == 1 || j == 1 && paramInt5 == 0 || j == 2 && paramInt5 == 3 || j == 3 && paramInt5 == 2) {
                continue;
            }
            int k = paramInt1;
            int l = paramInt2;
            int i1 = paramInt3;

            if (j == 0) {
                k--;
            }
            if (j == 1) {
                k++;
            }
            if (j == 2) {
                i1--;
            }
            if (j == 3) {
                i1++;
            }
            if (k(paramdy, k, l, i1) || paramdy.c(k, l, i1) == bn && paramdy.b(k, l, i1) == 0) {
                continue;
            }
            if (!k(paramdy, k, l - 1, i1)) {
                return paramInt4;
            }
            if (paramInt4 >= 4) {
                continue;
            }
            int i2 = a(paramdy, k, l, i1, paramInt4 + 1, j);

            if (i2 < i) {
                i = i2;
            }
        }

        return i;
    }

    private boolean[] j(World paramdy, int paramInt1, int paramInt2, int paramInt3) {
        int i;

        for (i = 0; i < 4; i++) {
            c[i] = 1000;
            int j = paramInt1;
            int k = paramInt2;
            int l = paramInt3;

            if (i == 0) {
                j--;
            }
            if (i == 1) {
                j++;
            }
            if (i == 2) {
                l--;
            }
            if (i == 3) {
                l++;
            }
            if (k(paramdy, j, k, l) || paramdy.c(j, k, l) == bn && paramdy.b(j, k, l) == 0) {
                continue;
            }
            if (!k(paramdy, j, k - 1, l)) {
                c[i] = 0;
            } else {
                c[i] = a(paramdy, j, k, l, 1, i);
            }
        }

        i = c[0];
        for (int j = 1; j < 4; j++) {
            if (c[j] < i) {
                i = c[j];
            }
        }

        for (int j = 0; j < 4; j++) {
            b[j] = c[j] == i;
        }

        return b;
    }

    private boolean k(World paramdy, int paramInt1, int paramInt2, int paramInt3) {
        int i = paramdy.a(paramInt1, paramInt2, paramInt3);

        if (i == Block.aF.bc || i == Block.aM.bc || i == Block.aE.bc || i == Block.aG.bc || i == Block.aY.bc) {
            return true;
        }
        if (i == 0) {
            return false;
        } else {
            Material localiq = Block.n[i].bn;

            return localiq.a();
        }
    }

    protected int e(World paramdy, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        int i = g(paramdy, paramInt1, paramInt2, paramInt3);

        if (i < 0) {
            return paramInt4;
        }
        if (i == 0) {
            a++;
        }
        if (i >= 8) {
            i = 0;
        }
        return paramInt4 >= 0 && i >= paramInt4 ? paramInt4 : i;
    }

    private boolean l(World paramdy, int paramInt1, int paramInt2, int paramInt3) {
        Material localiq = paramdy.c(paramInt1, paramInt2, paramInt3);

        if (localiq == bn) {
            return false;
        }
        if (localiq == Material.g) {
            return false;
        } else {
            return !k(paramdy, paramInt1, paramInt2, paramInt3);
        }
    }

    public void e(World paramdy, int paramInt1, int paramInt2, int paramInt3) {
        super.e(paramdy, paramInt1, paramInt2, paramInt3);
        if (paramdy.a(paramInt1, paramInt2, paramInt3) == bc) {
            paramdy.h(paramInt1, paramInt2, paramInt3, bc);
        }
    }
}
