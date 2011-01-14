package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.*;

public class DataWatcher {

    private static final HashMap a;
    private final Map b = new HashMap();
    private boolean c;

    public DataWatcher() {}

    public void a(int i, Object obj) {
        Integer integer = (Integer) a.get(((obj.getClass())));

        if (integer == null) {
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown data type: ").append(((obj.getClass()))).toString());
        }
        if (i > 31) {
            throw new IllegalArgumentException((new StringBuilder()).append("Data value id is too big with ").append(i).append("! (Max is ").append(31).append(")").toString());
        }
        if (b.containsKey(((Integer.valueOf(i))))) {
            throw new IllegalArgumentException((new StringBuilder()).append("Duplicate id value for ").append(i).append("!").toString());
        } else {
            WatchableObject watchableobject = new WatchableObject(integer.intValue(), i, obj);

            b.put(((Integer.valueOf(i))), ((watchableobject)));
            return;
        }
    }

    public byte a(int i) {
        return ((Byte) ((WatchableObject) b.get(((Integer.valueOf(i))))).b()).byteValue();
    }

    public void b(int i, Object obj) {
        WatchableObject watchableobject = (WatchableObject) b.get(((Integer.valueOf(i))));

        if (!obj.equals(watchableobject.b())) {
            watchableobject.a(obj);
            watchableobject.a(true);
            c = true;
        }
    }

    public boolean a() {
        return c;
    }

    public static void a(List list, DataOutputStream dataoutputstream) {
        if (list != null) {
            WatchableObject watchableobject;

            for (Iterator iterator = list.iterator(); iterator.hasNext(); a(dataoutputstream, watchableobject)) {
                watchableobject = (WatchableObject) iterator.next();
            }
        }
        dataoutputstream.writeByte(127);
    }

    public ArrayList b() {
        ArrayList arraylist = null;

        if (c) {
            Iterator iterator = b.values().iterator();

            do {
                if (!iterator.hasNext()) {
                    break;
                }
                WatchableObject watchableobject = (WatchableObject) iterator.next();

                if (watchableobject.d()) {
                    watchableobject.a(false);
                    if (arraylist == null) {
                        arraylist = new ArrayList();
                    }
                    arraylist.add(((watchableobject)));
                }
            } while (true);
        }
        c = false;
        return arraylist;
    }

    public void a(DataOutputStream dataoutputstream) {
        WatchableObject watchableobject;

        for (Iterator iterator = b.values().iterator(); iterator.hasNext(); a(dataoutputstream, watchableobject)) {
            watchableobject = (WatchableObject) iterator.next();
        }

        dataoutputstream.writeByte(127);
    }

    private static void a(DataOutputStream dataoutputstream, WatchableObject watchableobject) {
        int i = (watchableobject.c() << 5 | watchableobject.a() & 0x1f) & 0xff;

        dataoutputstream.writeByte(i);
        switch (watchableobject.c()) {
        case 0: // '\0'
            dataoutputstream.writeByte(((int) (((Byte) watchableobject.b()).byteValue())));
            break;

        case 1: // '\001'
            dataoutputstream.writeShort(((int) (((Short) watchableobject.b()).shortValue())));
            break;

        case 2: // '\002'
            dataoutputstream.writeInt(((Integer) watchableobject.b()).intValue());
            break;

        case 3: // '\003'
            dataoutputstream.writeFloat(((Float) watchableobject.b()).floatValue());
            break;

        case 4: // '\004'
            dataoutputstream.writeUTF((String) watchableobject.b());
            break;

        case 5: // '\005'
            ItemStack itemstack = (ItemStack) watchableobject.b();

            dataoutputstream.writeShort(itemstack.a().ba);
            dataoutputstream.writeByte(itemstack.a);
            dataoutputstream.writeShort(itemstack.h());
            break;
        }
    }

    public static List a(DataInputStream datainputstream) {
        ArrayList arraylist = null;

        for (byte byte0 = datainputstream.readByte(); byte0 != 127; byte0 = datainputstream.readByte()) {
            if (arraylist == null) {
                arraylist = new ArrayList();
            }
            int i = (byte0 & 0xe0) >> 5;
            int j = byte0 & 0x1f;
            WatchableObject watchableobject = null;

            switch (i) {
            case 0: // '\0'
                watchableobject = new WatchableObject(i, j, ((Byte.valueOf(datainputstream.readByte()))));
                break;

            case 1: // '\001'
                watchableobject = new WatchableObject(i, j, ((Short.valueOf(datainputstream.readShort()))));
                break;

            case 2: // '\002'
                watchableobject = new WatchableObject(i, j, ((Integer.valueOf(datainputstream.readInt()))));
                break;

            case 3: // '\003'
                watchableobject = new WatchableObject(i, j, ((Float.valueOf(datainputstream.readFloat()))));
                break;

            case 4: // '\004'
                watchableobject = new WatchableObject(i, j, ((datainputstream.readUTF())));
                break;

            case 5: // '\005'
                short word0 = datainputstream.readShort();
                byte byte1 = datainputstream.readByte();
                short word1 = datainputstream.readShort();

                watchableobject = new WatchableObject(i, j, ((new ItemStack(((int) (word0)), ((int) (byte1)), ((int) (word1))))));
                break;
            }
            arraylist.add(((watchableobject)));
        }

        return ((List) (arraylist));
    }

    static Class _mthclass$(String s) {
        try {
            return Class.forName(s);
        } catch (ClassNotFoundException classnotfoundexception) {
            throw new NoClassDefFoundError(classnotfoundexception.getMessage());
        }
    }

    static {
        a = new HashMap();
        a.put(((((java.lang.Byte.class)))), ((Integer.valueOf(0))));
        a.put(((((java.lang.Short.class)))), ((Integer.valueOf(1))));
        a.put(((((java.lang.Integer.class)))), ((Integer.valueOf(2))));
        a.put(((((java.lang.Float.class)))), ((Integer.valueOf(3))));
        a.put(((((java.lang.String.class)))), ((Integer.valueOf(4))));
        a.put(((((net.minecraft.server.ItemStack.class)))), ((Integer.valueOf(5))));
    }
}
