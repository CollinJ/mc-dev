package net.minecraft.server;

public class ThreadSleepForever extends Thread {

    final MinecraftServer a; /* synthetic field */

    public ThreadSleepForever(MinecraftServer minecraftserver) {
        super();
        a = minecraftserver;
        setDaemon(true);
        start();
    }

    public void run() {
        do {
            try {
                Thread.sleep(0x7fffffffL);
            } catch (InterruptedException interruptedexception) {}
        }
        while (true);
    }
}
