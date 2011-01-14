package net.minecraft.server;

import java.io.PrintStream;
import java.util.*;

public class CraftingManager {

    private static final CraftingManager a = new CraftingManager();
    private List b;

    public static final CraftingManager a() {
        return a;
    }

    private CraftingManager() {
        b = ((List) (new ArrayList()));
        (new RecipesTools()).a(this);
        (new RecipesWeapons()).a(this);
        (new RecipeIngots()).a(this);
        (new RecipesFood()).a(this);
        (new RecipesCrafting()).a(this);
        (new RecipesArmor()).a(this);
        (new RecipesDyes()).a(this);
        a(new ItemStack(Item.aI, 3), new Object[] {
            "###", Character.valueOf('#'), Item.aH
        });
        a(new ItemStack(Item.aJ, 1), new Object[] {
            "#", "#", "#", Character.valueOf('#'), Item.aI
        });
        a(new ItemStack(Block.aZ, 2), new Object[] {
            "###", "###", Character.valueOf('#'), Item.B
        });
        a(new ItemStack(Block.aY, 1), new Object[] {
            "###", "#X#", "###", Character.valueOf('#'), Block.x, Character.valueOf('X'), Item.l
        });
        a(new ItemStack(Block.R, 1), new Object[] {
            "###", "#X#", "###", Character.valueOf('#'), Block.x, Character.valueOf('X'), Item.aA
        });
        a(new ItemStack(Block.an, 1), new Object[] {
            "###", "XXX", "###", Character.valueOf('#'), Block.x, Character.valueOf('X'), Item.aJ
        });
        a(new ItemStack(Block.aU, 1), new Object[] {
            "##", "##", Character.valueOf('#'), Item.aB
        });
        a(new ItemStack(Block.aW, 1), new Object[] {
            "##", "##", Character.valueOf('#'), Item.aG
        });
        a(new ItemStack(Block.al, 1), new Object[] {
            "##", "##", Character.valueOf('#'), Item.aF
        });
        a(new ItemStack(Block.bd, 1), new Object[] {
            "###", "###", "###", Character.valueOf('#'), Item.aR
        });
        a(new ItemStack(Block.ab, 1), new Object[] {
            "###", "###", "###", Character.valueOf('#'), Item.I
        });
        a(new ItemStack(Block.am, 1), new Object[] {
            "X#X", "#X#", "X#X", Character.valueOf('X'), Item.K, Character.valueOf('#'), Block.E
        });
        a(new ItemStack(Block.ak, 3), new Object[] {
            "###", Character.valueOf('#'), Block.w
        });
        a(new ItemStack(Block.aF, 1), new Object[] {
            "# #", "###", "# #", Character.valueOf('#'), Item.B
        });
        a(new ItemStack(Item.at, 1), new Object[] {
            "##", "##", "##", Character.valueOf('#'), Block.x
        });
        a(new ItemStack(Item.az, 1), new Object[] {
            "##", "##", "##", Character.valueOf('#'), Item.m
        });
        a(new ItemStack(Item.as, 1), new Object[] {
            "###", "###", " X ", Character.valueOf('#'), Block.x, Character.valueOf('X'), Item.B
        });
        a(new ItemStack(Item.aX, 1), new Object[] {
            "AAA", "BEB", "CCC", Character.valueOf('A'), Item.aE, Character.valueOf('B'), Item.aW, Character.valueOf('C'), Item.R, Character.valueOf('E'), Item.aN
        });
        a(new ItemStack(Item.aW, 1), new Object[] {
            "#", Character.valueOf('#'), Item.aH
        });
        a(new ItemStack(Block.x, 4), new Object[] {
            "#", Character.valueOf('#'), Block.J
        });
        a(new ItemStack(Item.B, 4), new Object[] {
            "#", "#", Character.valueOf('#'), Block.x
        });
        a(new ItemStack(Block.aq, 4), new Object[] {
            "X", "#", Character.valueOf('X'), Item.k, Character.valueOf('#'), Item.B
        });
        a(new ItemStack(Block.aq, 4), new Object[] {
            "X", "#", Character.valueOf('X'), new ItemStack(Item.k, 1, 1), Character.valueOf('#'), Item.B
        });
        a(new ItemStack(Item.C, 4), new Object[] {
            "# #", " # ", Character.valueOf('#'), Block.x
        });
        a(new ItemStack(Block.aG, 16), new Object[] {
            "X X", "X#X", "X X", Character.valueOf('X'), Item.m, Character.valueOf('#'), Item.B
        });
        a(new ItemStack(Item.ax, 1), new Object[] {
            "# #", "###", Character.valueOf('#'), Item.m
        });
        a(new ItemStack(Block.bf, 1), new Object[] {
            "A", "B", Character.valueOf('A'), Block.ba, Character.valueOf('B'), Block.aq
        });
        a(new ItemStack(Item.aL, 1), new Object[] {
            "A", "B", Character.valueOf('A'), Block.au, Character.valueOf('B'), Item.ax
        });
        a(new ItemStack(Item.aM, 1), new Object[] {
            "A", "B", Character.valueOf('A'), Block.aB, Character.valueOf('B'), Item.ax
        });
        a(new ItemStack(Item.aC, 1), new Object[] {
            "# #", "###", Character.valueOf('#'), Block.x
        });
        a(new ItemStack(Item.au, 1), new Object[] {
            "# #", " # ", Character.valueOf('#'), Item.m
        });
        a(new ItemStack(Item.g, 1), new Object[] {
            "A ", " B", Character.valueOf('A'), Item.m, Character.valueOf('B'), Item.an
        });
        a(new ItemStack(Item.S, 1), new Object[] {
            "###", Character.valueOf('#'), Item.R
        });
        a(new ItemStack(Block.at, 4), new Object[] {
            "#  ", "## ", "###", Character.valueOf('#'), Block.x
        });
        a(new ItemStack(Item.aP, 1), new Object[] {
            "  #", " #X", "# X", Character.valueOf('#'), Item.B, Character.valueOf('X'), Item.I
        });
        a(new ItemStack(Block.aH, 4), new Object[] {
            "#  ", "## ", "###", Character.valueOf('#'), Block.w
        });
        a(new ItemStack(Item.aq, 1), new Object[] {
            "###", "#X#", "###", Character.valueOf('#'), Item.B, Character.valueOf('X'), Block.ab
        });
        a(new ItemStack(Item.ar, 1), new Object[] {
            "###", "#X#", "###", Character.valueOf('#'), Block.ah, Character.valueOf('X'), Item.h
        });
        a(new ItemStack(Block.aJ, 1), new Object[] {
            "X", "#", Character.valueOf('#'), Block.w, Character.valueOf('X'), Item.B
        });
        a(new ItemStack(Block.aQ, 1), new Object[] {
            "X", "#", Character.valueOf('#'), Item.B, Character.valueOf('X'), Item.aA
        });
        a(new ItemStack(Item.aQ, 1), new Object[] {
            " # ", "#X#", " # ", Character.valueOf('#'), Item.n, Character.valueOf('X'), Item.aA
        });
        a(new ItemStack(Item.aO, 1), new Object[] {
            " # ", "#X#", " # ", Character.valueOf('#'), Item.m, Character.valueOf('X'), Item.aA
        });
        a(new ItemStack(Block.aR, 1), new Object[] {
            "#", "#", Character.valueOf('#'), Block.t
        });
        a(new ItemStack(Block.aK, 1), new Object[] {
            "###", Character.valueOf('#'), Block.t
        });
        a(new ItemStack(Block.aM, 1), new Object[] {
            "###", Character.valueOf('#'), Block.x
        });
        a(new ItemStack(Block.P, 1), new Object[] {
            "###", "#X#", "#R#", Character.valueOf('#'), Block.w, Character.valueOf('X'), Item.i, Character.valueOf('R'), Item.aA
        });
        Collections.sort(b, ((java.util.Comparator) (new RecipeSorter(this))));
        System.out.println((new StringBuilder()).append(b.size()).append(" recipes").toString());
    }

