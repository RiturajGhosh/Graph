package graph;

import java.io.IOException;
import java.util.List;

import graph.undirected.traversal.Traversal;

/**
 * Class containing the main method </br>
 * <b>I have consistently followed zero based indexing</b>
 * 
 * @author Rituraj
 *
 */
public class Main {

	/**
	 * Main method
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Graph graph = new Graph();
		List<List<Integer>> adjacencyList = graph.takeInputToFormGraph();
		Traversal.bfsTraversal(3, adjacencyList).forEach(e -> System.out.println(e));
		Traversal.dfsTraversal(3, adjacencyList).forEach(e -> System.out.println(e));
	}

}
