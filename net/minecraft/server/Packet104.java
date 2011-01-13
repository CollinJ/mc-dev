package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.List;

public class Packet104 extends Packet {

    public int a;
    public ItemStack b[];

    public Packet104() {}

    public Packet104(int i, List list) {
        a = i;
        b = new ItemStack[list.size()];
        for (int j = 0; j < b.length; j++) {
            ItemStack itemstack = (ItemStack) list.get(j);

            b[j] = itemstack != null ? itemstack.j() : null;
        }
    }

    public void a(DataInputStream datainputstream) {
        a = ((int) (datainputstream.readByte()));
        short word0 = datainputstream.readShort();

        b = new ItemStack[word0];
        for (int i = 0; i < word0; i++) {
            short word1 = datainputstream.readShort();

            if (word1 >= 0) {
                byte byte0 = datainputstream.readByte();
                short word2 = datainputstream.readShort();

                b[i] = new ItemStack(((int) (word1)), ((int) (byte0)), ((int) (word2)));
            }
        }
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeByte(a);
        dataoutputstream.writeShort(b.length);
        for (int i = 0; i < b.length; i++) {
            if (b[i] == null) {
                dataoutputstream.writeShort(-1);
            } else {
                dataoutputstream.writeShort(((int) ((short) b[i].c)));
                dataoutputstream.writeByte(((int) ((byte) b[i].a)));
                dataoutputstream.writeShort(((int) ((short) b[i].h())));
            }
        }
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 3 + b.length * 5;
    }
}
