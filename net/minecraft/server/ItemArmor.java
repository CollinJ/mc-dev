package net.minecraft.server;

public class ItemArmor extends Item {

    private static final int bj[] = {
        3, 8, 6, 3
    };
    private static final int bk[] = {
        11, 16, 15, 13
    };
    public final int a;
    public final int bg;
    public final int bh;
    public final int bi;

    public ItemArmor(int i, int j, int k, int l) {
        super(i);
        a = j;
        bg = l;
        bi = k;
        bh = bj[l];
        bc = bk[l] * 3 << j;
        bb = 1;
    }
}
