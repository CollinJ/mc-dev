package net.minecraft.server;

import java.lang.reflect.Constructor;
import java.util.*;

public final class SpawnerAnimals
{
    private static Set<ChunkCoordIntPair> a = new HashSet<ChunkCoordIntPair>();

    public SpawnerAnimals() {
    }

    protected static ChunkPosition a(World world, int i, int j) {
        int k = i + world.l.nextInt(16);
        int l = world.l.nextInt(128);
        int i1 = j + world.l.nextInt(16);

        return new ChunkPosition(k, l, i1);
    }

    public static final int a(World world, boolean flag, boolean flag1) {
        int j;
        int l;
        int j1;
        if (!flag && !flag1)
            return 0;
        a.clear();
        for (int i = 0; i < world.d.size(); i++) {
            EntityPlayer entityplayer = (EntityPlayer) world.d.get(i);
            int k = MathHelper.b(entityplayer.p / 16D);
            int i1 = MathHelper.b(entityplayer.r / 16D);
            byte byte0 = 8;
            for (int k1 = -byte0; k1 <= byte0; k1++) {
                for (int l1 = -byte0; l1 <= byte0; l1++)
                    a.add(new ChunkCoordIntPair(k1 + k, l1 + i1));
            }
        }

        j = 0;
        for (EnumCreatureType enumcreaturetype : EnumCreatureType.values()) {
            if ((enumcreaturetype.d() && !flag1) || (!enumcreaturetype.d() && !flag)) {
                continue;
            }
            if (world.a(enumcreaturetype.a()) <= (enumcreaturetype.b() * a.size())) {
                continue;
            }
            continue_here:
            for (ChunkCoordIntPair chunkcoordintpair : a) {
                MobSpawnerBase mobspawnerbase = world.a().a(chunkcoordintpair);
                Class[] aclass = mobspawnerbase.a(enumcreaturetype);
                if (aclass != null && aclass.length != 0)
                    continue;
                int i2 = world.l.nextInt(aclass.length);
                ChunkPosition chunkposition_13 = a(world, chunkcoordintpair.a * 16, chunkcoordintpair.b * 16);
                int j2 = chunkposition_13.a;
                int k2 = chunkposition_13.b;
                int l2 = chunkposition_13.c;
                if (world.d(j2, k2, l2))
                    continue;
                if (world.c(j2, k2, l2) != enumcreaturetype.c())
                    continue;
                int i3 = 0;
                for (int j3 = 0; j3 < 3; j3++) {
                    int k3 = j2;
                    int l3 = k2;
                    int i4 = l2;
                    byte byte1 = 6;
                    for (int j4 = 0; j4 < 4; j4++) {
                        EntityLiving entityliving;
                        k3 += world.l.nextInt(byte1) - world.l.nextInt(byte1);
                        l3 += world.l.nextInt(1) - world.l.nextInt(1);
                        i4 += world.l.nextInt(byte1) - world.l.nextInt(byte1);
                        if (a(enumcreaturetype, world, k3, l3, i4)) {
                            float f = k3 + 0.5F;
                            float f1 = l3;
                            float f2 = i4 + 0.5F;
                            if (world.a(f, f1, f2, 24D) == null) {
                                float f3 = f - world.m;
                                float f4 = f1 - world.n;
                                float f5 = f2 - world.o;
                                float f6 = f3 * f3 + f4 * f4 + f5 * f5;
                                if (f6 >= 576F) {
                                    try {
                                        entityliving = (EntityLiving) aclass[i2].getConstructor(new Class[]{World.class}).newInstance(new Object[]{world});
                                    } catch (Exception exception) {
                                        exception.printStackTrace();
                                        return j;
                                    }
                                    entityliving.c(f, f1, f2, world.l.nextFloat() * 360F, 0.0F);
                                    if (entityliving.b()) {
                                        i3++;
                                        world.a((Entity) entityliving);
                                        a(entityliving, world, f, f1, f2);
                                        if (i3 >= entityliving.j())
                                            continue continue_here;
                                        j += i3;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return j;
    }

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
