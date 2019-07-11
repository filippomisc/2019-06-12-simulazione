package it.polito.tdp.food.model;


public class Portion {
	
	
	private Integer portion_id;
	private Food food;
	private Integer portion_default;
	private double portion_amount;
	private String portion_display_name;
	private double calories;
	
	
	public Portion(Integer portion_id, Food food, Integer portion_default, double portion_amount,
			String portion_display_name, double calories) {
		super();
		this.portion_id = portion_id;
		this.food = food;
		this.portion_default = portion_default;
		this.portion_amount = portion_amount;
		this.portion_display_name = portion_display_name;
		this.calories = calories;
	}


	public Integer getPortion_id() {
		return portion_id;
	}

	public Food getFood() {
		return food;
	}


	public Integer getPortion_default() {
		return portion_default;
	}


	public double getPortion_amount() {
		return portion_amount;
	}


	public String getPortion_display_name() {
		return portion_display_name;
	}


	public double getCalories() {
		return calories;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Portion [portion_id=");
		builder.append(portion_id);
		builder.append(", food=");
		builder.append(food);
		builder.append(", portion_default=");
		builder.append(portion_default);
		builder.append(", portion_amount=");
		builder.append(portion_amount);
		builder.append(", portion_display_name=");
		builder.append(portion_display_name);
		builder.append(", calories=");
		builder.append(calories);
		builder.append("]");
		return builder.toString();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((portion_id == null) ? 0 : portion_id.hashCode());
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
		Portion other = (Portion) obj;
		if (portion_id == null) {
			if (other.portion_id != null)
				return false;
		} else if (!portion_id.equals(other.portion_id))
			return false;
		return true;
	}

//	private Integer portion_id;
//	private Integer food_code;
//	private Integer portion_default;
//	private double portion_amount;
//	private String portion_display_name;
//	private double calories;
//	
//	public Portion(Integer portion_id, Integer food_code, Integer portion_default, double portion_amount,
//			String portion_display_name, double calories) {
//		super();
//		this.portion_id = portion_id;
//		this.food_code = food_code;
//		this.portion_default = portion_default;
//		this.portion_amount = portion_amount;
//		this.portion_display_name = portion_display_name;
//		this.calories = calories;
//	}
//
//	public Integer getPortion_id() {
//		return portion_id;
//	}
//
//	public Integer getFood_code() {
//		return food_code;
//	}
//
//	public Integer getPortion_default() {
//		return portion_default;
//	}
//
//	public double getPortion_amount() {
//		return portion_amount;
//	}
//
//	public String getPortion_display_name() {
//		return portion_display_name;
//	}
//
//	public double getCalories() {
//		return calories;
//	}
//
//	@Override
//	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("Portion [portion_id=");
//		builder.append(portion_id);
//		builder.append(", food_code=");
//		builder.append(food_code);
//		builder.append(", portion_default=");
//		builder.append(portion_default);
//		builder.append(", portion_amount=");
//		builder.append(portion_amount);
//		builder.append(", portion_display_name=");
//		builder.append(portion_display_name);
//		builder.append(", calories=");
//		builder.append(calories);
//		builder.append("]");
//		return builder.toString();
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((portion_id == null) ? 0 : portion_id.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Portion other = (Portion) obj;
//		if (portion_id == null) {
//			if (other.portion_id != null)
//				return false;
//		} else if (!portion_id.equals(other.portion_id))
//			return false;
//		return true;
//	}
	
	

}
