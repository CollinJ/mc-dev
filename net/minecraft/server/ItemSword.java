package net.minecraft.server;

public class ItemSword extends Item {

    private int a;

    public ItemSword(int i, bv bv1) {
        super(i);
        bb = 1;
        bc = bv1.a();
        a = 4 + bv1.c() * 2;
    }

    public float a(ItemStack itemstack, Block block) {
        return 1.5F;
    }

    public void a(ItemStack itemstack, EntityLiving entityliving) {
        itemstack.b(1);
    }

    public void a(ItemStack itemstack, int i, int j, int k, int l) {
        itemstack.b(2);
    }

    public int a(Entity entity) {
        return a;
    }
}
