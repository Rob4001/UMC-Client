package net.minecraft.src;

import java.io.*;

public class NBTTagInt extends NBTBase
{
    public int data;

    public NBTTagInt(String s)
    {
        super(s);
    }

    public NBTTagInt(String s, int i)
    {
        super(s);
        data = i;
    }

    void write(DataOutput dataoutput)
    throws IOException
    {
        dataoutput.writeInt(data);
    }

    void load(DataInput datainput)
    throws IOException
    {
        data = datainput.readInt();
    }

    public byte getId()
    {
        return 3;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(data).toString();
    }

    public NBTBase copy()
    {
        return new NBTTagInt(getName(), data);
    }

    public boolean equals(Object obj)
    {
        if (super.equals(obj))
        {
            NBTTagInt nbttagint = (NBTTagInt)obj;
            return data == nbttagint.data;
        }
        else
        {
            return false;
        }
    }
}
