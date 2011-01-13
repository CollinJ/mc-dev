package net.minecraft.server;

public final class jr extends Enum {

    public static final jr a;
    public static final jr b;
    private static final jr c[]; /* synthetic field */

    public static jr[] values() {
        return (jr[]) ((jr[]) (c)).clone();
    }

    public static jr valueOf(String s) {
        return (jr) Enum.valueOf(net.minecraft.server.jr.class, s);
    }

    private jr(String s, int i) {
        super(s, i);
    }

    static {
        a = new jr("TILE", 0);
        b = new jr("ENTITY", 1);
        c = (new jr[] {
            a, b
        });
    }
}
