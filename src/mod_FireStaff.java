package net.minecraft.src;

import java.util.Random;




public class mod_FireStaff extends BaseMod {
	/*public static final Block fireSummonedBlock = new BlockFireSummoned(315,0).setHardness(2.0F).setResistance(5.0F).setBlockName("Fire(Summoned)");*/
	public static final Item fireStaffItem = new ItemFireStaff(398).setItemName("fireStaffItem");
	public static final Item fireProjectile = new ItemFireProjectile(399).setItemName("fireProjectile");
	public static final Item ironRod = new ItemIronRod(400).setItemName("ironRod");
	public static final Item fireStone = new ItemFireStone(401).setItemName("fireStone");
	
			
	
	
	public mod_FireStaff() 
	{
		/*ModLoader.RegisterBlock(fireSummonedBlock);*/
		fireStaffItem.iconIndex = ModLoader.addOverride("/gui/items.png", "/FireStaff.png");
		ModLoader.AddName(fireStaffItem, "Fire Staff");
		
		fireProjectile.iconIndex = ModLoader.addOverride("/gui/items.png", "/FireProjectile.png");
		ModLoader.AddName(fireProjectile, "Fireball");
		
		ironRod.iconIndex = ModLoader.addOverride("/gui/items.png", "/IronBar.png");
		ModLoader.AddName(ironRod, "Iron Rod");
		
		fireStone.iconIndex = ModLoader.addOverride("/gui/items.png", "/FireStone.png");
		ModLoader.AddName(fireStone, "Fire Stone");
		
		ModLoader.AddRecipe(new ItemStack(fireStaffItem, 1), new Object[] {
            "X", "|", "|", Character.valueOf('X'), mod_FireStaff.fireStone, Character.valueOf('|'), mod_FireStaff.ironRod
        });
		
		ModLoader.AddRecipe(new ItemStack(ironRod, 1), new Object[] {
            "|", "|", Character.valueOf('|'), Item.ingotIron
        });
		
		ModLoader.AddRecipe(new ItemStack(fireStone, 1), new Object[] {
            "X", "|", Character.valueOf('X'), Item.diamond, Character.valueOf('|'), Item.redstone
        });
		
	}
	


	
	public String Version() 
	{
		
		return "1.8.1";
	}

}
/*package net.minecraft.src;

public class mod_FireStaff extends BaseMod 
{

	public static final Item fireStaff = new Item(2000).setItemName("FireStaffItem");

	
	 
	//FireStaff.iconIndex = ModLoader.addOverride("/gui/items.png", "/moreores/firestaff.png");
	//ModLoader.AddName(fireStaff, "Fire Staff");
	  
	public String Version()
	  {
	  return "1.8.1";
	  }

	

}
*/