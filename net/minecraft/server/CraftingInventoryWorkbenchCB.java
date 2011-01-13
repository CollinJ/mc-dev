package net.minecraft.server;

public class CraftingInventoryWorkbenchCB extends CraftingInventoryCB {

    public InventoryCrafting a;
    public IInventory b;
    private World c;
    private int h;
    private int i;
    private int j;

    public CraftingInventoryWorkbenchCB(InventoryPlayer inventoryplayer, World world, int k, int l, int i1) {
        a = new InventoryCrafting(((CraftingInventoryCB) (this)), 3, 3);
        b = ((IInventory) (new InventoryCraftResult()));
        c = world;
        h = k;
        i = l;
        j = i1;
        a(((Slot) (new SlotCrafting(((IInventory) (a)), b, 0, 124, 35))));
        for (int j1 = 0; j1 < 3; j1++) {
            for (int i2 = 0; i2 < 3; i2++) {
                a(new Slot(((IInventory) (a)), i2 + j1 * 3, 30 + i2 * 18, 17 + j1 * 18));
            }
        }

        for (int k1 = 0; k1 < 3; k1++) {
            for (int j2 = 0; j2 < 9; j2++) {
                a(new Slot(((IInventory) (inventoryplayer)), j2 + k1 * 9 + 9, 8 + j2 * 18, 84 + k1 * 18));
            }
        }

        for (int l1 = 0; l1 < 9; l1++) {
            a(new Slot(((IInventory) (inventoryplayer)), l1, 8 + l1 * 18, 142));
        }

        a(((IInventory) (a)));
    }

    public void a(IInventory iinventory) {
        b.a(0, CraftingManager.a().a(a));
    }

    public void a(EntityPlayer entityplayer) {
        super.a(entityplayer);
        for (int k = 0; k < 9; k++) {
            ItemStack itemstack = a.a(k);

            if (itemstack != null) {
                entityplayer.b(itemstack);
            }
        }
    }

    public boolean b(EntityPlayer entityplayer) {
        if (c.a(h, i, j) != Block.ay.bi) {
            return false;
        }
        return entityplayer.d((double) h + 0.5D, (double) i + 0.5D, (double) j + 0.5D) <= 64D;
    }
}
