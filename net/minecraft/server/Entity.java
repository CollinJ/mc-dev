package net.minecraft.server;

import java.util.List;
import java.util.Random;

public abstract class Entity {

    private static int a = 0;
    public int c;
    public double d;
    public boolean e;
    public Entity f;
    public Entity g;
    protected World h;
    public double i;
    public double j;
    public double k;
    public double l;
    public double m;
    public double n;
    public double o;
    public double p;
    public double q;
    public float r;
    public float s;
    public float t;
    public float u;
    public final AxisAlignedBB v = AxisAlignedBB.a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;
    public boolean A;
    public boolean B;
    public float C;
    public float D;
    public float E;
    public float F;
    public float G;
    protected boolean H;
    protected float I;
    private int b;
    public double J;
    public double K;
    public double L;
    public float M;
    public float N;
    public boolean O;
    public float P;
    public boolean Q;
    protected Random R;
    public int S;
    public int T;
    public int U;
    protected int V;
    protected boolean W;
    public int X;
    public int Y;
    private boolean ad;
    private double ae;
    private double af;
    public boolean Z;
    public int aa;
    public int ab;
    public int ac;

    public Entity(World world) {
        c = a++;
        d = 1.0D;
        e = false;
        w = false;
        z = false;
        A = true;
        B = false;
        C = 0.0F;
        D = 0.6F;
        E = 1.8F;
        F = 0.0F;
        G = 0.0F;
        H = true;
        I = 0.0F;
        b = 1;
        M = 0.0F;
        N = 0.0F;
        O = false;
        P = 0.0F;
        Q = false;
        R = new Random();
        S = 0;
        T = 1;
        U = 0;
        V = 300;
        W = false;
        X = 0;
        Y = 300;
        ad = true;
        Z = false;
        h = world;
        a(0.0D, 0.0D, 0.0D);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Entity) {
            return ((Entity) obj).c == c;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return c;
    }

    public void j() {
        B = true;
    }

    protected void a(float f1, float f2) {
        D = f1;
        E = f2;
    }

    protected void b(float f1, float f2) {
        r = f1;
        s = f2;
    }

    public void a(double d1, double d2, double d3) {
        l = d1;
        m = d2;
        n = d3;
        float f1 = D / 2.0F;
        float f2 = E;

        v.c(d1 - (double) f1, (d2 - (double) C) + (double) M, d3 - (double) f1, d1 + (double) f1, (d2 - (double) C) + (double) M + (double) f2, d3 + (double) f1);
    }

    public void b_() {
        k();
    }

    public void k() {
        if (g != null && g.B) {
            g = null;
        }
        S++;
        F = G;
        i = l;
        j = m;
        k = n;
        u = s;
        t = r;
        if (o()) {
            if (!W && !ad) {
                float f1 = MathHelper.a(o * o * 0.20000000298023224D + p * p + q * q * 0.20000000298023224D) * 0.2F;

                if (f1 > 1.0F) {
                    f1 = 1.0F;
                }
                h.a(this, "random.splash", f1, 1.0F + (R.nextFloat() - R.nextFloat()) * 0.4F);
                float f2 = MathHelper.b(v.b);

                for (int i1 = 0; (float) i1 < 1.0F + D * 20F; i1++) {
                    float f3 = (R.nextFloat() * 2.0F - 1.0F) * D;
                    float f5 = (R.nextFloat() * 2.0F - 1.0F) * D;

                    h.a("bubble", l + (double) f3, f2 + 1.0F, n + (double) f5, o, p - (double) (R.nextFloat() * 0.2F), q);
                }

                for (int j1 = 0; (float) j1 < 1.0F + D * 20F; j1++) {
                    float f4 = (R.nextFloat() * 2.0F - 1.0F) * D;
                    float f6 = (R.nextFloat() * 2.0F - 1.0F) * D;

                    h.a("splash", l + (double) f4, f2 + 1.0F, n + (double) f6, o, p, q);
                }
            }
            I = 0.0F;
            W = true;
            U = 0;
        } else {
            W = false;
        }
        if (U > 0) {
            if (U % 20 == 0) {
                a(((Entity) (null)), 1);
            }
            U--;
        }
        if (q()) {
            a(((Entity) (null)), 10);
            U = 600;
        }
        if (m < -64D) {
            l();
        }
        ad = false;
    }

