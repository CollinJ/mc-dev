package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Packet21PickupSpawn extends Packet {

    public int a;
    public int b;
    public int c;
    public int d;
    public byte e;
    public byte f;
    public byte g;
    public int h;
    public int i;

    public Packet21PickupSpawn() {}

    public Packet21PickupSpawn(EntityItem entityitem) {
        a = entityitem.c;
        h = entityitem.a.c;
        i = entityitem.a.a;
        b = MathHelper.b(entityitem.l * 32D);
        c = MathHelper.b(entityitem.m * 32D);
        d = MathHelper.b(entityitem.n * 32D);
        e = (byte) (int) (entityitem.o * 128D);
        f = (byte) (int) (entityitem.p * 128D);
        g = (byte) (int) (entityitem.q * 128D);
    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readInt();
        h = ((int) (datainputstream.readShort()));
        i = ((int) (datainputstream.readByte()));
        b = datainputstream.readInt();
        c = datainputstream.readInt();
        d = datainputstream.readInt();
        e = datainputstream.readByte();
        f = datainputstream.readByte();
        g = datainputstream.readByte();
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeInt(a);
        dataoutputstream.writeShort(h);
        dataoutputstream.writeByte(i);
        dataoutputstream.writeInt(b);
        dataoutputstream.writeInt(c);
        dataoutputstream.writeInt(d);
        dataoutputstream.writeByte(((int) (e)));
        dataoutputstream.writeByte(((int) (f)));
        dataoutputstream.writeByte(((int) (g)));
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 22;
    }
}
