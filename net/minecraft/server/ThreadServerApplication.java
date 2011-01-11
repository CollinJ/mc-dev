package net.minecraft.server;

public final class ThreadServerApplication extends Thread {

    final MinecraftServer a; /* synthetic field */

    public ThreadServerApplication(String s, MinecraftServer minecraftserver) {
        super(s);
        a = minecraftserver;
    }

    public void run() {
        a.run();
    }
}
