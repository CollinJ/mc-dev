package net.minecraft.server;

public class CraftingInventoryPlayerCB extends CraftingInventoryCB {

    public InventoryCrafting a;
    public IInventory b;
    public boolean c;

    public CraftingInventoryPlayerCB(InventoryPlayer inventoryplayer) {
        this(inventoryplayer, true);
    }

    public CraftingInventoryPlayerCB(InventoryPlayer inventoryplayer, boolean flag) {
        a = new InventoryCrafting(((CraftingInventoryCB) (this)), 2, 2);
        b = ((IInventory) (new InventoryCraftResult()));
        c = false;
        c = flag;
        a(((Slot) (new SlotCrafting(((IInventory) (a)), b, 0, 144, 36))));
        for (int i = 0; i < 2; i++) {
            for (int i1 = 0; i1 < 2; i1++) {
                a(new Slot(((IInventory) (a)), i1 + i * 2, 88 + i1 * 18, 26 + i * 18));
            }
        }

        for (int j = 0; j < 4; j++) {
            int j1 = j;

            a(((Slot) (new SlotArmor(this, ((IInventory) (inventoryplayer)), inventoryplayer.h_() - 1 - j, 8, 8 + j * 18, j1))));
        }

        for (int k = 0; k < 3; k++) {
            for (int k1 = 0; k1 < 9; k1++) {
                a(new Slot(((IInventory) (inventoryplayer)), k1 + (k + 1) * 9, 8 + k1 * 18, 84 + k * 18));
            }
        }

        for (int l = 0; l < 9; l++) {
            a(new Slot(((IInventory) (inventoryplayer)), l, 8 + l * 18, 142));
        }

        a(((IInventory) (a)));
    }

    public void a(IInventory iinventory) {
        b.a(0, CraftingManager.a().a(a));
    }

    public void a(EntityPlayer entityplayer) {
        super.a(entityplayer);
        for (int i = 0; i < 4; i++) {
            ItemStack itemstack = a.a(i);

            if (itemstack != null) {
                entityplayer.b(itemstack);
                a.a(i, ((ItemStack) (null)));
            }
        }
    }

    public boolean b(EntityPlayer entityplayer) {
        return true;
    }
}
