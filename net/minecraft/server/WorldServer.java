package net.minecraft.server;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WorldServer extends World {

    public ChunkProviderServer y;
    public boolean z;
    public boolean A;
    private boolean B;
    private SpawnerAnimals C;
    private SpawnerAnimals D;

    public WorldServer(File file, String s, boolean flag) {
        super(file, s);
        z = false;
        C = ((SpawnerAnimals) (new SpawnerMonsters(this, 200, net.minecraft.server.IMobs.class, new Class[] {
            net.minecraft.server.EntityZombie.class, net.minecraft.server.EntitySkeleton.class, net.minecraft.server.EntityCreeper.class, net.minecraft.server.EntitySpider.class, net.minecraft.server.EntitySlime.class
        })));
        D = new SpawnerAnimals(15, net.minecraft.server.EntityAnimals.class, new Class[] {
            net.minecraft.server.EntitySheep.class, net.minecraft.server.EntityPig.class, net.minecraft.server.EntityCow.class, net.minecraft.server.EntityChicken.class
        });
        B = flag;
    }

    public void e() {
        super.e();
        if (B) {
            C.a(((World) (this)));
        }
        D.a(((World) (this)));
    }

    protected IChunkProvider a(File file) {
        y = new ChunkProviderServer(this, ((IChunkLoader) (new ChunkLoader(file, true))), ((IChunkProvider) (new ChunkProviderGenerate(((World) (this)), t))));
        return ((IChunkProvider) (y));
    }

    public List d(int i, int j, int k, int l, int i1, int j1) {
        ArrayList arraylist = new ArrayList();

        for (int k1 = 0; k1 < b.size(); k1++) {
            TileEntity tileentity = (TileEntity) b.get(k1);

            if (tileentity.b >= i && tileentity.c >= j && tileentity.d >= k && tileentity.b < l && tileentity.c < i1 && tileentity.d < j1) {
                ((List) (arraylist)).add(((tileentity)));
            }
        }

        return ((List) (arraylist));
    }
}
