package net.minecraft.server;

public interface CraftingRecipe {

    public abstract boolean a(InventoryCrafting inventorycrafting);

    public abstract ItemStack b(InventoryCrafting inventorycrafting);

    public abstract int a();
}
