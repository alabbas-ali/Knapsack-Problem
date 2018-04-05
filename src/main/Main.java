package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static final int INDIVIDUAL_SIZE = 10;
	static final int POPSIZE = 50;
	static final int NR_OF_ITERATIONS = 100;

	static final int PARENTS = 10;
	static final double MUTATION_RATE = 0.05;
	static final int ROUND_PARENT_NUM = 2;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException
	{

		List<Item> items = new ArrayList<Item>();
		double limit = 5.67;
		
		// Read the items
		for (int i = 0; i < INDIVIDUAL_SIZE; i++)
		{

		}

		Operations operations = new Operations(items, limit);
		List<Individual<Integer>> population = new ArrayList<Individual<Integer>>();

		// System.out.println("######### Create Random Population ##########");
		for (int i = 0; i < POPSIZE; i++)
		{
			Individual<Integer> individual = operations.randomCreate(INDIVIDUAL_SIZE);

			population.add(individual);
		}

		population = operations.selectBest(population, POPSIZE);
		Individual<Integer> bestInd = population.get(0);

		System.out.println("########### Start The Algorthem #########");
		for (int i = 1; i < NR_OF_ITERATIONS + 1; i++)
		{
			List<Individual<Integer>> children = new ArrayList<Individual<Integer>>();
			for (int j = 0; j < PARENTS; j++)
			{
				Individual<Integer> parent1 = operations.selectParent(population);
				Individual<Integer> parent2 = operations.selectParent(population);

				Individual<Integer> child1 = (Individual<Integer>) parent1.clone();
				Individual<Integer> child2 = (Individual<Integer>) parent2.clone();

				// Operations.onePointCrossover(child1, child2);
				// Operations.bitFlipMutation(child1, MUTATION_RATE);
				// Operations.bitFlipMutation(child2, MUTATION_RATE);

				operations.towPointCrossover(child1, child2);
				operations.shuffleMutation(child1, MUTATION_RATE);
				operations.shuffleMutation(child2, MUTATION_RATE);

				// child1.setPenalty(gOpertions.calculateIndividualPanelty(child1));
				// child1.setMonitors(gOpertions.calculateIndividualMonitors(child1));
				// child2.setPenalty(gOpertions.calculateIndividualPanelty(child2));
				// child2.setMonitors(gOpertions.calculateIndividualMonitors(child2));
				// Operations.printIndividual(" -- Adding Child Individual ", child1,
				// gOpertions.getEdgeCount());
				// Operations.printIndividual(" -- Adding Child Individual ", child2,
				// gOpertions.getEdgeCount());
				children.add(child1);
				children.add(child2);
			}

			population.addAll(children);
			population = operations.selectBest(population, POPSIZE);
			bestInd = population.get(0);

			System.out.println("###### The Bist Individual for Generation " + i + " ######");
			operations.printIndividual(bestInd);

		}

	}

}
