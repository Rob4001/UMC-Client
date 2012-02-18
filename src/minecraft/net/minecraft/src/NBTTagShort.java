package net.minecraft.src;

import java.io.*;

public class NBTTagShort extends NBTBase
{
    public short data;

    public NBTTagShort(String s)
    {
        super(s);
    }

    public NBTTagShort(String s, short word0)
    {
        super(s);
        data = word0;
    }

    void write(DataOutput dataoutput)
    throws IOException
    {
        dataoutput.writeShort(data);
    }

    void load(DataInput datainput)
    throws IOException
    {
        data = datainput.readShort();
    }

    public byte getId()
    {
        return 2;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(data).toString();
    }

    public NBTBase copy()
    {
        return new NBTTagShort(getName(), data);
    }

    public boolean equals(Object obj)
    {
        if (super.equals(obj))
        {
            NBTTagShort nbttagshort = (NBTTagShort)obj;
            return data == nbttagshort.data;
        }
        else
        {
            return false;
        }
    }
}
