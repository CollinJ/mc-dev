package net.minecraft.server;

import java.util.Random;

public class g extends MobSpawnerBase {

    public g() {}

    public WorldGenerator a(Random random) {
        if (random.nextInt(3) == 0) {
            return ((WorldGenerator) (new cl()));
        } else {
            return ((WorldGenerator) (new ke()));
        }
    }
}
