package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Packet31RelEntityMove extends Packet30Entity {

    public Packet31RelEntityMove() {}

    public Packet31RelEntityMove(int i, byte byte0, byte byte1, byte byte2) {
        super(i);
        b = byte0;
        c = byte1;
        d = byte2;
    }

    public void a(DataInputStream datainputstream) {
        super.a(datainputstream);
        b = datainputstream.readByte();
        c = datainputstream.readByte();
        d = datainputstream.readByte();
    }

    public void a(DataOutputStream dataoutputstream) {
        super.a(dataoutputstream);
        dataoutputstream.writeByte(((int) (b)));
        dataoutputstream.writeByte(((int) (c)));
        dataoutputstream.writeByte(((int) (d)));
    }

    public int a() {
        return 7;
    }
}
