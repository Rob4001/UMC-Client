package net.minecraft.src;

import java.io.*;

public class NBTTagByte extends NBTBase
{
    public byte data;

    public NBTTagByte(String s)
    {
        super(s);
    }

    public NBTTagByte(String s, byte byte0)
    {
        super(s);
        data = byte0;
    }

    void write(DataOutput dataoutput)
    throws IOException
    {
        dataoutput.writeByte(data);
    }

    void load(DataInput datainput)
    throws IOException
    {
        data = datainput.readByte();
    }

    public byte getId()
    {
        return 1;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(data).toString();
    }

    public boolean equals(Object obj)
    {
        if (super.equals(obj))
        {
            NBTTagByte nbttagbyte = (NBTTagByte)obj;
            return data == nbttagbyte.data;
        }
        else
        {
            return false;
        }
    }

    public NBTBase copy()
    {
        return new NBTTagByte(getName(), data);
    }
}
