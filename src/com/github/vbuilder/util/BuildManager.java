package com.github.vbuilder.util;

import java.util.HashMap;
import java.util.UUID;

import com.github.vbuilder.builds.Build;

public class BuildManager {

	private static final HashMap<Integer, Build> builds = new HashMap<Integer, Build>();

	public static Build getBuild(UUID id) {
		return builds.get(id);
	}

	public static void addBuild(Build build) {
		int id = 1;
		if(!builds.isEmpty()){
			for(int i:builds.keySet()){
				id = i;
			}
		}
		id = id + 1;
		builds.put(id, build);
	}
	public static void removeBuild(int id){
		builds.remove(id);
	}
}
