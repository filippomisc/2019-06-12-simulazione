package it.polito.tdp.food.db;


import it.polito.tdp.food.model.CondimentIdMap;
import it.polito.tdp.food.model.FoodCondIDMap;
import it.polito.tdp.food.model.FoodIdMap;
import it.polito.tdp.food.model.PortionIdMap;

public class TestDao {

	public static void main(String[] args) {
		FoodDao dao = new FoodDao();
		
		FoodIdMap fIdMap = new FoodIdMap();
		CondimentIdMap cIdMap = new CondimentIdMap();
		PortionIdMap pIdMap=new PortionIdMap();
		FoodCondIDMap fCondIDMap=new FoodCondIDMap();
		
		System.out.println(dao.listAllFood(fIdMap).size());
		System.out.println(dao.listAllCondiment(cIdMap).size());
//		System.out.println(dao.listCondiment(cIdMap, 20.0).size());
		System.out.println(dao.listAllFoodCondiment(fCondIDMap, cIdMap, fIdMap).size());
		System.out.println(dao.listAllPortion(pIdMap, fIdMap).size());

	}

}
