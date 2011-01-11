package net.minecraft.server;

public class EntityTNTPrimed extends Entity {

    public int a;

    public EntityTNTPrimed(World world) {
        super(world);
        a = 0;
        e = true;
        a(0.98F, 0.98F);
        C = E / 2.0F;
    }

    public EntityTNTPrimed(World world, float f, float f1, float f2) {
        this(world);
        a(f, f1, f2);
        float f3 = (float) (Math.random() * 3.1415927410125732D * 2D);

        o = -MathHelper.a((f3 * 3.141593F) / 180F) * 0.02F;
        p = 0.20000000298023224D;
        q = -MathHelper.b((f3 * 3.141593F) / 180F) * 0.02F;
        H = false;
        a = 80;
        i = f;
        j = f1;
        k = f2;
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
            b();
        } else {
            h.a("smoke", l, m + 0.5D, n, 0.0D, 0.0D, 0.0D);
        }
    }

    private void b() {
        float f = 4F;

        h.a(((Entity) (null)), l, m, n, f);
    }

    protected void a(NBTTagCompound nbttagcompound) {
        nbttagcompound.a("Fuse", (byte) a);
    }

    protected void b(NBTTagCompound nbttagcompound) {
        a = ((int) (nbttagcompound.b("Fuse")));
    }
}
