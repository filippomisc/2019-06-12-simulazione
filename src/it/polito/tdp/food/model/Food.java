package it.polito.tdp.food.model;

public class Food {
	private Integer food_code;
	private String display_name;

	
	public Food(Integer food_code, String display_name) {
		super();
		this.food_code = food_code;
		this.display_name = display_name;
	}

	
	public Integer getFood_code() {
		return food_code;
	}
	public void setFood_code(Integer food_code) {
		this.food_code = food_code;
	}
	public String getDisplay_name() {
		return display_name;
	}
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	

	@Override
	public String toString() {
		return "Food [food_id=" + food_code + ", food_code=" + food_code + ", display_name=" + display_name
				+ ", portion_display_name=" + portion_display_name + "]";
	}

	
	
	
	
	
}
