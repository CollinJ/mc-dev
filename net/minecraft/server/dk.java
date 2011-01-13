package net.minecraft.server;

import java.util.Random;

public class dk extends MobSpawnerBase {

    public dk() {}

    public WorldGenerator a(Random random) {
        if (random.nextInt(5) == 0) {
            return ((WorldGenerator) (new o()));
        }
        if (random.nextInt(3) == 0) {
            return ((WorldGenerator) (new WorldGenBigTree()));
        } else {
            return ((WorldGenerator) (new WorldGenTrees()));
        }
    }
}
