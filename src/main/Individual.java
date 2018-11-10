package main;

import java.util.LinkedList;
import java.util.List;

public class Individual<T> extends LinkedList<Integer> implements Comparable<Individual<Integer>> {

	private static final long serialVersionUID = 1L;
	private int weight = 0;
	private int fitness;
	
	public void calculateFitness(List<Item> items) {
		this.fitness = 0;
		for (int i = 0; i < this.size(); i++)
		{
			this.fitness += this.get(i) * items.get(i).getSurvivalpoints();
		}
	}
	
	public void calculateWeight(List<Item> items, double limit) {
		this.weight = 0;
		for (int i = 0; i < this.size(); i++)
		{
			this.weight += this.get(i) * items.get(i).getWeight();
			if(this.weight > limit) {
				this.set(i, 0);
				this.weight -= items.get(i).getWeight();
			}
		}
	}

	public int getFitness()
	{
		return fitness;
	}

	public int getWeight()
	{
		return weight;
	}

	public int compareTo(Individual<Integer> individual)
	{
		// System.out.println("##### Compare Call #####");
		// System.out.println("##### individual Fitness is" + this.getFitness());
		// System.out.println("##### individual Fitness is" + int1.getFitness());
		if (this.getFitness() == individual.getFitness()) {
			return 0;
		} else if (this.getFitness() < individual.getFitness()) {
			return 1;
		} else {
			return -1;
		}
	}
}
