package net.minecraft.server;

public class ItemSeeds extends Item {

    private int a;

    public ItemSeeds(int i, int j) {
        super(i);
        a = j;
    }

    public boolean a(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l) {
        if (l != 1) {
            return false;
        }
        int i1 = world.a(i, j, k);

        if (i1 == Block.aB.bc) {
            world.d(i, j + 1, k, a);
            itemstack.a--;
            return true;
        } else {
            return false;
        }
    }
}
