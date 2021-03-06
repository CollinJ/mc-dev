package net.minecraft.server;

import java.util.Random;

public class BlockDoor extends Block {

    protected BlockDoor(int i, Material material) {
        super(i, material);
        bh = 97;
        if (material == Material.e) {
            bh++;
        }
        float f = 0.5F;
        float f1 = 1.0F;

        a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
    }

    public boolean a() {
        return false;
    }

    public AxisAlignedBB d(World world, int i, int j, int k) {
        a(((IBlockAccess) (world)), i, j, k);
        return super.d(world, i, j, k);
    }

    public void a(IBlockAccess iblockaccess, int i, int j, int k) {
        c(d(iblockaccess.b(i, j, k)));
    }

    public void c(int i) {
        float f = 0.1875F;

        a(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
        if (i == 0) {
            a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
        }
        if (i == 1) {
            a(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }
        if (i == 2) {
            a(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
        }
        if (i == 3) {
            a(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
        }
    }

    public void b(World world, int i, int j, int k, EntityPlayer entityplayer) {
        a(world, i, j, k, entityplayer);
    }

    public boolean a(World world, int i, int j, int k, EntityPlayer entityplayer) {
        if (bt == Material.e) {
            return true;
        }
        int l = world.b(i, j, k);

        if ((l & 8) != 0) {
            if (world.a(i, j - 1, k) == bi) {
                a(world, i, j - 1, k, entityplayer);
            }
            return true;
        }
        if (world.a(i, j + 1, k) == bi) {
            world.c(i, j + 1, k, (l ^ 4) + 8);
        }
        world.c(i, j, k, l ^ 4);
        world.b(i, j - 1, k, i, j, k);
        if (Math.random() < 0.5D) {
            world.a((double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, "random.door_open", 1.0F, world.l.nextFloat() * 0.1F + 0.9F);
        } else {
            world.a((double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, "random.door_close", 1.0F, world.l.nextFloat() * 0.1F + 0.9F);
        }
        return true;
    }

    public void a(World world, int i, int j, int k, boolean flag) {
        int l = world.b(i, j, k);

        if ((l & 8) != 0) {
            if (world.a(i, j - 1, k) == bi) {
                a(world, i, j - 1, k, flag);
            }
            return;
        }
        boolean flag1 = (world.b(i, j, k) & 4) > 0;

        if (flag1 == flag) {
            return;
        }
        if (world.a(i, j + 1, k) == bi) {
            world.c(i, j + 1, k, (l ^ 4) + 8);
        }
        world.c(i, j, k, l ^ 4);
        world.b(i, j - 1, k, i, j, k);
        if (Math.random() < 0.5D) {
            world.a((double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, "random.door_open", 1.0F, world.l.nextFloat() * 0.1F + 0.9F);
        } else {
            world.a((double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, "random.door_close", 1.0F, world.l.nextFloat() * 0.1F + 0.9F);
        }
    }

    public void b(World world, int i, int j, int k, int l) {
        int i1 = world.b(i, j, k);

        if ((i1 & 8) != 0) {
            if (world.a(i, j - 1, k) != bi) {
                world.e(i, j, k, 0);
            }
            if (l > 0 && Block.m[l].c()) {
                b(world, i, j - 1, k, l);
            }
        } else {
            boolean flag = false;

            if (world.a(i, j + 1, k) != bi) {
                world.e(i, j, k, 0);
                flag = true;
            }
            if (!world.d(i, j - 1, k)) {
                world.e(i, j, k, 0);
                flag = true;
                if (world.a(i, j + 1, k) == bi) {
                    world.e(i, j + 1, k, 0);
                }
            }
            if (flag) {
                a_(world, i, j, k, i1);
            } else if (l > 0 && Block.m[l].c()) {
                boolean flag1 = world.p(i, j, k) || world.p(i, j + 1, k);

                a(world, i, j, k, flag1);
            }
        }
    }

    public int a(int i, Random random) {
        if ((i & 8) != 0) {
            return 0;
        }
        if (bt == Material.e) {
            return Item.az.ba;
        } else {
            return Item.at.ba;
        }
    }

    public MovingObjectPosition a(World world, int i, int j, int k, Vec3D vec3d, Vec3D vec3d1) {
        a(((IBlockAccess) (world)), i, j, k);
        return super.a(world, i, j, k, vec3d, vec3d1);
    }

    public int d(int i) {
        if ((i & 4) == 0) {
            return i - 1 & 3;
        } else {
            return i & 3;
        }
    }

    public boolean a(World world, int i, int j, int k) {
        if (j >= 127) {
            return false;
        } else {
            return world.d(i, j - 1, k) && super.a(world, i, j, k) && super.a(world, i, j + 1, k);
        }
    }
}
