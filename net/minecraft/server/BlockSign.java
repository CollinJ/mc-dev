package net.minecraft.server;

import java.util.Random;

public class BlockSign extends BlockContainer {

    private Class a;
    private boolean b;

    protected BlockSign(int i, Class class1, boolean flag) {
        super(i, Material.c);
        b = flag;
        bb = 4;
        a = class1;
        float f = 0.25F;
        float f1 = 1.0F;

        a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
    }

    public AxisAlignedBB d(World world, int i, int j, int k) {
        return null;
    }

    public void a(IBlockAccess iblockaccess, int i, int j, int k) {
        if (b) {
            return;
        }
        int l = iblockaccess.b(i, j, k);
        float f = 0.28125F;
        float f1 = 0.78125F;
        float f2 = 0.0F;
        float f3 = 1.0F;
        float f4 = 0.125F;

        a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        if (l == 2) {
            a(f2, f, 1.0F - f4, f3, f1, 1.0F);
        }
        if (l == 3) {
            a(f2, f, 0.0F, f3, f1, f4);
        }
        if (l == 4) {
            a(1.0F - f4, f, f2, 1.0F, f1, f3);
        }
        if (l == 5) {
            a(0.0F, f, f2, f4, f1, f3);
        }
    }

    public int a() {
        return -1;
    }

    public boolean b() {
        return false;
    }

    protected TileEntity a_() {
        try {
            return (TileEntity) a.newInstance();
        } catch (Exception exception) {
            throw new RuntimeException(((Throwable) (exception)));
        }
    }

    public int a(int i, Random random) {
        return Item.as.aS;
    }

    public void b(World world, int i, int j, int k, int l) {
        boolean flag = false;

        if (b) {
            if (!world.c(i, j - 1, k).a()) {
                flag = true;
            }
        } else {
            int i1 = world.b(i, j, k);

            flag = true;
            if (i1 == 2 && world.c(i, j, k + 1).a()) {
                flag = false;
            }
            if (i1 == 3 && world.c(i, j, k - 1).a()) {
                flag = false;
            }
            if (i1 == 4 && world.c(i + 1, j, k).a()) {
                flag = false;
            }
            if (i1 == 5 && world.c(i - 1, j, k).a()) {
                flag = false;
            }
        }
        if (flag) {
            a_(world, i, j, k, world.b(i, j, k));
            world.d(i, j, k, 0);
        }
        super.b(world, i, j, k, l);
    }
}
