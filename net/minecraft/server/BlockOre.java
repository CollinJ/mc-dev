package net.minecraft.server;

import java.util.Random;

public class BlockOre extends Block {

    public BlockOre(int i, int j) {
        super(i, j, Material.d);
    }

    public int a(int i, Random random) {
        if (bc == Block.J.bc) {
            return Item.k.aS;
        }
        if (bc == Block.ax.bc) {
            return Item.l.aS;
        } else {
            return bc;
        }
    }

    public int a(Random random) {
        return 1;
    }
}
