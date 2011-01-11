package net.minecraft.server;

public class BlockOreBlock extends Block {

    public BlockOreBlock(int i, int j) {
        super(i, Material.e);
        bb = j;
    }

    public int a(int i) {
        if (i == 1) {
            return bb - 16;
        }
        if (i == 0) {
            return bb + 16;
        } else {
            return bb;
        }
    }
}
