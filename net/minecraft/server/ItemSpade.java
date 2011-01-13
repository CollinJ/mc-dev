package net.minecraft.server;

public class ItemSpade extends ItemTool {

    private static Block bg[];

    public ItemSpade(int i, bv bv) {
        super(i, 1, bv, bg);
    }

    public boolean a(Block block) {
        if (block == Block.aS) {
            return true;
        }
        return block == Block.aU;
    }

    static {
        bg = (new Block[] {
            Block.u, Block.v, Block.E, Block.F, Block.aS, Block.aU, Block.aW
        });
    }
}
