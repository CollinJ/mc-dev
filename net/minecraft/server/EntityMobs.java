package net.minecraft.server;

import java.util.Random;

public class EntityMobs extends EntityCreature implements IMobs {

    protected int c;

    public EntityMobs(World world) {
        super(world);
        c = 2;
        aZ = 20;
    }

    public void o() {
        float f = b(1.0F);

        if (f > 0.5F) {
            bw += 2;
        }
        super.o();
    }

    public void b_() {
        super.b_();
        if (l.k == 0) {
            q();
        }
    }

    protected Entity l() {
        EntityPlayer entityplayer = l.a(((Entity) (this)), 16D);

        if (entityplayer != null && i(((Entity) (entityplayer)))) {
            return ((Entity) (entityplayer));
        } else {
            return null;
        }
    }

    public boolean a(Entity entity, int i) {
        if (super.a(entity, i)) {
            if (j == entity || k == entity) {
                return true;
            }
            if (entity != this) {
                d = entity;
            }
            return true;
        } else {
            return false;
        }
    }

    protected void a(Entity entity, float f) {
        if ((double) f < 2.5D && entity.z.e > z.b && entity.z.b < z.e) {
            bf = 20;
            entity.a(((Entity) (this)), c);
        }
    }

    protected float a(int i, int j, int k) {
        return 0.5F - l.l(i, j, k);
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
    }

    public boolean b() {
        int i = MathHelper.b(p);
        int j = MathHelper.b(z.b);
        int k = MathHelper.b(r);

        if (l.a(EnumSkyBlock.a, i, j, k) > W.nextInt(32)) {
            return false;
        } else {
            int i1 = l.j(i, j, k);

            return i1 <= W.nextInt(8) && super.b();
        }
    }
}
