package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.List;

public class Packet40 extends Packet {

    public int a;
    private List b;

    public Packet40() {}

    public Packet40(int i, gx gx1) {
        a = i;
        b = ((List) (gx1.b()));
    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readInt();
        b = gx.a(datainputstream);
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeInt(a);
        gx.a(b, dataoutputstream);
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 5;
    }
}
