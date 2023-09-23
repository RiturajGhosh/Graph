package graph.undirected.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Breadth first search
 * 
 * @author Rituraj
 *
 */
public class Traversal {

	/**
	 * This is bfs algorithm to traverse a graph
	 * 
	 * @param n
	 * @param adj
	 * @return list of traversed nodes
	 */
	public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj) {
		List<Integer> output = new ArrayList<>();
		boolean[] vis = new boolean[adj.size()];
		for (int i = 0; i < n; i++) {
			if (!vis[i]) {
				Queue<Integer> queue = new LinkedList<>();
				queue.add(i);
				vis[i] = true;
				while (!queue.isEmpty()) {
					int node = queue.poll();
					output.add(node);
					for (int adjNode : adj.get(i)) {
						if (!vis[i]) {
							queue.add(adjNode);
							vis[adjNode] = true;
						}
					}
				}
			}
		}
		return output;
	}

	/**
	 * Dfs traversal algorithm to traverse a graph
	 * 
	 * @param n
	 * @param adj
	 * @return list of traversed nodes
	 */
	public static List<Integer> dfsTraversal(int n, List<List<Integer>> adj) {
		boolean[] vis = new boolean[n];
		List<Integer> output = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (!vis[i]) {
				dfs(i, output, vis, adj);
			}
		}
		return output;
	}

	private static void dfs(int i, List<Integer> output, boolean[] vis, List<List<Integer>> adj) {
		output.add(i);
		vis[i] = true;
		for (int adjNode : adj.get(i)) {
			if (!vis[adjNode]) {
				dfs(adjNode, output, vis, adj);
			}
		}
	}
}
