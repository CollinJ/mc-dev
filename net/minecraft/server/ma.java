package net.minecraft.server;

public final class ma extends Enum {

    public static final ma a;
    public static final ma b;
    public static final ma c;
    private final Class d;
    private final int e;
    private final Material f;
    private final boolean g;
    private static final ma h[]; /* synthetic field */

    public static ma[] values() {
        return (ma[]) ((ma[]) (h)).clone();
    }

    public static ma valueOf(String s) {
        return (ma) Enum.valueOf(net.minecraft.server.ma.class, s);
    }

    private ma(String s, int i, Class class1, int j, Material material, boolean flag) {
        super(s, i);
        d = class1;
        e = j;
        f = material;
        g = flag;
    }

    public Class a() {
        return d;
    }

    public int b() {
        return e;
    }

    public Material c() {
        return f;
    }

    public boolean d() {
        return g;
    }

    static {
        a = new ma("monster", 0, net.minecraft.server.IMobs.class, 100, Material.a, false);
        b = new ma("creature", 1, net.minecraft.server.EntityAnimals.class, 20, Material.a, true);
        c = new ma("waterCreature", 2, net.minecraft.server.ax.class, 5, Material.f, true);
        h = (new ma[] {
            a, b, c
        });
    }
}
