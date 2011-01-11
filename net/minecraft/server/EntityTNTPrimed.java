package net.minecraft.server;

public class EntityTNTPrimed extends Entity {

    public int a;

    public EntityTNTPrimed(World paramdy) {
        super(paramdy);
        a = 0;
        e = true;
        a(0.98F, 0.98F);
        C = E / 2.0F;
    }

    public EntityTNTPrimed(World paramdy, float paramFloat1, float paramFloat2, float paramFloat3) {
        this(paramdy);
        a(paramFloat1, paramFloat2, paramFloat3);
        float f = (float) (Math.random() * 3.1415927410125728D * 2D);

        o = -MathHelper.a((f * 3.141593F) / 180F) * 0.02F;
        p = 0.20000000298023221D;
        q = -MathHelper.b((f * 3.141593F) / 180F) * 0.02F;
        H = false;
        a = 80;
        i = paramFloat1;
        j = paramFloat2;
        k = paramFloat3;
    }

    public boolean c_() {
        return !B;
    }

    public void b_() {
        i = l;
        j = m;
        k = n;
        p -= 0.039999999105930328D;
        c(o, p, q);
        o *= 0.98000001907348633D;
        p *= 0.98000001907348633D;
        q *= 0.98000001907348633D;
        if (w) {
            o *= 0.69999998807907104D;
            q *= 0.69999998807907104D;
            p *= -0.5D;
        }
        if (a-- <= 0) {
            j();
        } else {
            h.a("smoke", l, m + 0.5D, n, 0.0D, 0.0D, 0.0D);
        }
    }

    private void b() {
        float f = 4F;

        h.a(((Entity) (null)), l, m, n, f);
    }

    protected void a(NBTTagCompound params) {
        params.a("Fuse", (byte) a);
    }

    protected void b(NBTTagCompound params) {
        a = ((int) (params.b("Fuse")));
    }
}
