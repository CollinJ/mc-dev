package net.minecraft.server;

import java.util.*;

public class Explosion {

    public Explosion() {}

    public void a(World world, Entity entity, double d, double d1, double d2, float f) {
        world.a(d, d1, d2, "random.explode", 4F, (1.0F + (world.m.nextFloat() - world.m.nextFloat()) * 0.2F) * 0.7F);
        HashSet hashset = new HashSet();
        float f1 = f;
        int i = 16;

        for (int j = 0; j < i; j++) {
            for (int l = 0; l < i; l++) {
                label0:
                for (int j1 = 0; j1 < i; j1++) {
                    if (j != 0 && j != i - 1 && l != 0 && l != i - 1 && j1 != 0 && j1 != i - 1) {
                        continue;
                    }
                    double d3 = ((float) j / ((float) i - 1.0F)) * 2.0F - 1.0F;
                    double d4 = ((float) l / ((float) i - 1.0F)) * 2.0F - 1.0F;
                    double d5 = ((float) j1 / ((float) i - 1.0F)) * 2.0F - 1.0F;
                    double d6 = Math.sqrt(d3 * d3 + d4 * d4 + d5 * d5);

                    d3 /= d6;
                    d4 /= d6;
                    d5 /= d6;
                    float f2 = f * (0.7F + world.m.nextFloat() * 0.6F);
                    double d7 = d;
                    double d9 = d1;
                    double d11 = d2;
                    float f3 = 0.3F;

                    do {
                        if (f2 <= 0.0F) {
                            continue label0;
                        }
                        int i2 = MathHelper.b(d7);
                        int j2 = MathHelper.b(d9);
                        int k2 = MathHelper.b(d11);
                        int l2 = world.a(i2, j2, k2);

                        if (l2 > 0) {
                            f2 -= (Block.n[l2].a(entity) + 0.3F) * f3;
                        }
                        if (f2 > 0.0F) {
                            ((Set) (hashset)).add(((new ChunkPosition(i2, j2, k2))));
                        }
                        d7 += d3 * (double) f3;
                        d9 += d4 * (double) f3;
                        d11 += d5 * (double) f3;
                        f2 -= f3 * 0.75F;
                    } while (true);
                }
            }
        }

        f *= 2.0F;
        int k = MathHelper.b(d - (double) f - 1.0D);
        int i1 = MathHelper.b(d + (double) f + 1.0D);
        int k1 = MathHelper.b(d1 - (double) f - 1.0D);
        int i3 = MathHelper.b(d1 + (double) f + 1.0D);
        int j3 = MathHelper.b(d2 - (double) f - 1.0D);
        int k3 = MathHelper.b(d2 + (double) f + 1.0D);
        List list = world.b(entity, AxisAlignedBB.b(k, k1, j3, i1, i3, k3));
        Vec3D vec3d = Vec3D.b(d, d1, d2);

        for (int l3 = 0; l3 < list.size(); l3++) {
            Entity entity1 = (Entity) list.get(l3);
            double d14 = entity1.e(d, d1, d2) / (double) f;

            if (d14 <= 1.0D) {
                double d8 = entity1.l - d;
                double d10 = entity1.m - d1;
                double d12 = entity1.n - d2;
                double d15 = MathHelper.a(d8 * d8 + d10 * d10 + d12 * d12);

                d8 /= d15;
                d10 /= d15;
                d12 /= d15;
                double d17 = world.a(vec3d, entity1.v);
                double d19 = (1.0D - d14) * d17;

                entity1.a(entity, (int) (((d19 * d19 + d19) / 2D) * 8D * (double) f + 1.0D));
                double d21 = d19;

                entity1.o += d8 * d21;
                entity1.p += d10 * d21;
                entity1.q += d12 * d21;
            }
        }

        f = f1;
        ArrayList arraylist = new ArrayList();

        ((List) (arraylist)).addAll(((java.util.Collection) (hashset)));
        for (int i4 = ((List) (arraylist)).size() - 1; i4 >= 0; i4--) {
            ChunkPosition chunkposition = (ChunkPosition) ((List) (arraylist)).get(i4);
            int l1 = chunkposition.a;
            int j4 = chunkposition.b;
            int k4 = chunkposition.c;
            int l4 = world.a(l1, j4, k4);

            for (int i5 = 0; i5 < 1; i5++) {
                double d13 = (float) l1 + world.m.nextFloat();
                double d16 = (float) j4 + world.m.nextFloat();
                double d18 = (float) k4 + world.m.nextFloat();
                double d20 = d13 - d;
                double d22 = d16 - d1;
                double d23 = d18 - d2;
                double d24 = MathHelper.a(d20 * d20 + d22 * d22 + d23 * d23);

                d20 /= d24;
                d22 /= d24;
                d23 /= d24;
                double d25 = 0.5D / (d24 / (double) f + 0.10000000000000001D);

                d25 *= world.m.nextFloat() * world.m.nextFloat() + 0.3F;
                d20 *= d25;
                d22 *= d25;
                d23 *= d25;
                world.a("explode", (d13 + d * 1.0D) / 2D, (d16 + d1 * 1.0D) / 2D, (d18 + d2 * 1.0D) / 2D, d20, d22, d23);
                world.a("smoke", d13, d16, d18, d20, d22, d23);
            }

            if (l4 > 0) {
                Block.n[l4].a(world, l1, j4, k4, world.b(l1, j4, k4), 0.3F);
                world.d(l1, j4, k4, 0);
                Block.n[l4].c(world, l1, j4, k4);
            }
        }
    }
}