    protected void l() {
        j();
    }

    public boolean b(double d1, double d2, double d3) {
        AxisAlignedBB axisalignedbb = v.c(d1, d2, d3);
        List list = h.a(this, axisalignedbb);

        if (list.size() > 0) {
            return false;
        }
        return !h.b(axisalignedbb);
    }

    public void c(double d1, double d2, double d3) {
        if (O) {
            v.d(d1, d2, d3);
            l = (v.a + v.d) / 2D;
            m = (v.b + (double) C) - (double) M;
            n = (v.c + v.f) / 2D;
            return;
        }
        double d4 = l;
        double d5 = n;
        double d6 = d1;
        double d7 = d2;
        double d8 = d3;
        AxisAlignedBB axisalignedbb = v.b();
        boolean flag = w && m();

        if (flag) {
            double d9 = 0.050000000000000003D;

            for (; d1 != 0.0D && h.a(this, v.c(d1, -1D, 0.0D)).size() == 0; d6 = d1) {
                if (d1 < d9 && d1 >= -d9) {
                    d1 = 0.0D;
                    continue;
                }
                if (d1 > 0.0D) {
                    d1 -= d9;
                } else {
                    d1 += d9;
                }
            }

            for (; d3 != 0.0D && h.a(this, v.c(0.0D, -1D, d3)).size() == 0; d8 = d3) {
                if (d3 < d9 && d3 >= -d9) {
                    d3 = 0.0D;
                    continue;
                }
                if (d3 > 0.0D) {
                    d3 -= d9;
                } else {
                    d3 += d9;
                }
            }
        }
        List list = h.a(this, v.a(d1, d2, d3));

        for (int i1 = 0; i1 < list.size(); i1++) {
            d2 = ((AxisAlignedBB) list.get(i1)).b(v, d2);
        }

        v.d(0.0D, d2, 0.0D);
        if (!A && d7 != d2) {
            d1 = d2 = d3 = 0.0D;
        }
        boolean flag1 = w || d7 != d2 && d7 < 0.0D;

        for (int j1 = 0; j1 < list.size(); j1++) {
            d1 = ((AxisAlignedBB) list.get(j1)).a(v, d1);
        }

        v.d(d1, 0.0D, 0.0D);
        if (!A && d6 != d1) {
            d1 = d2 = d3 = 0.0D;
        }
        for (int k1 = 0; k1 < list.size(); k1++) {
            d3 = ((AxisAlignedBB) list.get(k1)).c(v, d3);
        }

        v.d(0.0D, 0.0D, d3);
        if (!A && d8 != d3) {
            d1 = d2 = d3 = 0.0D;
        }
        if (N > 0.0F && flag1 && M < 0.05F && (d6 != d1 || d8 != d3)) {
            double d10 = d1;
            double d12 = d2;
            double d14 = d3;

            d1 = d6;
            d2 = N;
            d3 = d8;
            AxisAlignedBB axisalignedbb1 = v.b();

            v.b(axisalignedbb);
            List list1 = h.a(this, v.a(d1, d2, d3));

            for (int j2 = 0; j2 < list1.size(); j2++) {
                d2 = ((AxisAlignedBB) list1.get(j2)).b(v, d2);
            }

            v.d(0.0D, d2, 0.0D);
            if (!A && d7 != d2) {
                d1 = d2 = d3 = 0.0D;
            }
            for (int k2 = 0; k2 < list1.size(); k2++) {
                d1 = ((AxisAlignedBB) list1.get(k2)).a(v, d1);
            }

            v.d(d1, 0.0D, 0.0D);
            if (!A && d6 != d1) {
                d1 = d2 = d3 = 0.0D;
            }
            for (int l2 = 0; l2 < list1.size(); l2++) {
                d3 = ((AxisAlignedBB) list1.get(l2)).c(v, d3);
            }

            v.d(0.0D, 0.0D, d3);
            if (!A && d8 != d3) {
                d1 = d2 = d3 = 0.0D;
            }
            if (d10 * d10 + d14 * d14 >= d1 * d1 + d3 * d3) {
                d1 = d10;
                d2 = d12;
                d3 = d14;
                v.b(axisalignedbb1);
            } else {
                M += 0.5D;
            }
        }
        l = (v.a + v.d) / 2D;
        m = (v.b + (double) C) - (double) M;
        n = (v.c + v.f) / 2D;
        x = d6 != d1 || d8 != d3;
        y = d7 != d2;
        w = d7 != d2 && d7 < 0.0D;
        z = x || y;
        if (w) {
            if (I > 0.0F) {
                a(I);
                I = 0.0F;
            }
        } else if (d2 < 0.0D) {
            I -= ((float) (d2));
        }
        if (d6 != d1) {
            o = 0.0D;
        }
        if (d7 != d2) {
            p = 0.0D;
        }
        if (d8 != d3) {
            q = 0.0D;
        }
        double d11 = l - d4;
        double d13 = n - d5;

        G += ((float) ((double) MathHelper.a(d11 * d11 + d13 * d13) * 0.59999999999999998D));
        if (H && !flag) {
            int k3 = MathHelper.b(l);
            int i4 = MathHelper.b(m - 0.20000000298023224D - (double) C);
            int l1 = MathHelper.b(n);
            int i3 = h.a(k3, i4, l1);

            if (G > (float) b && i3 > 0) {
                b++;
                StepSound stepsound = Block.n[i3].bl;

                if (h.a(k3, i4 + 1, l1) == Block.aT.bc) {
                    stepsound = Block.aT.bl;
                    h.a(this, stepsound.c(), stepsound.a() * 0.15F, stepsound.b());
                } else if (!Block.n[i3].bn.d()) {
                    h.a(this, stepsound.c(), stepsound.a() * 0.15F, stepsound.b());
                }
                Block.n[i3].b(h, k3, i4, l1, this);
            }
        }
        int l3 = MathHelper.b(v.a);
        int j4 = MathHelper.b(v.b);
        int i2 = MathHelper.b(v.c);
        int j3 = MathHelper.b(v.d);
        int k4 = MathHelper.b(v.e);
        int l4 = MathHelper.b(v.f);

        for (int i5 = l3; i5 <= j3; i5++) {
            for (int j5 = j4; j5 <= k4; j5++) {
                for (int k5 = i2; k5 <= l4; k5++) {
                    int l5 = h.a(i5, j5, k5);

                    if (l5 > 0) {
                        Block.n[l5].a(h, i5, j5, k5, this);
                    }
                }
            }
        }

        M *= 0.4F;
        boolean flag2 = o();

        if (h.c(v)) {
            b(1);
            if (!flag2) {
                U++;
                if (U == 0) {
                    U = 300;
                }
            }
        } else if (U <= 0) {
            U = -T;
        }
        if (flag2 && U > 0) {
            h.a(this, "random.fizz", 0.7F, 1.6F + (R.nextFloat() - R.nextFloat()) * 0.4F);
            U = -T;
        }
    }

