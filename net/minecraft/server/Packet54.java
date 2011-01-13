package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Packet54 extends Packet {

    public int a;
    public int b;
    public int c;
    public int d;
    public int e;

    public Packet54() {}

    public Packet54(int i, int j, int k, int l, int i1) {
        a = i;
        b = j;
        c = k;
        d = l;
        e = i1;
    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readInt();
        b = ((int) (datainputstream.readShort()));
        c = datainputstream.readInt();
        d = datainputstream.read();
        e = datainputstream.read();
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeInt(a);
        dataoutputstream.writeShort(b);
        dataoutputstream.writeInt(c);
        dataoutputstream.write(d);
        dataoutputstream.write(e);
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 12;
    }
}
