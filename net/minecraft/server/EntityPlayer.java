package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class EntityPlayer extends EntityLiving {

    public InventoryPlayer aj;
    public byte ak;
    public int al;
    public float am;
    public float an;
    public boolean ao;
    public int ap;
    public String aq;
    private int a;

    public EntityPlayer(World world) {
        super(world);
        aj = new InventoryPlayer(this);
        ak = 0;
        al = 0;
        ao = false;
        ap = 0;
        a = 0;
        C = 1.62F;
        c((double) world.n + 0.5D, world.o + 1, (double) world.p + 0.5D, 0.0F, 0.0F);
        aM = 20;
        aF = "humanoid";
        aE = 180F;
        T = 20;
        aC = "/char.png";
    }

    public void v() {
        super.v();
        am = an;
        an = 0.0F;
    }

    protected void d_() {
        if (ao) {
            ap++;
            if (ap == 8) {
                ap = 0;
                ao = false;
            }
        } else {
            ap = 0;
        }
        aL = (float) ap / 8F;
    }

    public void y() {
        if (h.l == 0 && aM < 20 && (S % 20) * 4 == 0) {
            a(1);
        }
        aj.c();
        am = an;
        super.y();
        float f1 = MathHelper.a(o * o + q * q);
        float f2 = (float) Math.atan(-p * 0.20000000298023224D) * 15F;

        if (f1 > 0.1F) {
            f1 = 0.1F;
        }
        if (!w || aM <= 0) {
            f1 = 0.0F;
        }
        if (w || aM <= 0) {
            f2 = 0.0F;
        }
        an += (f1 - an) * 0.4F;
        aU += (f2 - aU) * 0.8F;
        if (aM > 0) {
            List list = h.b(((Entity) (this)), v.b(1.0D, 0.0D, 1.0D));

            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    h((Entity) list.get(i));
                }
            }
        }
    }

    private void h(Entity entity) {
        entity.a(this);
    }

    public void f(Entity entity) {
        a(0.2F, 0.2F);
        a(l, m, n);
        p = 0.10000000149011612D;
        if (aq.equals("Notch")) {
            a(new ItemStack(Item.h, 1), true);
        }
        aj.f();
        if (entity != null) {
            o = -MathHelper.b(((aQ + r) * 3.141593F) / 180F) * 0.1F;
            q = -MathHelper.a(((aQ + r) * 3.141593F) / 180F) * 0.1F;
        } else {
            o = q = 0.0D;
        }
        C = 0.1F;
    }

    public void b(Entity entity, int i) {
        al += i;
    }

    public void a(ItemStack itemstack) {
        a(itemstack, false);
    }

    public void a(ItemStack itemstack, boolean flag) {
        if (itemstack == null) {
            return;
        }
        EntityItem entityitem = new EntityItem(h, l, (m - 0.30000001192092896D) + (double) p(), n, itemstack);

        entityitem.ad = 40;
        float f1 = 0.1F;

        if (flag) {
            float f3 = R.nextFloat() * 0.5F;
            float f5 = R.nextFloat() * 3.141593F * 2.0F;

            entityitem.o = -MathHelper.a(f5) * f3;
            entityitem.q = MathHelper.b(f5) * f3;
            entityitem.p = 0.20000000298023224D;
        } else {
            float f2 = 0.3F;

            entityitem.o = -MathHelper.a((r / 180F) * 3.141593F) * MathHelper.b((s / 180F) * 3.141593F) * f2;
            entityitem.q = MathHelper.b((r / 180F) * 3.141593F) * MathHelper.b((s / 180F) * 3.141593F) * f2;
            entityitem.p = -MathHelper.a((s / 180F) * 3.141593F) * f2 + 0.1F;
            f2 = 0.02F;
            float f4 = R.nextFloat() * 3.141593F * 2.0F;

            f2 *= R.nextFloat();
            entityitem.o += Math.cos(f4) * (double) f2;
            entityitem.p += (R.nextFloat() - R.nextFloat()) * 0.1F;
            entityitem.q += Math.sin(f4) * (double) f2;
        }
        a(entityitem);
    }

    protected void a(EntityItem entityitem) {
        h.a(((Entity) (entityitem)));
    }

    public float a(Block block) {
        float f1 = aj.a(block);

        if (a(Material.f)) {
            f1 /= 5F;
        }
        if (!w) {
            f1 /= 5F;
        }
        return f1;
    }

    public boolean b(Block block) {
        return aj.b(block);
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        NBTTagList nbttaglist = nbttagcompound.k("Inventory");

        aj.b(nbttaglist);
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        nbttagcompound.a("Inventory", ((NBTBase) (aj.a(new NBTTagList()))));
    }

    public void a(IInventory iinventory) {}

    public void A() {}

    public void c(Entity entity, int i) {}

    protected float p() {
        return 0.12F;
    }

    public boolean a(Entity entity, int i) {
        bc = 0;
        if (aM <= 0) {
            return false;
        }
        if ((float) X > (float) ar / 2.0F) {
            return false;
        }
        if ((entity instanceof EntityMobs) || (entity instanceof EntityArrow)) {
            if (h.l == 0) {
                i = 0;
            }
            if (h.l == 1) {
                i = i / 3 + 1;
            }
            if (h.l == 3) {
                i = (i * 3) / 2;
            }
        }
        int j = 25 - aj.e();
        int k = i * j + a;

        aj.b(i);
        i = k / 25;
        a = k % 25;
        if (i == 0) {
            return false;
        } else {
            return super.a(entity, i);
        }
    }

    public void a(TileEntityFurnace tileentityfurnace) {}

    public void a(TileEntitySign tileentitysign) {}

    public ItemStack B() {
        return aj.b();
    }

    public void C() {
        aj.a(aj.d, ((ItemStack) (null)));
    }

    public double x() {
        return (double) (C - 0.5F);
    }

    public void z() {
        ap = -1;
        ao = true;
    }
}
