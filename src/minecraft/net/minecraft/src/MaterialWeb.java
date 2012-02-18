package net.minecraft.src;

final class MaterialWeb extends Material
{
    MaterialWeb(MapColor mapcolor)
    {
        super(mapcolor);
    }

    public boolean blocksMovement()
    {
        return false;
    }
}
