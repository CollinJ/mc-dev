package net.minecraft.server;

public class ItemTool extends Item {

    private Block aX[];
    private float aY;
    private int aZ;
    protected int a;

    public ItemTool(int i, int j, int k, Block ablock[]) {
        super(i);
        aY = 4F;
        a = k;
        aX = ablock;
        aT = 1;
        aU = 32 << k;
        if (k == 3) {
            aU *= 4;
        }
        aY = (k + 1) * 2;
        aZ = j + k;
    }

    public float a(ItemStack itemstack, Block block) {
        for (int i = 0; i < aX.length; i++) {
            if (aX[i] == block) {
                return aY;
            }
        }

        return 1.0F;
    }

    public void a(ItemStack itemstack, int i, int j, int k, int l) {
        itemstack.a(1);
    }
}
