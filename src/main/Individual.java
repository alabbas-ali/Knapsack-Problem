package main;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Individual<T extends Integer> extends LinkedList<Integer> implements Comparable<Individual<Integer>> {

	private static final long serialVersionUID = 1L;
	public int weight = 0;
	private int fitness;
	private int penalty;
	
	public void calculateFitness(List<Item> items) {
		fitness = 0;
		for (int i = 0; i < this.size(); i++)
		{
			fitness += this.get(i) * items.get(i).getSurvivalpoints();
		}
	}
	
//	public void calculatePenalty(List<Item> items) {
//		fitness = 0;
//		for (int i = 0; i < this.size(); i++)
//		{
//			fitness += sum(w) * abs(sum(x * w) - W);
//		}
//	}

	public int getFitness()
	{
		return fitness;
	}
	

	public int getPenalty()
	{
		return penalty;
	}

	public int compareTo(Individual<Integer> int1)
	{
		// System.out.println("##### Compare Call #####");
		// System.out.println("##### individual Fitness is" + this.getFitness());
		// System.out.println("##### individual Fitness is" + int1.getFitness());
		if (this.getFitness() == int1.getFitness())
		{
			return 0;
		} else if (this.getFitness() > int1.getFitness())
		{
			return 1;
		} else
		{
			return -1;
		}
	}
}
