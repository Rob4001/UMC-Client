package net.minecraft.src;

public class MaterialLiquid extends Material
{
    public MaterialLiquid(MapColor mapcolor)
    {
        super(mapcolor);
        setGroundCover();
        setNoPushMobility();
    }

    public boolean isLiquid()
    {
        return true;
    }

    public boolean blocksMovement()
    {
        return false;
    }

    public boolean isSolid()
    {
        return false;
    }
}
