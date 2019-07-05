package it.polito.tdp.food.db;

import java.util.*;

public class CondimentIdMap {
		
		private Map<Integer, Condiment> map;
		
		public CondimentIdMap() {
			map = new HashMap<>();
		}
		
		public Condiment get(int id) {
			return map.get(id);
		}
		
		public Condiment get(Condiment oggetto) {
			Condiment old = map.get(oggetto.getCondiment_id());
			if (old == null) {
				map.put(oggetto.getCondiment_id(), oggetto);
				return oggetto;
			}
			return old;
		}
		
		public void put(Condiment oggetto, int id) {
			map.put(id, oggetto);
		}

		public Map<Integer, Condiment> getMap() {
			return map;
		}	
	
		

}
