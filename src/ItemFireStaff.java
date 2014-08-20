package net.minecraft.src;

public class ItemFireStaff extends Item {

	public ItemFireStaff(int i) 
	{
		
		super(i);
		maxStackSize = 1;
		setMaxDamage(64);
	}
	
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
       
            world.playSoundAtEntity(entityplayer, "mob.ghast.fireball", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));
            if(!world.multiplayerWorld)
            {
            	world.entityJoinedWorld(new EntityFireballMod(world, entityplayer));
                //world.entityJoinedWorld(new EntityArrow(world,entityplayer));
            }
        itemstack.damageItem(4, entityplayer);
        return itemstack;
    }


	public boolean onItemUse(ItemStack itemstack,EntityPlayer entityplayer,World world, int i, int j, int k, int l)
	{
		int i1 = world.getBlockId(i, j+1, k);
        if(i1 == 0)
        {
        	world.playSoundAtEntity(entityplayer, "mob.ghast.fireball", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));
        	int l1 = MathHelper.floor_double((double)((entityplayer.rotationYaw * 4F) / 360F) + 0.5D) & 3;
            if(l1 == 0)
            {
            	world.setBlockWithNotify(i, j+1, k+2,    Block.fire.blockID);
            	world.setBlockWithNotify(i, j+1, k+3,    Block.fire.blockID);
            	world.setBlockWithNotify(i, j+1, k+4,    Block.fire.blockID);
            	world.setBlockWithNotify(i+1, j+1, k+2,    Block.fire.blockID);
            	world.setBlockWithNotify(i+1, j+1, k+3,    Block.fire.blockID);
            	world.setBlockWithNotify(i+1, j+1, k+4,    Block.fire.blockID);
            	world.setBlockWithNotify(i-1, j+1, k+2,    Block.fire.blockID);
            	world.setBlockWithNotify(i-1, j+1, k+3,    Block.fire.blockID);
            	world.setBlockWithNotify(i-1, j+1, k+4,    Block.fire.blockID);
            }
            if(l1 == 1)
            {
            	world.setBlockWithNotify(i-2, j+1, k, 	 Block.fire.blockID);
            	world.setBlockWithNotify(i-3, j+1, k, 	 Block.fire.blockID);
            	world.setBlockWithNotify(i-4, j+1, k, 	 Block.fire.blockID);
            	world.setBlockWithNotify(i-2, j+1, k+1, 	 Block.fire.blockID);
            	world.setBlockWithNotify(i-3, j+1, k+1, 	 Block.fire.blockID);
            	world.setBlockWithNotify(i-4, j+1, k+1, 	 Block.fire.blockID);
            	world.setBlockWithNotify(i-2, j+1, k-1, 	 Block.fire.blockID);
            	world.setBlockWithNotify(i-3, j+1, k-1, 	 Block.fire.blockID);
            	world.setBlockWithNotify(i-4, j+1, k-1, 	 Block.fire.blockID);
            }
            if(l1 == 2)
            {
            	world.setBlockWithNotify(i, j+1, k-2, 	 Block.fire.blockID);
            	world.setBlockWithNotify(i, j+1, k-3, 	 Block.fire.blockID);
            	world.setBlockWithNotify(i, j+1, k-4, 	 Block.fire.blockID);
            	world.setBlockWithNotify(i+1, j+1, k-2, 	 Block.fire.blockID);
            	world.setBlockWithNotify(i+1, j+1, k-3, 	 Block.fire.blockID);
            	world.setBlockWithNotify(i+1, j+1, k-4, 	 Block.fire.blockID);
            	world.setBlockWithNotify(i-1, j+1, k-2, 	 Block.fire.blockID);
            	world.setBlockWithNotify(i-1, j+1, k-3, 	 Block.fire.blockID);
            	world.setBlockWithNotify(i-1, j+1, k-4, 	 Block.fire.blockID);
            }
            if(l1 == 3)
            {
            	world.setBlockWithNotify(i+2, j+1, k, 	 Block.fire.blockID);
            	world.setBlockWithNotify(i+3, j+1, k, 	 Block.fire.blockID);
            	world.setBlockWithNotify(i+4, j+1, k, 	 Block.fire.blockID);
            	world.setBlockWithNotify(i+2, j+1, k+1, 	 Block.fire.blockID);
            	world.setBlockWithNotify(i+3, j+1, k+1, 	 Block.fire.blockID);
            	world.setBlockWithNotify(i+4, j+1, k+1, 	 Block.fire.blockID);
            	world.setBlockWithNotify(i+2, j+1, k-1, 	 Block.fire.blockID);
            	world.setBlockWithNotify(i+3, j+1, k-1, 	 Block.fire.blockID);
            	world.setBlockWithNotify(i+4, j+1, k-1, 	 Block.fire.blockID);
            
            }
           	
            itemstack.damageItem(2, entityplayer);
			return true;
        }
        else
        {
		return false;
        }
		 
		
		
	}

	
	
}
