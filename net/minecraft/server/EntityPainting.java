package net.minecraft.server;

import java.util.*;

public class EntityPainting extends Entity {

    private int ad;
    public int a;
    private int ae;
    private int af;
    private int ag;
    public EnumArt b;

    public EntityPainting(World world) {
        super(world);
        ad = 0;
        a = 0;
        C = 0.0F;
        a(0.5F, 0.5F);
    }

    public EntityPainting(World world, int i, int j, int k, int l) {
        this(world);
        ae = i;
        af = j;
        ag = k;
        ArrayList arraylist = new ArrayList();
        EnumArt aenumart[] = EnumArt.values();
        int i1 = aenumart.length;

        for (int j1 = 0; j1 < i1; j1++) {
            EnumArt enumart = aenumart[j1];

            b = enumart;
            a(l);
            if (b()) {
                ((List) (arraylist)).add(((enumart)));
            }
        }

        if (((List) (arraylist)).size() > 0) {
            b = (EnumArt) ((List) (arraylist)).get(R.nextInt(((List) (arraylist)).size()));
        }
        a(l);
    }

    public void a(int i) {
        a = i;
        t = r = i * 90;
        float f = b.z;
        float f1 = b.A;
        float f2 = b.z;

        if (i == 0 || i == 2) {
            f2 = 0.5F;
        } else {
            f = 0.5F;
        }
        f /= 32F;
        f1 /= 32F;
        f2 /= 32F;
        float f3 = (float) ae + 0.5F;
        float f4 = (float) af + 0.5F;
        float f5 = (float) ag + 0.5F;
        float f6 = 0.5625F;

        if (i == 0) {
            f5 -= f6;
        }
        if (i == 1) {
            f3 -= f6;
        }
        if (i == 2) {
            f5 += f6;
        }
        if (i == 3) {
            f3 += f6;
        }
        if (i == 0) {
            f3 -= c(b.z);
        }
        if (i == 1) {
            f5 += c(b.z);
        }
        if (i == 2) {
            f3 += c(b.z);
        }
        if (i == 3) {
            f5 -= c(b.z);
        }
        f4 += c(b.A);
        a(f3, f4, f5);
        float f7 = -0.00625F;

        v.c(f3 - f - f7, f4 - f1 - f7, f5 - f2 - f7, f3 + f + f7, f4 + f1 + f7, f5 + f2 + f7);
    }

    private float c(int i) {
        if (i == 32) {
            return 0.5F;
        }
        return i != 64 ? 0.0F : 0.5F;
    }

    public void b_() {
        if (ad++ == 100 && !b()) {
            ad = 0;
            j();
            h.a(((Entity) (new EntityItem(h, l, m, n, new ItemStack(Item.aq)))));
        }
    }

    public boolean b() {
        if (h.a(((Entity) (this)), v).size() > 0) {
            return false;
        }
        int i = b.z / 16;
        int j = b.A / 16;
        int k = ae;
        int l = af;
        int i1 = ag;

        if (a == 0) {
            k = MathHelper.b(this.l - (double) ((float) b.z / 32F));
        }
        if (a == 1) {
            i1 = MathHelper.b(n - (double) ((float) b.z / 32F));
        }
        if (a == 2) {
            k = MathHelper.b(this.l - (double) ((float) b.z / 32F));
        }
        if (a == 3) {
            i1 = MathHelper.b(n - (double) ((float) b.z / 32F));
        }
        l = MathHelper.b(m - (double) ((float) b.A / 32F));
        for (int j1 = 0; j1 < i; j1++) {
            for (int k1 = 0; k1 < j; k1++) {
                Material material;

                if (a == 0 || a == 2) {
                    material = h.c(k + j1, l + k1, ag);
                } else {
                    material = h.c(ae, l + k1, i1 + j1);
                }
                if (!material.a()) {
                    return false;
                }
            }
        }

        List list = h.b(((Entity) (this)), v);

        for (int l1 = 0; l1 < list.size(); l1++) {
            if (list.get(l1) instanceof EntityPainting) {
                return false;
            }
        }

        return true;
    }

    public boolean c_() {
        return true;
    }

    public boolean a(Entity entity, int i) {
        j();
        h.a(((Entity) (new EntityItem(h, l, m, n, new ItemStack(Item.aq)))));
        return true;
    }

    public void a(NBTTagCompound nbttagcompound) {
        nbttagcompound.a("Dir", (byte) a);
        nbttagcompound.a("Motive", b.y);
        nbttagcompound.a("TileX", ae);
        nbttagcompound.a("TileY", af);
        nbttagcompound.a("TileZ", ag);
    }

    public void b(NBTTagCompound nbttagcompound) {
        a = ((int) (nbttagcompound.b("Dir")));
        ae = nbttagcompound.d("TileX");
        af = nbttagcompound.d("TileY");
        ag = nbttagcompound.d("TileZ");
        String s = nbttagcompound.h("Motive");
        EnumArt aenumart[] = EnumArt.values();
        int i = aenumart.length;

        for (int j = 0; j < i; j++) {
            EnumArt enumart = aenumart[j];

            if (enumart.y.equals(((s)))) {
                b = enumart;
            }
        }

        if (b == null) {
            b = EnumArt.a;
        }
        a(a);
    }
}
