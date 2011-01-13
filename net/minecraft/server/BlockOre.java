package net.minecraft.server;

import java.util.Random;

public class BlockOre extends Block {

    public BlockOre(int i, int j) {
        super(i, j, Material.d);
    }

    public int a(int i, Random random) {
        if (bi == Block.I.bi) {
            return Item.k.ba;
        }
        if (bi == Block.aw.bi) {
            return Item.l.ba;
        }
        if (bi == Block.N.bi) {
            return Item.aU.ba;
        } else {
            return bi;
        }
    }

    public int a(Random random) {
        return 1;
    }

    protected int b(int i) {
        return bi != Block.N.bi ? 0 : 4;
    }
}
