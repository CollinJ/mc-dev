package net.minecraft.server;

public class jf implements CraftingRecipe {

    private int b;
    private int c;
    private ItemStack d[];
    private ItemStack e;
    public final int a;

    public jf(int i, int j, ItemStack aitemstack[], ItemStack itemstack) {
        a = itemstack.c;
        b = i;
        c = j;
        d = aitemstack;
        e = itemstack;
    }

    public boolean a(InventoryCrafting inventorycrafting) {
        for (int i = 0; i <= 3 - b; i++) {
            for (int j = 0; j <= 3 - c; j++) {
                if (a(inventorycrafting, i, j, true)) {
                    return true;
                }
                if (a(inventorycrafting, i, j, false)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean a(InventoryCrafting inventorycrafting, int i, int j, boolean flag) {
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                int i1 = k - i;
                int j1 = l - j;
                ItemStack itemstack = null;

                if (i1 >= 0 && j1 >= 0 && i1 < b && j1 < c) {
                    if (flag) {
                        itemstack = d[(b - i1 - 1) + j1 * b];
                    } else {
                        itemstack = d[i1 + j1 * b];
                    }
                }
                ItemStack itemstack1 = inventorycrafting.a(k, l);

                if (itemstack1 == null && itemstack == null) {
                    continue;
                }
                if (itemstack1 == null && itemstack != null || itemstack1 != null && itemstack == null) {
                    return false;
                }
                if (itemstack.c != itemstack1.c) {
                    return false;
                }
                if (itemstack.h() != -1 && itemstack.h() != itemstack1.h()) {
                    return false;
                }
            }
        }

        return true;
    }

    public ItemStack b(InventoryCrafting inventorycrafting) {
        return new ItemStack(e.c, e.a, e.h());
    }

    public int a() {
        return b * c;
    }
}
