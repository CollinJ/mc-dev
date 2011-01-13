package net.minecraft.server;

public class dl extends Block {

    public dl(int i) {
        super(i, 192, Material.d);
    }

    public int a(int i) {
        if (i == 1) {
            return bh - 16;
        }
        if (i == 0) {
            return bh + 16;
        } else {
            return bh;
        }
    }
}
