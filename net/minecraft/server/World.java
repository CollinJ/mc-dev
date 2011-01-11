package net.minecraft.server;

import java.io.*;
import java.util.*;

public class World implements IBlockAccess {

    private List y;
    public List a;
    private List z;
    private TreeSet A;
    private Set B;
    public List b;
    public long c;
    public boolean d;
    private long C;
    private long D;
    private long E;
    public int e;
    protected int f;
    protected int g;
    public boolean h;
    public static float i[];
    private final long F;
    protected int j;
    public List k;
    public int l;
    public Random m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    protected List r;
    private IChunkProvider G;
    public File s;
    public long t;
    private NBTTagCompound H;
    public long u;
    public final String v;
    public boolean w;
    private ArrayList I;
    private Set J;
    private int K;
    private List L;
    public boolean x;

    public World(File file, String s1) {
        this(file, s1, (new Random()).nextLong());
    }

    public World(String s1) {
        y = ((List) (new ArrayList()));
        a = ((List) (new ArrayList()));
        z = ((List) (new ArrayList()));
        A = new TreeSet();
        B = ((Set) (new HashSet()));
        b = ((List) (new ArrayList()));
        c = 0L;
        d = false;
        C = 0x88bbffL;
        D = 0xc0d8ffL;
        E = 0xffffffL;
        e = 0;
        f = (new Random()).nextInt();
        g = 0x3c6ef35f;
        h = false;
        F = System.currentTimeMillis();
        j = 40;
        k = ((List) (new ArrayList()));
        m = new Random();
        q = false;
        r = ((List) (new ArrayList()));
        t = 0L;
        u = 0L;
        I = new ArrayList();
        J = ((Set) (new HashSet()));
        K = m.nextInt(12000);
        L = ((List) (new ArrayList()));
        x = false;
        v = s1;
        G = a(s);
        d();
    }

