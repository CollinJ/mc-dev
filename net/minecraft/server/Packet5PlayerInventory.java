package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Packet5PlayerInventory extends Packet {

    public int a;
    public int b;
    public int c;
    public int d;

    public Packet5PlayerInventory() {}

    public Packet5PlayerInventory(int i, int j, ItemStack itemstack) {
        a = i;
        b = j;
        if (itemstack == null) {
            c = -1;
            d = 0;
        } else {
            c = itemstack.c;
            d = itemstack.h();
        }
    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readInt();
        b = ((int) (datainputstream.readShort()));
        c = ((int) (datainputstream.readShort()));
        d = ((int) (datainputstream.readShort()));
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeInt(a);
        dataoutputstream.writeShort(b);
        dataoutputstream.writeShort(c);
        dataoutputstream.writeShort(d);
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 8;
    }
}
