package net.minecraft.server;

import java.util.Random;

public class ls extends MobSpawnerBase {

    public ls() {}

    public WorldGenerator a(Random random) {
        if (random.nextInt(3) == 0) {
            return ((WorldGenerator) (new WorldGenBigTree()));
        } else {
            return ((WorldGenerator) (new WorldGenTrees()));
        }
    }
}
