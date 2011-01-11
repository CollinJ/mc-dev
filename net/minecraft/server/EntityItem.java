package net.minecraft.server;

import java.util.Random;

public class EntityItem extends Entity {

    public ItemStack a;
    private int af;
    public int b;
    public int ad;
    private int ag;
    public float ae;

    public EntityItem(World world, double d, double d1, double d2, ItemStack itemstack) {
        super(world);
        b = 0;
        ag = 5;
        ae = (float) (Math.random() * 3.1415926535897931D * 2D);
        a(0.25F, 0.25F);
        C = E / 2.0F;
        a(d, d1, d2);
        a = itemstack;
        r = (float) (Math.random() * 360D);
        o = (float) (Math.random() * 0.20000000298023224D - 0.10000000149011612D);
        p = 0.20000000298023224D;
        q = (float) (Math.random() * 0.20000000298023224D - 0.10000000149011612D);
        H = false;
    }

    public EntityItem(World world) {
        super(world);
        b = 0;
        ag = 5;
        ae = (float) (Math.random() * 3.1415926535897931D * 2D);
        a(0.25F, 0.25F);
        C = E / 2.0F;
    }

    public void b_() {
        super.b_();
        if (ad > 0) {
            ad--;
        }
        this.i = l;
        j = m;
        k = n;
        p -= 0.039999999105930328D;
        if (h.c(MathHelper.b(l), MathHelper.b(m), MathHelper.b(n)) == Material.g) {
            p = 0.20000000298023224D;
            o = (R.nextFloat() - R.nextFloat()) * 0.2F;
            q = (R.nextFloat() - R.nextFloat()) * 0.2F;
            h.a(((Entity) (this)), "random.fizz", 0.4F, 2.0F + R.nextFloat() * 0.4F);
        }
        g(l, m, n);
        o();
        c(o, p, q);
        float f = 0.98F;

        if (w) {
            f = 0.5880001F;
            int i = h.a(MathHelper.b(l), MathHelper.b(v.b) - 1, MathHelper.b(n));

            if (i > 0) {
                f = Block.n[i].bo * 0.98F;
            }
        }
        o *= f;
        p *= 0.98000001907348633D;
        q *= f;
        if (w) {
            p *= -0.5D;
        }
        af++;
        b++;
        if (b >= 6000) {
            j();
        }
    }

    public boolean o() {
        return h.a(v, Material.f, ((Entity) (this)));
    }

    private boolean g(double d, double d1, double d2) {
        int i = MathHelper.b(d);
        int j = MathHelper.b(d1);
        int k = MathHelper.b(d2);
        double d3 = d - (double) i;
        double d4 = d1 - (double) j;
        double d5 = d2 - (double) k;

        if (Block.p[h.a(i, j, k)]) {
            boolean flag = !Block.p[h.a(i - 1, j, k)];
            boolean flag1 = !Block.p[h.a(i + 1, j, k)];
            boolean flag2 = !Block.p[h.a(i, j - 1, k)];
            boolean flag3 = !Block.p[h.a(i, j + 1, k)];
            boolean flag4 = !Block.p[h.a(i, j, k - 1)];
            boolean flag5 = !Block.p[h.a(i, j, k + 1)];
            byte byte0 = -1;
            double d6 = 9999D;

            if (flag && d3 < d6) {
                d6 = d3;
                byte0 = 0;
            }
            if (flag1 && 1.0D - d3 < d6) {
                d6 = 1.0D - d3;
                byte0 = 1;
            }
            if (flag2 && d4 < d6) {
                d6 = d4;
                byte0 = 2;
            }
            if (flag3 && 1.0D - d4 < d6) {
                d6 = 1.0D - d4;
                byte0 = 3;
            }
            if (flag4 && d5 < d6) {
                d6 = d5;
                byte0 = 4;
            }
            if (flag5 && 1.0D - d5 < d6) {
                double d7 = 1.0D - d5;

                byte0 = 5;
            }
            float f = R.nextFloat() * 0.2F + 0.1F;

            if (byte0 == 0) {
                o = -f;
            }
            if (byte0 == 1) {
                o = f;
            }
            if (byte0 == 2) {
                p = -f;
            }
            if (byte0 == 3) {
                p = f;
            }
            if (byte0 == 4) {
                q = -f;
            }
            if (byte0 == 5) {
                q = f;
            }
        }
        return false;
    }

    protected void b(int i) {
        a(((Entity) (null)), i);
    }

    public boolean a(Entity entity, int i) {
        ag -= i;
        if (ag <= 0) {
            j();
        }
        return false;
    }

    public void a(NBTTagCompound nbttagcompound) {
        nbttagcompound.a("Health", (byte) ag);
        nbttagcompound.a("Age", (short) b);
        nbttagcompound.a("Item", a.a(new NBTTagCompound()));
    }

    public void b(NBTTagCompound nbttagcompound) {
        ag = nbttagcompound.c("Health") & 0xff;
        b = ((int) (nbttagcompound.c("Age")));
        NBTTagCompound nbttagcompound1 = nbttagcompound.j("Item");

        a = new ItemStack(nbttagcompound1);
    }

    public void a(EntityPlayer entityplayer) {
        if (h.x) {
            return;
        }
        int i = a.a;

        if (ad == 0 && entityplayer.aj.a(a)) {
            h.a(((Entity) (this)), "random.pop", 0.2F, ((R.nextFloat() - R.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            entityplayer.c(((Entity) (this)), i);
            j();
        }
    }
}
