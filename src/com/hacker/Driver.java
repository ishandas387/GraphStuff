package com.hacker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {

	 // Driver program 
    public static void main(String[] args) throws IOException  
    { 
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("total number of vertex");
		int vert = Integer.parseInt(br.readLine());
		Graph g = new Graph(vert); 
		
		System.out.println("number of edges");
		int numberOfEdges = Integer.parseInt(br.readLine());
		
		for(int i =0;i<numberOfEdges;i++){
			String edge = br.readLine();
			String[] split = edge.split(",");
			g.addEdge(Integer.parseInt(split[0].trim()),Integer.parseInt(split[1].trim())); 
					
		}
        // Create a sample graph 
      /*  g.addEdge(0,2); 
        g.addEdge(0,3); 
        g.addEdge(2,0); 
        g.addEdge(2,1); 
        g.addEdge(1,3); */
      
        // arbitrary source 
        int s = 2; 
      
        // arbitrary destination 
        int d = 3; 
      
       // System.out.println("Following are all different paths "); 
        //g.printAllPaths(s,d); 
        //g.printAllPaths(0);
        System.out.println(g.isCyclic());
  
    } 
} 

