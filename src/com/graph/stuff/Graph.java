package com.graph.stuff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class Graph {

	Map<Vertex, List<Vertex>> adjecentListMap = new HashMap<>();

	public Graph() {
		super();
	}

	public Graph(Map<Vertex, List<Vertex>> adjecentListMap) {
		this.adjecentListMap = adjecentListMap;
	}

	public Map<Vertex, List<Vertex>> getAdjecentListMap() {
		return adjecentListMap;
	}

	public void setAdjecentListMap(Map<Vertex, List<Vertex>> adjecentListMap) {
		this.adjecentListMap = adjecentListMap;
	}

	/**
	 * Mutation operation adding vertex to map.
	 * 
	 * @param label
	 */
	public void addVertex(String label) {
		adjecentListMap.putIfAbsent(new Vertex(label), new ArrayList<>());
	}

	public void removeVertex(String label) {
		Vertex v = new Vertex(label);
		adjecentListMap.values().stream().map(adjecencyList -> adjecencyList.remove(v)).collect(Collectors.toList());
		adjecentListMap.remove(v);

	}

	public void addEdge(String label1, String label2) {
		Vertex v1 = new Vertex(label1);
		Vertex v2 = new Vertex(label2);
		adjecentListMap.get(v1).add(v2);
		adjecentListMap.get(v2).add(v1);

	}

	public void removeEdge(String l1, String l2) {

		Vertex v1 = new Vertex(l1);
		Vertex v2 = new Vertex(l2);
		List<Vertex> list = adjecentListMap.get(v1);
		List<Vertex> list2 = adjecentListMap.get(v2);

		if (null != list) {
			list.remove(v2);
		}

		if (null != list2) {
			list.remove(v1);
		}

	}

	List<Vertex> getAdjVertices(String label) {
		return adjecentListMap.get(new Vertex(label));
	}

	// depth first search uses stack
	public void depthFirstSearch(Graph graph, String root) {

		Set<String> visited = new LinkedHashSet<String>();
		Stack<String> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			String vertex = stack.pop();
			if (!visited.contains(vertex)) {
				visited.add(vertex);
				for (Vertex v : this.getAdjVertices(vertex)) {
					stack.push(v.label);
				}

			}
		}
		visited.forEach(System.out::println);
	}
	
	//breadth first search
	public void breadthFirstSearch(Graph graph, String root){
		Set<String> visited = new LinkedHashSet<String>();
		Queue<String> queue = new LinkedList<>();
		queue.add(root);
		visited.add(root);
		while(!queue.isEmpty()){
			String vertex = queue.poll();
			for (Vertex v : this.getAdjVertices(vertex)) {
				visited.add(v.label);
				queue.add(v.label);
			}
		}
		visited.forEach(System.out::println);
	}

}