    public boolean m() {
        return false;
    }

    public AxisAlignedBB n() {
        return null;
    }

    protected void b(int i1) {
        a(((Entity) (null)), i1);
    }

    protected void a(float f1) {}

    public boolean o() {
        return h.a(v.b(0.0D, -0.40000000596046448D, 0.0D), Material.f, this);
    }

    public boolean a(Material material) {
        double d1 = m + (double) p();
        int i1 = MathHelper.b(l);
        int j1 = MathHelper.d(MathHelper.b(d1));
        int k1 = MathHelper.b(n);
        int l1 = h.a(i1, j1, k1);

        if (l1 != 0 && Block.n[l1].bn == material) {
            float f1 = BlockFluids.b(h.b(i1, j1, k1)) - 0.1111111F;
            float f2 = (float) (j1 + 1) - f1;

            return d1 < (double) f2;
        } else {
            return false;
        }
    }

    protected float p() {
        return 0.0F;
    }

    public boolean q() {
        return h.a(v.b(0.0D, -0.40000000596046448D, 0.0D), Material.g);
    }

    public void a(float f1, float f2, float f3) {
        float f4 = MathHelper.c(f1 * f1 + f2 * f2);

        if (f4 < 0.01F) {
            return;
        }
        if (f4 < 1.0F) {
            f4 = 1.0F;
        }
        f4 = f3 / f4;
        f1 *= f4;
        f2 *= f4;
        float f5 = MathHelper.a((r * 3.141593F) / 180F);
        float f6 = MathHelper.b((r * 3.141593F) / 180F);

        o += f1 * f6 - f2 * f5;
        q += f2 * f6 + f1 * f5;
    }

