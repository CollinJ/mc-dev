package net.minecraft.server;

public class ItemReed extends Item {

    private int a;

    public ItemReed(int i, Block block) {
        super(i);
        a = block.bc;
    }

    public boolean a(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l) {
        if (world.a(i, j, k) == Block.aT.bc) {
            l = 0;
        } else {
            if (l == 0) {
                j--;
            }
            if (l == 1) {
                j++;
            }
            if (l == 2) {
                k--;
            }
            if (l == 3) {
                k++;
            }
            if (l == 4) {
                i--;
            }
            if (l == 5) {
                i++;
            }
        }
        if (itemstack.a == 0) {
            return false;
        }
        if (world.a(a, i, j, k, false)) {
            Block block = Block.n[a];

            if (world.d(i, j, k, a)) {
                Block.n[a].c(world, i, j, k, l);
                world.a((float) i + 0.5F, (float) j + 0.5F, (float) k + 0.5F, block.bl.c(), (block.bl.a() + 1.0F) / 2.0F, block.bl.b() * 0.8F);
                itemstack.a--;
            }
        }
        return true;
    }
}
