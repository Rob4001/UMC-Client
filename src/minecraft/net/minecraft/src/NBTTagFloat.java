package net.minecraft.src;

import java.io.*;

public class NBTTagFloat extends NBTBase
{
    public float data;

    public NBTTagFloat(String s)
    {
        super(s);
    }

    public NBTTagFloat(String s, float f)
    {
        super(s);
        data = f;
    }

    void write(DataOutput dataoutput)
    throws IOException
    {
        dataoutput.writeFloat(data);
    }

    void load(DataInput datainput)
    throws IOException
    {
        data = datainput.readFloat();
    }

    public byte getId()
    {
        return 5;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(data).toString();
    }

    public NBTBase copy()
    {
        return new NBTTagFloat(getName(), data);
    }

    public boolean equals(Object obj)
    {
        if (super.equals(obj))
        {
            NBTTagFloat nbttagfloat = (NBTTagFloat)obj;
            return data == nbttagfloat.data;
        }
        else
        {
            return false;
        }
    }
}
