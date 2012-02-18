package net.minecraft.src;

class EntityAITaskEntry
{
    public EntityAIBase field_46114_a;
    public int priority;
    final EntityAITasks field_46113_c;

    public EntityAITaskEntry(EntityAITasks entityaitasks, int i, EntityAIBase entityaibase)
    {
        field_46113_c = entityaitasks;

        priority = i;
        field_46114_a = entityaibase;
    }
}
