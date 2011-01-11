package net.minecraft.server;

public class ItemSpade extends ItemTool {

    private static Block aX[];

    public ItemSpade(int i, int j) {
        super(i, 1, j, aX);
    }

    public boolean a(Block block) {
        if (block == Block.aT) {
            return true;
        }
        return block == Block.aV;
    }

    static {
        aX = (new Block[] {
            Block.v, Block.w, Block.F, Block.G, Block.aT, Block.aV, Block.aX
        });
    }
}
