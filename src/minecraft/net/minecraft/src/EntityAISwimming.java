package net.minecraft.src;

import java.util.Random;

public class EntityAISwimming extends EntityAIBase
{
    private EntityLiving field_46106_a;

    public EntityAISwimming(EntityLiving entityliving)
    {
        field_46106_a = entityliving;
        func_46079_a(4);
    }

    public boolean shouldExecute()
    {
        return field_46106_a.getRNG().nextFloat() < 0.8F && (field_46106_a.isInWater() || field_46106_a.handleLavaMovement());
    }

    public void func_46080_e()
    {
        field_46106_a.getJumpHelper().setJumping();
    }

    public int func_46083_c()
    {
        return super.func_46083_c();
    }

    public void func_46079_a(int i)
    {
        super.func_46079_a(i);
    }

    public void updateTask()
    {
        super.updateTask();
    }

    public void resetTask()
    {
        super.resetTask();
    }

    public boolean isContinous()
    {
        return super.isContinous();
    }

    public boolean continueExecuting()
    {
        return super.continueExecuting();
    }
}
