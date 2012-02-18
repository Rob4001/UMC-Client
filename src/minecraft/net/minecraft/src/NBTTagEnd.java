package net.minecraft.src;

import java.io.*;

public class NBTTagEnd extends NBTBase
{
    public NBTTagEnd()
    {
        super(null);
    }

    void load(DataInput datainput)
    throws IOException
    {
    }

    void write(DataOutput dataoutput)
    throws IOException
    {
    }

    public byte getId()
    {
        return 0;
    }

    public String toString()
    {
        return "END";
    }

    public NBTBase copy()
    {
        return new NBTTagEnd();
    }

    public boolean equals(Object obj)
    {
        return super.equals(obj);
    }
}
