package net.minecraft.server;

public class ItemAxe extends ItemTool {

    private static Block aX[];

    public ItemAxe(int i, int j) {
        super(i, 3, j, aX);
    }

    static {
        aX = (new Block[] {
            Block.y, Block.ao, Block.K, Block.av
        });
    }
}
