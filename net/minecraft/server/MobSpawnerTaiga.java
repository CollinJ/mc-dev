package net.minecraft.server;

import java.util.Random;

public class MobSpawnerTaiga extends MobSpawnerBase {

    public MobSpawnerTaiga() {}

    public WorldGenerator a(Random random) {
        if (random.nextInt(3) == 0) {
            return ((WorldGenerator) (new WorldGenTaiga1()));
        } else {
            return ((WorldGenerator) (new WorldGenTaiga2()));
        }
    }
}
