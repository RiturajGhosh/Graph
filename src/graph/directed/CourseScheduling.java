package graph.directed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * <b> Cycle detection algorithm</b></br>
 * 
 * There are a total of numCourses courses you have to take, labeled from 0 to
 * numCourses - 1. You are given an array prerequisites where prerequisites[i] =
 * [ai, bi] indicates that you must take course bi first if you want to take
 * course ai.
 * 
 * For example, the pair [0, 1], indicates that to take course 0 you have to
 * first take course 1. Return true if you can finish all courses. Otherwise,
 * return false.
 * 
 * 
 * 
 * @author Rituraj
 *
 */
public class CourseScheduling {
	/*
	 * The thought process is if the courses and their dependency to each other is
	 * represented by a graph, we should get an topo sorted result in order to cover
	 * all the courses. so, if a graph can not have a topo sorted result then we can
	 * say that one can not finish all the courses, so our point of observation is
	 * we have to find out the graphs for which we can not achieve the topo sorted
	 * result, which is if a graph is cyclic then we can not find its topo sorting,
	 * so ultimately we will find if the given graph has a cycle or not, here
	 * prerequisutes[a1, bi] suggests there is an edge between bi to ai
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, ArrayList<Integer>> adjList = constructAdjList(numCourses, prerequisites);
		boolean[] visited = new boolean[numCourses];
		boolean[] dfsV = new boolean[numCourses];
		for (int i = 0; i < numCourses; i++) {
			if (!visited[i] && dfs(i, adjList, visited, dfsV)) {
				return false;
			}
		}
		return true;
	}

	private Map<Integer, ArrayList<Integer>> constructAdjList(int num, int[][] pReq) {
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		for (int i = 0; i < pReq.length; i++) {
			if (!map.containsKey(pReq[i][1])) {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(pReq[i][0]);
				map.put(pReq[i][1], list);
			} else {
				ArrayList<Integer> list = map.get(pReq[i][1]);
				list.add(pReq[i][0]);
				map.put(pReq[i][1], list);
			}
		}
		return map;
	}

	/**
	 * Return true if the graph has cycle else false
	 * 
	 * @param node
	 * @param adjList
	 * @param visited
	 * @param dfsV
	 * @return
	 */
	public boolean dfs(int node, Map<Integer, ArrayList<Integer>> adjList, boolean[] visited, boolean[] dfsV) {
		visited[node] = true;
		dfsV[node] = true;
		if (adjList.containsKey(node) && adjList.get(node) != null) {
			for (Integer it : adjList.get(node)) {
				if (!visited[it]) {
					if (dfs(it, adjList, visited, dfsV)) {
						return true;
					}
				} else if (dfsV[it]) {
					return true;
				}
			}
		}
		dfsV[node] = false;
		return false;
	}
}
