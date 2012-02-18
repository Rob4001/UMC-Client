package net.minecraft.src;

public class EntityAIAttackOnCollide extends EntityAIBase
{
    World worldObj;
    EntityMob entity;
    EntityLiving entityTarget;
    int field_46091_d;
    float field_46092_e;

    public EntityAIAttackOnCollide(EntityMob entitymob, World world, float f)
    {
        field_46091_d = 0;
        entity = entitymob;
        worldObj = world;
        field_46092_e = f;
        func_46079_a(3);
    }

    public boolean shouldExecute()
    {
        entityTarget = func_46090_h();
        return entityTarget != null;
    }

    public void updateTask()
    {
        entity.getNavigator().func_46070_a(entityTarget, entity.getMoveSpeed());
        entity.getLookHelper().setLookPositionWithEntity(entityTarget, 30F, 30F);
        field_46091_d = Math.max(field_46091_d - 1, 0);
        double d = 4D;
        if (entity.getDistanceSqToEntity(entityTarget) > d)
        {
            return;
        }
        if (field_46091_d > 0)
        {
            return;
        }
        else
        {
            field_46091_d = 20;
            entity.attackEntityAsMob(entityTarget);
            return;
        }
    }

    private EntityLiving func_46090_h()
    {
        Object obj = entity.func_46007_aL();
        if (obj == null)
        {
            obj = worldObj.getClosestVulnerablePlayerToEntity(entity, field_46092_e);
        }
        if (obj == null)
        {
            return null;
        }
        if (((EntityLiving) (obj)).boundingBox.maxY <= entity.boundingBox.minY || ((EntityLiving) (obj)).boundingBox.minY >= entity.boundingBox.maxY)
        {
            return null;
        }
        if (!entity.canEntityBeSeen(((Entity) (obj))))
        {
            return null;
        }
        else
        {
            return ((EntityLiving) (obj));
        }
    }

    public int func_46083_c()
    {
        return super.func_46083_c();
    }

    public void func_46079_a(int i)
    {
        super.func_46079_a(i);
    }

    public void resetTask()
    {
        super.resetTask();
    }

    public void func_46080_e()
    {
        super.func_46080_e();
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
