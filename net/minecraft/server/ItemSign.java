package net.minecraft.server;

public class ItemSign extends Item {

    public ItemSign(int i) {
        super(i);
        aU = 64;
        aT = 1;
    }

    public boolean a(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l) {
        if (l == 0) {
            return false;
        }
        if (!world.c(i, j, k).a()) {
            return false;
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
        if (!Block.aE.a(world, i, j, k)) {
            return false;
        }
        if (l == 1) {
            world.b(i, j, k, Block.aE.bc, MathHelper.b((double) (((entityplayer.r + 180F) * 16F) / 360F) + 0.5D) & 0xf);
        } else {
            world.b(i, j, k, Block.aJ.bc, l);
        }
        itemstack.a--;
        entityplayer.a((TileEntitySign) world.k(i, j, k));
        return true;
    }
}
