package net.minecraft.server;

import java.util.Random;

public class BlockStationary extends BlockFluids {

    protected BlockStationary(int paramInt, Material paramiq) {
        super(paramInt, paramiq);
        a(false);
        if (paramiq != Material.g) {
            return;
        } else {
            a(true);
            return;
        }
    }

    public void b(World paramdy, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.b(paramdy, paramInt1, paramInt2, paramInt3, paramInt4);
        if (paramdy.a(paramInt1, paramInt2, paramInt3) == bc) {
            i(paramdy, paramInt1, paramInt2, paramInt3);
        }
    }

    private void i(World paramdy, int paramInt1, int paramInt2, int paramInt3) {
        int i = paramdy.b(paramInt1, paramInt2, paramInt3);

        paramdy.h = true;
        paramdy.a(paramInt1, paramInt2, paramInt3, bc - 1, i);
        paramdy.b(paramInt1, paramInt2, paramInt3, paramInt1, paramInt2, paramInt3);
        paramdy.h(paramInt1, paramInt2, paramInt3, bc - 1);
        paramdy.h = false;
    }

    public void a(World paramdy, int paramInt1, int paramInt2, int paramInt3, Random paramRandom) {
        if (bn == Material.g) {
            int i = paramRandom.nextInt(3);

            for (int j = 0; j < i; j++) {
                paramInt1 += paramRandom.nextInt(3) - 1;
                paramInt2++;
                paramInt3 += paramRandom.nextInt(3) - 1;
                int k = paramdy.a(paramInt1, paramInt2, paramInt3);

                if (k == 0) {
                    if (j(paramdy, paramInt1 - 1, paramInt2, paramInt3) || j(paramdy, paramInt1 + 1, paramInt2, paramInt3) || j(paramdy, paramInt1, paramInt2, paramInt3 - 1) || j(paramdy, paramInt1, paramInt2, paramInt3 + 1) || j(paramdy, paramInt1, paramInt2 - 1, paramInt3) || j(paramdy, paramInt1, paramInt2 + 1, paramInt3)) {
                        return;
                    }
                    continue;
                }
                if (Block.n[k].bn.c()) {
                    return;
                }
            }
        }
    }

    private boolean j(World paramdy, int paramInt1, int paramInt2, int paramInt3) {
        return paramdy.c(paramInt1, paramInt2, paramInt3).e();
    }
}
