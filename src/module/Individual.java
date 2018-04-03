package module;

import java.util.LinkedList;
import java.util.Random;

public class Individual <T extends Integer> extends LinkedList<Integer> implements Comparable<Individual<Integer>> 
{

	private static final long serialVersionUID = 1L;
	
	private double weight;
	private double survivalpoints;
	
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getSurvivalpoints() {
		return survivalpoints;
	}

	public void setSurvivalpoints(double survivalpoints) {
		this.survivalpoints = survivalpoints;
	}

	public Individual<T> randomInit(int len)
	{
		Random r = new Random();
		this.clear();
		for(int i=0; i<len; i++ )
		{
			this.add(r.nextInt(2));
		}
		return this;
	}
	
	public int getFitness()
	{
		return 0;
	}

	public int compareTo(Individual<Integer> int1) 
	{
		//System.out.println("##### Compertion Call #####");
		//System.out.println("##### individual Fitness is" + this.getFitness());
		//System.out.println("##### individual Fitness is" + int1.getFitness());
		if(this.getFitness() == int1.getFitness()){
			return 0;
		} else if(this.getFitness() > int1.getFitness()) {
			return 1;
		} else {
			return -1;
		}
	}

	
}
