package net.minecraft.src;

import java.io.*;
import java.util.*;

public class NBTTagList extends NBTBase
{
    private List tagList;
    private byte tagType;

    public NBTTagList()
    {
        super("");
        tagList = new ArrayList();
    }

    public NBTTagList(String s)
    {
        super(s);
        tagList = new ArrayList();
    }

    void write(DataOutput dataoutput)
    throws IOException
    {
        if (tagList.size() > 0)
        {
            tagType = ((NBTBase)tagList.get(0)).getId();
        }
        else
        {
            tagType = 1;
        }
        dataoutput.writeByte(tagType);
        dataoutput.writeInt(tagList.size());
        for (int i = 0; i < tagList.size(); i++)
        {
            ((NBTBase)tagList.get(i)).write(dataoutput);
        }
    }

    void load(DataInput datainput)
    throws IOException
    {
        tagType = datainput.readByte();
        int i = datainput.readInt();
        tagList = new ArrayList();
        for (int j = 0; j < i; j++)
        {
            NBTBase nbtbase = NBTBase.newTag(tagType, null);
            nbtbase.load(datainput);
            tagList.add(nbtbase);
        }
    }

    public byte getId()
    {
        return 9;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(tagList.size()).append(" entries of type ").append(NBTBase.getTagName(tagType)).toString();
    }

    public void appendTag(NBTBase nbtbase)
    {
        tagType = nbtbase.getId();
        tagList.add(nbtbase);
    }

    public NBTBase tagAt(int i)
    {
        return (NBTBase)tagList.get(i);
    }

    public int tagCount()
    {
        return tagList.size();
    }

    public NBTBase copy()
    {
        NBTTagList nbttaglist = new NBTTagList(getName());
        nbttaglist.tagType = tagType;
        NBTBase nbtbase1;
        for (Iterator iterator = tagList.iterator(); iterator.hasNext(); nbttaglist.tagList.add(nbtbase1))
        {
            NBTBase nbtbase = (NBTBase)iterator.next();
            nbtbase1 = nbtbase.copy();
        }

        return nbttaglist;
    }

    public boolean equals(Object obj)
    {
        if (super.equals(obj))
        {
            NBTTagList nbttaglist = (NBTTagList)obj;
            if (tagType == nbttaglist.tagType)
            {
                return tagList.equals(nbttaglist.tagList);
            }
        }
        return false;
    }
}
