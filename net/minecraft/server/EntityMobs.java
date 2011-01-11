package net.minecraft.server;

import java.util.Random;

public class EntityMobs extends EntityCreature implements IMobs {

    protected int af;

    public EntityMobs(World world) {
        super(world);
        af = 2;
        aM = 20;
    }

    public void y() {
        float f = b(1.0F);

        if (f > 0.5F) {
            bc += 2;
        }
        super.y();
    }

    public void b_() {
        super.b_();
        if (h.l == 0) {
            j();
        }
    }

    protected Entity i() {
        EntityPlayer entityplayer = h.a(((Entity) (this)), 16D);

        if (entityplayer != null && g(((Entity) (entityplayer)))) {
            return ((Entity) (entityplayer));
        } else {
            return null;
        }
    }

    public boolean a(Entity entity, int j) {
        if (super.a(entity, j)) {
            if (f == entity || g == entity) {
                return true;
            }
            if (entity != this) {
                ag = entity;
            }
            return true;
        } else {
            return false;
        }
    }

    protected void a(Entity entity, float f) {
        if ((double) f < 2.5D && entity.v.e > v.b && entity.v.b < v.e) {
            aS = 20;
            entity.a(((Entity) (this)), af);
        }
    }

    protected float a(int j, int k, int l) {
        return 0.5F - h.j(j, k, l);
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
    }

    public boolean a() {
        int j = MathHelper.b(this.l);
        int k = MathHelper.b(v.b);
        int l = MathHelper.b(n);

        if (h.a(EnumSkyBlock.a, j, k, l) > R.nextInt(32)) {
            return false;
        } else {
            int i1 = h.h(j, k, l);

            return i1 <= R.nextInt(8) && super.a();
        }
    }
}
