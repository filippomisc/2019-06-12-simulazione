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
	
	private FoodIdMap foodIdMap;
	private CondimentIdMap condimentIdMap;
	
	
	

	public Model() {
		
		this.graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		this.dao = new FoodDao();
		
		this.foodIdMap= new FoodIdMap();
		this.condimentIdMap=new CondimentIdMap();
		
		this.foods= dao.listAllFood(this.foodIdMap);
		System.out.println(foods.size());
		
		this.condiments= dao.listAllCondiment(condimentIdMap);
		System.out.println(condiments.size());
		
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
	

}