    void a(ItemStack itemstack, Object aobj[]) {
        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;

        if (aobj[i] instanceof String[]) {
            String as[] = (String[]) aobj[i++];

            for (int l = 0; l < as.length; l++) {
                String s2 = as[l];

                k++;
                j = s2.length();
                s = (new StringBuilder()).append(s).append(s2).toString();
            }
        } else {
            while (aobj[i] instanceof String) {
                String s1 = (String) aobj[i++];

                k++;
                j = s1.length();
                s = (new StringBuilder()).append(s).append(s1).toString();
            }
        }
        HashMap hashmap = new HashMap();

        for (; i < aobj.length; i += 2) {
            Character character = (Character) aobj[i];
            ItemStack itemstack1 = null;

            if (aobj[i + 1] instanceof Item) {
                itemstack1 = new ItemStack((Item) aobj[i + 1]);
            } else if (aobj[i + 1] instanceof Block) {
                itemstack1 = new ItemStack((Block) aobj[i + 1], 1, -1);
            } else if (aobj[i + 1] instanceof ItemStack) {
                itemstack1 = (ItemStack) aobj[i + 1];
            }
            ((Map) (hashmap)).put(((character)), ((itemstack1)));
        }

        ItemStack aitemstack[] = new ItemStack[j * k];

        for (int i1 = 0; i1 < j * k; i1++) {
            char c = s.charAt(i1);

            if (((Map) (hashmap)).containsKey(((Character.valueOf(c))))) {
                aitemstack[i1] = ((ItemStack) ((Map) (hashmap)).get(((Character.valueOf(c))))).j();
            } else {
                aitemstack[i1] = null;
            }
        }

        b.add(((new ShapedRecipes(j, k, aitemstack, itemstack))));
    }

    void b(ItemStack itemstack, Object aobj[]) {
        ArrayList arraylist = new ArrayList();
        Object aobj1[] = aobj;
        int i = aobj1.length;

        for (int j = 0; j < i; j++) {
            Object obj = aobj1[j];

            if (obj instanceof ItemStack) {
                ((List) (arraylist)).add(((((ItemStack) obj).j())));
                continue;
            }
            if (obj instanceof Item) {
                ((List) (arraylist)).add(((new ItemStack((Item) obj))));
                continue;
            }
            if (obj instanceof Block) {
                ((List) (arraylist)).add(((new ItemStack((Block) obj))));
            } else {
                throw new RuntimeException("Invalid shapeless recipy!");
            }
        }

        b.add(((new ShapelessRecipes(itemstack, ((List) (arraylist))))));
    }

    public ItemStack a(InventoryCrafting inventorycrafting) {
        for (int i = 0; i < b.size(); i++) {
            CraftingRecipe craftingrecipe = (CraftingRecipe) b.get(i);

            if (craftingrecipe.a(inventorycrafting)) {
                return craftingrecipe.b(inventorycrafting);
            }
        }

        return null;
    }
}
