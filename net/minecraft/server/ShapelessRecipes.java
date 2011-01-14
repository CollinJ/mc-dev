package net.minecraft.server;

import java.util.*;

public class ShapelessRecipes implements CraftingRecipe {

    private final ItemStack a;
    private final List b;

    public ShapelessRecipes(ItemStack itemstack, List list) {
        a = itemstack;
        b = list;
    }

    public boolean a(InventoryCrafting inventorycrafting) {
        ArrayList arraylist = new ArrayList(((java.util.Collection) (b)));
        int i = 0;

        do {
            if (i >= 3) {
                break;
            }
            for (int j = 0; j < 3; j++) {
                ItemStack itemstack = inventorycrafting.a(j, i);

                if (itemstack == null) {
                    continue;
                }
                boolean flag = false;
                Iterator iterator = ((List) (arraylist)).iterator();

                do {
                    if (!iterator.hasNext()) {
                        break;
                    }
                    ItemStack itemstack1 = (ItemStack) iterator.next();

                    if (itemstack.c != itemstack1.c || itemstack1.h() != -1 && itemstack.h() != itemstack1.h()) {
                        continue;
                    }
                    flag = true;
                    ((List) (arraylist)).remove(((itemstack1)));
                    break;
                } while (true);
                if (!flag) {
                    return false;
                }
            }

            i++;
        } while (true);
        return ((List) (arraylist)).isEmpty();
    }

    public ItemStack b(InventoryCrafting inventorycrafting) {
        return a.j();
    }

    public int a() {
        return b.size();
    }
}
