package net.minecraft.src;

import java.io.*;
import java.util.*;

public class NBTTagCompound extends NBTBase
{
    private Map tagMap;

    public NBTTagCompound()
    {
        super("");
        tagMap = new HashMap();
    }

    public NBTTagCompound(String s)
    {
        super(s);
        tagMap = new HashMap();
    }

    void write(DataOutput dataoutput)
    throws IOException
    {
        NBTBase nbtbase;
        for (Iterator iterator = tagMap.values().iterator(); iterator.hasNext(); NBTBase.writeNamedTag(nbtbase, dataoutput))
        {
            nbtbase = (NBTBase)iterator.next();
        }

        dataoutput.writeByte(0);
    }

    void load(DataInput datainput)
    throws IOException
    {
        tagMap.clear();
        NBTBase nbtbase;
        for (; (nbtbase = NBTBase.readNamedTag(datainput)).getId() != 0; tagMap.put(nbtbase.getName(), nbtbase)) { }
    }

    public Collection getTags()
    {
        return tagMap.values();
    }

    public byte getId()
    {
        return 10;
    }

    public void setTag(String s, NBTBase nbtbase)
    {
        tagMap.put(s, nbtbase.setName(s));
    }

    public void setByte(String s, byte byte0)
    {
        tagMap.put(s, new NBTTagByte(s, byte0));
    }

    public void setShort(String s, short word0)
    {
        tagMap.put(s, new NBTTagShort(s, word0));
    }

    public void setInteger(String s, int i)
    {
        tagMap.put(s, new NBTTagInt(s, i));
    }

    public void setLong(String s, long l)
    {
        tagMap.put(s, new NBTTagLong(s, l));
    }

    public void setFloat(String s, float f)
    {
        tagMap.put(s, new NBTTagFloat(s, f));
    }

    public void setDouble(String s, double d)
    {
        tagMap.put(s, new NBTTagDouble(s, d));
    }

    public void setString(String s, String s1)
    {
        tagMap.put(s, new NBTTagString(s, s1));
    }

    public void setByteArray(String s, byte abyte0[])
    {
        tagMap.put(s, new NBTTagByteArray(s, abyte0));
    }

    public void setCompoundTag(String s, NBTTagCompound nbttagcompound)
    {
        tagMap.put(s, nbttagcompound.setName(s));
    }

    public void setBoolean(String s, boolean flag)
    {
        setByte(s, ((byte)(flag ? 1 : 0)));
    }

    public NBTBase getTag(String s)
    {
        return (NBTBase)tagMap.get(s);
    }

    public boolean hasKey(String s)
    {
        return tagMap.containsKey(s);
    }

    public byte getByte(String s)
    {
        if (!tagMap.containsKey(s))
        {
            return 0;
        }
        else
        {
            return ((NBTTagByte)tagMap.get(s)).data;
        }
    }

    public short getShort(String s)
    {
        if (!tagMap.containsKey(s))
        {
            return 0;
        }
        else
        {
            return ((NBTTagShort)tagMap.get(s)).data;
        }
    }

    public int getInteger(String s)
    {
        if (!tagMap.containsKey(s))
        {
            return 0;
        }
        else
        {
            return ((NBTTagInt)tagMap.get(s)).data;
        }
    }

    public long getLong(String s)
    {
        if (!tagMap.containsKey(s))
        {
            return 0L;
        }
        else
        {
            return ((NBTTagLong)tagMap.get(s)).data;
        }
    }

    public float getFloat(String s)
    {
        if (!tagMap.containsKey(s))
        {
            return 0.0F;
        }
        else
        {
            return ((NBTTagFloat)tagMap.get(s)).data;
        }
    }

    public double getDouble(String s)
    {
        if (!tagMap.containsKey(s))
        {
            return 0.0D;
        }
        else
        {
            return ((NBTTagDouble)tagMap.get(s)).doubleValue;
        }
    }

    public String getString(String s)
    {
        if (!tagMap.containsKey(s))
        {
            return "";
        }
        else
        {
            return ((NBTTagString)tagMap.get(s)).data;
        }
    }

    public byte[] getByteArray(String s)
    {
        if (!tagMap.containsKey(s))
        {
            return new byte[0];
        }
        else
        {
            return ((NBTTagByteArray)tagMap.get(s)).byteArray;
        }
    }

    public NBTTagCompound getCompoundTag(String s)
    {
        if (!tagMap.containsKey(s))
        {
            return new NBTTagCompound(s);
        }
        else
        {
            return (NBTTagCompound)tagMap.get(s);
        }
    }

    public NBTTagList getTagList(String s)
    {
        if (!tagMap.containsKey(s))
        {
            return new NBTTagList(s);
        }
        else
        {
            return (NBTTagList)tagMap.get(s);
        }
    }

    public boolean getBoolean(String s)
    {
        return getByte(s) != 0;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(tagMap.size()).append(" entries").toString();
    }

    public NBTBase copy()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound(getName());
        String s;
        for (Iterator iterator = tagMap.keySet().iterator(); iterator.hasNext(); nbttagcompound.setTag(s, ((NBTBase)tagMap.get(s)).copy()))
        {
            s = (String)iterator.next();
        }

        return nbttagcompound;
    }

    public boolean equals(Object obj)
    {
        if (super.equals(obj))
        {
            NBTTagCompound nbttagcompound = (NBTTagCompound)obj;
            return tagMap.entrySet().equals(nbttagcompound.tagMap.entrySet());
        }
        else
        {
            return false;
        }
    }
}
