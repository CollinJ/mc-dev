package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Packet103 extends Packet {

    public int a;
    public int b;
    public ItemStack c;

    public Packet103() {}

    public Packet103(int i, int j, ItemStack itemstack) {
        a = i;
        b = j;
        c = itemstack != null ? itemstack.j() : itemstack;
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public void a(DataInputStream datainputstream) {
        a = ((int) (datainputstream.readByte()));
        b = ((int) (datainputstream.readShort()));
        short word0 = datainputstream.readShort();

        if (word0 >= 0) {
            byte byte0 = datainputstream.readByte();
            short word1 = datainputstream.readShort();

            c = new ItemStack(((int) (word0)), ((int) (byte0)), ((int) (word1)));
        } else {
            c = null;
        }
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeByte(a);
        dataoutputstream.writeShort(b);
        if (c == null) {
            dataoutputstream.writeShort(-1);
        } else {
            dataoutputstream.writeShort(c.c);
            dataoutputstream.writeByte(c.a);
            dataoutputstream.writeShort(c.h());
        }
    }

    public int a() {
        return 8;
    }
}
