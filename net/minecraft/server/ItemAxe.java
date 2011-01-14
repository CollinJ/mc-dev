package net.minecraft.server;

public class ItemAxe extends ItemTool {

    private static Block bg[];

    protected ItemAxe(int i, EnumToolMaterial enumtoolmaterial) {
        super(i, 3, enumtoolmaterial, bg);
    }

    static {
        bg = (new Block[] {
            Block.x, Block.an, Block.J, Block.au
        });
    }
}
