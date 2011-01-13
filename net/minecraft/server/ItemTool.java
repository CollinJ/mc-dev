package net.minecraft.server;

public class ItemTool extends Item {

    private Block bg[];
    private float bh;
    private int bi;
    protected bv a;

    protected ItemTool(int i, int j, bv bv1, Block ablock[]) {
        super(i);
        bh = 4F;
        a = bv1;
        bg = ablock;
        bb = 1;
        bc = bv1.a();
        bh = bv1.b();
        bi = j + bv1.c();
    }

    public float a(ItemStack itemstack, Block block) {
        for (int i = 0; i < bg.length; i++) {
            if (bg[i] == block) {
                return bh;
            }
        }

        return 1.0F;
    }

    public void a(ItemStack itemstack, EntityLiving entityliving) {
        itemstack.b(2);
    }

    public void a(ItemStack itemstack, int i, int j, int k, int l) {
        itemstack.b(1);
    }

    public int a(Entity entity) {
        return bi;
    }
}
