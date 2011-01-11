package net.minecraft.server;

public class TileEntityFurnace extends TileEntity implements IInventory {

    private ItemStack e[];
    private int f;
    private int g;
    private int h;

    public TileEntityFurnace() {
        e = new ItemStack[3];
        f = 0;
        g = 0;
        h = 0;
    }

    public int a() {
        return e.length;
    }

    public ItemStack a(int i) {
        return e[i];
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        NBTTagList nbttaglist = nbttagcompound.k("Items");

        e = new ItemStack[a()];
        for (int i = 0; i < nbttaglist.b(); i++) {
            NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.a(i);
            byte byte0 = nbttagcompound1.b("Slot");

            if (byte0 >= 0 && byte0 < e.length) {
                e[byte0] = new ItemStack(nbttagcompound1);
            }
        }

        f = ((int) (nbttagcompound.c("BurnTime")));
        h = ((int) (nbttagcompound.c("CookTime")));
        g = a(e[1]);
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.a("BurnTime", (short) f);
        nbttagcompound.a("CookTime", (short) h);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < e.length; i++) {
            if (e[i] != null) {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();

                nbttagcompound1.a("Slot", (byte) i);
                e[i].a(nbttagcompound1);
                nbttaglist.a(((NBTBase) (nbttagcompound1)));
            }
        }

        nbttagcompound.a("Items", ((NBTBase) (nbttaglist)));
    }

    public int d() {
        return 64;
    }

    public boolean e() {
        return f > 0;
    }

    public void b() {
        boolean flag = f > 0;
        boolean flag1 = false;

        if (f > 0) {
            f--;
        }
        if (!a.x) {
            if (f == 0 && g()) {
                g = f = a(e[1]);
                if (f > 0) {
                    flag1 = true;
                    if (e[1] != null) {
                        e[1].a--;
                        if (e[1].a == 0) {
                            e[1] = null;
                        }
                    }
                }
            }
            if (e() && g()) {
                h++;
                if (h == 200) {
                    h = 0;
                    f();
                    flag1 = true;
                }
            } else {
                h = 0;
            }
            if (flag != (f > 0)) {
                flag1 = true;
                BlockFurnace.a(f > 0, a, b, c, d);
            }
        }
        if (flag1) {
            c();
        }
    }

    private boolean g() {
        if (e[0] == null) {
            return false;
        }
        int i = b(e[0].a().aS);

        if (i < 0) {
            return false;
        }
        if (e[2] == null) {
            return true;
        }
        if (e[2].c != i) {
            return false;
        }
        if (e[2].a < d() && e[2].a < e[2].b()) {
            return true;
        }
        return e[2].a < Item.c[i].a();
    }

    public void f() {
        if (!g()) {
            return;
        }
        int i = b(e[0].a().aS);

        if (e[2] == null) {
            e[2] = new ItemStack(i, 1);
        } else if (e[2].c == i) {
            e[2].a++;
        }
        e[0].a--;
        if (e[0].a <= 0) {
            e[0] = null;
        }
    }

    private int b(int i) {
        if (i == Block.I.bc) {
            return Item.m.aS;
        }
        if (i == Block.H.bc) {
            return Item.n.aS;
        }
        if (i == Block.ax.bc) {
            return Item.l.aS;
        }
        if (i == Block.F.bc) {
            return Block.N.bc;
        }
        if (i == Item.ao.aS) {
            return Item.ap.aS;
        }
        if (i == Block.x.bc) {
            return Block.u.bc;
        }
        if (i == Item.aG.aS) {
            return Item.aF.aS;
        } else {
            return -1;
        }
    }

    private int a(ItemStack itemstack) {
        if (itemstack == null) {
            return 0;
        }
        int i = itemstack.a().aS;

        if (i < 256 && Block.n[i].bn == Material.c) {
            return 300;
        }
        if (i == Item.B.aS) {
            return 100;
        }
        if (i == Item.k.aS) {
            return 1600;
        }
        return i != Item.aw.aS ? 0 : 20000;
    }
}