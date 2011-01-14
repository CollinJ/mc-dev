package net.minecraft.server;

import java.util.Random;

public class MobSpawnerForest extends MobSpawnerBase {

    public MobSpawnerForest() {}

    public WorldGenerator a(Random random) {
        if (random.nextInt(5) == 0) {
            return ((WorldGenerator) (new WorldGenForest()));
        }
        if (random.nextInt(3) == 0) {
            return ((WorldGenerator) (new WorldGenBigTree()));
        } else {
            return ((WorldGenerator) (new WorldGenTrees()));
        }
    }
}
