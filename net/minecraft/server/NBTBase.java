package net.minecraft.server;

import java.io.DataInput;
import java.io.DataOutput;

public abstract class NBTBase {

    private String a;

    public NBTBase() {
        a = null;
    }

    abstract void a(DataOutput dataoutput);

    abstract void a(DataInput datainput);

    public abstract byte a();

    public String c() {
        if (a == null) {
            return "";
        } else {
            return a;
        }
    }

    public NBTBase m(String s) {
        a = s;
        return this;
    }

    public static NBTBase b(DataInput datainput) {
        byte byte0 = datainput.readByte();

        if (byte0 == 0) {
            return ((NBTBase) (new NBTTagEnd()));
        } else {
            NBTBase nbtbase = a(byte0);

            nbtbase.a = datainput.readUTF();
            nbtbase.a(datainput);
            return nbtbase;
        }
    }

    public static void a(NBTBase nbtbase, DataOutput dataoutput) {
        dataoutput.writeByte(((int) (nbtbase.a())));
        if (nbtbase.a() == 0) {
            return;
        } else {
            dataoutput.writeUTF(nbtbase.c());
            nbtbase.a(dataoutput);
            return;
        }
    }

    public static NBTBase a(byte byte0) {
        switch (byte0) {
        case 0: // '\0'
            return ((NBTBase) (new NBTTagEnd()));

        case 1: // '\001'
            return ((NBTBase) (new NBTTagByte()));

        case 2: // '\002'
            return ((NBTBase) (new NBTTagShort()));

        case 3: // '\003'
            return ((NBTBase) (new NBTTagInt()));

        case 4: // '\004'
            return ((NBTBase) (new NBTTagLong()));

        case 5: // '\005'
            return ((NBTBase) (new NBTTagFloat()));

        case 6: // '\006'
            return ((NBTBase) (new NBTTagDouble()));

        case 7: // '\007'
            return ((NBTBase) (new NBTTagByteArray()));

        case 8: // '\b'
            return ((NBTBase) (new NBTTagString()));

        case 9: // '\t'
            return ((NBTBase) (new NBTTagList()));

        case 10: // '\n'
            return ((NBTBase) (new NBTTagCompound()));
        }
        return null;
    }

    public static String b(byte byte0) {
        switch (byte0) {
        case 0: // '\0'
            return "TAG_End";

        case 1: // '\001'
            return "TAG_Byte";

        case 2: // '\002'
            return "TAG_Short";

        case 3: // '\003'
            return "TAG_Int";

        case 4: // '\004'
            return "TAG_Long";

        case 5: // '\005'
            return "TAG_Float";

        case 6: // '\006'
            return "TAG_Double";

        case 7: // '\007'
            return "TAG_Byte_Array";

        case 8: // '\b'
            return "TAG_String";

        case 9: // '\t'
            return "TAG_List";

        case 10: // '\n'
            return "TAG_Compound";
        }
        return "UNKNOWN";
    }
}
