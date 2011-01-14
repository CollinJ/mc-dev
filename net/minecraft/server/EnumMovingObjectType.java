package net.minecraft.server;

public final class EnumMovingObjectType extends Enum {

    public static final EnumMovingObjectType a;
    public static final EnumMovingObjectType b;
    private static final EnumMovingObjectType c[]; /* synthetic field */

    public static EnumMovingObjectType[] values() {
        return (EnumMovingObjectType[]) ((EnumMovingObjectType[]) (c)).clone();
    }

    public static EnumMovingObjectType valueOf(String s) {
        return (EnumMovingObjectType) Enum.valueOf(net.minecraft.server.EnumMovingObjectType.class, s);
    }

    private EnumMovingObjectType(String s, int i) {
        super(s, i);
    }

    static {
        a = new EnumMovingObjectType("TILE", 0);
        b = new EnumMovingObjectType("ENTITY", 1);
        c = (new EnumMovingObjectType[] {
            a, b
        });
    }
}
