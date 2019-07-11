package it.polito.tdp.food.model;


public class CondimentRes implements Comparable<CondimentRes>{
	
	Condiment condiment;
	
	int sum;
	double calorie;
	
	public CondimentRes(Condiment condiment, int sum) {
		super();
		this.calorie= condiment.getCondiment_calories();
		this.condiment = condiment;
		this.sum = sum;
	}

	public Condiment getCondiment() {
		return condiment;
	}

	public double getCalorie() {
		return calorie;
	}

	public int getSum() {
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Condiment: ");
		builder.append(condiment.getDisplay_name());
		builder.append("\ncalorie: ");
		builder.append(condiment.getCondiment_calories());
		builder.append("\ncontenuto in: ");
		builder.append(sum);
		builder.append(" cibo/o\n");
		return builder.toString();
	}

	@Override
	public int compareTo(CondimentRes o) {

			double c1 = this.calorie;
			double c2 = o.getCalorie();
			
			if(c1>c2)
				return -1;
			else if(c1<c2)
				return 1;
			else
				return 0;

		}
	
	

}
