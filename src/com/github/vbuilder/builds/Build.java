package com.github.vbuilder.builds;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.Material;

public abstract class Build {

	private UUID id;
	private Location loc;
	private Float f;
	private HashMap<Location, Material> old = new HashMap<Location, Material>();
	private HashMap<Location, Material> current = new HashMap<Location, Material>();
	
	public Build(UUID id, Location l, Float f){
		setId(id);
		setStartLocation(l);
		setYaw(f);
	}
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
	public Location getStartLocation() {
		return loc;
	}

	public void setStartLocation(Location loc) {
		this.loc = loc;
	}
	
	public Float getYaw() {
		return f;
	}

	public void setYaw(Float f) {
		this.f = f;
	}

	public void addOldBlock(Location l, Material m){
		old.put(l, m);
	}
	
	public void addCurrentBlock(Location l, Material m){
		current.put(l, m);
	}
	
	public Material getOldBlock(Location l){
		return old.get(l);
	}
	
	public Material getCurrentBlock(Location l){
		return current.get(l);
	}
	
	public void rollback(){
		for(Location l : old.keySet()){
			l.getBlock().setType(getOldBlock(l));
		}
	}
	/* Positive X is forward
	 * Positive Z is right
	 * Negative Z is Left
	 */
	protected boolean isFacingEast(){
		Float f = getYaw();
		if(f > 0){
			f = f * -1;
		}
		if(f < -45 && f >= -135){
			return true;
		}else{
			return false;
		}
	}
	/* Negative Z is forward
	 * Positive x is right
	 * Negative X is Left
	 */
	protected boolean isFacingNorth(){
		Float f = getYaw();
		if(f > 0){
			f = f * -1;
		}
		if(f < -135 && f >= -225){
			return true;
		}else{
			return false;
		}
	}
	/* Negative X is forward
	 * Positive Z is left
	 * Negative Z is right
	 */
	protected boolean isFacingWest(){
		Float f = getYaw();
		if(f > 0){
			f = f * -1;
		}
		if(f < -225 && f >= -315){
			return true;
		}else{
			return false;
		}
	}
	/* Positive Z is forward
	 * Positive X is left
	 * Negative X is right
	 */
	protected boolean isFacingSouth(){
		Float f = getYaw();
		if(f > 0){
			f = f * -1;
		}
		if(f < -315 || f >= -45){
			return true;
		}else{
			return false;
		}
	}
	
	public abstract void GenerateStructure();
}
