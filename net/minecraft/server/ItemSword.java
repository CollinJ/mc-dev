package net.minecraft.server;

public class ItemSword extends Item {

    private int a;

    public ItemSword(int i, int j) {
        super(i);
        aT = 1;
        aU = 32 << j;
        if (j == 3) {
            aU *= 4;
        }
        a = 4 + j * 2;
    }

    public float a(ItemStack itemstack, Block block) {
        return 1.5F;
    }

    public void a(ItemStack itemstack, int i, int j, int k, int l) {
        itemstack.a(2);
    }
}