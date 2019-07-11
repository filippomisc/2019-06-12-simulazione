package it.polito.tdp.food.model;

public class FoodCondiment {
	
	private int id;
	private Food food; 
	private Condiment condiment;
	
	public FoodCondiment(Integer id, Food food, Condiment condiment) {
		this.id=id;
		this.food = food;
		this.condiment = condiment;
	}
	
	
	public int getId() {
		return id;
	}

	public Food getFood() {
		return food;
	}
	
	public Condiment getCondiment() {
		return condiment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FoodCondiment other = (FoodCondiment) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FoodCondiment [id: ");
		builder.append(id);
		builder.append("\nfood: ");
		builder.append(food);
		builder.append("\ncondiment: ");
		builder.append(condiment);
		return builder.toString();
	}

	/*
	 * SE NON SI USANO IDMAP
	 */
//	private int id;
//	private Integer food_code;
//	private Integer condiment_code;
//	
//	public FoodCondiment(int id, Integer food_code, Integer condiment_code) {
//		super();
//		this.id = id;
//		this.food_code = food_code;
//		this.condiment_code = condiment_code;
//	}
//	
//	
//	public int getId() {
//		return id;
//	}
//	public Integer getFood_code() {
//		return food_code;
//	}
//	public Integer getCondiment_code() {
//		return condiment_code;
//	}
//
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + id;
//		return result;
//	}
//
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		FoodCondiment other = (FoodCondiment) obj;
//		if (id != other.id)
//			return false;
//		return true;
//	}
//
//
//	@Override
//	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("FoodCondiment [id=");
//		builder.append(id);
//		builder.append(", food_code=");
//		builder.append(food_code);
//		builder.append(", condiment_code=");
//		builder.append(condiment_code);
//		builder.append("]");
//		return builder.toString();
//	}
	

}
