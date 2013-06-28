package graphs;

import java.util.LinkedHashMap;
import java.util.LinkedList;


public class Graph {
	private LinkedHashMap<Node, LinkedList<Edge>> graph ; 
	
	
	
	public Graph(LinkedHashMap<Node, LinkedList<Edge>> graph) {
		super();
		this.graph = graph;
	}


	public Graph() {
		super();
		this.graph = new LinkedHashMap<Node, LinkedList<Edge>>();
	}


	public LinkedHashMap<Node, LinkedList<Edge>> getGraph() {
		return graph;
	}


	public void setGraph(LinkedHashMap<Node, LinkedList<Edge>> graph) {
		this.graph = graph;
	}


	
	
	/**
	 * Adds a new Node (if not already added) into the 
	 * graph structure with its list of outgoing edges. 
	 * 
	 * @param node the node to insert if not existing
	 * @param edges the list of outgoing edges
	 * 
	 */
	public void  insertNode(Node node, LinkedList<Edge> edges) {
		if(! this.graph.containsKey(node)) {
			this.graph.put(node, edges) ;
		}
	}
	
	
	/**
	 * Inserts an edge (if it doesn't exist) into the graph 
	 * structure and which source node is the provided one.
	 * 
	 * In case the node does not exist in the graph, then it
	 * is automatically created.
	 *  
	 * @param node the node that is source for the edge
	 * @param edge the edge to insert
	 *
	 */
	public void insertEdgeToNode(Node node, Edge edge) {
		if(this.graph.containsKey(node) && ! this.graph.get(node).contains(edge)){
			this.graph.get(node).add(edge);
		}
		else {
			LinkedList<Edge> edges = new LinkedList<Edge>();
			edges.add(edge);
			this.insertNode(node, edges);
		} 
	}
	
	
	
	
	


	@Override
	public String toString() {
		return "Graph :" + graph ;
	}
	
	
	
	
	
	
	
	
}
