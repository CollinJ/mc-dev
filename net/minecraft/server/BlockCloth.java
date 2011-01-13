package net.minecraft.server;

public class BlockCloth extends Block {

    public BlockCloth() {
        super(35, 64, Material.k);
    }

    protected int b(int i) {
        return i;
    }

    public static int c(int i) {
        return ~i & 0xf;
    }

    public static int d(int i) {
        return ~i & 0xf;
    }
}
