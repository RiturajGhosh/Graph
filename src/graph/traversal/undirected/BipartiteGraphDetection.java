package graph.undirected;

import java.util.LinkedList;
import java.util.Queue;

/**
 * here is an undirected graph with n nodes, where each node is numbered between
 * 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of
 * nodes that node u is adjacent to. More formally, for each v in graph[u],
 * there is an undirected edge between node u and node v. The graph has the
 * following properties:
 * 
 * There are no self-edges (graph[u] does not contain u). There are no parallel
 * edges (graph[u] does not contain duplicate values). If v is in graph[u], then
 * u is in graph[v] (the graph is undirected). The graph may not be connected,
 * meaning there may be two nodes u and v such that there is no path between
 * them. A graph is bipartite if the nodes can be partitioned into two
 * independent sets A and B such that every edge in the graph connects a node in
 * set A and a node in set B.
 * 
 * Return true if and only if it is bipartite.</br>
 * 
 * <a href='https://leetcode.com/problems/is-graph-bipartite/'><u>link to this
 * problem in leetcode</u></a>
 * 
 * @author Rituraj
 *
 */
public class BipartiteGraphDetection {
	public boolean isBipartite(int[][] graph) {
		// instantiating col array and initiating with -1 for all col[i]
		int[] col = new int[graph.length];
		for (int i = 0; i < graph.length; i++) {
			col[i] = -1;
		}
		for (int i = 0; i < graph.length; i++) {
			if (col[i] == -1) {
				Queue<Integer> q = new LinkedList<>();
				q.add(i);
				col[i] = 1;
				// if atleast one component is not bipartite we can say the entire graph as not
				// bipartite graph, so added this below if check
				if (!bfs(i, q, graph, col)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Bipartite graph detection using bfs. returns true if it is bipartite
	 * otherwise false
	 * 
	 * @param i
	 * @param q
	 * @param graph
	 * @param col
	 * @return
	 */
	public boolean bfs(int i, Queue<Integer> q, int[][] graph, int[] col) {
		while (!q.isEmpty()) {
			int node = q.poll();
			for (int it : graph[node]) {
				if (col[it] == -1) {
					q.add(it);
					col[it] = 1 - col[node];
				} else if (col[it] == col[node]) {
					return false;
				}
			}
		}
		return true;
	}
}
