package it.polito.tdp.food.model;

import java.util.HashMap;
import java.util.Map;

public class FoodIdMap {


	private Map<Integer, Food> map;
	
	public FoodIdMap() {
		map = new HashMap<>();
	}
	
	public Food get(int id) {
		return map.get(id);
	}
	
	public Food get(Food oggetto) {
		Food old = map.get(oggetto.getFood_code());
		if (old == null) {
			map.put(oggetto.getFood_code(), oggetto);
			return oggetto;
		}
		return old;
	}
	
	public void put(Food oggetto, int id) {
		map.put(id, oggetto);
	}	

	public Map<Integer, Food> getMap() {
		return map;
	}
}
