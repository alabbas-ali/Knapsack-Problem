package main;

import java.util.LinkedList;

public class Individual<T extends Integer> extends LinkedList<Integer> implements Comparable<Individual<Integer>> {

	private static final long serialVersionUID = 1L;

	private double individualWeight;
	
	public double getIndividualWeight()
	{
		return individualWeight;
	}

	public void setIndividualWeight(double individualWeight)
	{
		this.individualWeight = individualWeight;
	}

	public int getFitness()
	{
		return 0;
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
