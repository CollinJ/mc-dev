package net.minecraft.server;

public class SlotCrafting extends Slot {

    private final IInventory a;

    public SlotCrafting(IInventory iinventory, IInventory iinventory1, int i, int j, int k) {
        super(iinventory1, i, j, k);
        a = iinventory;
    }

    public boolean a(ItemStack itemstack) {
        return false;
    }

    public void b() {
        for (int i = 0; i < a.h_(); i++) {
            ItemStack itemstack = a.a(i);

            if (itemstack == null) {
                continue;
            }
            a.b(i, 1);
            if (itemstack.a().g()) {
                a.a(i, new ItemStack(itemstack.a().f()));
            }
        }
    }
}
