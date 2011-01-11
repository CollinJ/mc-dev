package net.minecraft.server;

public class ItemFlintAndSteel extends Item {

    public ItemFlintAndSteel(int paramInt) {
        super(paramInt);
        aT = 1;
        aU = 64;
    }

    public boolean a(ItemStack paramgp, EntityPlayer paramfc, World paramdy, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        int dbl = paramdy.a(paramInt1, paramInt2, paramInt3);

        if (dbl == 52 || dbl == 46) {
            paramdy.d(paramInt1, paramInt2, paramInt3, 0);
        }
        if (dbl == 7 && paramInt2 > 5) {
            paramdy.d(paramInt1, paramInt2, paramInt3, 0);
        }
        if (paramInt4 == 0) {
            paramInt2--;
        }
        if (paramInt4 == 1) {
            paramInt2++;
        }
        if (paramInt4 == 2) {
            paramInt3--;
        }
        if (paramInt4 == 3) {
            paramInt3++;
        }
        if (paramInt4 == 4) {
            paramInt1--;
        }
        if (paramInt4 == 5) {
            paramInt1++;
        }
        int i = paramdy.a(paramInt1, paramInt2, paramInt3);

        if (i == 0) {
            paramdy.d(paramInt1, paramInt2, paramInt3, 20);
            paramdy.d(paramInt1, paramInt2, paramInt3, 0);
        }
        paramgp.a(1);
        return true;
    }
}
