package net.minecraft.server;

import java.io.IOException;

public class ChunkProviderLoadOrGenerate implements IChunkProvider {

    private Chunk c;
    private IChunkProvider d;
    private IChunkLoader e;
    private Chunk f[];
    private World g;
    int a;
    int b;
    private Chunk h;
    private int i;
    private int j;

    public ChunkProviderLoadOrGenerate(World world, IChunkLoader ichunkloader, IChunkProvider ichunkprovider) {
        f = new Chunk[1024];
        a = 0xc4653601;
        b = 0xc4653601;
        c = ((Chunk) (new lz(world, new byte[32768], 0, 0)));
        g = world;
        e = ichunkloader;
        d = ichunkprovider;
    }

    public boolean c(int k, int l) {
        byte byte0 = 15;

        return k >= i - byte0 && l >= j - byte0 && k <= i + byte0 && l <= j + byte0;
    }

    public boolean a(int k, int l) {
        if (!c(k, l)) {
            return false;
        }
        if (k == a && l == b && h != null) {
            return true;
        } else {
            int i1 = k & 0x1f;
            int j1 = l & 0x1f;
            int k1 = i1 + j1 * 32;

            return f[k1] != null && (f[k1] == c || f[k1].a(k, l));
        }
    }

    public Chunk b(int k, int l) {
        if (k == a && l == b && h != null) {
            return h;
        }
        if (!g.x && !c(k, l)) {
            return c;
        }
        int i1 = k & 0x1f;
        int j1 = l & 0x1f;
        int k1 = i1 + j1 * 32;

        if (!a(k, l)) {
            if (f[k1] != null) {
                f[k1].e();
                b(f[k1]);
                a(f[k1]);
            }
            Chunk chunk = d(k, l);

            if (chunk == null) {
                if (d == null) {
                    chunk = c;
                } else {
                    chunk = d.b(k, l);
                }
            }
            f[k1] = chunk;
            chunk.c();
            if (f[k1] != null) {
                f[k1].d();
            }
            if (!f[k1].n && a(k + 1, l + 1) && a(k, l + 1) && a(k + 1, l)) {
                a(((IChunkProvider) (this)), k, l);
            }
            if (a(k - 1, l) && !b(k - 1, l).n && a(k - 1, l + 1) && a(k, l + 1) && a(k - 1, l)) {
                a(((IChunkProvider) (this)), k - 1, l);
            }
            if (a(k, l - 1) && !b(k, l - 1).n && a(k + 1, l - 1) && a(k, l - 1) && a(k + 1, l)) {
                a(((IChunkProvider) (this)), k, l - 1);
            }
            if (a(k - 1, l - 1) && !b(k - 1, l - 1).n && a(k - 1, l - 1) && a(k, l - 1) && a(k - 1, l)) {
                a(((IChunkProvider) (this)), k - 1, l - 1);
            }
        }
        a = k;
        b = l;
        h = f[k1];
        return f[k1];
    }

    private Chunk d(int k, int l) {
        if (e == null) {
            return c;
        }
        try {
            Chunk chunk = e.a(g, k, l);

            if (chunk != null) {
                chunk.r = g.e;
            }
            return chunk;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return c;
    }

    private void a(Chunk chunk) {
        if (e == null) {
            return;
        }
        try {
            e.b(g, chunk);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void b(Chunk chunk) {
        if (e == null) {
            return;
        }
        try {
            chunk.r = g.e;
            e.a(g, chunk);
        } catch (IOException ioexception) {
            ioexception.printStackTrace();
        }
    }

    public void a(IChunkProvider ichunkprovider, int k, int l) {
        Chunk chunk = b(k, l);

        if (!chunk.n) {
            chunk.n = true;
            if (d != null) {
                d.a(ichunkprovider, k, l);
                chunk.f();
            }
        }
    }

    public boolean a(boolean flag, IProgressUpdate iprogressupdate) {
        int k = 0;
        int l = 0;

        if (iprogressupdate != null) {
            for (int i1 = 0; i1 < f.length; i1++) {
                if (f[i1] != null && f[i1].a(flag)) {
                    l++;
                }
            }
        }
        int j1 = 0;

        for (int k1 = 0; k1 < f.length; k1++) {
            if (f[k1] == null) {
                continue;
            }
            if (flag && !f[k1].p) {
                a(f[k1]);
            }
            if (!f[k1].a(flag)) {
                continue;
            }
            b(f[k1]);
            f[k1].o = false;
            if (++k == 2 && !flag) {
                return false;
            }
            if (iprogressupdate != null && ++j1 % 10 == 0) {
                iprogressupdate.a((j1 * 100) / l);
            }
        }

        if (flag) {
            if (e == null) {
                return true;
            }
            e.b();
        }
        return true;
    }

    public boolean a() {
        if (e != null) {
            e.a();
        }
        return d.a();
    }

    public boolean b() {
        return true;
    }
}
