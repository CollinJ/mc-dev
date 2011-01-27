package net.minecraft.server;

public class ItemTool extends Item {

    private Block bg[];
    public float bh;
    private int bi;
    protected EnumToolMaterial a;

    protected ItemTool(int i, int j, EnumToolMaterial enumtoolmaterial, Block ablock[]) {
        super(i);
        bh = 4F;
        a = enumtoolmaterial;
        bg = ablock;
        bb = 1;
        bc = enumtoolmaterial.a();
        bh = enumtoolmaterial.b();
        bi = j + enumtoolmaterial.c();
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
