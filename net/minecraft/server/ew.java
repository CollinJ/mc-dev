package net.minecraft.server;

public class ew extends CraftingInventoryCB {

    private bf a;

    public ew(IInventory iinventory, bf bf1) {
        a = bf1;
        for (int i = 0; i < 3; i++) {
            for (int l = 0; l < 3; l++) {
                a(new Slot(((IInventory) (bf1)), l + i * 3, 61 + l * 18, 17 + i * 18));
            }
        }

        for (int j = 0; j < 3; j++) {
            for (int i1 = 0; i1 < 9; i1++) {
                a(new Slot(iinventory, i1 + j * 9 + 9, 8 + i1 * 18, 84 + j * 18));
            }
        }

        for (int k = 0; k < 9; k++) {
            a(new Slot(iinventory, k, 8 + k * 18, 142));
        }
    }

    public boolean b(EntityPlayer entityplayer) {
        return a.a_(entityplayer);
    }
}
