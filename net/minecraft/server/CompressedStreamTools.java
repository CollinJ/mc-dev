package net.minecraft.server;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class CompressedStreamTools {

    public CompressedStreamTools() {}

    public static NBTTagCompound a(InputStream inputstream) {
        DataInputStream datainputstream = new DataInputStream(((InputStream) (new GZIPInputStream(inputstream))));

        try {
            NBTTagCompound nbttagcompound = a(((DataInput) (datainputstream)));

            return nbttagcompound;
        } finally {
            datainputstream.close();
        }
    }

    public static void a(NBTTagCompound nbttagcompound, OutputStream outputstream) {
        DataOutputStream dataoutputstream = new DataOutputStream(((OutputStream) (new GZIPOutputStream(outputstream))));

        try {
            a(nbttagcompound, ((DataOutput) (dataoutputstream)));
        } finally {
            dataoutputstream.close();
        }
    }

    public static NBTTagCompound a(DataInput datainput) {
        NBTBase nbtbase = NBTBase.b(datainput);

        if (nbtbase instanceof NBTTagCompound) {
            return (NBTTagCompound) nbtbase;
        } else {
            throw new IOException("Root tag must be a named compound tag");
        }
    }

    public static void a(NBTTagCompound nbttagcompound, DataOutput dataoutput) {
        NBTBase.a(((NBTBase) (nbttagcompound)), dataoutput);
    }
}
