package net.minecraft.src;

public class ItemSlab extends ItemBlock
{
    public ItemSlab(int par1)
    {
        super(par1);
        setMaxDamage(0);
        setHasSubtypes(true);
    }

    /**
     * Gets an icon index based on an item's damage value
     */
    public int getIconFromDamage(int par1)
    {
        return Block.stairSingle.getBlockTextureFromSideAndMetadata(2, par1);
    }

    /**
     * Returns the metadata of the block which this Item (ItemBlock) can place
     */
    public int getMetadata(int par1)
    {
        return par1;
    }

    public String getItemNameIS(ItemStack par1ItemStack)
    {
        int i = par1ItemStack.getItemDamage();

        if (i < 0 || i >= BlockStep.blockStepTypes.length)
        {
            i = 0;
        }

        return (new StringBuilder()).append(super.getItemName()).append(".").append(BlockStep.blockStepTypes[i]).toString();
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS !
     */
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7)
    {
        if (par1ItemStack.stackSize == 0)
        {
            return false;
        }

        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6))
        {
            return false;
        }

        int i = par3World.getBlockId(par4, par5, par6);
        int j = par3World.getBlockMetadata(par4, par5, par6);
        int k = j & 7;
        boolean flag = (j & 8) != 0;

        if ((par7 == 1 && !flag || par7 == 0 && flag) && i == Block.stairSingle.blockID && k == par1ItemStack.getItemDamage())
        {
            if (par3World.setBlockAndMetadataWithNotify(par4, par5, par6, Block.stairDouble.blockID, k))
            {
                par3World.playSoundEffect((float)par4 + 0.5F, (float)par5 + 0.5F, (float)par6 + 0.5F, Block.stairDouble.stepSound.getStepSound(), (Block.stairDouble.stepSound.getVolume() + 1.0F) / 2.0F, Block.stairDouble.stepSound.getPitch() * 0.8F);
                par1ItemStack.stackSize--;
            }

            return true;
        }
        else
        {
            return super.onItemUse(par1ItemStack, par2EntityPlayer, par3World, par4, par5, par6, par7);
        }
    }
}