    public float b(float f1) {
        int i1 = MathHelper.b(l);
        double d1 = (v.e - v.b) * 0.66000000000000003D;
        int j1 = MathHelper.b((m - (double) C) + d1);
        int k1 = MathHelper.b(n);

        return h.j(i1, j1, k1);
    }

    public void b(double d1, double d2, double d3, float f1, float f2) {
        i = l = d1;
        j = m = d2;
        k = n = d3;
        r = f1;
        s = f2;
        M = 0.0F;
        double d4 = t - f1;

        if (d4 < -180D) {
            t += 360F;
        }
        if (d4 >= 180D) {
            t -= 360F;
        }
        a(l, m, n);
    }

    public void c(double d1, double d2, double d3, float f1, float f2) {
        i = l = d1;
        j = m = d2 + (double) C;
        k = n = d3;
        r = f1;
        s = f2;
        a(l, m, n);
    }

    public float a(Entity entity) {
        float f1 = (float) (l - entity.l);
        float f2 = (float) (m - entity.m);
        float f3 = (float) (n - entity.n);

        return MathHelper.c(f1 * f1 + f2 * f2 + f3 * f3);
    }

    public double d(double d1, double d2, double d3) {
        double d4 = l - d1;
        double d5 = m - d2;
        double d6 = n - d3;

        return d4 * d4 + d5 * d5 + d6 * d6;
    }

    public double e(double d1, double d2, double d3) {
        double d4 = l - d1;
        double d5 = m - d2;
        double d6 = n - d3;

        return (double) MathHelper.a(d4 * d4 + d5 * d5 + d6 * d6);
    }

    public double b(Entity entity) {
        double d1 = l - entity.l;
        double d2 = m - entity.m;
        double d3 = n - entity.n;

        return d1 * d1 + d2 * d2 + d3 * d3;
    }

    public void a(EntityPlayer entityplayer) {}

    public void c(Entity entity) {
        if (entity.f == this || entity.g == this) {
            return;
        }
        double d1 = entity.l - l;
        double d2 = entity.n - n;
        double d3 = MathHelper.a(d1, d2);

        if (d3 >= 0.0099999997764825821D) {
            d3 = MathHelper.a(d3);
            d1 /= d3;
            d2 /= d3;
            double d4 = 1.0D / d3;

            if (d4 > 1.0D) {
                d4 = 1.0D;
            }
            d1 *= d4;
            d2 *= d4;
            d1 *= 0.05000000074505806D;
            d2 *= 0.05000000074505806D;
            d1 *= 1.0F - P;
            d2 *= 1.0F - P;
            f(-d1, 0.0D, -d2);
            entity.f(d1, 0.0D, d2);
        }
    }

    public void f(double d1, double d2, double d3) {
        o += d1;
        p += d2;
        q += d3;
    }

    public boolean a(Entity entity, int i1) {
        return false;
    }

    public boolean c_() {
        return false;
    }

    public boolean r() {
        return false;
    }

    public void b(Entity entity, int i1) {}

    public boolean c(NBTTagCompound nbttagcompound) {
        String s1 = s();

        if (B || s1 == null) {
            return false;
        } else {
            nbttagcompound.a("id", s1);
            d(nbttagcompound);
            return true;
        }
    }

    public void d(NBTTagCompound nbttagcompound) {
        nbttagcompound.a("Pos", ((NBTBase) (a(new double[] {
            l, m, n
        }))));
        nbttagcompound.a("Motion", ((NBTBase) (a(new double[] {
            o, p, q
        }))));
        nbttagcompound.a("Rotation", ((NBTBase) (a(new float[] {
            r, s
        }))));
        nbttagcompound.a("FallDistance", I);
        nbttagcompound.a("Fire", (short) U);
        nbttagcompound.a("Air", (short) Y);
        nbttagcompound.a("OnGround", w);
        a(nbttagcompound);
    }

