package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Packet24MobSpawn extends Packet {

    public int a;
    public byte b;
    public int c;
    public int d;
    public int e;
    public byte f;
    public byte g;

    public Packet24MobSpawn() {}

    public Packet24MobSpawn(EntityLiving entityliving) {
        a = entityliving.c;
        b = (byte) EntityList.a(((Entity) (entityliving)));
        c = MathHelper.b(entityliving.l * 32D);
        d = MathHelper.b(entityliving.m * 32D);
        e = MathHelper.b(entityliving.n * 32D);
        f = (byte) (int) ((entityliving.r * 256F) / 360F);
        g = (byte) (int) ((entityliving.s * 256F) / 360F);
    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readInt();
        b = datainputstream.readByte();
        c = datainputstream.readInt();
        d = datainputstream.readInt();
        e = datainputstream.readInt();
        f = datainputstream.readByte();
        g = datainputstream.readByte();
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeInt(a);
        dataoutputstream.writeByte(((int) (b)));
        dataoutputstream.writeInt(c);
        dataoutputstream.writeInt(d);
        dataoutputstream.writeInt(e);
        dataoutputstream.writeByte(((int) (f)));
        dataoutputstream.writeByte(((int) (g)));
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 19;
    }
}
