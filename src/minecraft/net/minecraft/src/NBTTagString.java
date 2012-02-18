package net.minecraft.src;

import java.io.*;

public class NBTTagString extends NBTBase
{
    public String data;

    public NBTTagString(String s)
    {
        super(s);
    }

    public NBTTagString(String s, String s1)
    {
        super(s);
        data = s1;
        if (s1 == null)
        {
            throw new IllegalArgumentException("Empty string not allowed");
        }
        else
        {
            return;
        }
    }

    void write(DataOutput dataoutput)
    throws IOException
    {
        dataoutput.writeUTF(data);
    }

    void load(DataInput datainput)
    throws IOException
    {
        data = datainput.readUTF();
    }

    public byte getId()
    {
        return 8;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(data).toString();
    }

    public NBTBase copy()
    {
        return new NBTTagString(getName(), data);
    }

    public boolean equals(Object obj)
    {
        if (super.equals(obj))
        {
            NBTTagString nbttagstring = (NBTTagString)obj;
            return data == null && nbttagstring.data == null || data != null && data.equals(nbttagstring.data);
        }
        else
        {
            return false;
        }
    }
}
