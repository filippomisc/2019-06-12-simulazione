package it.polito.tdp.food.db;


public class TestDao {

	public static void main(String[] args) {
		FoodDao dao = new FoodDao();
		
		FoodIdMap fIdMap = new FoodIdMap();
		CondimentIdMap cIdMap = new CondimentIdMap();
		
		System.out.println(dao.listAllFood(fIdMap).size());
		System.out.println(dao.listAllCondiment(cIdMap).size());
		System.out.println(dao.listCondiment(cIdMap, 20.0).size());

	}

}
