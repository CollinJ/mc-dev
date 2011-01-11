package net.minecraft.server;

import java.util.Random;

public class ItemHoe extends Item {

    public ItemHoe(int i, int j) {
        super(i);
        aT = 1;
        aU = 32 << j;
    }

    public boolean a(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l) {
        int i1 = world.a(i, j, k);
        Material material = world.c(i, j + 1, k);

        if (!material.a() && i1 == Block.v.bc || i1 == Block.w.bc) {
            Block block = Block.aB;

            world.a((float) i + 0.5F, (float) j + 0.5F, (float) k + 0.5F, block.bl.c(), (block.bl.a() + 1.0F) / 2.0F, block.bl.b() * 0.8F);
            world.d(i, j, k, block.bc);
            itemstack.a(1);
            if (world.m.nextInt(8) == 0 && i1 == Block.v.bc) {
                int j1 = 1;

                for (int k1 = 0; k1 < j1; k1++) {
                    float f = 0.7F;
                    float f1 = world.m.nextFloat() * f + (1.0F - f) * 0.5F;
                    float f2 = 1.2F;
                    float f3 = world.m.nextFloat() * f + (1.0F - f) * 0.5F;
                    EntityItem entityitem = new EntityItem(world, (float) i + f1, (float) j + f2, (float) k + f3, new ItemStack(Item.Q));

                    entityitem.ad = 10;
                    world.a(((Entity) (entityitem)));
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
