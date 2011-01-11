package net.minecraft.server;

import java.util.Random;

public class EntityChicken extends EntityAnimals {

    public boolean a;
    public float b;
    public float ad;
    public float ae;
    public float af;
    public float ai;
    public int aj;

    public EntityChicken(World world) {
        super(world);
        a = false;
        b = 0.0F;
        ad = 0.0F;
        ai = 1.0F;
        aC = "/mob/chicken.png";
        a(0.3F, 0.4F);
        aM = 4;
        aj = R.nextInt(6000) + 6000;
    }

    public void y() {
        super.y();
        af = b;
        ae = ad;
        ad += ((float) ((double) (w ? -1 : 4) * 0.29999999999999999D));
        if (ad < 0.0F) {
            ad = 0.0F;
        }
        if (ad > 1.0F) {
            ad = 1.0F;
        }
        if (!w && ai < 1.0F) {
            ai = 1.0F;
        }
        ai *= 0.90000000000000002D;
        if (!w && p < 0.0D) {
            p *= 0.59999999999999998D;
        }
        b += ai * 2.0F;
        if (!h.x && --aj <= 0) {
            h.a(((Entity) (this)), "mob.chickenplop", 1.0F, (R.nextFloat() - R.nextFloat()) * 0.2F + 1.0F);
            a(Item.aN.aS, 1);
            aj = R.nextInt(6000) + 6000;
        }
    }

    protected void a(float f) {}

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
    }

    protected String c() {
        return "mob.chicken";
    }

    protected String d() {
        return "mob.chickenhurt";
    }

    protected String e() {
        return "mob.chickenhurt";
    }

    protected int g() {
        return Item.J.aS;
    }
}
