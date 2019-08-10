package com.graph.stuff;

public class MainGraph {

	public static void main(String[] args) {
		    Graph graph = new Graph();
		    graph.addVertex("Bob");
		    graph.addVertex("Alice");
		    graph.addVertex("Mark");
		    graph.addVertex("Rob");
		    graph.addVertex("Maria");
		    graph.addEdge("Bob", "Alice");
		    graph.addEdge("Bob", "Rob");
		    graph.addEdge("Alice", "Mark");
		    graph.addEdge("Rob", "Mark");
		    graph.addEdge("Alice", "Maria");
		    graph.addEdge("Rob", "Maria");

		    
		    graph.depthFirstSearch(graph, "Alice");
		//    graph.breadthFirstSearch(graph, "Alice");
		    
	}

	
}
