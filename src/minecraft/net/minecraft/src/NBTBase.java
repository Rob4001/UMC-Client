package net.minecraft.src;

import java.io.*;

public abstract class NBTBase
{
    private String name;

    abstract void write(DataOutput dataoutput)
    throws IOException;

    abstract void load(DataInput datainput)
    throws IOException;

    public abstract byte getId();

    protected NBTBase(String s)
    {
        if (s == null)
        {
            name = "";
        }
        else
        {
            name = s;
        }
    }

    public boolean equals(Object obj)
    {
        if (obj == null || !(obj instanceof NBTBase))
        {
            return false;
        }
        NBTBase nbtbase = (NBTBase)obj;
        if (getId() != nbtbase.getId())
        {
            return false;
        }
        if (name == null && nbtbase.name != null || name != null && nbtbase.name == null)
        {
            return false;
        }
        return name == null || name.equals(nbtbase.name);
    }

    public NBTBase setName(String s)
    {
        if (s == null)
        {
            name = "";
        }
        else
        {
            name = s;
        }
        return this;
    }

    public String getName()
    {
        if (name == null)
        {
            return "";
        }
        else
        {
            return name;
        }
    }

    public static NBTBase readNamedTag(DataInput datainput)
    throws IOException
    {
        byte byte0 = datainput.readByte();
        if (byte0 == 0)
        {
            return new NBTTagEnd();
        }
        else
        {
            String s = datainput.readUTF();
            NBTBase nbtbase = newTag(byte0, s);
            nbtbase.load(datainput);
            return nbtbase;
        }
    }

    public static void writeNamedTag(NBTBase nbtbase, DataOutput dataoutput)
    throws IOException
    {
        dataoutput.writeByte(nbtbase.getId());
        if (nbtbase.getId() == 0)
        {
            return;
        }
        else
        {
            dataoutput.writeUTF(nbtbase.getName());
            nbtbase.write(dataoutput);
            return;
        }
    }

    public static NBTBase newTag(byte byte0, String s)
    {
        switch (byte0)
        {
            case 0:
                return new NBTTagEnd();

            case 1:
                return new NBTTagByte(s);

            case 2:
                return new NBTTagShort(s);

            case 3:
                return new NBTTagInt(s);

            case 4:
                return new NBTTagLong(s);

            case 5:
                return new NBTTagFloat(s);

            case 6:
                return new NBTTagDouble(s);

            case 7:
                return new NBTTagByteArray(s);

            case 8:
                return new NBTTagString(s);

            case 9:
                return new NBTTagList(s);

            case 10:
                return new NBTTagCompound(s);
        }
        return null;
    }

    public static String getTagName(byte byte0)
    {
        switch (byte0)
        {
            case 0:
                return "TAG_End";

            case 1:
                return "TAG_Byte";

            case 2:
                return "TAG_Short";

            case 3:
                return "TAG_Int";

            case 4:
                return "TAG_Long";

            case 5:
                return "TAG_Float";

            case 6:
                return "TAG_Double";

            case 7:
                return "TAG_Byte_Array";

            case 8:
                return "TAG_String";

            case 9:
                return "TAG_List";

            case 10:
                return "TAG_Compound";
        }
        return "UNKNOWN";
    }

    public abstract NBTBase copy();
}
