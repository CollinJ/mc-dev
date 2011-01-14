package net.minecraft.server;

public final class EnumToolMaterial extends Enum {

    public static final EnumToolMaterial a;
    public static final EnumToolMaterial b;
    public static final EnumToolMaterial c;
    public static final EnumToolMaterial d;
    public static final EnumToolMaterial e;
    private final int f;
    private final int g;
    private final float h;
    private final int i;
    private static final EnumToolMaterial j[]; /* synthetic field */

    public static EnumToolMaterial[] values() {
        return (EnumToolMaterial[]) ((EnumToolMaterial[]) (j)).clone();
    }

    public static EnumToolMaterial valueOf(String s) {
        return (EnumToolMaterial) Enum.valueOf(net.minecraft.server.EnumToolMaterial.class, s);
    }

    private EnumToolMaterial(String s, int k, int l, int i1, float f1, int j1) {
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
        a = new EnumToolMaterial("WOOD", 0, 0, 59, 2.0F, 0);
        b = new EnumToolMaterial("STONE", 1, 1, 131, 4F, 1);
        c = new EnumToolMaterial("IRON", 2, 2, 250, 6F, 2);
        d = new EnumToolMaterial("EMERALD", 3, 3, 1561, 8F, 3);
        e = new EnumToolMaterial("GOLD", 4, 0, 32, 12F, 0);
        j = (new EnumToolMaterial[] {
            a, b, c, d, e
        });
    }
}
