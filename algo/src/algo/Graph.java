package algo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph { 
	 public static final double INFINITY = Double.MAX_VALUE; 
	 private Map<String,Vertex> vertexMap = new HashMap<String,Vertex>( ); 
	 /** 
	 * Add a new edge to the graph. 
	 */ 
	 public void addEdge( String sourceName, String destName, 
	 double cost ) 
	 { 
	 Vertex v = getVertex( sourceName ); 
	 Vertex w = getVertex( destName ); 
	 v.adj.add( new Edge( w, cost ) ); 
	 } 
	 /** 
	 * If vertexName is not present, add it to vertexMap. 
	 * In either case, return the Vertex. 
	 */ 
	 private Vertex getVertex( String vertexName ) { 
	 Vertex v = vertexMap.get( vertexName ); 
	 if( v == null ) {
	 v = new Vertex( vertexName ); 
	 vertexMap.put( vertexName, v ); 
	 }
	 return v; 
	 
	 } 
	 
	 /** 
	 * Initializes the vertex output info prior to running 
	 * any shortest path algorithm. 
	 */ 
	 private void clearAll( ) { 
	 for( Vertex v : vertexMap.values( ) ) 
	 v.reset( ); 
	 }
	 
	 public void dijkstra( String startName ){
		clearAll();
		//TODO- this algo 
		 
	 } 
	 
	 // uppgift 7a 
	 // Compute the subgraph of this graph where all nodes are 
	 // reacheable from startNode within at most maxDist distance. 
	 // Nodes at longer distance are omitted.  
	 public Graph computeSubGraph(String startNode,double maxDist) {
		 //changes this graph so that shortes path from startNode to
		 //every other node in graph with shortest edges 
		 dijkstra(startNode);
		 Graph g= new Graph();
		 g.getVertex(startNode);
		 for(Vertex v: this.vertexMap.values()) {
			for(Edge e: v.adj) {
				if(e.cost<=maxDist) {
					g.addEdge(v.name, e.dest.name, e.cost);
					
				}
				
			}
		 }
		 
	 }
	 // uppgift 7b 
	 // Compute a list of all nodes at the exact 
	 // unweighted distance d from startNode 
	 public List<String> nodesAtUWD(String startNode,int d){}
	} 