    public World(File file, String s1, long l1) {
        y = ((List) (new ArrayList()));
        a = ((List) (new ArrayList()));
        z = ((List) (new ArrayList()));
        A = new TreeSet();
        B = ((Set) (new HashSet()));
        b = ((List) (new ArrayList()));
        c = 0L;
        d = false;
        C = 0x88bbffL;
        D = 0xc0d8ffL;
        E = 0xffffffL;
        e = 0;
        f = (new Random()).nextInt();
        g = 0x3c6ef35f;
        h = false;
        F = System.currentTimeMillis();
        j = 40;
        k = ((List) (new ArrayList()));
        m = new Random();
        q = false;
        r = ((List) (new ArrayList()));
        t = 0L;
        u = 0L;
        I = new ArrayList();
        J = ((Set) (new HashSet()));
        K = m.nextInt(12000);
        L = ((List) (new ArrayList()));
        x = false;
        v = s1;
        file.mkdirs();
        s = new File(file, s1);
        s.mkdirs();
        try {
            File file1 = new File(s, "session.lock");
            DataOutputStream dataoutputstream = new DataOutputStream(((java.io.OutputStream) (new FileOutputStream(file1))));

            try {
                dataoutputstream.writeLong(F);
            } finally {
                dataoutputstream.close();
            }
        } catch (IOException ioexception) {
            throw new RuntimeException("Failed to check session lock, aborting");
        }
        File file2 = new File(s, "level.dat");

        q = !file2.exists();
        if (file2.exists()) {
            try {
                NBTTagCompound nbttagcompound = CompressedStreamTools.a(((java.io.InputStream) (new FileInputStream(file2))));
                NBTTagCompound nbttagcompound1 = nbttagcompound.j("Data");

                t = nbttagcompound1.e("RandomSeed");
                n = nbttagcompound1.d("SpawnX");
                o = nbttagcompound1.d("SpawnY");
                p = nbttagcompound1.d("SpawnZ");
                c = nbttagcompound1.e("Time");
                u = nbttagcompound1.e("SizeOnDisk");
                d = nbttagcompound1.l("SnowCovered");
                if (nbttagcompound1.a("Player")) {
                    H = nbttagcompound1.j("Player");
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        } else {
            d = m.nextInt(4) == 0;
        }
        boolean flag = false;

        if (t == 0L) {
            t = l1;
            flag = true;
        }
        G = a(s);
        if (flag) {
            w = true;
            n = 0;
            o = 64;
            for (p = 0; !e(n, p); p += m.nextInt(64) - m.nextInt(64)) {
                n += m.nextInt(64) - m.nextInt(64);
            }

            w = false;
        }
        d();
    }

    protected IChunkProvider a(File file) {
        return ((IChunkProvider) (new ChunkProviderLoadOrGenerate(this, ((IChunkLoader) (new ChunkLoader(file, true))), ((IChunkProvider) (new ChunkProviderGenerate(this, t))))));
    }

    private boolean e(int i1, int j1) {
        int k1 = f(i1, j1);

        return k1 == Block.F.bc;
    }

    private int f(int i1, int j1) {
        int k1;

        for (k1 = 63; a(i1, k1 + 1, j1) != 0; k1++) {
            ;
        }
        return a(i1, k1, j1);
    }

    public void a(boolean flag, IProgressUpdate iprogressupdate) {
        if (!G.b()) {
            return;
        }
        if (iprogressupdate != null) {
            iprogressupdate.a("Saving level");
        }
        h();
        if (iprogressupdate != null) {
            iprogressupdate.b("Saving chunks");
        }
        G.a(flag, iprogressupdate);
    }

    private void h() {
        g();
        NBTTagCompound nbttagcompound = new NBTTagCompound();

        nbttagcompound.a("RandomSeed", t);
        nbttagcompound.a("SpawnX", n);
        nbttagcompound.a("SpawnY", o);
        nbttagcompound.a("SpawnZ", p);
        nbttagcompound.a("Time", c);
        nbttagcompound.a("SizeOnDisk", u);
        nbttagcompound.a("SnowCovered", d);
        nbttagcompound.a("LastPlayed", System.currentTimeMillis());
        EntityPlayer entityplayer = null;

        if (k.size() > 0) {
            entityplayer = (EntityPlayer) k.get(0);
        }
        if (entityplayer != null) {
            NBTTagCompound nbttagcompound1 = new NBTTagCompound();

            entityplayer.d(nbttagcompound1);
            nbttagcompound.a("Player", nbttagcompound1);
        }
        NBTTagCompound nbttagcompound2 = new NBTTagCompound();

        nbttagcompound2.a("Data", ((NBTBase) (nbttagcompound)));
        try {
            File file = new File(s, "level.dat_new");
            File file1 = new File(s, "level.dat_old");
            File file2 = new File(s, "level.dat");

            CompressedStreamTools.a(nbttagcompound2, ((java.io.OutputStream) (new FileOutputStream(file))));
            if (file1.exists()) {
                file1.delete();
            }
            file2.renameTo(file1);
            if (file2.exists()) {
                file2.delete();
            }
            file.renameTo(file2);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public int a(int i1, int j1, int k1) {
        if (i1 < 0xfe17b800 || k1 < 0xfe17b800 || i1 >= 0x1e84800 || k1 > 0x1e84800) {
            return 0;
        }
        if (j1 < 0) {
            return 0;
        }
        if (j1 >= 128) {
            return 0;
        } else {
            return b(i1 >> 4, k1 >> 4).a(i1 & 0xf, j1, k1 & 0xf);
        }
    }

    public boolean e(int i1, int j1, int k1) {
        if (j1 < 0 || j1 >= 128) {
            return false;
        } else {
            return g(i1 >> 4, k1 >> 4);
        }
    }

    public boolean a(int i1, int j1, int k1, int l1, int i2, int j2) {
        if (i2 < 0 || j1 >= 128) {
            return false;
        }
        i1 >>= 4;
        j1 >>= 4;
        k1 >>= 4;
        l1 >>= 4;
        i2 >>= 4;
        j2 >>= 4;
        for (int k2 = i1; k2 <= l1; k2++) {
            for (int l2 = k1; l2 <= j2; l2++) {
                if (!g(k2, l2)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean g(int i1, int j1) {
        return G.a(i1, j1);
    }

    public Chunk a(int i1, int j1) {
        return b(i1 >> 4, j1 >> 4);
    }

    public Chunk b(int i1, int j1) {
        return G.b(i1, j1);
    }

    public boolean a(int i1, int j1, int k1, int l1, int i2) {
        if (i1 < 0xfe17b800 || k1 < 0xfe17b800 || i1 >= 0x1e84800 || k1 > 0x1e84800) {
            return false;
        }
        if (j1 < 0) {
            return false;
        }
        if (j1 >= 128) {
            return false;
        } else {
            Chunk chunk = b(i1 >> 4, k1 >> 4);

            return chunk.a(i1 & 0xf, j1, k1 & 0xf, l1, i2);
        }
    }

    public boolean a(int i1, int j1, int k1, int l1) {
        if (i1 < 0xfe17b800 || k1 < 0xfe17b800 || i1 >= 0x1e84800 || k1 > 0x1e84800) {
            return false;
        }
        if (j1 < 0) {
            return false;
        }
        if (j1 >= 128) {
            return false;
        } else {
            Chunk chunk = b(i1 >> 4, k1 >> 4);

            return chunk.a(i1 & 0xf, j1, k1 & 0xf, l1);
        }
    }

    public Material c(int i1, int j1, int k1) {
        int l1 = a(i1, j1, k1);

        if (l1 == 0) {
            return Material.a;
        } else {
            return Block.n[l1].bn;
        }
    }

    public int b(int i1, int j1, int k1) {
        if (i1 < 0xfe17b800 || k1 < 0xfe17b800 || i1 >= 0x1e84800 || k1 > 0x1e84800) {
            return 0;
        }
        if (j1 < 0) {
            return 0;
        }
        if (j1 >= 128) {
            return 0;
        } else {
            Chunk chunk = b(i1 >> 4, k1 >> 4);

            i1 &= 0xf;
            k1 &= 0xf;
            return chunk.b(i1, j1, k1);
        }
    }

    public void b(int i1, int j1, int k1, int l1) {
        c(i1, j1, k1, l1);
    }

    public boolean c(int i1, int j1, int k1, int l1) {
        if (i1 < 0xfe17b800 || k1 < 0xfe17b800 || i1 >= 0x1e84800 || k1 > 0x1e84800) {
            return false;
        }
        if (j1 < 0) {
            return false;
        }
        if (j1 >= 128) {
            return false;
        } else {
            Chunk chunk = b(i1 >> 4, k1 >> 4);

            i1 &= 0xf;
            k1 &= 0xf;
            chunk.b(i1, j1, k1, l1);
            return true;
        }
    }

    public boolean d(int i1, int j1, int k1, int l1) {
        if (a(i1, j1, k1, l1)) {
            e(i1, j1, k1, l1);
            return true;
        } else {
            return false;
        }
    }

    public boolean b(int i1, int j1, int k1, int l1, int i2) {
        if (a(i1, j1, k1, l1, i2)) {
            e(i1, j1, k1, l1);
            return true;
        } else {
            return false;
        }
    }

    public void f(int i1, int j1, int k1) {
        for (int l1 = 0; l1 < r.size(); l1++) {
            ((IWorldAccess) r.get(l1)).a(i1, j1, k1);
        }
    }

    protected void e(int i1, int j1, int k1, int l1) {
        f(i1, j1, k1);
        g(i1, j1, k1, l1);
    }

    public void f(int i1, int j1, int k1, int l1) {
        if (k1 > l1) {
            int i2 = l1;

            l1 = k1;
            k1 = i2;
        }
        b(i1, k1, j1, i1, l1, j1);
    }

    public void b(int i1, int j1, int k1, int l1, int i2, int j2) {
        for (int k2 = 0; k2 < r.size(); k2++) {
            ((IWorldAccess) r.get(k2)).a(i1, j1, k1, l1, i2, j2);
        }
    }

    public void g(int i1, int j1, int k1, int l1) {
        k(i1 - 1, j1, k1, l1);
        k(i1 + 1, j1, k1, l1);
        k(i1, j1 - 1, k1, l1);
        k(i1, j1 + 1, k1, l1);
        k(i1, j1, k1 - 1, l1);
        k(i1, j1, k1 + 1, l1);
    }

    private void k(int i1, int j1, int k1, int l1) {
        if (h || x) {
            return;
        }
        Block block = Block.n[a(i1, j1, k1)];

        if (block != null) {
            block.b(this, i1, j1, k1, l1);
        }
    }

    public boolean g(int i1, int j1, int k1) {
        return b(i1 >> 4, k1 >> 4).c(i1 & 0xf, j1, k1 & 0xf);
    }

    public int h(int i1, int j1, int k1) {
        return a(i1, j1, k1, true);
    }

    public int a(int i1, int j1, int k1, boolean flag) {
        if (i1 < 0xfe17b800 || k1 < 0xfe17b800 || i1 >= 0x1e84800 || k1 > 0x1e84800) {
            return 15;
        }
        if (flag) {
            int l1 = a(i1, j1, k1);

            if (l1 == Block.al.bc || l1 == Block.aB.bc) {
                int j2 = a(i1, j1 + 1, k1, false);
                int k2 = a(i1 + 1, j1, k1, false);
                int l2 = a(i1 - 1, j1, k1, false);
                int i3 = a(i1, j1, k1 + 1, false);
                int j3 = a(i1, j1, k1 - 1, false);

                if (k2 > j2) {
                    j2 = k2;
                }
                if (l2 > j2) {
                    j2 = l2;
                }
                if (i3 > j2) {
                    j2 = i3;
                }
                if (j3 > j2) {
                    j2 = j3;
                }
                return j2;
            }
        }
        if (j1 < 0) {
            return 0;
        }
        if (j1 >= 128) {
            int i2 = 15 - e;

            if (i2 < 0) {
                i2 = 0;
            }
            return i2;
        } else {
            Chunk chunk = b(i1 >> 4, k1 >> 4);

            i1 &= 0xf;
            k1 &= 0xf;
            return chunk.c(i1, j1, k1, e);
        }
    }

    public boolean i(int i1, int j1, int k1) {
        if (i1 < 0xfe17b800 || k1 < 0xfe17b800 || i1 >= 0x1e84800 || k1 > 0x1e84800) {
            return false;
        }
        if (j1 < 0) {
            return false;
        }
        if (j1 >= 128) {
            return true;
        }
        if (!g(i1 >> 4, k1 >> 4)) {
            return false;
        } else {
            Chunk chunk = b(i1 >> 4, k1 >> 4);

            i1 &= 0xf;
            k1 &= 0xf;
            return chunk.c(i1, j1, k1);
        }
    }

    public int c(int i1, int j1) {
        if (i1 < 0xfe17b800 || j1 < 0xfe17b800 || i1 >= 0x1e84800 || j1 > 0x1e84800) {
            return 0;
        }
        if (!g(i1 >> 4, j1 >> 4)) {
            return 0;
        } else {
            Chunk chunk = b(i1 >> 4, j1 >> 4);

            return chunk.b(i1 & 0xf, j1 & 0xf);
        }
    }

    public void a(EnumSkyBlock enumskyblock, int i1, int j1, int k1, int l1) {
        if (!e(i1, j1, k1)) {
            return;
        }
        if (enumskyblock == EnumSkyBlock.a) {
            if (i(i1, j1, k1)) {
                l1 = 15;
            }
        } else if (enumskyblock == EnumSkyBlock.b) {
            int i2 = a(i1, j1, k1);

            if (Block.t[i2] > l1) {
                l1 = Block.t[i2];
            }
        }
        if (a(enumskyblock, i1, j1, k1) != l1) {
            a(enumskyblock, i1, j1, k1, i1, j1, k1);
        }
    }

    public int a(EnumSkyBlock enumskyblock, int i1, int j1, int k1) {
        if (j1 < 0 || j1 >= 128 || i1 < 0xfe17b800 || k1 < 0xfe17b800 || i1 >= 0x1e84800 || k1 > 0x1e84800) {
            return enumskyblock.c;
        }
        int l1 = i1 >> 4;
        int i2 = k1 >> 4;

        if (!g(l1, i2)) {
            return 0;
        } else {
            Chunk chunk = b(l1, i2);

            return chunk.a(enumskyblock, i1 & 0xf, j1, k1 & 0xf);
        }
    }

    public void b(EnumSkyBlock enumskyblock, int i1, int j1, int k1, int l1) {
        if (i1 < 0xfe17b800 || k1 < 0xfe17b800 || i1 >= 0x1e84800 || k1 > 0x1e84800) {
            return;
        }
        if (j1 < 0) {
            return;
        }
        if (j1 >= 128) {
            return;
        }
        if (!g(i1 >> 4, k1 >> 4)) {
            return;
        }
        Chunk chunk = b(i1 >> 4, k1 >> 4);

        chunk.a(enumskyblock, i1 & 0xf, j1, k1 & 0xf, l1);
        for (int i2 = 0; i2 < r.size(); i2++) {
            ((IWorldAccess) r.get(i2)).a(i1, j1, k1);
        }
    }

    public float j(int i1, int j1, int k1) {
        return i[h(i1, j1, k1)];
    }

    public boolean a() {
        return e < 4;
    }

    public MovingObjectPosition a(Vec3D vec3d, Vec3D vec3d1) {
        return a(vec3d, vec3d1, false);
    }

    public MovingObjectPosition a(Vec3D vec3d, Vec3D vec3d1, boolean flag) {
        if (Double.isNaN(vec3d.a) || Double.isNaN(vec3d.b) || Double.isNaN(vec3d.c)) {
            return null;
        }
        if (Double.isNaN(vec3d1.a) || Double.isNaN(vec3d1.b) || Double.isNaN(vec3d1.c)) {
            return null;
        }
        int i1 = MathHelper.b(vec3d1.a);
        int j1 = MathHelper.b(vec3d1.b);
        int k1 = MathHelper.b(vec3d1.c);
        int l1 = MathHelper.b(vec3d.a);
        int i2 = MathHelper.b(vec3d.b);
        int j2 = MathHelper.b(vec3d.c);

        for (int k2 = 20; k2-- >= 0;) {
            if (Double.isNaN(vec3d.a) || Double.isNaN(vec3d.b) || Double.isNaN(vec3d.c)) {
                return null;
            }
            if (l1 == i1 && i2 == j1 && j2 == k1) {
                return null;
            }
            double d1 = 999D;
            double d2 = 999D;
            double d3 = 999D;

            if (i1 > l1) {
                d1 = (double) l1 + 1.0D;
            }
            if (i1 < l1) {
                d1 = (double) l1 + 0.0D;
            }
            if (j1 > i2) {
                d2 = (double) i2 + 1.0D;
            }
            if (j1 < i2) {
                d2 = (double) i2 + 0.0D;
            }
            if (k1 > j2) {
                d3 = (double) j2 + 1.0D;
            }
            if (k1 < j2) {
                d3 = (double) j2 + 0.0D;
            }
            double d4 = 999D;
            double d5 = 999D;
            double d6 = 999D;
            double d7 = vec3d1.a - vec3d.a;
            double d8 = vec3d1.b - vec3d.b;
            double d9 = vec3d1.c - vec3d.c;

            if (d1 != 999D) {
                d4 = (d1 - vec3d.a) / d7;
            }
            if (d2 != 999D) {
                d5 = (d2 - vec3d.b) / d8;
            }
            if (d3 != 999D) {
                d6 = (d3 - vec3d.c) / d9;
            }
            byte byte0 = 0;

            if (d4 < d5 && d4 < d6) {
                if (i1 > l1) {
                    byte0 = 4;
                } else {
                    byte0 = 5;
                }
                vec3d.a = d1;
                vec3d.b += d8 * d4;
                vec3d.c += d9 * d4;
            } else if (d5 < d6) {
                if (j1 > i2) {
                    byte0 = 0;
                } else {
                    byte0 = 1;
                }
                vec3d.a += d7 * d5;
                vec3d.b = d2;
                vec3d.c += d9 * d5;
            } else {
                if (k1 > j2) {
                    byte0 = 2;
                } else {
                    byte0 = 3;
                }
                vec3d.a += d7 * d6;
                vec3d.b += d8 * d6;
                vec3d.c = d3;
            }
            Vec3D vec3d2 = Vec3D.b(vec3d.a, vec3d.b, vec3d.c);

            l1 = (int) (vec3d2.a = MathHelper.b(vec3d.a));
            if (byte0 == 5) {
                l1--;
                vec3d2.a++;
            }
            i2 = (int) (vec3d2.b = MathHelper.b(vec3d.b));
            if (byte0 == 1) {
                i2--;
                vec3d2.b++;
            }
            j2 = (int) (vec3d2.c = MathHelper.b(vec3d.c));
            if (byte0 == 3) {
                j2--;
                vec3d2.c++;
            }
            int l2 = a(l1, i2, j2);
            int i3 = b(l1, i2, j2);
            Block block = Block.n[l2];

            if (l2 > 0 && block.a(i3, flag)) {
                MovingObjectPosition movingobjectposition = block.a(this, l1, i2, j2, vec3d, vec3d1);

                if (movingobjectposition != null) {
                    return movingobjectposition;
                }
            }
        }

        return null;
    }

    public void a(Entity entity, String s1, float f1, float f2) {
        for (int i1 = 0; i1 < r.size(); i1++) {
            ((IWorldAccess) r.get(i1)).a(s1, entity.l, entity.m - (double) entity.C, entity.n, f1, f2);
        }
    }

    public void a(double d1, double d2, double d3, String s1, float f1, float f2) {
        for (int i1 = 0; i1 < r.size(); i1++) {
            ((IWorldAccess) r.get(i1)).a(s1, d1, d2, d3, f1, f2);
        }
    }

    public void a(String s1, int i1, int j1, int k1) {
        for (int l1 = 0; l1 < r.size(); l1++) {
            ((IWorldAccess) r.get(l1)).a(s1, i1, j1, k1);
        }
    }

    public void a(String s1, double d1, double d2, double d3, double d4, double d5, double d6) {
        for (int i1 = 0; i1 < r.size(); i1++) {
            ((IWorldAccess) r.get(i1)).a(s1, d1, d2, d3, d4, d5, d6);
        }
    }

    public boolean a(Entity entity) {
        int i1 = MathHelper.b(entity.l / 16D);
        int j1 = MathHelper.b(entity.n / 16D);
        boolean flag = false;

        if (entity instanceof EntityPlayer) {
            flag = true;
        }
        if (flag || g(i1, j1)) {
            if (entity instanceof EntityPlayer) {
                k.add((((EntityPlayer) entity)));
                System.out.println((new StringBuilder()).append("Player count: ").append(k.size()).toString());
            }
            b(i1, j1).a(entity);
            a.add(((entity)));
            b(entity);
            return true;
        } else {
            return false;
        }
    }

    protected void b(Entity entity) {
        for (int i1 = 0; i1 < r.size(); i1++) {
            ((IWorldAccess) r.get(i1)).a(entity);
        }
    }

    protected void c(Entity entity) {
        for (int i1 = 0; i1 < r.size(); i1++) {
            ((IWorldAccess) r.get(i1)).b(entity);
        }
    }

    public void d(Entity entity) {
        entity.j();
        if (entity instanceof EntityPlayer) {
            k.remove((((EntityPlayer) entity)));
            System.out.println((new StringBuilder()).append("Player count: ").append(k.size()).toString());
        }
    }

    public void a(IWorldAccess iworldaccess) {
        r.add(((iworldaccess)));
    }

    public List a(Entity entity, AxisAlignedBB axisalignedbb) {
        I.clear();
        int i1 = MathHelper.b(axisalignedbb.a);
        int j1 = MathHelper.b(axisalignedbb.d + 1.0D);
        int k1 = MathHelper.b(axisalignedbb.b);
        int l1 = MathHelper.b(axisalignedbb.e + 1.0D);
        int i2 = MathHelper.b(axisalignedbb.c);
        int j2 = MathHelper.b(axisalignedbb.f + 1.0D);

        for (int k2 = i1; k2 < j1; k2++) {
            for (int l2 = i2; l2 < j2; l2++) {
                if (!e(k2, 64, l2)) {
                    continue;
                }
                for (int i3 = k1 - 1; i3 < l1; i3++) {
                    Block block = Block.n[a(k2, i3, l2)];

                    if (block != null) {
                        block.a(this, k2, i3, l2, axisalignedbb, I);
                    }
                }
            }
        }

        double d1 = 0.25D;
        List list = b(entity, axisalignedbb.b(d1, d1, d1));

        for (int j3 = 0; j3 < list.size(); j3++) {
            AxisAlignedBB axisalignedbb1 = ((Entity) list.get(j3)).n();

            if (axisalignedbb1 != null && axisalignedbb1.a(axisalignedbb)) {
                I.add(((axisalignedbb1)));
            }
            axisalignedbb1 = entity.d((Entity) list.get(j3));
            if (axisalignedbb1 != null && axisalignedbb1.a(axisalignedbb)) {
                I.add(((axisalignedbb1)));
            }
        }

        return ((List) (I));
    }

    public int a(float f1) {
        float f2 = b(f1);
        float f3 = 1.0F - (MathHelper.b(f2 * 3.141593F * 2.0F) * 2.0F + 0.5F);

        if (f3 < 0.0F) {
            f3 = 0.0F;
        }
        if (f3 > 1.0F) {
            f3 = 1.0F;
        }
        return (int) (f3 * 11F);
    }

    public float b(float f1) {
        int i1 = (int) (c % 24000L);
        float f2 = ((float) i1 + f1) / 24000F - 0.25F;

        if (f2 < 0.0F) {
            f2++;
        }
        if (f2 > 1.0F) {
            f2--;
        }
        float f3 = f2;

        f2 = 1.0F - (float) ((Math.cos((double) f2 * 3.1415926535897931D) + 1.0D) / 2D);
        f2 = f3 + (f2 - f3) / 3F;
        return f2;
    }

    public int d(int i1, int j1) {
        Chunk chunk = a(i1, j1);
        int k1 = 127;

        i1 &= 0xf;
        j1 &= 0xf;
        while (k1 > 0) {
            int l1 = chunk.a(i1, k1, j1);

            if (l1 == 0 || !Block.n[l1].bn.c() && !Block.n[l1].bn.d()) {
                k1--;
            } else {
                return k1 + 1;
            }
        }
        return -1;
    }

    public void h(int i1, int j1, int k1, int l1) {
        NextTickListEntry nextticklistentry = new NextTickListEntry(i1, j1, k1, l1);
        byte byte0 = 8;

        if (a(i1 - byte0, j1 - byte0, k1 - byte0, i1 + byte0, j1 + byte0, k1 + byte0)) {
            if (l1 > 0) {
                nextticklistentry.a((long) Block.n[l1].c() + c);
            }
            if (!B.contains(((nextticklistentry)))) {
                B.add(((nextticklistentry)));
                A.add(((nextticklistentry)));
            }
        }
    }

    public void b() {
        a.removeAll(((java.util.Collection) (z)));
        for (int i1 = 0; i1 < z.size(); i1++) {
            Entity entity = (Entity) z.get(i1);
            int i2 = entity.aa;
            int k2 = entity.ac;

            if (entity.Z && g(i2, k2)) {
                b(i2, k2).b(entity);
            }
        }

        for (int j1 = 0; j1 < z.size(); j1++) {
            c((Entity) z.get(j1));
        }

        z.clear();
        for (int k1 = 0; k1 < a.size(); k1++) {
            Entity entity1 = (Entity) a.get(k1);

            if (entity1.g != null) {
                if (!entity1.g.B && entity1.g.f == entity1) {
                    continue;
                }
                entity1.g.f = null;
                entity1.g = null;
            }
            if (!entity1.B) {
                e(entity1);
            }
            if (!entity1.B) {
                continue;
            }
            int j2 = entity1.aa;
            int l2 = entity1.ac;

            if (entity1.Z && g(j2, l2)) {
                b(j2, l2).b(entity1);
            }
            a.remove(k1--);
            c(entity1);
        }

        for (int l1 = 0; l1 < b.size(); l1++) {
            TileEntity tileentity = (TileEntity) b.get(l1);

            tileentity.b();
        }
    }

    protected void e(Entity entity) {
        int i1 = MathHelper.b(entity.l);
        int j1 = MathHelper.b(entity.n);
        byte byte0 = 16;

        if (!a(i1 - byte0, 0, j1 - byte0, i1 + byte0, 128, j1 + byte0)) {
            return;
        }
        entity.J = entity.l;
        entity.K = entity.m;
        entity.L = entity.n;
        entity.t = entity.r;
        entity.u = entity.s;
        if (entity.g != null) {
            entity.v();
        } else {
            entity.b_();
        }
        int k1 = MathHelper.b(entity.l / 16D);
        int l1 = MathHelper.b(entity.m / 16D);
        int i2 = MathHelper.b(entity.n / 16D);

        if (!entity.Z || entity.aa != k1 || entity.ab != l1 || entity.ac != i2) {
            if (entity.Z && g(entity.aa, entity.ac)) {
                b(entity.aa, entity.ac).a(entity, entity.ab);
            }
            if (g(k1, i2)) {
                b(k1, i2).a(entity);
            } else {
                entity.Z = false;
                System.out.println("Removing entity because it's not in a chunk!!");
                entity.j();
            }
        }
        if (entity.f != null) {
            if (entity.f.B || entity.f.g != entity) {
                entity.f.g = null;
                entity.f = null;
            } else {
                e(entity.f);
            }
        }
        if (Double.isNaN(entity.l) || Double.isInfinite(entity.l)) {
            entity.l = entity.J;
        }
        if (Double.isNaN(entity.m) || Double.isInfinite(entity.m)) {
            entity.m = entity.K;
        }
        if (Double.isNaN(entity.n) || Double.isInfinite(entity.n)) {
            entity.n = entity.L;
        }
        if (Double.isNaN(entity.s) || Double.isInfinite(entity.s)) {
            entity.s = entity.u;
        }
        if (Double.isNaN(entity.r) || Double.isInfinite(entity.r)) {
            entity.r = entity.t;
        }
    }

    public boolean a(AxisAlignedBB axisalignedbb) {
        List list = b(((Entity) (null)), axisalignedbb);

        for (int i1 = 0; i1 < list.size(); i1++) {
            Entity entity = (Entity) list.get(i1);

            if (!entity.B && entity.e) {
                return false;
            }
        }

        return true;
    }

    public boolean b(AxisAlignedBB axisalignedbb) {
        int i1 = MathHelper.b(axisalignedbb.a);
        int j1 = MathHelper.b(axisalignedbb.d + 1.0D);
        int k1 = MathHelper.b(axisalignedbb.b);
        int l1 = MathHelper.b(axisalignedbb.e + 1.0D);
        int i2 = MathHelper.b(axisalignedbb.c);
        int j2 = MathHelper.b(axisalignedbb.f + 1.0D);

        if (axisalignedbb.a < 0.0D) {
            i1--;
        }
        if (axisalignedbb.b < 0.0D) {
            k1--;
        }
        if (axisalignedbb.c < 0.0D) {
            i2--;
        }
        for (int k2 = i1; k2 < j1; k2++) {
            for (int l2 = k1; l2 < l1; l2++) {
                for (int i3 = i2; i3 < j2; i3++) {
                    Block block = Block.n[a(k2, l2, i3)];

                    if (block != null && block.bn.d()) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean c(AxisAlignedBB axisalignedbb) {
        int i1 = MathHelper.b(axisalignedbb.a);
        int j1 = MathHelper.b(axisalignedbb.d + 1.0D);
        int k1 = MathHelper.b(axisalignedbb.b);
        int l1 = MathHelper.b(axisalignedbb.e + 1.0D);
        int i2 = MathHelper.b(axisalignedbb.c);
        int j2 = MathHelper.b(axisalignedbb.f + 1.0D);

        for (int k2 = i1; k2 < j1; k2++) {
            for (int l2 = k1; l2 < l1; l2++) {
                for (int i3 = i2; i3 < j2; i3++) {
                    int j3 = a(k2, l2, i3);

                    if (j3 == Block.as.bc || j3 == Block.D.bc || j3 == Block.E.bc) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean a(AxisAlignedBB axisalignedbb, Material material, Entity entity) {
        int i1 = MathHelper.b(axisalignedbb.a);
        int j1 = MathHelper.b(axisalignedbb.d + 1.0D);
        int k1 = MathHelper.b(axisalignedbb.b);
        int l1 = MathHelper.b(axisalignedbb.e + 1.0D);
        int i2 = MathHelper.b(axisalignedbb.c);
        int j2 = MathHelper.b(axisalignedbb.f + 1.0D);
        boolean flag = false;
        Vec3D vec3d = Vec3D.b(0.0D, 0.0D, 0.0D);

        for (int k2 = i1; k2 < j1; k2++) {
            for (int l2 = k1; l2 < l1; l2++) {
                for (int i3 = i2; i3 < j2; i3++) {
                    Block block = Block.n[a(k2, l2, i3)];

                    if (block == null || block.bn != material) {
                        continue;
                    }
                    double d1 = (float) (l2 + 1) - BlockFluids.b(b(k2, l2, i3));

                    if ((double) l1 >= d1) {
                        flag = true;
                        block.a(this, k2, l2, i3, entity, vec3d);
                    }
                }
            }
        }

        if (vec3d.c() > 0.0D) {
            vec3d = vec3d.b();
            double d2 = 0.0040000000000000001D;

            entity.o += vec3d.a * d2;
            entity.p += vec3d.b * d2;
            entity.q += vec3d.c * d2;
        }
        return flag;
    }

    public boolean a(AxisAlignedBB axisalignedbb, Material material) {
        int i1 = MathHelper.b(axisalignedbb.a);
        int j1 = MathHelper.b(axisalignedbb.d + 1.0D);
        int k1 = MathHelper.b(axisalignedbb.b);
        int l1 = MathHelper.b(axisalignedbb.e + 1.0D);
        int i2 = MathHelper.b(axisalignedbb.c);
        int j2 = MathHelper.b(axisalignedbb.f + 1.0D);

        for (int k2 = i1; k2 < j1; k2++) {
            for (int l2 = k1; l2 < l1; l2++) {
                for (int i3 = i2; i3 < j2; i3++) {
                    Block block = Block.n[a(k2, l2, i3)];

                    if (block != null && block.bn == material) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean b(AxisAlignedBB axisalignedbb, Material material) {
        int i1 = MathHelper.b(axisalignedbb.a);
        int j1 = MathHelper.b(axisalignedbb.d + 1.0D);
        int k1 = MathHelper.b(axisalignedbb.b);
        int l1 = MathHelper.b(axisalignedbb.e + 1.0D);
        int i2 = MathHelper.b(axisalignedbb.c);
        int j2 = MathHelper.b(axisalignedbb.f + 1.0D);

        for (int k2 = i1; k2 < j1; k2++) {
            for (int l2 = k1; l2 < l1; l2++) {
                for (int i3 = i2; i3 < j2; i3++) {
                    Block block = Block.n[a(k2, l2, i3)];

                    if (block == null || block.bn != material) {
                        continue;
                    }
                    int j3 = b(k2, l2, i3);
                    double d1 = l2 + 1;

                    if (j3 < 8) {
                        d1 = (double) (l2 + 1) - (double) j3 / 8D;
                    }
                    if (d1 >= axisalignedbb.b) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public void a(Entity entity, double d1, double d2, double d3, float f1) {
        (new Explosion()).a(this, entity, d1, d2, d3, f1);
    }

    public float a(Vec3D vec3d, AxisAlignedBB axisalignedbb) {
        double d1 = 1.0D / ((axisalignedbb.d - axisalignedbb.a) * 2D + 1.0D);
        double d2 = 1.0D / ((axisalignedbb.e - axisalignedbb.b) * 2D + 1.0D);
        double d3 = 1.0D / ((axisalignedbb.f - axisalignedbb.c) * 2D + 1.0D);
        int i1 = 0;
        int j1 = 0;

        for (float f1 = 0.0F; f1 <= 1.0F; f1 = (float) ((double) f1 + d1)) {
            for (float f2 = 0.0F; f2 <= 1.0F; f2 = (float) ((double) f2 + d2)) {
                for (float f3 = 0.0F; f3 <= 1.0F; f3 = (float) ((double) f3 + d3)) {
                    double d4 = axisalignedbb.a + (axisalignedbb.d - axisalignedbb.a) * (double) f1;
                    double d5 = axisalignedbb.b + (axisalignedbb.e - axisalignedbb.b) * (double) f2;
                    double d6 = axisalignedbb.c + (axisalignedbb.f - axisalignedbb.c) * (double) f3;

                    if (a(Vec3D.b(d4, d5, d6), vec3d) == null) {
                        i1++;
                    }
                    j1++;
                }
            }
        }

        return (float) i1 / (float) j1;
    }

    public TileEntity k(int i1, int j1, int k1) {
        Chunk chunk = b(i1 >> 4, k1 >> 4);

        if (chunk != null) {
            return chunk.d(i1 & 0xf, j1, k1 & 0xf);
        } else {
            return null;
        }
    }

    public void a(int i1, int j1, int k1, TileEntity tileentity) {
        Chunk chunk = b(i1 >> 4, k1 >> 4);

        if (chunk != null) {
            chunk.a(i1 & 0xf, j1, k1 & 0xf, tileentity);
        }
    }

    public void l(int i1, int j1, int k1) {
        Chunk chunk = b(i1 >> 4, k1 >> 4);

        if (chunk != null) {
            chunk.e(i1 & 0xf, j1, k1 & 0xf);
        }
    }

    public boolean d(int i1, int j1, int k1) {
        Block block = Block.n[a(i1, j1, k1)];

        if (block == null) {
            return false;
        } else {
            return block.b();
        }
    }

    public boolean c() {
        int i1 = 1000;

        for (; y.size() > 0; ((MetadataChunkBlock) y.remove(y.size() - 1)).a(this)) {
            if (--i1 <= 0) {
                return true;
            }
        }

        return false;
    }

    public void a(EnumSkyBlock enumskyblock, int i1, int j1, int k1, int l1, int i2, int j2) {
        a(enumskyblock, i1, j1, k1, l1, i2, j2, true);
    }

    public void a(EnumSkyBlock enumskyblock, int i1, int j1, int k1, int l1, int i2, int j2, boolean flag) {
        int k2 = (l1 + i1) / 2;
        int l2 = (j2 + k1) / 2;

        if (!e(k2, 64, l2)) {
            return;
        }
        int i3 = y.size();

        if (flag) {
            int j3 = 4;

            if (j3 > i3) {
                j3 = i3;
            }
            for (int k3 = 0; k3 < j3; k3++) {
                MetadataChunkBlock metadatachunkblock = (MetadataChunkBlock) y.get(y.size() - k3 - 1);

                if (metadatachunkblock.a == enumskyblock && metadatachunkblock.a(i1, j1, k1, l1, i2, j2)) {
                    return;
                }
            }
        }
        y.add(((new MetadataChunkBlock(enumskyblock, i1, j1, k1, l1, i2, j2))));
        if (y.size() > 0x186a0) {
            for (; y.size() > 50000; c()) {
                ;
            }
        }
    }

    public void d() {
        int i1 = a(1.0F);

        if (i1 != e) {
            e = i1;
        }
    }

    public void e() {
        G.a();
        int i1 = a(1.0F);

        if (i1 != e) {
            e = i1;
            for (int j1 = 0; j1 < r.size(); j1++) {
                ((IWorldAccess) r.get(j1)).a();
            }
        }
        c++;
        if (c % (long) j == 0L) {
            a(false, ((IProgressUpdate) (null)));
        }
        a(false);
        f();
    }

    protected void f() {
        J.clear();
        for (int i1 = 0; i1 < k.size(); i1++) {
            EntityPlayer entityplayer = (EntityPlayer) k.get(i1);
            int j1 = MathHelper.b(entityplayer.l / 16D);
            int l1 = MathHelper.b(entityplayer.n / 16D);
            byte byte0 = 9;

            for (int j2 = -byte0; j2 <= byte0; j2++) {
                for (int j3 = -byte0; j3 <= byte0; j3++) {
                    J.add(((new ChunkCoordIntPair(j2 + j1, j3 + l1))));
                }
            }
        }

        if (K > 0) {
            K--;
        }
        for (Iterator iterator = J.iterator(); iterator.hasNext();) {
            ChunkCoordIntPair chunkcoordintpair = (ChunkCoordIntPair) iterator.next();
            int k1 = chunkcoordintpair.a * 16;
            int i2 = chunkcoordintpair.b * 16;
            Chunk chunk = b(chunkcoordintpair.a, chunkcoordintpair.b);

            if (K == 0) {
                f = f * 3 + g;
                int k2 = f >> 2;
                int k3 = k2 & 0xf;
                int j4 = k2 >> 8 & 0xf;
                int i5 = k2 >> 16 & 0x7f;
                int l5 = chunk.a(k3, i5, j4);

                k3 += k1;
                j4 += i2;
                if (l5 == 0 && h(k3, i5, j4) <= m.nextInt(8) && a(EnumSkyBlock.a, k3, i5, j4) <= 0) {
                    EntityPlayer entityplayer1 = a((double) k3 + 0.5D, (double) i5 + 0.5D, (double) j4 + 0.5D, 8D);

                    if (entityplayer1 != null && entityplayer1.d((double) k3 + 0.5D, (double) i5 + 0.5D, (double) j4 + 0.5D) > 4D) {
                        a((double) k3 + 0.5D, (double) i5 + 0.5D, (double) j4 + 0.5D, "ambient.cave.cave", 0.7F, 0.8F + m.nextFloat() * 0.2F);
                        K = m.nextInt(12000) + 6000;
                    }
                }
            }
            if (d && m.nextInt(4) == 0) {
                f = f * 3 + g;
                int l2 = f >> 2;
                int l3 = l2 & 0xf;
                int k4 = l2 >> 8 & 0xf;
                int j5 = d(l3 + k1, k4 + i2);

                if (j5 >= 0 && j5 < 128 && chunk.a(EnumSkyBlock.b, l3, j5, k4) < 10) {
                    int i6 = chunk.a(l3, j5 - 1, k4);

                    if (chunk.a(l3, j5, k4) == 0 && Block.aT.a(this, l3 + k1, j5, k4 + i2)) {
                        d(l3 + k1, j5, k4 + i2, Block.aT.bc);
                    }
                    if (i6 == Block.C.bc && chunk.b(l3, j5 - 1, k4) == 0) {
                        d(l3 + k1, j5 - 1, k4 + i2, Block.aU.bc);
                    }
                }
            }
            int i3 = 0;

            while (i3 < 80) {
                f = f * 3 + g;
                int i4 = f >> 2;
                int l4 = i4 & 0xf;
                int k5 = i4 >> 8 & 0xf;
                int j6 = i4 >> 16 & 0x7f;
                byte byte1 = chunk.b[l4 << 11 | k5 << 7 | j6];

                if (Block.o[byte1]) {
                    Block.n[byte1].a(this, l4 + k1, j6, k5 + i2, m);
                }
                i3++;
            }
        }
    }

    public boolean a(boolean flag) {
        int i1 = A.size();

        if (i1 != B.size()) {
            throw new IllegalStateException("TickNextTick list out of synch");
        }
        if (i1 > 1000) {
            i1 = 1000;
        }
        for (int j1 = 0; j1 < i1; j1++) {
            NextTickListEntry nextticklistentry = (NextTickListEntry) A.first();

            if (!flag && nextticklistentry.e > c) {
                break;
            }
            A.remove(((nextticklistentry)));
            B.remove(((nextticklistentry)));
            byte byte0 = 8;

            if (!a(nextticklistentry.a - byte0, nextticklistentry.b - byte0, nextticklistentry.c - byte0, nextticklistentry.a + byte0, nextticklistentry.b + byte0, nextticklistentry.c + byte0)) {
                continue;
            }
            int k1 = a(nextticklistentry.a, nextticklistentry.b, nextticklistentry.c);

            if (k1 == nextticklistentry.d && k1 > 0) {
                Block.n[k1].a(this, nextticklistentry.a, nextticklistentry.b, nextticklistentry.c, m);
            }
        }

        return A.size() != 0;
    }

    public List b(Entity entity, AxisAlignedBB axisalignedbb) {
        L.clear();
        int i1 = MathHelper.b((axisalignedbb.a - 2D) / 16D);
        int j1 = MathHelper.b((axisalignedbb.d + 2D) / 16D);
        int k1 = MathHelper.b((axisalignedbb.c - 2D) / 16D);
        int l1 = MathHelper.b((axisalignedbb.f + 2D) / 16D);

        for (int i2 = i1; i2 <= j1; i2++) {
            for (int j2 = k1; j2 <= l1; j2++) {
                if (g(i2, j2)) {
                    b(i2, j2).a(entity, axisalignedbb, L);
                }
            }
        }

        return L;
    }

    public List a(Class class1, AxisAlignedBB axisalignedbb) {
        int i1 = MathHelper.b((axisalignedbb.a - 2D) / 16D);
        int j1 = MathHelper.b((axisalignedbb.d + 2D) / 16D);
        int k1 = MathHelper.b((axisalignedbb.c - 2D) / 16D);
        int l1 = MathHelper.b((axisalignedbb.f + 2D) / 16D);
        ArrayList arraylist = new ArrayList();

        for (int i2 = i1; i2 <= j1; i2++) {
            for (int j2 = k1; j2 <= l1; j2++) {
                if (g(i2, j2)) {
                    b(i2, j2).a(class1, axisalignedbb, ((List) (arraylist)));
                }
            }
        }

        return ((List) (arraylist));
    }

    public void b(int i1, int j1, int k1, TileEntity tileentity) {
        if (e(i1, j1, k1)) {
            a(i1, k1).e();
        }
        for (int l1 = 0; l1 < r.size(); l1++) {
            ((IWorldAccess) r.get(l1)).a(i1, j1, k1, tileentity);
        }
    }

    public int a(Class class1) {
        int i1 = 0;

        for (int j1 = 0; j1 < a.size(); j1++) {
            Entity entity = (Entity) a.get(j1);

            if (class1.isAssignableFrom(((entity)).getClass())) {
                i1++;
            }
        }

        return i1;
    }

    public void a(List list) {
        a.addAll(((java.util.Collection) (list)));
        for (int i1 = 0; i1 < list.size(); i1++) {
            b((Entity) list.get(i1));
        }
    }

    public void b(List list) {
        z.addAll(((java.util.Collection) (list)));
    }

    public boolean a(int i1, int j1, int k1, int l1, boolean flag) {
        int i2 = a(j1, k1, l1);
        Block block = Block.n[i2];
        Block block1 = Block.n[i1];
        AxisAlignedBB axisalignedbb = block1.d(this, j1, k1, l1);

        if (flag) {
            axisalignedbb = null;
        }
        if (axisalignedbb != null && !a(axisalignedbb)) {
            return false;
        }
        if (block == Block.B || block == Block.C || block == Block.D || block == Block.E || block == Block.as || block == Block.aT) {
            return true;
        }
        return i1 > 0 && block == null && block1.a(this, j1, k1, l1);
    }

    public PathEntity a(Entity entity, Entity entity1, float f1) {
        int i1 = MathHelper.b(entity.l);
        int j1 = MathHelper.b(entity.m);
        int k1 = MathHelper.b(entity.n);
        int l1 = (int) (f1 + 16F);
        int i2 = i1 - l1;
        int j2 = j1 - l1;
        int k2 = k1 - l1;
        int l2 = i1 + l1;
        int i3 = j1 + l1;
        int j3 = k1 + l1;
        ChunkCache chunkcache = new ChunkCache(this, i2, j2, k2, l2, i3, j3);

        return (new Pathfinder(((IBlockAccess) (chunkcache)))).a(entity, entity1, f1);
    }

    public PathEntity a(Entity entity, int i1, int j1, int k1, float f1) {
        int l1 = MathHelper.b(entity.l);
        int i2 = MathHelper.b(entity.m);
        int j2 = MathHelper.b(entity.n);
        int k2 = (int) (f1 + 8F);
        int l2 = l1 - k2;
        int i3 = i2 - k2;
        int j3 = j2 - k2;
        int k3 = l1 + k2;
        int l3 = i2 + k2;
        int i4 = j2 + k2;
        ChunkCache chunkcache = new ChunkCache(this, l2, i3, j3, k3, l3, i4);

        return (new Pathfinder(((IBlockAccess) (chunkcache)))).a(entity, i1, j1, k1, f1);
    }

    public boolean i(int i1, int j1, int k1, int l1) {
        int i2 = a(i1, j1, k1);

        if (i2 == 0) {
            return false;
        } else {
            return Block.n[i2].d(this, i1, j1, k1, l1);
        }
    }

    public boolean m(int i1, int j1, int k1) {
        if (i(i1, j1 - 1, k1, 0)) {
            return true;
        }
        if (i(i1, j1 + 1, k1, 1)) {
            return true;
        }
        if (i(i1, j1, k1 - 1, 2)) {
            return true;
        }
        if (i(i1, j1, k1 + 1, 3)) {
            return true;
        }
        if (i(i1 - 1, j1, k1, 4)) {
            return true;
        }
        return i(i1 + 1, j1, k1, 5);
    }

    public boolean j(int i1, int j1, int k1, int l1) {
        if (d(i1, j1, k1)) {
            return m(i1, j1, k1);
        }
        int i2 = a(i1, j1, k1);

        if (i2 == 0) {
            return false;
        } else {
            return Block.n[i2].b(((IBlockAccess) (this)), i1, j1, k1, l1);
        }
    }

    public boolean n(int i1, int j1, int k1) {
        if (j(i1, j1 - 1, k1, 0)) {
            return true;
        }
        if (j(i1, j1 + 1, k1, 1)) {
            return true;
        }
        if (j(i1, j1, k1 - 1, 2)) {
            return true;
        }
        if (j(i1, j1, k1 + 1, 3)) {
            return true;
        }
        if (j(i1 - 1, j1, k1, 4)) {
            return true;
        }
        return j(i1 + 1, j1, k1, 5);
    }

    public EntityPlayer a(Entity entity, double d1) {
        return a(entity.l, entity.m, entity.n, d1);
    }

    public EntityPlayer a(double d1, double d2, double d3, double d4) {
        double d5 = -1D;
        EntityPlayer entityplayer = null;

        for (int i1 = 0; i1 < k.size(); i1++) {
            EntityPlayer entityplayer1 = (EntityPlayer) k.get(i1);
            double d6 = entityplayer1.d(d1, d2, d3);

            if ((d4 < 0.0D || d6 < d4 * d4) && (d5 == -1D || d6 < d5)) {
                d5 = d6;
                entityplayer = entityplayer1;
            }
        }

        return entityplayer;
    }

    public byte[] c(int i1, int j1, int k1, int l1, int i2, int j2) {
        byte abyte0[] = new byte[(l1 * i2 * j2 * 5) / 2];
        int k2 = i1 >> 4;
        int l2 = k1 >> 4;
        int i3 = (i1 + l1) - 1 >> 4;
        int j3 = (k1 + j2) - 1 >> 4;
        int k3 = 0;
        int l3 = j1;
        int i4 = j1 + i2;

        if (l3 < 0) {
            l3 = 0;
        }
        if (i4 > 128) {
            i4 = 128;
        }
        for (int j4 = k2; j4 <= i3; j4++) {
            int k4 = i1 - j4 * 16;
            int l4 = (i1 + l1) - j4 * 16;

            if (k4 < 0) {
                k4 = 0;
            }
            if (l4 > 16) {
                l4 = 16;
            }
            for (int i5 = l2; i5 <= j3; i5++) {
                int j5 = k1 - i5 * 16;
                int k5 = (k1 + j2) - i5 * 16;

                if (j5 < 0) {
                    j5 = 0;
                }
                if (k5 > 16) {
                    k5 = 16;
                }
                k3 = b(j4, i5).a(abyte0, k4, l3, j5, l4, i4, k5, k3);
            }
        }

        return abyte0;
    }

    public void g() {
        try {
            File file = new File(s, "session.lock");
            DataInputStream datainputstream = new DataInputStream(((java.io.InputStream) (new FileInputStream(file))));

            try {
                if (datainputstream.readLong() != F) {
                    throw new MinecraftException("The save is being accessed from another location, aborting");
                }
            } finally {
                datainputstream.close();
            }
        } catch (IOException ioexception) {
            throw new MinecraftException("Failed to check session lock, aborting");
        }
    }

    static {
        i = new float[16];
        float f1 = 0.05F;

        for (int i1 = 0; i1 <= 15; i1++) {
            float f2 = 1.0F - (float) i1 / 15F;

            i[i1] = ((1.0F - f2) / (f2 * 3F + 1.0F)) * (1.0F - f1) + f1;
        }
    }
}
