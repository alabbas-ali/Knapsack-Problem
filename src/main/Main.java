package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static final int INDIVIDUAL_SIZE = 10;
	static final int POPSIZE = 50;
	static final int NR_OF_ITERATIONS = 100;
	static final int PARENTS = 10;
	
	static final double MUTATION_RATE = 0.1;
	static final int ROUND_PARENT_NUM = 2;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException
	{
		readInputData();

		// System.out.println("######### Create Random Population ##########");
		List<Individual<Integer>> population = new ArrayList<>();
		for (int i = 0; i < POPSIZE; i++)
		{
			Individual<Integer> individual = Operations.createRandomIndividual(INDIVIDUAL_SIZE);
			population.add(individual);
		}

		population = Operations.selectBest(population, POPSIZE);
		Individual<Integer> bestInd = population.get(0);

		System.out.println("########### Start The Algorthem #########");
		for (int i = 1; i < NR_OF_ITERATIONS + 1; i++)
		{
			List<Individual<Integer>> children = new ArrayList<>();
			for (int j = 0; j < PARENTS; j++)
			{
				Individual<Integer> parent1 = Operations.selectParent(population);
				Individual<Integer> parent2 = Operations.selectParent(population);

				Individual<Integer> child1 = (Individual<Integer>) parent1.clone();
				Individual<Integer> child2 = (Individual<Integer>) parent2.clone();

				Operations.onePointCrossover(child1, child2);
				Operations.bitFlipMutation(child1, MUTATION_RATE);
				Operations.bitFlipMutation(child2, MUTATION_RATE);

				//Operations.towPointCrossover(child1, child2);
				//Operations.shuffleMutation(child1, MUTATION_RATE);
				//Operations.shuffleMutation(child2, MUTATION_RATE);

				children.add(child1);
				children.add(child2);
			}

			population.addAll(children);
			population = Operations.selectBest(population, POPSIZE);
			bestInd = population.get(0);

			System.out.println("###### The Bist Individual for Generation " + i + " ######");
			Operations.printIndividual(bestInd);
		}

	}

	private static void readInputData() throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader("resources\\input.txt"));
		List<Item> items = new ArrayList<>();
		String line = reader.readLine();
		String[] parts = line.split("\t");
		Item item;

		// Read the items
		for (int i = 0; i < INDIVIDUAL_SIZE * 2; i += 2)
		{
			item = new Item();
			item.setWeight(Double.parseDouble(parts[i]));
			// System.out.println("Weight = " + Double.parseDouble(parts[i]));
			item.setSurvivalpoints(Double.parseDouble(parts[i + 1]));
			// System.out.println("Survival points = " + Double.parseDouble(parts[i+1]));
			items.add(item);
		}

		line = reader.readLine();
		// System.out.println("WeightLimitation = " + line);
		Operations.setItems(items);
		Operations.setWeightLimitation(Double.parseDouble(line));
		reader.close();
	}

}
