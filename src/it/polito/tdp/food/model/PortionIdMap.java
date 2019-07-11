package it.polito.tdp.food.model;

import java.util.HashMap;
import java.util.Map;

public class PortionIdMap {

private Map<Integer, Portion> map;
	
	public PortionIdMap() {
		map = new HashMap<>();
	}
	
	public Portion get(int id) {
		return map.get(id);
	}
	
	public Portion get(Portion oggetto) {
		Portion old = map.get(oggetto.getPortion_id());
		if (old == null) {
			map.put(oggetto.getPortion_id(), oggetto);
			return oggetto;
		}
		return old;
	}
	
	public void put(Portion oggetto, int id) {
		map.put(id, oggetto);
	}

	public Map<Integer, Portion> getMap() {
		return map;
	}	
}
