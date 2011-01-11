package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class EntityPigZombie extends EntityZombie {

    private boolean a;
    private int b;
    private static final ItemStack c;

    public EntityPigZombie(World world) {
        super(world);
        a = false;
        b = 0;
        aF = "/mob/pigzombie.png";
        bl = 0.5F;
        e = 5;
        ad = true;
    }

    public void b_() {
        bl = f == null ? 0.5F : 0.95F;
        if (b > 0 && --b == 0) {
            l.a(((Entity) (this)), "mob.zombiepig.zpigangry", h() * 2.0F, ((V.nextFloat() - V.nextFloat()) * 0.2F + 1.0F) * 1.8F);
        }
        super.b_();
    }

    public boolean a() {
        return l.k > 0 && l.a(z) && l.a(((Entity) (this)), z).size() == 0 && !l.b(z);
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        nbttagcompound.a("Angry", a);
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        a = nbttagcompound.l("Angry");
    }

    protected Entity k() {
        if (!a) {
            return null;
        } else {
            return super.k();
        }
    }

    public void D() {
        super.D();
    }

    public boolean a(Entity entity, int i) {
        if (entity instanceof EntityPlayer) {
            List list = l.b(((Entity) (this)), z.b(32D, 32D, 32D));

            for (int j = 0; j < list.size(); j++) {
                Entity entity1 = (Entity) list.get(j);

                if (entity1 instanceof EntityPigZombie) {
                    EntityPigZombie entitypigzombie = (EntityPigZombie) entity1;

                    entitypigzombie.h(entity);
                }
            }

            h(entity);
        }
        return super.a(entity, i);
    }

    private void h(Entity entity) {
        f = entity;
        a = true;
        b = V.nextInt(40);
    }

    protected String d() {
        return "mob.zombiepig.zpig";
    }

    protected String e() {
        return "mob.zombiepig.zpighurt";
    }

    protected String f() {
        return "mob.zombiepig.zpigdeath";
    }

    protected int g() {
        return Item.ap.aW;
    }

    static {
        c = new ItemStack(Item.E, 1);
    }
}