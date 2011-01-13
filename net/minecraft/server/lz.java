package net.minecraft.server;

import java.util.*;

public class lz extends Chunk {

    public lz(World world, int i, int j) {
        super(world, i, j);
        p = true;
    }

    public lz(World world, byte abyte0[], int i, int j) {
        super(world, abyte0, i, j);
        p = true;
    }

    public boolean a(int i, int j) {
        return i == this.j && j == k;
    }

    public int b(int i, int j) {
        return 0;
    }

    public void a() {}

    public void b() {}

    public void c() {}

    public int a(int i, int j, int k) {
        return 0;
    }

    public boolean a(int i, int j, int k, int l, int i1) {
        return true;
    }

    public boolean a(int i, int j, int k, int l) {
        return true;
    }

    public int b(int i, int j, int k) {
        return 0;
    }

    public void b(int i, int j, int k, int l) {}

    public int a(EnumSkyBlock enumskyblock, int i, int j, int k) {
        return 0;
    }

    public void a(EnumSkyBlock enumskyblock, int i, int j, int k, int l) {}

    public int c(int i, int j, int k, int l) {
        return 0;
    }

    public void a(Entity entity) {}

    public void b(Entity entity) {}

    public void a(Entity entity, int i) {}

    public boolean c(int i, int j, int k) {
        return false;
    }

    public TileEntity d(int i, int j, int k) {
        return null;
    }

    public void a(TileEntity tileentity) {}

    public void a(int i, int j, int k, TileEntity tileentity) {}

    public void e(int i, int j, int k) {}

    public void d() {}

    public void e() {}

    public void f() {}

    public void a(Entity entity, AxisAlignedBB axisalignedbb, List list) {}

    public void a(Class class1, AxisAlignedBB axisalignedbb, List list) {}

    public boolean a(boolean flag) {
        return false;
    }

    public int a(byte abyte0[], int i, int j, int k, int l, int i1, int j1, int k1) {
        int l1 = l - i;
        int i2 = i1 - j;
        int j2 = j1 - k;
        int k2 = l1 * i2 * j2;
        int l2 = k2 + (k2 / 2) * 3;

        Arrays.fill(abyte0, k1, k1 + l2, (byte) 0);
        return l2;
    }

    public Random a(long l) {
        return new Random(d.u + (long) (j * j * 0x4c1906) + (long) (j * 0x5ac0db) + (long) (k * k) * 0x4307a7L + (long) (k * 0x5f24f) ^ l);
    }

    public boolean g() {
        return true;
    }
}
