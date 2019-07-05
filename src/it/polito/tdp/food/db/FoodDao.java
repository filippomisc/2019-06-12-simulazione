package it.polito.tdp.food.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.food.model.CondimentEdge;


public class FoodDao {

	public List<Food> listAllFood(FoodIdMap idMap){
		String sql = "SELECT * FROM food" ;
		try {
			Connection conn = DBConnect.getConnection() ;

			PreparedStatement st = conn.prepareStatement(sql) ;
			
			List<Food> list = new ArrayList<>() ;
			
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				try {
					
					Food food = new Food(res.getInt("food_id"),
							res.getInt("food_code"),
							res.getString("display_name"), 
							res.getInt("portion_default"), 
							res.getDouble("portion_amount"),
							res.getString("portion_display_name"),
							res.getDouble("calories"));
				
					
					list.add(idMap.get(food));
					
				} catch (Throwable t) {
					t.printStackTrace();
				}
			}
			
			conn.close();
			return list ;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null ;
		}

	}
	
	public List<Condiment> listAllCondiment(CondimentIdMap idMap){
		String sql = "SELECT * FROM condiment" ;
		try {
			Connection conn = DBConnect.getConnection() ;

			PreparedStatement st = conn.prepareStatement(sql) ;
			
			List<Condiment> list = new ArrayList<>() ;
			
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				try {
					
					Condiment condiment = new Condiment(res.getInt("condiment_id"),
							res.getInt("food_code"),
							res.getString("display_name"), 
							res.getString("condiment_portion_size"), 
							res.getDouble("condiment_calories")
							);
							
					list.add(idMap.get(condiment));
					
					
				} catch (Throwable t) {
					t.printStackTrace();
				}
			}
			
			conn.close();
			return list ;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null ;
		}

	}
	
//	public List<Condiment> listAllFoodCond(CondimentIdMap condimentIdMap, FoodIdMap foodIdMap, FoodCondIDMap foodCondIDMap){
//		String sql = "SELECT * FROM food_condiment" ;
//		try {
//			Connection conn = DBConnect.getConnection() ;
//
//			PreparedStatement st = conn.prepareStatement(sql) ;
//			
//			List<FoodCondiment> list = new ArrayList<>() ;
//			
//			ResultSet res = st.executeQuery() ;
//			
//			while(res.next()) {
//				try {
//					
//					FoodCondiment foodCondiment= new FoodCondiment(res.getInt("id"), foodIdMap.get(res.getInt("food_code")), condimentIdMap.get);
//				
//					list.add(idMap.get(condiment));
//					
//					
//				} catch (Throwable t) {
//					t.printStackTrace();
//				}
//			}
//			
//			conn.close();
//			return list ;
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null ;
//		}
//
//	}
	
	
	public List<Condiment> listCondiment(CondimentIdMap idMap, double calorie){
		String sql = "select c.condiment_id as id " + 
				"from condiment c " + 
				"where c.condiment_calories<?" ;
		try {
			Connection conn = DBConnect.getConnection() ;

			PreparedStatement st = conn.prepareStatement(sql); 
					st.setDouble(1, calorie);
			
			List<Condiment> list = new ArrayList<>() ;
			
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				try {
					
					Condiment condiment = idMap.get(res.getInt("condiment_id"));
							
					list.add(idMap.get(condiment));
					
					
				} catch (Throwable t) {
					t.printStackTrace();
				}
			}
			
			conn.close();
			return list ;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null ;
		}

	}
	
	public List<CondimentEdge> getEdge(CondimentIdMap idMap, double calorie){
		String sql = "select count(distinct fc1.food_code) as cnt, c1.condiment_id as co1, c2.condiment_id as co2 " + 
				"from condiment c1, food_condiment fc1, condiment c2, food_condiment fc2 " + 
				"where c1.food_code=fc1.condiment_food_code " + 
				"and c2.food_code=fc2.condiment_food_code " + 
				"and fc1.food_code=fc2.food_code " + 
				"and c1.condiment_calories<? " + 
				"and c2.condiment_calories<? " + 
				"and c1.condiment_id<c2.condiment_id " + 
				"and c1.food_code!=c2.food_code " + 
				"group by c1.condiment_id,c2.condiment_id" ;
		try {
			Connection conn = DBConnect.getConnection() ;

			PreparedStatement st = conn.prepareStatement(sql); 
					st.setDouble(1, calorie);
					st.setDouble(2, calorie);
			
			List<CondimentEdge> list = new ArrayList<>() ;
			
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				try {
					
					CondimentEdge condimentEdge = new CondimentEdge(res.getInt("cnt"), idMap.get(res.getInt("co1")), idMap.get(res.getInt("co2")));
							
					list.add(condimentEdge);
					
					
				} catch (Throwable t) {
					t.printStackTrace();
				}
			}
			
			conn.close();
			return list ;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null ;
		}

	}
	
	
}
