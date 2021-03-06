package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.List;

public class Packet24MobSpawn extends Packet {

    public int a;
    public byte b;
    public int c;
    public int d;
    public int e;
    public byte f;
    public byte g;
    private DataWatcher h;
    private List i;

    public Packet24MobSpawn() {}

    public Packet24MobSpawn(EntityLiving entityliving) {
        a = entityliving.g;
        b = (byte) EntityList.a(((Entity) (entityliving)));
        c = MathHelper.b(entityliving.p * 32D);
        d = MathHelper.b(entityliving.q * 32D);
        e = MathHelper.b(entityliving.r * 32D);
        f = (byte) (int) ((entityliving.v * 256F) / 360F);
        g = (byte) (int) ((entityliving.w * 256F) / 360F);
        h = entityliving.p();
    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readInt();
        b = datainputstream.readByte();
        c = datainputstream.readInt();
        d = datainputstream.readInt();
        e = datainputstream.readInt();
        f = datainputstream.readByte();
        g = datainputstream.readByte();
        i = DataWatcher.a(datainputstream);
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeInt(a);
        dataoutputstream.writeByte(((int) (b)));
        dataoutputstream.writeInt(c);
        dataoutputstream.writeInt(d);
        dataoutputstream.writeInt(e);
        dataoutputstream.writeByte(((int) (f)));
        dataoutputstream.writeByte(((int) (g)));
        h.a(dataoutputstream);
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 20;
    }
}
