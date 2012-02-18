package net.minecraft.src;

public class EntityJumpHelper
{
    private EntityLiving entity;
    private boolean isJumping;

    public EntityJumpHelper(EntityLiving entityliving)
    {
        isJumping = false;
        entity = entityliving;
    }

    public void setJumping()
    {
        isJumping = true;
    }

    public void doJump()
    {
        if (!isJumping)
        {
            return;
        }
        else
        {
            entity.setJumping(true);
            isJumping = false;
            return;
        }
    }
}
