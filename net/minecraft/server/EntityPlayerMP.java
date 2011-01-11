package net.minecraft.server;

import java.util.*;

public class EntityPlayerMP extends EntityPlayer {

    public NetServerHandler a;
    public MinecraftServer b;
    public ItemInWorldManager ad;
    public double ae;
    public double af;
    public List ag;
    public Set ah;
    public double ai;

    public EntityPlayerMP(MinecraftServer minecraftserver, World world, String s, ItemInWorldManager iteminworldmanager) {
        super(world);
        ag = ((List) (new LinkedList()));
        ah = ((Set) (new HashSet()));
        int j = (world.n + R.nextInt(20)) - 10;
        int k = (world.p + R.nextInt(20)) - 10;
        int l = world.d(j, k);

        c((double) j + 0.5D, l, (double) k + 0.5D, 0.0F, 0.0F);
        b = minecraftserver;
        N = 0.0F;
        iteminworldmanager.a = ((EntityPlayer) (this));
        aq = s;
        ad = iteminworldmanager;
        C = 0.0F;
    }

    public void b_() {}

    public void f(Entity entity) {}

    public boolean a(Entity entity, int j) {
        return false;
    }

    public void a(int j) {}

    public void i() {
        super.b_();
        ChunkCoordIntPair chunkcoordintpair = null;
        double d = 0.0D;

        for (int j = 0; j < ag.size(); j++) {
            ChunkCoordIntPair chunkcoordintpair1 = (ChunkCoordIntPair) ag.get(j);
            double d1 = chunkcoordintpair1.a(((Entity) (this)));

            if (j == 0 || d1 < d) {
                chunkcoordintpair = chunkcoordintpair1;
                d = chunkcoordintpair1.a(((Entity) (this)));
            }
        }

        if (chunkcoordintpair != null) {
            boolean flag = false;

            if (d < 1024D) {
                flag = true;
            }
            if (a.b() < 2) {
                flag = true;
            }
            if (flag) {
                ag.remove(((chunkcoordintpair)));
                a.b(((Packet) (new Packet51MapChunk(chunkcoordintpair.a * 16, 0, chunkcoordintpair.b * 16, 16, 128, 16, ((World) (b.e))))));
                List list = b.e.d(chunkcoordintpair.a * 16, 0, chunkcoordintpair.b * 16, chunkcoordintpair.a * 16 + 16, 128, chunkcoordintpair.b * 16 + 16);

                for (int k = 0; k < list.size(); k++) {
                    TileEntity tileentity = (TileEntity) list.get(k);

                    a.b(((Packet) (new Packet59ComplexEntity(tileentity.b, tileentity.c, tileentity.d, tileentity))));
                }
            }
        }
    }

    public void y() {
        o = p = q = 0.0D;
        bg = false;
        super.y();
    }

    public void c(Entity entity, int j) {
        if (!entity.B && (entity instanceof EntityItem)) {
            a.b(((Packet) (new Packet17AddToInventory(((EntityItem) entity).a, j))));
            b.k.a(entity, ((Packet) (new Packet22Collect(entity.c, c))));
        }
        super.c(entity, j);
    }

    public void z() {
        if (!ao) {
            ap = -1;
            ao = true;
            b.k.a(((Entity) (this)), ((Packet) (new Packet18ArmAnimation(((Entity) (this)), 1))));
        }
    }

    protected float p() {
        return 1.62F;
    }
}
