package algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Graph {
	public static final double INFINITY = Double.MAX_VALUE;
	private Map<String, Vertex> vertexMap = new HashMap<String, Vertex>();

	/**
	 * Add a new edge to the graph.
	 */
	public void addEdge(String sourceName, String destName, double cost) {
		Vertex v = getVertex(sourceName);
		Vertex w = getVertex(destName);
		v.adj.add(new Edge(w, cost));
	}

	/**
	 * If vertexName is not present, add it to vertexMap. In either case, return the
	 * Vertex.
	 */
	private Vertex getVertex(String vertexName) {
		Vertex v = vertexMap.get(vertexName);
		if (v == null) {
			v = new Vertex(vertexName);
			vertexMap.put(vertexName, v);
		}
		return v;

	}

	/**
	 * Initializes the vertex output info prior to running any shortest path
	 * algorithm.
	 */
	private void clearAll() {
		for (Vertex v : vertexMap.values())
			v.reset();
	}

	public void dijkstra(String startName) {
		clearAll();
		PriorityQueue<Double> pq= new PriorityQueue<>();
		for(Vertex v: this.vertexMap.values()) {
			if(!v.name.equals(startName)) {
				pq.add(v.dist);
				
			}else {
				v.dist=0;
			}
			while(pq.size()>0) {
				Double min= pq.poll();
				v.dist=min;
				for(Edge e: v.adj) {
					Double tempDist=min+e.cost;
					if(tempDist<v.dist) {
						v.dist=tempDist;
					
					}
					
				}
				
			}
		}

	}

	// uppgift 7a
	// Compute the subgraph of this graph where all nodes are
	// reacheable from startNode within at most maxDist distance.
	// Nodes at longer distance are omitted.
	public Graph computeSubGraph(String startNode, double maxDist) {
		// the algo is adding info to every vertex in the graph, dist and prev for ex
		dijkstra(startNode);
		Graph g = new Graph();
		// add startNode to graph g
		g.getVertex(startNode);
		for (Vertex v : this.vertexMap.values()) {
			// info in dist is provided from algorithm above, dist gives us the cost from
			// startNode to v
			if (v.dist <= maxDist) {
				// when we know that total dist from startNode to v does'nt exceed limit check
				// the edge from v to next node
				// if cost does'nt exceed limit add that edge to graph g
				for (Edge e : v.adj) {
					if (e.cost <= maxDist) {
						g.addEdge(v.name, e.dest.name, e.cost);

					}

				}

			}

		}
		return g;

	}

	// uppgift 7b
	// Compute a list of all nodes at the exact
	// unweighted distance d from startNode
	public List<String> nodesAtUWD(String startNode, int d) {

		dijkstra(startNode);
		List<String> list = new ArrayList<>();
		for (Vertex v : this.vertexMap.values()) {
			// v is startNode
			// should not return startNode itself if d==0
			if (v.name.equals(startNode) && d == 0) {
				list.add(v.name);
				return list;
			}
			if (v.prev.name.equals(startNode) && d == 1) {
				list.add(v.name);

			}
			if (v.prev.prev.name.equals(startNode) && d == 2) {
				list.add(v.name);

			}
			if (v.prev.prev.prev.equals(startNode) && d == 3) {
				list.add(v.name);

			}

		}

		return list;

	}

	public static void main(String args[]) {
		Graph graph = new Graph();

	}

}
