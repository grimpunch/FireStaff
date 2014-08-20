package net.minecraft.src;

public class EntityFireballMod extends EntityItem
{
 
    public EntityFireballMod(World world)
    {
        super(world);
        setSize(0.5F, 0.5F);
        yOffset = height / 2.0F;
        item = new ItemStack(mod_FireStaff.fireProjectile);  //item used as projectile image
        bounceFactor = 0.6;
        exploded = false;
        stopped = false;
        fuse = 0;
    }
    public EntityFireballMod(World world, double x, double y, double z, float yaw, float pitch, double force, int fuseLength)
    {
        this(world);

        setRotation(yaw, 0);
        double xHeading = -MathHelper.sin((yaw * 3.141593F) / 180F);
        double zHeading = MathHelper.cos((yaw * 3.141593F) / 180F);
        motionX = force*xHeading*MathHelper.cos((pitch / 180F) * 3.141593F);
        motionY = -force*MathHelper.sin((pitch / 180F) * 3.141593F);
        motionZ = force*zHeading*MathHelper.cos((pitch / 180F) * 3.141593F);

        setPosition(x+xHeading*0.8, y, z+zHeading*0.8);
        prevPosX = posX;
        prevPosY = posY;
        prevPosZ = posZ;
 
        fuse = fuseLength;
    }
    public EntityFireballMod(World world, Entity entity)
    {
        this(world, entity.posX, entity.posY, entity.posZ, entity.rotationYaw, entity.rotationPitch, 0.5, 50);
    }
    
    protected boolean canTriggerWalking()
    {
        return false;
    }
 
    public void onUpdate()
    {
        if(fuse-- <= 0)
        {
            explode();
        }
        if(!(stopped) && !(exploded))
        {
                double prevVelX = motionX;
                double prevVelY = motionY;
                double prevVelZ = motionZ;
                prevPosX = posX;
                prevPosY = posY;
                prevPosZ = posZ;
                moveEntity(motionX, motionY, motionZ);
         
                boolean collided = false;
                        
                if(motionX!=prevVelX)
                {
                        motionX = -prevVelX;
                        collided = true;
                }
                if(motionZ!=prevVelZ)
                {
                        motionZ = -prevVelZ;
                }
         
                if(motionY!=prevVelY)
                {
                        motionY = -prevVelY;
                        collided = true;
                }
                else
                {
                        motionY -= 0.01;
                }
         
                if(collided)
                {
                	int spread = 0;
                	int x = (int)posX;
                	int y = (int)posY;
                	int z = (int)posZ;
                	if(spread <= 5)
                	{
    	            	if(spread == 0)
    	            	{
    	                worldObj.setBlockWithNotify(x, y, z, Block.fire.blockID);
    	                spread++;
    	            	}
    	            	if(spread == 1)
    	            	{
    	                    worldObj.setBlockWithNotify(x - 1, y, z, Block.fire.blockID);
    	                    spread++;
    	            	}
    	            	if(spread == 2)
    	            	{
    	                    worldObj.setBlockWithNotify(x + 1, y, z, Block.fire.blockID);
    	                    spread++;
    	            	}
    	            	if(spread == 3)
    	            	{
    	                    worldObj.setBlockWithNotify(x, y, z - 1 , Block.fire.blockID);
    	                    spread++;
    	            	}
    	            	if(spread == 4)
    	            	{
    	                    worldObj.setBlockWithNotify(x, y, z + 1, Block.fire.blockID);
    	                    spread = 6;
    	            	}
                	}		
                        motionX *= bounceFactor;
                        motionY *= bounceFactor;
                        motionZ *= bounceFactor;
                }
         
                motionX *= 0.99;
                motionY *= 0.99;
                motionZ *= 0.99;
                if(onGround && (motionX*motionX+motionY*motionY+motionZ*motionZ)<0.02)
                {
                        stopped = true;
                        motionX = 0;
                        motionY = 0;
                        motionZ = 0;
                }
        }
    }
    public void onCollideWithPlayer(EntityPlayer entityplayer)
    {
        //stops player grabbing it instantly
    }
    protected void explode()
    {
        if(!exploded)
        {
                exploded = true;
                
               //worldObj.newExplosion(null, posX, posY, posZ, 1F, true);
              	int spread = 0;
            	int x = (int)posX;
            	int y = (int)posY;
            	int z = (int)posZ;
            	if(spread <= 5)
            	{
	            	if(spread == 0)
	            	{
	                worldObj.setBlockWithNotify(x, y, z, Block.fire.blockID);
	                spread++;
	            	}
	            	if(spread == 1)
	            	{
	                    worldObj.setBlockWithNotify(x - 1, y, z, Block.fire.blockID);
	                    spread++;
	            	}
	            	if(spread == 2)
	            	{
	                    worldObj.setBlockWithNotify(x + 1, y, z, Block.fire.blockID);
	                    spread++;
	            	}
	            	if(spread == 3)
	            	{
	                    worldObj.setBlockWithNotify(x, y, z - 1 , Block.fire.blockID);
	                    spread++;
	            	}
	            	if(spread == 4)
	            	{
	                    worldObj.setBlockWithNotify(x, y, z + 1, Block.fire.blockID);
	                    spread = 6;
	            	}
            	}
            	setEntityDead();

            	
        }
    }
 
    public boolean attackEntity(DamageSource entity, int i)
    {
        super.attackEntityFrom(entity, i);
        explode();
        return false;
    }
    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setByte("Fuse", (byte)fuse);
    }
 
    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
        fuse = nbttagcompound.getByte("Fuse");
    }
    double bounceFactor;
    int fuse;
    boolean exploded;
    boolean collided;
    boolean stopped;
}