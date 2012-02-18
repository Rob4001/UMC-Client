package net.minecraft.src;

abstract class EntityAIBase
{
    private int field_46085_a;

    EntityAIBase()
    {
        field_46085_a = 0;
    }

    public abstract boolean shouldExecute();

    public boolean continueExecuting()
    {
        return shouldExecute();
    }

    public boolean isContinous()
    {
        return true;
    }

    public void func_46080_e()
    {
    }

    public void resetTask()
    {
    }

    public void updateTask()
    {
    }

    public void func_46079_a(int i)
    {
        field_46085_a = i;
    }

    public int func_46083_c()
    {
        return field_46085_a;
    }
}
