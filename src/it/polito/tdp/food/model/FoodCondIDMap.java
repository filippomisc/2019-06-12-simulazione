package it.polito.tdp.food.model;

import java.util.HashMap;
import java.util.Map;

public class FoodCondIDMap {
	
private Map<Integer, FoodCondiment> map;
	
	public FoodCondIDMap() {
		map = new HashMap<>();
	}
	
	public FoodCondiment get(int id) {
		return map.get(id);
	}
	
	public FoodCondiment get(FoodCondiment oggetto) {
		FoodCondiment old = map.get(oggetto.getId());
		if (old == null) {
			map.put(oggetto.getId(), oggetto);
			return oggetto;
		}
		return old;
	}
	
	public void put(FoodCondiment oggetto, int id) {
		map.put(id, oggetto);
	}

	public Map<Integer, FoodCondiment> getMap() {
		return map;
	}	

}
