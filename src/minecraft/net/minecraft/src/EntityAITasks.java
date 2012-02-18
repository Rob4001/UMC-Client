package net.minecraft.src;

import java.util.ArrayList;
import java.util.Iterator;

public class EntityAITasks
{
    private ArrayList tasksToDo;
    private ArrayList executingTasks;

    public EntityAITasks()
    {
        tasksToDo = new ArrayList();
        executingTasks = new ArrayList();
    }

    public void addTask(int i, EntityAIBase entityaibase)
    {
        tasksToDo.add(new EntityAITaskEntry(this, i, entityaibase));
    }

    public void onUpdateTasks()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = tasksToDo.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            EntityAITaskEntry entityaitaskentry = (EntityAITaskEntry)iterator.next();
            boolean flag = executingTasks.contains(entityaitaskentry);
            if (flag)
            {
                if (!entityaitaskentry.field_46114_a.continueExecuting() || !func_46116_a(entityaitaskentry))
                {
                    entityaitaskentry.field_46114_a.resetTask();
                    executingTasks.remove(entityaitaskentry);
                }
            }
            else if (entityaitaskentry.field_46114_a.shouldExecute() && func_46116_a(entityaitaskentry))
            {
                arraylist.add(entityaitaskentry);
                executingTasks.add(entityaitaskentry);
            }
        }
        while (true);
        EntityAITaskEntry entityaitaskentry1;
        for (Iterator iterator1 = arraylist.iterator(); iterator1.hasNext(); entityaitaskentry1.field_46114_a.func_46080_e())
        {
            entityaitaskentry1 = (EntityAITaskEntry)iterator1.next();
        }

        EntityAITaskEntry entityaitaskentry2;
        for (Iterator iterator2 = executingTasks.iterator(); iterator2.hasNext(); entityaitaskentry2.field_46114_a.updateTask())
        {
            entityaitaskentry2 = (EntityAITaskEntry)iterator2.next();
        }
    }

    private boolean func_46116_a(EntityAITaskEntry entityaitaskentry)
    {
        label0:
        {
            Iterator iterator = tasksToDo.iterator();
            EntityAITaskEntry entityaitaskentry1;
            label1:
            do
            {
                do
                {
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break label0;
                        }
                        entityaitaskentry1 = (EntityAITaskEntry)iterator.next();
                    }
                    while (entityaitaskentry1 == entityaitaskentry);
                    if (entityaitaskentry.priority < entityaitaskentry1.priority)
                    {
                        continue label1;
                    }
                }
                while (!executingTasks.contains(entityaitaskentry1) || areTasksCompatible(entityaitaskentry, entityaitaskentry1));
                return false;
            }
            while (!executingTasks.contains(entityaitaskentry1) || entityaitaskentry1.field_46114_a.isContinous());
            return false;
        }
        return true;
    }

    private boolean areTasksCompatible(EntityAITaskEntry entityaitaskentry, EntityAITaskEntry entityaitaskentry1)
    {
        return (entityaitaskentry.field_46114_a.func_46083_c() & entityaitaskentry1.field_46114_a.func_46083_c()) == 0;
    }
}
