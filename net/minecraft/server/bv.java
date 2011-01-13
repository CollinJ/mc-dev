package net.minecraft.server;

public final class bv extends Enum {

    public static final bv a;
    public static final bv b;
    public static final bv c;
    public static final bv d;
    public static final bv e;
    private final int f;
    private final int g;
    private final float h;
    private final int i;
    private static final bv j[]; /* synthetic field */

    public static bv[] values() {
        return (bv[]) ((bv[]) (j)).clone();
    }

    public static bv valueOf(String s) {
        return (bv) Enum.valueOf(net.minecraft.server.bv.class, s);
    }

    private bv(String s, int k, int l, int i1, float f1, int j1) {
        super(s, k);
        f = l;
        g = i1;
        h = f1;
        i = j1;
    }

    public int a() {
        return g;
    }

    public float b() {
        return h;
    }

    public int c() {
        return i;
    }

    public int d() {
        return f;
    }

    static {
        a = new bv("WOOD", 0, 0, 59, 2.0F, 0);
        b = new bv("STONE", 1, 1, 131, 4F, 1);
        c = new bv("IRON", 2, 2, 250, 6F, 2);
        d = new bv("EMERALD", 3, 3, 1561, 8F, 3);
        e = new bv("GOLD", 4, 0, 32, 12F, 0);
        j = (new bv[] {
            a, b, c, d, e
        });
    }
}
