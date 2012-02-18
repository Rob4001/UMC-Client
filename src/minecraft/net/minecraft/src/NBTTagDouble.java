package net.minecraft.src;

import java.io.*;

public class NBTTagDouble extends NBTBase
{
    public double doubleValue;

    public NBTTagDouble(String s)
    {
        super(s);
    }

    public NBTTagDouble(String s, double d)
    {
        super(s);
        doubleValue = d;
    }

    void write(DataOutput dataoutput)
    throws IOException
    {
        dataoutput.writeDouble(doubleValue);
    }

    void load(DataInput datainput)
    throws IOException
    {
        doubleValue = datainput.readDouble();
    }

    public byte getId()
    {
        return 6;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(doubleValue).toString();
    }

    public NBTBase copy()
    {
        return new NBTTagDouble(getName(), doubleValue);
    }

    public boolean equals(Object obj)
    {
        if (super.equals(obj))
        {
            NBTTagDouble nbttagdouble = (NBTTagDouble)obj;
            return doubleValue == nbttagdouble.doubleValue;
        }
        else
        {
            return false;
        }
    }
}
