package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Packet15Place extends Packet {

    public int a;
    public int b;
    public int c;
    public int d;
    public ItemStack e;

    public Packet15Place() {}

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readInt();
        b = datainputstream.read();
        c = datainputstream.readInt();
        d = datainputstream.read();
        short word0 = datainputstream.readShort();

        if (word0 >= 0) {
            byte byte0 = datainputstream.readByte();
            short word1 = datainputstream.readShort();

            e = new ItemStack(((int) (word0)), ((int) (byte0)), ((int) (word1)));
        } else {
            e = null;
        }
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeInt(a);
        dataoutputstream.write(b);
        dataoutputstream.writeInt(c);
        dataoutputstream.write(d);
        if (e == null) {
            dataoutputstream.writeShort(-1);
        } else {
            dataoutputstream.writeShort(e.c);
            dataoutputstream.writeByte(e.a);
            dataoutputstream.writeShort(e.h());
        }
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 15;
    }
}
