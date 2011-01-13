package net.minecraft.server;

import java.util.Random;

public class BlockTNT extends Block {

    public BlockTNT(int i, int j) {
        super(i, j, Material.p);
    }

    public int a(int i) {
        if (i == 0) {
            return bh + 2;
        }
        if (i == 1) {
            return bh + 1;
        } else {
            return bh;
        }
    }

    public void b(World world, int i, int j, int k, int l) {
        if (l > 0 && Block.m[l].c() && world.p(i, j, k)) {
            a(world, i, j, k, 0);
            world.e(i, j, k, 0);
        }
    }

    public int a(Random random) {
        return 0;
    }

    public void a_(World world, int i, int j, int k) {
        EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(world, (float) i + 0.5F, (float) j + 0.5F, (float) k + 0.5F);

        entitytntprimed.a = world.l.nextInt(entitytntprimed.a / 4) + entitytntprimed.a / 8;
        world.a(((Entity) (entitytntprimed)));
    }

    public void a(World world, int i, int j, int k, int l) {
        if (world.z) {
            return;
        } else {
            EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(world, (float) i + 0.5F, (float) j + 0.5F, (float) k + 0.5F);

            world.a(((Entity) (entitytntprimed)));
            world.a(((Entity) (entitytntprimed)), "random.fuse", 1.0F, 1.0F);
            return;
        }
    }
}
