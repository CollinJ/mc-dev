package net.minecraft.server;

import java.util.ArrayList;
import java.util.Random;

public class BlockStairs extends Block {

    private Block a;

    protected BlockStairs(int j, Block block) {
        super(j, block.bb, block.bn);
        a = block;
        c(block.bd);
        b(block.be / 3F);
        a(block.bl);
    }

    public boolean b() {
        return false;
    }

    public int a() {
        return 10;
    }

    public boolean a(IBlockAccess iblockaccess, int j, int k, int l, int i1) {
        return super.a(iblockaccess, j, k, l, i1);
    }

    public void a(World world, int j, int k, int l, AxisAlignedBB axisalignedbb, ArrayList arraylist) {
        int i1 = world.b(j, k, l);

        if (i1 == 0) {
            a(0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 1.0F);
            super.a(world, j, k, l, axisalignedbb, arraylist);
            a(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            super.a(world, j, k, l, axisalignedbb, arraylist);
        } else if (i1 == 1) {
            a(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
            super.a(world, j, k, l, axisalignedbb, arraylist);
            a(0.5F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
            super.a(world, j, k, l, axisalignedbb, arraylist);
        } else if (i1 == 2) {
            a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 0.5F);
            super.a(world, j, k, l, axisalignedbb, arraylist);
            a(0.0F, 0.0F, 0.5F, 1.0F, 1.0F, 1.0F);
            super.a(world, j, k, l, axisalignedbb, arraylist);
        } else if (i1 == 3) {
            a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
            super.a(world, j, k, l, axisalignedbb, arraylist);
            a(0.0F, 0.0F, 0.5F, 1.0F, 0.5F, 1.0F);
            super.a(world, j, k, l, axisalignedbb, arraylist);
        }
        a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public void b(World world, int j, int k, int l, int i1) {
        if (world.x) {
            return;
        }
        if (world.c(j, k + 1, l).a()) {
            world.d(j, k, l, a.bc);
        } else {
            g(world, j, k, l);
            g(world, j + 1, k - 1, l);
            g(world, j - 1, k - 1, l);
            g(world, j, k - 1, l - 1);
            g(world, j, k - 1, l + 1);
            g(world, j + 1, k + 1, l);
            g(world, j - 1, k + 1, l);
            g(world, j, k + 1, l - 1);
            g(world, j, k + 1, l + 1);
        }
        a.b(world, j, k, l, i1);
    }

    private void g(World world, int j, int k, int l) {
        if (!i(world, j, k, l)) {
            return;
        }
        byte byte0 = -1;

        if (i(world, j + 1, k + 1, l)) {
            byte0 = 0;
        }
        if (i(world, j - 1, k + 1, l)) {
            byte0 = 1;
        }
        if (i(world, j, k + 1, l + 1)) {
            byte0 = 2;
        }
        if (i(world, j, k + 1, l - 1)) {
            byte0 = 3;
        }
        if (byte0 < 0) {
            if (h(world, j + 1, k, l) && !h(world, j - 1, k, l)) {
                byte0 = 0;
            }
            if (h(world, j - 1, k, l) && !h(world, j + 1, k, l)) {
                byte0 = 1;
            }
            if (h(world, j, k, l + 1) && !h(world, j, k, l - 1)) {
                byte0 = 2;
            }
            if (h(world, j, k, l - 1) && !h(world, j, k, l + 1)) {
                byte0 = 3;
            }
        }
        if (byte0 < 0) {
            if (i(world, j - 1, k - 1, l)) {
                byte0 = 0;
            }
            if (i(world, j + 1, k - 1, l)) {
                byte0 = 1;
            }
            if (i(world, j, k - 1, l - 1)) {
                byte0 = 2;
            }
            if (i(world, j, k - 1, l + 1)) {
                byte0 = 3;
            }
        }
        if (byte0 >= 0) {
            world.b(j, k, l, ((int) (byte0)));
        }
    }

    private boolean h(World world, int j, int k, int l) {
        return world.c(j, k, l).a();
    }

    private boolean i(World world, int j, int k, int l) {
        int i1 = world.a(j, k, l);

        if (i1 == 0) {
            return false;
        } else {
            return Block.n[i1].a() == 10;
        }
    }

    public void b(World world, int j, int k, int l, EntityPlayer entityplayer) {
        a.b(world, j, k, l, entityplayer);
    }

    public void a(World world, int j, int k, int l, int i1) {
        a.a(world, j, k, l, i1);
    }

    public float a(Entity entity) {
        return a.a(entity);
    }

    public int a(int j, Random random) {
        return a.a(j, random);
    }

    public int a(Random random) {
        return a.a(random);
    }

    public int a(int j) {
        return a.a(j);
    }

    public int c() {
        return a.c();
    }

    public void a(World world, int j, int k, int l, Entity entity, Vec3D vec3d) {
        a.a(world, j, k, l, entity, vec3d);
    }

    public boolean e() {
        return a.e();
    }

    public boolean a(int j, boolean flag) {
        return a.a(j, flag);
    }

    public boolean a(World world, int j, int k, int l) {
        return a.a(world, j, k, l);
    }

    public void e(World world, int j, int k, int l) {
        b(world, j, k, l, 0);
        a.e(world, j, k, l);
    }

    public void b(World world, int j, int k, int l) {
        a.b(world, j, k, l);
    }

    public void a(World world, int j, int k, int l, int i1, float f) {
        a.a(world, j, k, l, i1, f);
    }

    public void a_(World world, int j, int k, int l, int i1) {
        a.a_(world, j, k, l, i1);
    }

    public void b(World world, int j, int k, int l, Entity entity) {
        a.b(world, j, k, l, entity);
    }

    public void a(World world, int j, int k, int l, Random random) {
        a.a(world, j, k, l, random);
    }

    public boolean a(World world, int j, int k, int l, EntityPlayer entityplayer) {
        return a.a(world, j, k, l, entityplayer);
    }

    public void c(World world, int j, int k, int l) {
        a.c(world, j, k, l);
    }
}
