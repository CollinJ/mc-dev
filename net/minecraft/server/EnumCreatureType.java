package net.minecraft.server;

public final class EnumCreatureType extends Enum {

    public static final EnumCreatureType a;
    public static final EnumCreatureType b;
    public static final EnumCreatureType c;
    private final Class d;
    private final int e;
    private final Material f;
    private final boolean g;
    private static final EnumCreatureType h[]; /* synthetic field */

    public static EnumCreatureType[] values() {
        return (EnumCreatureType[]) ((EnumCreatureType[]) (h)).clone();
    }

    public static EnumCreatureType valueOf(String s) {
        return (EnumCreatureType) Enum.valueOf(net.minecraft.server.EnumCreatureType.class, s);
    }

    private EnumCreatureType(String s, int i, Class class1, int j, Material material, boolean flag) {
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
        a = new EnumCreatureType("monster", 0, net.minecraft.server.IMobs.class, 70, Material.a, false);
        b = new EnumCreatureType("creature", 1, net.minecraft.server.EntityAnimals.class, 15, Material.a, true);
        c = new EnumCreatureType("waterCreature", 2, net.minecraft.server.EntityWaterMob.class, 5, Material.f, true);
        h = (new EnumCreatureType[] {
            a, b, c
        });
    }
}
