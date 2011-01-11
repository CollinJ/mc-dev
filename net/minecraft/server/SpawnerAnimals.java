package net.minecraft.server;

import java.lang.reflect.Constructor;
import java.util.*;

public class SpawnerAnimals {

    private int a;
    private Class b;
    private Class c[];
    private Set d;

    public SpawnerAnimals(int i, Class class1, Class aclass[]) {
        d = ((Set) (new HashSet()));
        a = i;
        b = class1;
        c = aclass;
    }

    public void a(World world) {
        int i = world.a(b);

        if (i < a) {
            for (int j = 0; j < 3; j++) {
                a(world, 1, ((IProgressUpdate) (null)));
            }
        }
    }

    protected ChunkPosition a(World world, int i, int j) {
        int k = i + world.m.nextInt(16);
        int l = world.m.nextInt(128);
        int i1 = j + world.m.nextInt(16);

        return new ChunkPosition(k, l, i1);
    }

    private int a(World world, int i, IProgressUpdate iprogressupdate) {
        d.clear();
        for (int j = 0; j < world.k.size(); j++) {
            EntityPlayer entityplayer = (EntityPlayer) world.k.get(j);
            int l = MathHelper.b(entityplayer.l / 16D);
            int i1 = MathHelper.b(entityplayer.n / 16D);
            byte byte0 = 4;

            for (int k1 = -byte0; k1 <= byte0; k1++) {
                for (int i2 = -byte0; i2 <= byte0; i2++) {
                    d.add(((new ChunkCoordIntPair(k1 + l, i2 + i1))));
                }
            }
        }

        int k = 0;
        Iterator iterator = d.iterator();

        do {
            if (!iterator.hasNext()) {
                break;
            }
            ChunkCoordIntPair chunkcoordintpair = (ChunkCoordIntPair) iterator.next();

            if (world.m.nextInt(10) == 0) {
                int j1 = world.m.nextInt(c.length);
                ChunkPosition chunkposition = a(world, chunkcoordintpair.a * 16, chunkcoordintpair.b * 16);
                int l1 = chunkposition.a;
                int j2 = chunkposition.b;
                int k2 = chunkposition.c;

                if (world.d(l1, j2, k2)) {
                    return 0;
                }
                if (world.c(l1, j2, k2) != Material.a) {
                    return 0;
                }
                int l2 = 0;

                while (l2 < 3) {
                    int i3 = l1;
                    int j3 = j2;
                    int k3 = k2;
                    byte byte1 = 6;

                    for (int l3 = 0; l3 < 2; l3++) {
                        i3 += world.m.nextInt(((int) (byte1))) - world.m.nextInt(((int) (byte1)));
                        j3 += world.m.nextInt(1) - world.m.nextInt(1);
                        k3 += world.m.nextInt(((int) (byte1))) - world.m.nextInt(((int) (byte1)));
                        if (!world.d(i3, j3 - 1, k3) || world.d(i3, j3, k3) || world.c(i3, j3, k3).d() || world.d(i3, j3 + 1, k3)) {
                            continue;
                        }
                        float f = (float) i3 + 0.5F;
                        float f1 = j3;
                        float f2 = (float) k3 + 0.5F;

                        if (world.a(f, f1, f2, 24D) != null) {
                            continue;
                        }
                        float f3 = f - (float) world.n;
                        float f4 = f1 - (float) world.o;
                        float f5 = f2 - (float) world.p;
                        float f6 = f3 * f3 + f4 * f4 + f5 * f5;

                        if (f6 < 576F) {
                            continue;
                        }
                        EntityLiving entityliving;

                        try {
                            entityliving = (EntityLiving) c[j1].getConstructor(new Class[] {
                                net.minecraft.server.World.class
                            }).newInstance(new Object[] {
                                world
                            });
                        } catch (Exception exception) {
                            exception.printStackTrace();
                            return k;
                        }
                        entityliving.c(f, f1, f2, world.m.nextFloat() * 360F, 0.0F);
                        if (!entityliving.a()) {
                            continue;
                        }
                        k++;
                        world.a(((Entity) (entityliving)));
                        if ((entityliving instanceof EntitySpider) && world.m.nextInt(100) == 0) {
                            EntitySkeleton entityskeleton = new EntitySkeleton(world);

                            entityskeleton.c(f, f1, f2, entityliving.r, 0.0F);
                            world.a(((Entity) (entityskeleton)));
                            entityskeleton.e(((Entity) (entityliving)));
                        }
                    }

                    l2++;
                }
            }
        } while (true);
        return k;
    }
}
