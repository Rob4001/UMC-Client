package net.minecraft.src;

public class MaterialTransparent extends Material
{
    public MaterialTransparent(MapColor mapcolor)
    {
        super(mapcolor);
        setGroundCover();
    }

    public boolean isSolid()
    {
        return false;
    }

    public boolean getCanBlockGrass()
    {
        return false;
    }

    public boolean blocksMovement()
    {
        return false;
    }
}
