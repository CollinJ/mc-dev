package net.minecraft.server;

public class ItemPickaxe extends ItemTool {

    private static Block bg[];

    protected ItemPickaxe(int i, EnumToolMaterial enumtoolmaterial) {
        super(i, 2, enumtoolmaterial, bg);
    }

    public boolean a(Block block) {
        if (block == Block.ap) {
            return a.d() == 3;
        }
        if (block == Block.ax || block == Block.aw) {
            return a.d() >= 2;
        }
        if (block == Block.ah || block == Block.G) {
            return a.d() >= 2;
        }
        if (block == Block.ai || block == Block.H) {
            return a.d() >= 1;
        }
        if (block == Block.O || block == Block.N) {
            return a.d() >= 1;
        }
        if (block == Block.aN || block == Block.aO) {
            return a.d() >= 2;
        }
        if (block.bt == Material.d) {
            return true;
        }
        return block.bt == Material.e;
    }

    static {
        bg = (new Block[] {
            Block.w, Block.aj, Block.ak, Block.t, Block.ao, Block.H, Block.ai, Block.I, Block.ah, Block.G, Block.aw, Block.ax, Block.aT, Block.bb, Block.N, Block.O
        });
    }
}
