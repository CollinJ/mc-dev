package net.minecraft.server;

class SlotArmor extends Slot {

    final int a; /* synthetic field */
    final CraftingInventoryPlayerCB b; /* synthetic field */

    SlotArmor(CraftingInventoryPlayerCB craftinginventoryplayercb, IInventory iinventory, int i, int j, int k, int l) {
        super(iinventory, i, j, k);
        b = craftinginventoryplayercb;
        a = l;
    }

    public int a() {
        return 1;
    }

    public boolean a(ItemStack itemstack) {
        if (itemstack.a() instanceof ItemArmor) {
            return ((ItemArmor) itemstack.a()).bb == a;
        }
        if (itemstack.a().aW == Block.ba.bh) {
            return a == 0;
        } else {
            return false;
        }
    }
}
