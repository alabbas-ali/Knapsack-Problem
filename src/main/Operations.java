package main;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Operations {

	private static Random random = new Random();
	private static List<Item> items;
	private static double weightLimitation;

	public static void setItems(List<Item> items)
	{
		Operations.items = items;
	}

	public static void setWeightLimitation(double weightLimitation)
	{
		Operations.weightLimitation = weightLimitation;
	}

	public static Individual<Integer> createRandomIndividual(int length)
	{
		Individual<Integer> ind = new Individual<Integer>();
		ind.clear();
		for (int i = 0; i < length; i++)
		{
			ind.add(random.nextInt(2));
		}
		ind.calculateWeight(items, weightLimitation);
		ind.calculateFitness(items);
		return ind;
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

		ind1.calculateWeight(items, weightLimitation);
		ind1.calculateFitness(items);
		ind2.calculateWeight(items, weightLimitation);
		ind2.calculateFitness(items);
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

		ind1.calculateWeight(items, weightLimitation);
		ind1.calculateFitness(items);
		ind2.calculateWeight(items, weightLimitation);
		ind2.calculateFitness(items);
	}

	public static void bitFlipMutation(Individual<Integer> ind, double mutationRate)
	{
		for (int i = 0; i < ind.size(); i++)
		{
			if (random.nextDouble() <= mutationRate)
			{
				ind.set(i, ind.get(i) == 0 ? 1 : 0);
			}
		}

		ind.calculateWeight(items, weightLimitation);
		ind.calculateFitness(items);
	}

	public static void shuffleMutation(Individual<Integer> ind, double mutationRate)
	{
		for (int i = 0; i < random.nextInt(ind.size()); i++)
		{
			if (random.nextDouble() <= mutationRate)
			{
				int bit1 = random.nextInt(ind.size());
				int bit2 = random.nextInt(ind.size());
				int bit2Value = ind.get(bit2);
				ind.set(bit2, ind.get(bit1));
				ind.set(bit1, bit2Value);
			}
		}

		ind.calculateWeight(items, weightLimitation);
		ind.calculateFitness(items);
	}

	public static List<Individual<Integer>> selectBest(List<Individual<Integer>> population, int lenght)
	{
		List<Individual<Integer>> best = new LinkedList<Individual<Integer>>();
		Collections.sort(population);
		for (int i = 0; i < lenght; i++)
		{
			best.add(population.get(i));
		}
		return best;
	}

	public static Individual<Integer> selectParent(List<Individual<Integer>> population)
	{
		return population.get(random.nextInt(population.size()));
	}

	public static void printIndividual(Individual<Integer> ind)
	{
		System.out.print("The Individual Configuration [ ");
		String comma = ", ";
		for(int i = 0; i < ind.size();i++) {
			System.out.print(ind.get(i) + comma);
			if(i == ind.size() - 2) {
				comma = "";
			}
		}
		System.out.print(" ] , with fitness = " + ind.getFitness());
		System.out.println();
	}

}
