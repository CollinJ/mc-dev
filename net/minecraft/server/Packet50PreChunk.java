package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Packet50PreChunk extends Packet {

    public int a;
    public int b;
    public boolean c;

    public Packet50PreChunk() {
        l = false;
    }

    public Packet50PreChunk(int i, int j, boolean flag) {
        l = false;
        a = i;
        b = j;
        c = flag;
    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readInt();
        b = datainputstream.readInt();
        c = datainputstream.read() != 0;
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeInt(a);
        dataoutputstream.writeInt(b);
        dataoutputstream.write(c ? 1 : 0);
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 9;
    }
}
