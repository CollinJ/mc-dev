package net.minecraft.server;

public class ItemPickaxe extends ItemTool {

    private static Block aX[];
    private int aY;

    public ItemPickaxe(int i, int j) {
        super(i, 2, j, aX);
        aY = j;
    }

    public boolean a(Block block) {
        if (block == Block.aq) {
            return aY == 3;
        }
        if (block == Block.ay || block == Block.ax) {
            return aY >= 2;
        }
        if (block == Block.ai || block == Block.H) {
            return aY >= 2;
        }
        if (block == Block.aj || block == Block.I) {
            return aY >= 1;
        }
        if (block == Block.aO || block == Block.aP) {
            return aY >= 2;
        }
        if (block.bn == Material.d) {
            return true;
        }
        return block.bn == Material.e;
    }

    static {
        aX = (new Block[] {
            Block.x, Block.ak, Block.al, Block.u, Block.ap, Block.I, Block.aj, Block.J, Block.ai, Block.H, Block.ax, Block.ay, Block.aU
        });
    }
}
