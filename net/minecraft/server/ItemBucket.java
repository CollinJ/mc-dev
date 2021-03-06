package net.minecraft.server;

import java.util.Random;

public class ItemBucket extends Item {

    private int a;

    public ItemBucket(int i, int j) {
        super(i);
        bb = 1;
        bc = 64;
        a = j;
    }

    public ItemStack a(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        float f = 1.0F;
        float f1 = entityplayer.y + (entityplayer.w - entityplayer.y) * f;
        float f2 = entityplayer.x + (entityplayer.v - entityplayer.x) * f;
        double d = entityplayer.m + (entityplayer.p - entityplayer.m) * (double) f;
        double d1 = (entityplayer.n + (entityplayer.q - entityplayer.n) * (double) f + 1.6200000000000001D) - (double) entityplayer.H;
        double d2 = entityplayer.o + (entityplayer.r - entityplayer.o) * (double) f;
        Vec3D vec3d = Vec3D.b(d, d1, d2);
        float f3 = MathHelper.b(-f2 * 0.01745329F - 3.141593F);
        float f4 = MathHelper.a(-f2 * 0.01745329F - 3.141593F);
        float f5 = -MathHelper.b(-f1 * 0.01745329F);
        float f6 = MathHelper.a(-f1 * 0.01745329F);
        float f7 = f4 * f5;
        float f8 = f6;
        float f9 = f3 * f5;
        double d3 = 5D;
        Vec3D vec3d1 = vec3d.c((double) f7 * d3, (double) f8 * d3, (double) f9 * d3);
        MovingObjectPosition movingobjectposition = world.a(vec3d, vec3d1, a == 0);

        if (movingobjectposition == null) {
            return itemstack;
        }
        if (movingobjectposition.a == EnumMovingObjectType.a) {
            int i = movingobjectposition.b;
            int j = movingobjectposition.c;
            int k = movingobjectposition.d;

            if (!world.a(entityplayer, i, j, k)) {
                return itemstack;
            }
            if (a == 0) {
                if (world.c(i, j, k) == Material.f && world.b(i, j, k) == 0) {
                    world.e(i, j, k, 0);
                    return new ItemStack(Item.av);
                }
                if (world.c(i, j, k) == Material.g && world.b(i, j, k) == 0) {
                    world.e(i, j, k, 0);
                    return new ItemStack(Item.aw);
                }
            } else {
                if (a < 0) {
                    return new ItemStack(Item.au);
                }
                if (movingobjectposition.e == 0) {
                    j--;
                }
                if (movingobjectposition.e == 1) {
                    j++;
                }
                if (movingobjectposition.e == 2) {
                    k--;
                }
                if (movingobjectposition.e == 3) {
                    k++;
                }
                if (movingobjectposition.e == 4) {
                    i--;
                }
                if (movingobjectposition.e == 5) {
                    i++;
                }
                if (world.e(i, j, k) || !world.c(i, j, k).a()) {
                    if (world.q.d && a == Block.A.bi) {
                        world.a(d + 0.5D, d1 + 0.5D, d2 + 0.5D, "random.fizz", 0.5F, 2.6F + (world.l.nextFloat() - world.l.nextFloat()) * 0.8F);
                        for (int l = 0; l < 8; l++) {
                            world.a("largesmoke", (double) i + Math.random(), (double) j + Math.random(), (double) k + Math.random(), 0.0D, 0.0D, 0.0D);
                        }
                    } else {
                        world.b(i, j, k, a, 0);
                    }
                    return new ItemStack(Item.au);
                }
            }
        } else if (a == 0 && (movingobjectposition.g instanceof EntityCow)) {
            return new ItemStack(Item.aE);
        }
        return itemstack;
    }
}
