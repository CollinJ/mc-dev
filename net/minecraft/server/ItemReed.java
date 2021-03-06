package net.minecraft.server;

public class ItemReed extends Item {

    private int a;

    public ItemReed(int i, Block block) {
        super(i);
        a = block.bi;
    }

    public boolean a(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l) {
        if (world.a(i, j, k) == Block.aS.bi) {
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
            Block block = Block.m[a];

            if (world.e(i, j, k, a)) {
                Block.m[a].c(world, i, j, k, l);
                world.a((float) i + 0.5F, (float) j + 0.5F, (float) k + 0.5F, block.br.c(), (block.br.a() + 1.0F) / 2.0F, block.br.b() * 0.8F);
                itemstack.a--;
            }
        }
        return true;
    }
}
