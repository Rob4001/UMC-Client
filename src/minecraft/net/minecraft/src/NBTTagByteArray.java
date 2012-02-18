package net.minecraft.src;

import java.io.*;

public class NBTTagByteArray extends NBTBase
{
    public byte byteArray[];

    public NBTTagByteArray(String s)
    {
        super(s);
    }

    public NBTTagByteArray(String s, byte abyte0[])
    {
        super(s);
        byteArray = abyte0;
    }

    void write(DataOutput dataoutput)
    throws IOException
    {
        dataoutput.writeInt(byteArray.length);
        dataoutput.write(byteArray);
    }

    void load(DataInput datainput)
    throws IOException
    {
        int i = datainput.readInt();
        byteArray = new byte[i];
        datainput.readFully(byteArray);
    }

    public byte getId()
    {
        return 7;
    }

    public String toString()
    {
        return (new StringBuilder()).append("[").append(byteArray.length).append(" bytes]").toString();
    }

    public boolean equals(Object obj)
    {
        if (super.equals(obj))
        {
            NBTTagByteArray nbttagbytearray = (NBTTagByteArray)obj;
            return byteArray == null && nbttagbytearray.byteArray == null || byteArray != null && byteArray.equals(nbttagbytearray.byteArray);
        }
        else
        {
            return false;
        }
    }

    public NBTBase copy()
    {
        byte abyte0[] = new byte[byteArray.length];
        System.arraycopy(byteArray, 0, abyte0, 0, byteArray.length);
        return new NBTTagByteArray(getName(), abyte0);
    }
}
