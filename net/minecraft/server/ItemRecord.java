package net.minecraft.server;

public class ItemRecord extends Item {

    private String a;

    protected ItemRecord(int i, String s) {
        super(i);
        a = s;
        bb = 1;
    }

    public boolean a(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l) {
        if (world.a(i, j, k) == Block.aY.bi && world.b(i, j, k) == 0) {
            world.c(i, j, k, (ba - Item.aY.ba) + 1);
            world.a(a, i, j, k);
            itemstack.a--;
            return true;
        } else {
            return false;
        }
    }
}
