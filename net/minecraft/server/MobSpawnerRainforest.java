package net.minecraft.server;

import java.util.Random;

public class MobSpawnerRainforest extends MobSpawnerBase {

    public MobSpawnerRainforest() {}

    public WorldGenerator a(Random random) {
        if (random.nextInt(3) == 0) {
            return ((WorldGenerator) (new WorldGenBigTree()));
        } else {
            return ((WorldGenerator) (new WorldGenTrees()));
        }
    }
}
