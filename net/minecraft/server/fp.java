package net.minecraft.server;

import java.util.HashMap;
import java.util.Map;

public class fp {

    private static final fp a = new fp();
    private Map b;

    public static final fp a() {
        return a;
    }

    private fp() {
        b = ((Map) (new HashMap()));
        a(Block.H.bi, new ItemStack(Item.m));
        a(Block.G.bi, new ItemStack(Item.n));
        a(Block.aw.bi, new ItemStack(Item.l));
        a(Block.E.bi, new ItemStack(Block.M));
        a(Item.ao.ba, new ItemStack(Item.ap));
        a(Item.aS.ba, new ItemStack(Item.aT));
        a(Block.w.bi, new ItemStack(Block.t));
        a(Item.aG.ba, new ItemStack(Item.aF));
        a(Block.aV.bi, new ItemStack(Item.aU, 1, 2));
        a(Block.J.bi, new ItemStack(Item.k, 1, 1));
    }

    public void a(int i, ItemStack itemstack) {
        b.put(((Integer.valueOf(i))), ((itemstack)));
    }

    public ItemStack a(int i) {
        return (ItemStack) b.get(((Integer.valueOf(i))));
    }
}
