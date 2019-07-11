package it.polito.tdp.food.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.food.db.Condiment;
import it.polito.tdp.food.db.CondimentIdMap;
import it.polito.tdp.food.db.Food;
import it.polito.tdp.food.db.FoodDao;
import it.polito.tdp.food.db.FoodIdMap;

public class Model {
	
	private FoodDao dao;
	
	private SimpleWeightedGraph<Condiment, DefaultWeightedEdge> graph;
	
	private List<Food> foods;
	private List<Condiment> condiments;
	private List<Portion> portions;
	private List<FoodCondiment> foodCondiments;
	
	private FoodIdMap foodIdMap;
	private CondimentIdMap condimentIdMap;
	private PortionIdMap portionIdMap;
	private FoodCondIDMap foodCondIDMap;
	
	

	public Model() {
		
		this.graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		this.dao = new FoodDao();
		
		this.foodIdMap= new FoodIdMap();
		this.condimentIdMap=new CondimentIdMap();
		this.portionIdMap=new PortionIdMap();
		this.foodCondIDMap=new FoodCondIDMap();
		
		this.foods= dao.listAllFood(this.foodIdMap);
		System.out.println(foods.size());
		
		this.condiments= dao.listAllCondiment(condimentIdMap);
		System.out.println(condiments.size());
		
		this.portions=dao.listAllPortion(portionIdMap, foodIdMap);
		System.out.println(portions.size());
		
		this.foodCondiments=dao.listAllFoodCondiment(foodCondIDMap, condimentIdMap, foodIdMap);
		System.out.println(foodCondiments.size());
		
	}
	
	public void createGraph (double calorie) {
		
		Graphs.addAllVertices(this.graph, dao.listCondiment(condimentIdMap, calorie));
		System.out.println("vertici creati: "+this.graph.vertexSet().size());
		
		
		for (CondimentEdge cE : dao.getEdge(condimentIdMap, calorie)) {
			
			Graphs.addEdge(this.graph, cE.getCo1(), cE.getCo2(), cE.getPeso());
		}
		System.out.println("archi creati: "+this.graph.edgeSet().size());
		
	}
	
	
	public List<CondimentRes> ListCondRes(){
		
		List<CondimentRes> res=new ArrayList<>();
		
		
		for (Condiment condiment : this.graph.vertexSet()) {
			
			int pesoTot = 0;
			Set<DefaultWeightedEdge> edges = this.graph.edgesOf(condiment);
			
			for (DefaultWeightedEdge defaultWeightedEdge : edges) {
				pesoTot+=(int)this.graph.getEdgeWeight(defaultWeightedEdge);
			}
		
			CondimentRes condimentRes= new CondimentRes(condiment, pesoTot);
			res.add(condimentRes);
		}
		
		Collections.sort(res);
		return res;
	
	}
	
	
	public List<CondimentRes> ListCondResSQL(){
		List<CondimentRes> res=new ArrayList<>();

		for (Condiment condiment : this.graph.vertexSet()) {
			
			int sum = dao.getNumCibi(condiment.getCondiment_id());
			CondimentRes condimentRes= new CondimentRes(condiment, sum);
			res.add(condimentRes);
		}
		
		Collections.sort(res);
		return res;
	}
	

}
