package net.minecraft.server;

import java.util.*;

public abstract class CraftingInventoryCB {

    public List d;
    public List e;
    public int f;
    private short a;
    protected List g;
    private Set b;

    public CraftingInventoryCB() {
        d = ((List) (new ArrayList()));
        e = ((List) (new ArrayList()));
        f = 0;
        a = 0;
        g = ((List) (new ArrayList()));
        b = ((Set) (new HashSet()));
    }

    protected void a(Slot slot) {
        slot.c = e.size();
        e.add(((slot)));
        d.add(((null)));
    }

    public void a(ICrafting icrafting) {
        g.add(((icrafting)));
        ArrayList arraylist = new ArrayList();

        for (int i = 0; i < e.size(); i++) {
            ((List) (arraylist)).add(((((Slot) e.get(i)).c())));
        }

        icrafting.a(this, ((List) (arraylist)));
        a();
    }

    public void a() {
        for (int i = 0; i < e.size(); i++) {
            ItemStack itemstack = ((Slot) e.get(i)).c();
            ItemStack itemstack1 = (ItemStack) d.get(i);

            if (ItemStack.a(itemstack1, itemstack)) {
                continue;
            }
            itemstack1 = itemstack != null ? itemstack.j() : null;
            d.set(i, ((itemstack1)));
            for (int j = 0; j < g.size(); j++) {
                ((ICrafting) g.get(j)).a(this, i, itemstack1);
            }
        }
    }

    public Slot a(IInventory iinventory, int i) {
        for (int j = 0; j < e.size(); j++) {
            Slot slot = (Slot) e.get(j);

            if (slot.a(iinventory, i)) {
                return slot;
            }
        }

        return null;
    }

    public Slot a(int i) {
        return (Slot) e.get(i);
    }

    public ItemStack a(int i, int j, EntityPlayer entityplayer) {
        ItemStack itemstack = null;

        if (j == 0 || j == 1) {
            InventoryPlayer inventoryplayer = entityplayer.an;

            if (i == -999) {
                if (inventoryplayer.i() != null && i == -999) {
                    if (j == 0) {
                        entityplayer.b(inventoryplayer.i());
                        inventoryplayer.b(((ItemStack) (null)));
                    }
                    if (j == 1) {
                        entityplayer.b(inventoryplayer.i().a(1));
                        if (inventoryplayer.i().a == 0) {
                            inventoryplayer.b(((ItemStack) (null)));
                        }
                    }
                }
            } else {
                Slot slot = (Slot) e.get(i);

                if (slot != null) {
                    slot.d();
                    ItemStack itemstack1 = slot.c();

                    if (itemstack1 != null) {
                        itemstack = itemstack1.j();
                    }
                    if (itemstack1 != null || inventoryplayer.i() != null) {
                        if (itemstack1 != null && inventoryplayer.i() == null) {
                            int k = j != 0 ? (itemstack1.a + 1) / 2 : itemstack1.a;

                            inventoryplayer.b(slot.a(k));
                            if (itemstack1.a == 0) {
                                slot.b(((ItemStack) (null)));
                            }
                            slot.b();
                        } else if (itemstack1 == null && inventoryplayer.i() != null && slot.a(inventoryplayer.i())) {
                            int l = j != 0 ? 1 : inventoryplayer.i().a;

                            if (l > slot.a()) {
                                l = slot.a();
                            }
                            slot.b(inventoryplayer.i().a(l));
                            if (inventoryplayer.i().a == 0) {
                                inventoryplayer.b(((ItemStack) (null)));
                            }
                        } else if (itemstack1 != null && inventoryplayer.i() != null) {
                            if (slot.a(inventoryplayer.i())) {
                                if (itemstack1.c != inventoryplayer.i().c || itemstack1.e() && itemstack1.h() != inventoryplayer.i().h()) {
                                    if (inventoryplayer.i().a <= slot.a()) {
                                        ItemStack itemstack2 = itemstack1;

                                        slot.b(inventoryplayer.i());
                                        inventoryplayer.b(itemstack2);
                                    }
                                } else if (itemstack1.c == inventoryplayer.i().c) {
                                    if (j == 0) {
                                        int i1 = inventoryplayer.i().a;

                                        if (i1 > slot.a() - itemstack1.a) {
                                            i1 = slot.a() - itemstack1.a;
                                        }
                                        if (i1 > inventoryplayer.i().b() - itemstack1.a) {
                                            i1 = inventoryplayer.i().b() - itemstack1.a;
                                        }
                                        inventoryplayer.i().a(i1);
                                        if (inventoryplayer.i().a == 0) {
                                            inventoryplayer.b(((ItemStack) (null)));
                                        }
                                        itemstack1.a += i1;
                                    } else if (j == 1) {
                                        int j1 = 1;

                                        if (j1 > slot.a() - itemstack1.a) {
                                            j1 = slot.a() - itemstack1.a;
                                        }
                                        if (j1 > inventoryplayer.i().b() - itemstack1.a) {
                                            j1 = inventoryplayer.i().b() - itemstack1.a;
                                        }
                                        inventoryplayer.i().a(j1);
                                        if (inventoryplayer.i().a == 0) {
                                            inventoryplayer.b(((ItemStack) (null)));
                                        }
                                        itemstack1.a += j1;
                                    }
                                }
                            } else {
                                ItemStack itemstack3 = inventoryplayer.i();

                                if (itemstack1.c == itemstack3.c && itemstack3.b() > 1 && (!itemstack1.e() || itemstack1.h() == itemstack3.h())) {
                                    int k1 = itemstack1.a;

                                    if (k1 > 0 && k1 + itemstack3.a <= itemstack3.b()) {
                                        itemstack3.a += k1;
                                        itemstack1.a(k1);
                                        if (itemstack1.a == 0) {
                                            slot.b(((ItemStack) (null)));
                                        }
                                        slot.b();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return itemstack;
    }

    public void a(EntityPlayer entityplayer) {
        InventoryPlayer inventoryplayer = entityplayer.an;

        if (inventoryplayer.i() != null) {
            entityplayer.b(inventoryplayer.i());
            inventoryplayer.b(((ItemStack) (null)));
        }
    }

    public void a(IInventory iinventory) {
        a();
    }

    public boolean c(EntityPlayer entityplayer) {
        return !b.contains(((entityplayer)));
    }

    public void a(EntityPlayer entityplayer, boolean flag) {
        if (flag) {
            b.remove(((entityplayer)));
        } else {
            b.add(((entityplayer)));
        }
    }

    public abstract boolean b(EntityPlayer entityplayer);
}
