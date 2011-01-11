package net.minecraft.server;

import java.util.Random;

class SpawnerMonsters extends SpawnerAnimals {

    final WorldServer a; /* synthetic field */

    SpawnerMonsters(WorldServer worldserver, int i, Class class1, Class aclass[]) {
        super(i, class1, aclass);
        a = worldserver;
    }

    protected ChunkPosition a(World world, int i, int j) {
        int k = i + world.m.nextInt(16);
        int l = world.m.nextInt(world.m.nextInt(120) + 8);
        int i1 = j + world.m.nextInt(16);

        return new ChunkPosition(k, l, i1);
    }
}
