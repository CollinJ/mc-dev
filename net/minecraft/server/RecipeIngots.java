package net.minecraft.server;

public class RecipeIngots {

    private Object a[][];

    public RecipeIngots() {
        a = (new Object[][] {
            new Object[] {
                Block.ah, new ItemStack(Item.n, 9)
            }, new Object[] {
                Block.ai, new ItemStack(Item.m, 9)
            }, new Object[] {
                Block.ax, new ItemStack(Item.l, 9)
            }, new Object[] {
                Block.O, new ItemStack(Item.aU, 9, 4)
            }
        });
    }

    public void a(CraftingManager craftingmanager) {
        for (int i = 0; i < a.length; i++) {
            Block block = (Block) a[i][0];
            ItemStack itemstack = (ItemStack) a[i][1];

            craftingmanager.a(new ItemStack(block), new Object[] {
                "###", "###", "###", Character.valueOf('#'), itemstack
            });
            craftingmanager.a(itemstack, new Object[] {
                "#", Character.valueOf('#'), block
            });
        }
    }
}
