package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graph {

	/**
	 * We wil be given input as: n, m -> n: number of nodes, m: number of edges
	 * following next m number of lines will be: u,v -> this means there exists an
	 * edge between u and v. For undirected graph this means there also exists an
	 * edge between v and u, but for directed graph it is not.</br>
	 * ex:</br>
	 * 3, 2 <span> means, n=3, m=2, and following 2 lines will be the nodes adjacent
	 * to each other</span></br>
	 * 1, 3</br>
	 * 2, 3
	 * 
	 * @param n             denotes number of nodes present in the graph
	 * @param m             denotes number of edges in the graph
	 * @param adjacentNodes denotes a list which will contain the given pairs of
	 *                      adjacent nodes as input, furthermore each pair of
	 *                      adjacent nodes are stored in a list as well. So the data
	 *                      structure for adjacentNodes is List of List of Integer
	 *
	 * @return list of list of integer where outerList.get(i) returns a inner list
	 *         which denotes all the nodes adjacent to node i
	 */
	public List<List<Integer>> representInAdjacencyList(int n, int m, ArrayList<ArrayList<Integer>> adjacentNodes) {
		// Inistantiating the adjacency list
		List<List<Integer>> adjacencyList = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			adjacencyList.add(new ArrayList<Integer>());
		}
		// Inserting the adjacent nodes in the adjacency list
		// As for undirected graph if there exists an edge between a->b means there also
		// exists one edge between b->a
		for (int i = 0; i < m; i++) {
			adjacencyList.get(adjacentNodes.get(i).get(0)).add(adjacentNodes.get(i).get(1));
			adjacencyList.get(adjacentNodes.get(i).get(1)).add(adjacentNodes.get(i).get(0));
		}
		return adjacencyList;
	}

	public List<List<Integer>> takeInputToFormGraph() {
		int n;
		int m;
		ArrayList<ArrayList<Integer>> pairList = new ArrayList<>();
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter value of n");
			n = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter value of m");
			m = scanner.nextInt();
			for (int i = 0; i < m; i++) {
				ArrayList<Integer> pair = new ArrayList<>();
				for (int j = 0; j < 2; j++) {
					System.out.println("Enter " + (i + 1) + " th pair's " + (j + 1) + " th element");
					pair.add(scanner.nextInt());
				}
				pairList.add(pair);
			}
		}
		return representInAdjacencyList(n, m, pairList);

	}
}
