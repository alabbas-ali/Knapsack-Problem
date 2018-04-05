package main;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Operations {

	private static Random random = new Random();
	private static List<Item> items;
	private static double weightLimitation;

	public static void bitFlipMutation(Individual<Integer> ind, double prob)
	{
		for (int i = 0; i < ind.size(); i++)
		{
			if (random.nextDouble() <= prob)
			{
				ind.set(i, ind.get(i) == 0 ? 1 : 0);
			}
		}
	}

	public static void shuffleMutation(Individual<Integer> ind, double prob)
	{
		for (int i = 0; i < random.nextInt(ind.size()); i++)
		{
			if (random.nextDouble() <= prob)
			{
				int bit1 = random.nextInt(ind.size());
				int bit2 = random.nextInt(ind.size());
				int bit2Value = ind.get(bit2);
				ind.set(bit2, ind.get(bit1));
				ind.set(bit1, bit2Value);
			}
		}
	}

	public static void onePointCrossover(Individual<Integer> ind1, Individual<Integer> ind2)
	{
		int splitPoint = random.nextInt(ind1.size());
		for (int i = splitPoint; i < ind1.size(); i++)
		{
			int swap = ind1.get(i);
			ind1.set(i, ind2.get(i));
			ind2.set(i, swap);
		}
	}

	public static void towPointCrossover(Individual<Integer> ind1, Individual<Integer> ind2)
	{
		int startPoint = random.nextInt(ind1.size());
		int endPoint = startPoint + random.nextInt(ind1.size() - startPoint);
		for (int i = startPoint; i < endPoint; i++)
		{
			int swap = ind1.get(i);
			ind1.set(i, ind2.get(i));
			ind2.set(i, swap);
		}
	}

	public static List<Individual<Integer>> selectBest(List<Individual<Integer>> population, int len)
	{
		List<Individual<Integer>> best = new LinkedList<Individual<Integer>>();
		Collections.sort(population);
		for (int i = 0; i < len; i++)
		{
			best.add(population.get(i));
		}
		return best;
	}

	public static Individual<Integer> createRandomIndividual(int length)
	{
		Individual<Integer> ind = new Individual<Integer>();
		ind.clear();
		for (int i = 0; i < length; i++)
		{
			int v = random.nextInt(2);
			if (v > 0) {
				ind.weight += items.get(i).getWeight();
				if (ind.weight < weightLimitation) {
					ind.add(v);
				} else {
					ind.weight -= items.get(i).getWeight();
					ind.add(0);
				}
			} else {
				ind.add(v);
			}
		}
		return ind;
	}
	
	public static void calculateIndividualFitness(Individual<Integer> ind) {
		ind.calculateFitness(items);
	}

	public static Individual<Integer> selectParent(List<Individual<Integer>> population)
	{
		return population.get(random.nextInt(population.size()));
	}

	public static void printIndividual(Individual<Integer> ind)
	{
		System.out.println(" ");
	}

	public static List<Item> getItems()
	{
		return items;
	}

	public static void setItems(List<Item> items)
	{
		Operations.items = items;
	}

	public static double getWeightLimitation()
	{
		return weightLimitation;
	}

	public static void setWeightLimitation(double weightLimitation)
	{
		Operations.weightLimitation = weightLimitation;
	}

}
