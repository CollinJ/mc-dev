package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Packet28 extends Packet {

    public int a;
    public int b;
    public int c;
    public int d;

    public Packet28() {}

    public Packet28(Entity entity) {
        this(entity.g, entity.s, entity.t, entity.u);
    }

    public Packet28(int i, double d1, double d2, double d3) {
        a = i;
        double d4 = 3.8999999999999999D;

        if (d1 < -d4) {
            d1 = -d4;
        }
        if (d2 < -d4) {
            d2 = -d4;
        }
        if (d3 < -d4) {
            d3 = -d4;
        }
        if (d1 > d4) {
            d1 = d4;
        }
        if (d2 > d4) {
            d2 = d4;
        }
        if (d3 > d4) {
            d3 = d4;
        }
        b = (int) (d1 * 8000D);
        c = (int) (d2 * 8000D);
        d = (int) (d3 * 8000D);
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
        return 10;
    }
}
