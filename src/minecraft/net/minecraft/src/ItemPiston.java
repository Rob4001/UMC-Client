// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemBlock

public class ItemPiston extends ItemBlock
{

    public ItemPiston(int i)
    {
        super(i);
    }

    public int getPlacedBlockMetadata(int i)
    {
        return 7;
    }
}
