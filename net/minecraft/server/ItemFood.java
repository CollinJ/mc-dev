package net.minecraft.server;

public class ItemFood extends Item {

    private int a;

    public ItemFood(int i, int j) {
        super(i);
        a = j;
        bb = 1;
    }

    public ItemStack a(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        itemstack.a--;
        entityplayer.d(a);
        return itemstack;
    }
}
