package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Packet19 extends Packet {

    public int a;
    public int b;

    public Packet19() {}

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readInt();
        b = ((int) (datainputstream.readByte()));
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeInt(a);
        dataoutputstream.writeByte(b);
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 5;
    }
}
