package net.minecraft.server;

import java.util.Random;

public class ItemFishingRod extends Item {

    public ItemFishingRod(int i) {
        super(i);
        aY = 64;
    }

    public ItemStack a(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        if (entityplayer.at != null) {
            int i = entityplayer.at.c();

            itemstack.a(i);
            entityplayer.E();
        } else {
            world.a(((Entity) (entityplayer)), "random.bow", 0.5F, 0.4F / (b.nextFloat() * 0.4F + 0.8F));
            if (!world.z) {
                world.a(((Entity) (new EntityFish(world, entityplayer))));
            }
            entityplayer.E();
        }
        return itemstack;
    }
}
