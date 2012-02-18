package net.minecraft.src;

import java.io.*;

public class NBTTagLong extends NBTBase
{
    public long data;

    public NBTTagLong(String s)
    {
        super(s);
    }

    public NBTTagLong(String s, long l)
    {
        super(s);
        data = l;
    }

    void write(DataOutput dataoutput)
    throws IOException
    {
        dataoutput.writeLong(data);
    }

    void load(DataInput datainput)
    throws IOException
    {
        data = datainput.readLong();
    }

    public byte getId()
    {
        return 4;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(data).toString();
    }

    public NBTBase copy()
    {
        return new NBTTagLong(getName(), data);
    }

    public boolean equals(Object obj)
    {
        if (super.equals(obj))
        {
            NBTTagLong nbttaglong = (NBTTagLong)obj;
            return data == nbttaglong.data;
        }
        else
        {
            return false;
        }
    }
}
