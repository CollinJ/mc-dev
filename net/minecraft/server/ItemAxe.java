package net.minecraft.server;

public class ItemAxe extends ItemTool {

    private static Block bg[];

    protected ItemAxe(int i, bv bv) {
        super(i, 3, bv, bg);
    }

    static {
        bg = (new Block[] {
            Block.x, Block.an, Block.J, Block.au
        });
    }
}
