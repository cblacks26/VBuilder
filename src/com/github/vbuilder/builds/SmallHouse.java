package com.github.vbuilder.builds;

import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

public class SmallHouse extends Build{

	public SmallHouse(UUID id, Location l, Float f) {
		super(id, l, f);
	}

	@SuppressWarnings("deprecation")
	public void GenerateStructure() {
		Location l = getStartLocation();
		World w = l.getWorld();
		int x1 = l.getBlockX(); 
	    int y1 = l.getBlockY();
	    int z1 = l.getBlockZ();
	    int x2;
	    int y2 = y1 + 4;
	    int z2;
	    // East
	    if(isFacingEast()){
	    	z1 = z1 - 4;
	    	x2 = x1 + 8;
	    	z2 = z1 + 8;
	    	for(int x = x1; x <= x2; x++){
	    		// Creates the Floor and Ceiling
		    	for(int z = z1; z <= z2; z++){
		    		Block b = w.getBlockAt(x, y1, z);
		    		b.setType(Material.SANDSTONE);
		    		Block b2 = w.getBlockAt(x, y2, z);
		    		b2.setType(Material.WOOD);
		    	}
		    	// Creates the Left and Right wall
		    	for(int y = y1+1; y <= y2; y++){
		    		if(y == y2-2 && x != x1 && x != x2){
		    			Block b = w.getBlockAt(x, y, z1);
			    		b.setType(Material.GLASS);
			    		Block b2 = w.getBlockAt(x, y, z2);
			    		b2.setType(Material.GLASS);
		    		}else{
				    	Block b = w.getBlockAt(x, y, z1);
			    		b.setType(Material.WOOD);
			    		Block b2 = w.getBlockAt(x, y, z2);
			    		b2.setType(Material.WOOD);
		    		}
		    	}
		    }
	    	// Empties the House
	    	for(int x = x1+1; x <= x2-1; x++){
	    		for(int z = z1+1; z <= z2-1; z++){
	    			for(int y = y1+1; y<= y2-1; y++){
	    				Block b = w.getBlockAt(x, y, z);
			    		b.setType(Material.AIR);
	    			}
	    		}
	    	}
	    	// Creates the Back and Front wall
	    	for(int z = z1+1; z <= z2-1; z++){
	    		for(int y = y1+1; y <= y2-1; y++){
		    		Block b = w.getBlockAt(x1, y, z);
			    	b.setType(Material.WOOD);
			    	Block b2 = w.getBlockAt(x2, y, z);
			    	b2.setType(Material.WOOD);
	    		}
	    	}
	    	// Creates the Door
		    Block doorpt1 = w.getBlockAt(x1, y1 + 1, z1+4);	    
		    Block doorpt2 = w.getBlockAt(x1, y1 + 2, z1+4);
		    doorpt1.setType(Material.WOODEN_DOOR);
		    doorpt1.setData((byte) 0x3);
		    doorpt2.setType(Material.WOODEN_DOOR);
		    doorpt2.setData((byte) 0x8);
		    Block torch = w.getBlockAt(x1+1, y1+3, z1+4);
		    torch.setType(Material.TORCH);
		    Block torch1 = w.getBlockAt(x2-1, y1+3, z1+4);
		    torch1.setType(Material.TORCH);
	    // North
	    }else if(isFacingNorth()){
	    	x1 = x1 - 4;
	    	x2 = x1 + 8;
	    	z2 = z1 - 8;
	    	for(int x = x1; x <= x2; x++){
	    		// Creates the Floor and Ceiling
	    		for(int z = z1; z >= z2; z--){
	    			Block b = w.getBlockAt(x, y1, z);
		    		b.setType(Material.SANDSTONE);
		    		Block b2 = w.getBlockAt(x, y2, z);
		    		b2.setType(Material.WOOD);
	    	   	}
	    		// Creates the Left and Right wall
		    	for(int y = y1+1; y <= y2; y++){
			    	Block b = w.getBlockAt(x, y, z1);
		    		b.setType(Material.WOOD);
		    		Block b2 = w.getBlockAt(x, y, z2);
		    		b2.setType(Material.WOOD);
		    	}
		    }
	    	// Empties the House
	    	for(int z = z1-1; z >= z2+1; z++){
	    		for(int x = x1+1; x <= x2-1; x--){
	    			for(int y = y1+1; y<= y2-1; y++){
	    				Block b = w.getBlockAt(x, y, z);
			    		b.setType(Material.AIR);
	    			}
	    		}
	    	}
	    	// Creates the Back and Front wall
	    	for(int x = x1+1; x <= x2-1; x--){
	    		for(int y = y1+1; y <= y2-1; y++){
		    		Block b = w.getBlockAt(x, y, z1);
			    	b.setType(Material.WOOD);
			    	Block b2 = w.getBlockAt(x, y, z2);
			    	b2.setType(Material.WOOD);
	    		}
	    	}
	    	// Creates the Door
		    Block doorpt1 = w.getBlockAt(x1+4, y1 + 1, z1);	    
		    Block doorpt2 = w.getBlockAt(x1+4, y1 + 2, z1);
		    doorpt1.setType(Material.WOODEN_DOOR);
		    doorpt1.setData((byte) 0x3);
		    doorpt2.setType(Material.WOODEN_DOOR);
		    doorpt2.setData((byte) 0x8);
		    Block torch = w.getBlockAt(x1+4, y1+3, z1-1);
		    torch.setType(Material.TORCH);
		    Block torch1 = w.getBlockAt(x1+4, y1+3, z1+1);
		    torch1.setType(Material.TORCH);
	    // West
	    }else if(isFacingWest()){
	    	z1 = z1 - 1;
	    	x2 = x1 - 2;
	    	z2 = z1 + 2;
	    	for(int x = x1; x >= x2; x--){
	    		// Creates the Floor and Ceiling
		    	for(int z = z1; z <= z2; z++){
		    		Block b = w.getBlockAt(x, y1, z);
		    		b.setType(Material.SANDSTONE);
		    		Block b2 = w.getBlockAt(x, y2, z);
		    		b2.setType(Material.WOOD);
		    	}
		    	// Creates the Left and Right wall
		    	for(int y = y1+1; y <= y2; y++){
		    		if(y == y2-2 && x != x1 && x != x2){
		    			Block b = w.getBlockAt(x, y, z1);
			    		b.setType(Material.GLASS);
			    		Block b2 = w.getBlockAt(x, y, z2);
			    		b2.setType(Material.GLASS);
		    		}else{
				    	Block b = w.getBlockAt(x, y, z1);
			    		b.setType(Material.WOOD);
			    		Block b2 = w.getBlockAt(x, y, z2);
			    		b2.setType(Material.WOOD);
		    		}
		    	}
		    }
	    	// Empties the House
	    	for(int x = x1-1; x >= x2+1; x--){
	    		for(int z = z1+1; z <= z2-1; z++){
	    			for(int y = y1+1; y<= y2-1; y++){
	    				Block b = w.getBlockAt(x, y, z);
			    		b.setType(Material.AIR);
	    			}
	    		}
	    	}
	    	// Creates the Back and Front wall
	    	for(int z = z1+1; z <= z2-1; z++){
	    		for(int y = y1+1; y <= y2-1; y++){
		    		Block b = w.getBlockAt(x1, y, z);
			    	b.setType(Material.WOOD);
			    	Block b2 = w.getBlockAt(x2, y, z);
			    	b2.setType(Material.WOOD);
	    		}
	    	}
	    	// Creates the Door
		    Block doorpt1 = w.getBlockAt(x1, y1 + 1, z1+4);	    
		    Block doorpt2 = w.getBlockAt(x1, y1 + 2, z1+4);
		    doorpt1.setType(Material.WOODEN_DOOR);
		    doorpt1.setData((byte) 0x3);
		    doorpt2.setType(Material.WOODEN_DOOR);
		    doorpt2.setData((byte) 0x8);
		    Block torch = w.getBlockAt(x1+1, y1+3, z1+4);
		    torch.setType(Material.TORCH);
		    Block torch1 = w.getBlockAt(x2-1, y1+3, z1+4);
		    torch1.setType(Material.TORCH);
	    // South
	    }else{
	    	x1 = x1 + 1;
	    	x2 = x1 - 2;
	    	z2 = z1 + 2;
	    	for(int x = x1; x >= x2; x--){
	    		for(int z = z1; z <= z2; z++){
	    	    	Block b = w.getBlockAt(x, y1, z);
	    	   	    b.setType(Material.SANDSTONE);
	    	   	}
		    }
	    }
	}
}
