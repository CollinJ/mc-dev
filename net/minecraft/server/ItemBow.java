package net.minecraft.server;

import java.util.Random;

public class ItemBow extends Item {

    public ItemBow(int i) {
        super(i);
        aX = 1;
    }

    public ItemStack a(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        if (entityplayer.al.b(Item.j.aW)) {
            world.a(((Entity) (entityplayer)), "random.bow", 1.0F, 1.0F / (b.nextFloat() * 0.4F + 0.8F));
            world.a(((Entity) (new EntityArrow(world, ((EntityLiving) (entityplayer))))));
        }
        return itemstack;
    }
}
