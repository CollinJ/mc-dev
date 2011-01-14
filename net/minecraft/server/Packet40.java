package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.List;

public class Packet40 extends Packet {

    public int a;
    private List b;

    public Packet40() {}

    public Packet40(int i, DataWatcher datawatcher) {
        a = i;
        b = ((List) (datawatcher.b()));
    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readInt();
        b = DataWatcher.a(datainputstream);
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeInt(a);
        DataWatcher.a(b, dataoutputstream);
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 5;
    }
}