    public void e(NBTTagCompound nbttagcompound) {
        NBTTagList nbttaglist = nbttagcompound.k("Pos");
        NBTTagList nbttaglist1 = nbttagcompound.k("Motion");
        NBTTagList nbttaglist2 = nbttagcompound.k("Rotation");

        a(0.0D, 0.0D, 0.0D);
        o = ((NBTTagDouble) nbttaglist1.a(0)).a;
        p = ((NBTTagDouble) nbttaglist1.a(1)).a;
        q = ((NBTTagDouble) nbttaglist1.a(2)).a;
        i = J = l = ((NBTTagDouble) nbttaglist.a(0)).a;
        j = K = m = ((NBTTagDouble) nbttaglist.a(1)).a;
        k = L = n = ((NBTTagDouble) nbttaglist.a(2)).a;
        t = r = ((NBTTagFloat) nbttaglist2.a(0)).a;
        u = s = ((NBTTagFloat) nbttaglist2.a(1)).a;
        I = nbttagcompound.f("FallDistance");
        U = ((int) (nbttagcompound.c("Fire")));
        Y = ((int) (nbttagcompound.c("Air")));
        w = nbttagcompound.l("OnGround");
        a(l, m, n);
        b(nbttagcompound);
    }

    protected final String s() {
        return EntityList.b(this);
    }

    protected abstract void b(NBTTagCompound nbttagcompound);

    protected abstract void a(NBTTagCompound nbttagcompound);

    protected NBTTagList a(double ad1[]) {
        NBTTagList nbttaglist = new NBTTagList();
        double ad2[] = ad1;
        int i1 = ad2.length;

        for (int j1 = 0; j1 < i1; j1++) {
            double d1 = ad2[j1];

            nbttaglist.a(((NBTBase) (new NBTTagDouble(d1))));
        }

        return nbttaglist;
    }

    protected NBTTagList a(float af1[]) {
        NBTTagList nbttaglist = new NBTTagList();
        float af2[] = af1;
        int i1 = af2.length;

        for (int j1 = 0; j1 < i1; j1++) {
            float f1 = af2[j1];

            nbttaglist.a(((NBTBase) (new NBTTagFloat(f1))));
        }

        return nbttaglist;
    }

    public EntityItem a(int i1, int j1) {
        return a(i1, j1, 0.0F);
    }

    public EntityItem a(int i1, int j1, float f1) {
        EntityItem entityitem = new EntityItem(h, l, m + (double) f1, n, new ItemStack(i1, j1));

        entityitem.ad = 10;
        h.a(((Entity) (entityitem)));
        return entityitem;
    }

    public boolean t() {
        return !B;
    }

    public boolean u() {
        int i1 = MathHelper.b(l);
        int j1 = MathHelper.b(m + (double) p());
        int k1 = MathHelper.b(n);

        return h.d(i1, j1, k1);
    }

    public AxisAlignedBB d(Entity entity) {
        return null;
    }

    public void v() {
        if (g.B) {
            g = null;
            return;
        }
        o = 0.0D;
        p = 0.0D;
        q = 0.0D;
        b_();
        g.w();
        af += g.r - g.t;
        ae += g.s - g.u;
        for (; af >= 180D; af -= 360D) {
            ;
        }
        for (; af < -180D; af += 360D) {
            ;
        }
        for (; ae >= 180D; ae -= 360D) {
            ;
        }
        for (; ae < -180D; ae += 360D) {
            ;
        }
        double d1 = af * 0.5D;
        double d2 = ae * 0.5D;
        float f1 = 10F;

        if (d1 > (double) f1) {
            d1 = f1;
        }
        if (d1 < (double) (-f1)) {
            d1 = -f1;
        }
        if (d2 > (double) f1) {
            d2 = f1;
        }
        if (d2 < (double) (-f1)) {
            d2 = -f1;
        }
        af -= d1;
        ae -= d2;
        r += ((float) (d1));
        s += ((float) (d2));
    }

    protected void w() {
        f.a(l, m + h() + f.x(), n);
    }

    public double x() {
        return (double) C;
    }

    public double h() {
        return (double) E * 0.75D;
    }

    public void e(Entity entity) {
        ae = 0.0D;
        af = 0.0D;
        if (g == entity) {
            g.f = null;
            g = null;
            c(entity.l, entity.v.b + (double) entity.E, entity.n, r, s);
            return;
        }
        if (g != null) {
            g.f = null;
        }
        if (entity.f != null) {
            entity.f.g = null;
        }
        g = entity;
        entity.f = this;
    }
}
