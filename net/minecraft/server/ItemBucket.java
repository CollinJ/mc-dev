package net.minecraft.server;

public class ItemBucket extends Item {

    private int a;

    public ItemBucket(int paramInt1, int paramInt2) {
        super(paramInt1);
        aT = 1;
        aU = 64;
        a = paramInt2;
    }

    public boolean a(ItemStack paramgp, EntityPlayer paramfc, World paramdy, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
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
        if (a == 0) {
            int i1 = paramdy.a(paramInt1, paramInt2, paramInt3);

            if (i1 == 8 || i1 == 9 || i1 == 10 || i1 == 11) {
                paramdy.d(paramInt1, paramInt2, paramInt3, 0);
            }
        }
        int i = paramdy.a(paramInt1, paramInt2, paramInt3);

        if (i == 0) {
            paramdy.d(paramInt1, paramInt2, paramInt3, a);
        }
        paramgp.a(1);
        return true;
    }
}
