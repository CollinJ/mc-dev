package net.minecraft.server;

public enum EnumCreatureType {

    /*monster*/ a(net.minecraft.server.IMobs.class, 70, Material.a, false),
    /*creature*/ b(net.minecraft.server.EntityAnimals.class, 15, Material.a, true),
    /*waterCreature*/ c(net.minecraft.server.EntityWaterMob.class, 5, Material.f, true);
    private final Class d;
    private final int e;
    private final Material f;
    private final boolean g;

    private EnumCreatureType(Class class1, int j, Material material, boolean flag) {
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
}
