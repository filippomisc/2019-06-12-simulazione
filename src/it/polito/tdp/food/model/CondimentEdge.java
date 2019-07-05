package it.polito.tdp.food.model;

import it.polito.tdp.food.db.Condiment;

public class CondimentEdge {
	
	private int peso;
	private Condiment co1;
	private Condiment co2;
	
	public CondimentEdge(int peso, Condiment co1, Condiment co2) {
		super();
		this.peso = peso;
		this.co1 = co1;
		this.co2 = co2;
	}

	public int getPeso() {
		return peso;
	}

	public Condiment getCo1() {
		return co1;
	}

	public Condiment getCo2() {
		return co2;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CondimentEdge [peso=");
		builder.append(peso);
		builder.append(", co1=");
		builder.append(co1);
		builder.append(", co2=");
		builder.append(co2);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
