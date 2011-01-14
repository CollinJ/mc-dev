package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Packet25 extends Packet {

    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public String f;

    public Packet25() {}

    public Packet25(EntityPainting entitypainting) {
        a = entitypainting.g;
        b = entitypainting.b;
        c = entitypainting.c;
        d = entitypainting.d;
        e = entitypainting.a;
        f = entitypainting.e.z;
    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readInt();
        f = datainputstream.readUTF();
        b = datainputstream.readInt();
        c = datainputstream.readInt();
        d = datainputstream.readInt();
        e = datainputstream.readInt();
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeInt(a);
        dataoutputstream.writeUTF(f);
        dataoutputstream.writeInt(b);
        dataoutputstream.writeInt(c);
        dataoutputstream.writeInt(d);
        dataoutputstream.writeInt(e);
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 24;
    }
}
