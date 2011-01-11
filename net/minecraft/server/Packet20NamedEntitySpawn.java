package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Packet20NamedEntitySpawn extends Packet {

    public int a;
    public String b;
    public int c;
    public int d;
    public int e;
    public byte f;
    public byte g;
    public int h;

    public Packet20NamedEntitySpawn() {}

    public Packet20NamedEntitySpawn(EntityPlayer entityplayer) {
        a = entityplayer.c;
        b = entityplayer.aq;
        c = MathHelper.b(entityplayer.l * 32D);
        d = MathHelper.b(entityplayer.m * 32D);
        e = MathHelper.b(entityplayer.n * 32D);
        f = (byte) (int) ((entityplayer.r * 256F) / 360F);
        g = (byte) (int) ((entityplayer.s * 256F) / 360F);
        ItemStack itemstack = entityplayer.aj.b();

        h = itemstack != null ? itemstack.c : 0;
    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readInt();
        b = datainputstream.readUTF();
        c = datainputstream.readInt();
        d = datainputstream.readInt();
        e = datainputstream.readInt();
        f = datainputstream.readByte();
        g = datainputstream.readByte();
        h = ((int) (datainputstream.readShort()));
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeInt(a);
        dataoutputstream.writeUTF(b);
        dataoutputstream.writeInt(c);
        dataoutputstream.writeInt(d);
        dataoutputstream.writeInt(e);
        dataoutputstream.writeByte(((int) (f)));
        dataoutputstream.writeByte(((int) (g)));
        dataoutputstream.writeShort(h);
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 28;
    }
}
