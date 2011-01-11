package net.minecraft.server;

import java.util.Random;

public class EntitySlime extends EntityLiving implements IMobs {

    public float a;
    public float b;
    private int ae;
    public int ad;

    public EntitySlime(World world) {
        super(world);
        ae = 0;
        ad = 1;
        aC = "/mob/slime.png";
        ad = 1 << R.nextInt(3);
        C = 0.0F;
        ae = R.nextInt(20) + 10;
        c(ad);
    }

    public void c(int i) {
        ad = i;
        a(0.6F * (float) i, 0.6F * (float) i);
        aM = i * i;
        a(l, m, n);
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        nbttagcompound.a("Size", ad - 1);
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        ad = nbttagcompound.d("Size") + 1;
    }

    public void b_() {
        b = a;
        boolean flag = w;

        super.b_();
        if (w && !flag) {
            for (int i = 0; i < ad * 8; i++) {
                float f1 = R.nextFloat() * 3.141593F * 2.0F;
                float f2 = R.nextFloat() * 0.5F + 0.5F;
                float f3 = MathHelper.a(f1) * (float) ad * 0.5F * f2;
                float f4 = MathHelper.b(f1) * (float) ad * 0.5F * f2;

                h.a("slime", l + (double) f3, v.b, n + (double) f4, 0.0D, 0.0D, 0.0D);
            }

            if (ad > 2) {
                h.a(((Entity) (this)), "mob.slime", f(), ((R.nextFloat() - R.nextFloat()) * 0.2F + 1.0F) / 0.8F);
            }
            a = -0.5F;
        }
        a = a * 0.6F;
    }

    protected void d_() {
        EntityPlayer entityplayer = h.a(((Entity) (this)), 16D);

        if (entityplayer != null) {
            b(((Entity) (entityplayer)), 10F);
        }
        if (w && ae-- <= 0) {
            ae = R.nextInt(20) + 10;
            if (entityplayer != null) {
                ae /= 3;
            }
            bg = true;
            if (ad > 1) {
                h.a(((Entity) (this)), "mob.slime", f(), ((R.nextFloat() - R.nextFloat()) * 0.2F + 1.0F) * 0.8F);
            }
            a = 1.0F;
            bd = 1.0F - R.nextFloat() * 2.0F;
            be = 1 * ad;
        } else {
            bg = false;
            if (w) {
                bd = be = 0.0F;
            }
        }
    }

    public void j() {
        if (ad > 1 && aM == 0) {
            for (int i = 0; i < 4; i++) {
                float f1 = (((float) (i % 2) - 0.5F) * (float) ad) / 4F;
                float f2 = (((float) (i / 2) - 0.5F) * (float) ad) / 4F;
                EntitySlime entityslime = new EntitySlime(h);

                entityslime.c(ad / 2);
                entityslime.c(l + (double) f1, m + 0.5D, n + (double) f2, R.nextFloat() * 360F, 0.0F);
                h.a(((Entity) (entityslime)));
            }
        }
        super.j();
    }

    public void a(EntityPlayer entityplayer) {
        if (ad > 1 && g(((Entity) (entityplayer))) && (double) a(((Entity) (entityplayer))) < 0.59999999999999998D * (double) ad && entityplayer.a(((Entity) (this)), ad)) {
            h.a(((Entity) (this)), "mob.slimeattack", 1.0F, (R.nextFloat() - R.nextFloat()) * 0.2F + 1.0F);
        }
    }

    protected String d() {
        return "mob.slime";
    }

    protected String e() {
        return "mob.slime";
    }

    protected int g() {
        if (ad == 1) {
            return Item.aK.aS;
        } else {
            return 0;
        }
    }

    public boolean a() {
        Chunk chunk = h.a(MathHelper.b(l), MathHelper.b(m));

        return (ad == 1 || h.l > 0) && R.nextInt(10) == 0 && chunk.a(0x3ad8025fL).nextInt(10) == 0 && m < 16D;
    }

    protected float f() {
        return 0.6F;
    }
}
