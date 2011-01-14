package net.minecraft.server;

import java.lang.reflect.Constructor;
import java.util.*;

public final class SpawnerAnimals {

    private static Set a = new HashSet();

    public SpawnerAnimals() {}

    protected static ChunkPosition a(World world, int i, int j) {
        int k = i + world.l.nextInt(16);
        int l = world.l.nextInt(128);
        int i1 = j + world.l.nextInt(16);

        return new ChunkPosition(k, l, i1);
    }

    public static final int a(World world, boolean flag, boolean flag1) {/**
         * broken decompile
         */}

    private static boolean a(EnumCreatureType enumcreaturetype, World world, int i, int j, int k) {
        if (enumcreaturetype.c() == Material.f) {
            return world.c(i, j, k).d() && !world.d(i, j + 1, k);
        } else {
            return world.d(i, j - 1, k) && !world.d(i, j, k) && !world.c(i, j, k).d() && !world.d(i, j + 1, k);
        }
    }

    private static void a(EntityLiving entityliving, World world, float f, float f1, float f2) {
        if ((entityliving instanceof EntitySpider) && world.l.nextInt(100) == 0) {
            EntitySkeleton entityskeleton = new EntitySkeleton(world);

            entityskeleton.c(f, f1, f2, entityliving.v, 0.0F);
            world.a(((Entity) (entityskeleton)));
            entityskeleton.e(((Entity) (entityliving)));
        } else if (entityliving instanceof EntitySheep) {
            ((EntitySheep) entityliving).a(EntitySheep.a(world.l));
        }
    }
}
