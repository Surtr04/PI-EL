package graphs.cfg;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

import parsing.Pair;
import parsing.PairDefRef;
import graphs.Edge;
import graphs.Graph;
import graphs.Node;

public class CFG extends Graph{
	
	private HashMap<Node, LinkedList<Pair<String, String>>> dependencies ;
	private HashMap<Node, PairDefRef<HashSet<String>, HashSet<String>>> _vars;
	private Node _start;
	private Node _stop;
	private boolean _showDefsRefs;
	
	
	public CFG(LinkedHashMap<Node, LinkedList<Edge>> graph,	HashMap<Node, LinkedList<Pair<String, String>>> dependencies) {
		super(graph);
		this._start = null;
		this._stop = null;
		this.dependencies = dependencies;
		this._showDefsRefs = false;
		this._vars = new HashMap<>();
	}


	

	public boolean isShowDefsRefs() {
		return _showDefsRefs;
	}




	public void setShowDefsRefs(boolean _showDefsRefs) {
		this._showDefsRefs = _showDefsRefs;
	}




	public CFG() {
		super();
		this.dependencies = new HashMap<Node, LinkedList<Pair<String,String>>>();
		this._start = null;
		this._stop = null;
		this._vars = new HashMap<>();
		this._showDefsRefs = false;
	}


	


	public Node get_start() {
		return _start;
	}




	public Node get_stop() {
		return _stop;
	}


	private void checkVars(Node n){
		if (!this._vars.containsKey(n)){
			PairDefRef<HashSet<String>, HashSet<String>> p = new PairDefRef<>();
			p.setDefs(new HashSet<String>());
			p.setRefs(new HashSet<String>());
			this._vars.put(n, p);
		}
	}
	
	public void addRefs(Node n, HashSet<String> vals){
		this.checkVars(n);
		this._vars.get(n).setRefs(vals);
	}
	
	public HashSet<String> getRefs(Node n){
		if (this._vars.containsKey(n)) return this._vars.get(n).getRefs(); else return new HashSet<String>();
	}
	
	public HashSet<String> getDefs(Node n){
		if (this._vars.containsKey(n)) return this._vars.get(n).getDefs(); else return new HashSet<String>();
	}
	
	public void addDef(Node n, String nome){
		this.checkVars(n);
		this._vars.get(n).getDefs().add(nome);
	}

	public void addRef(Node n, String nome){
		this.checkVars(n);
		this._vars.get(n).getRefs().add(nome);
	}
	
	public void addVar(Node n, String nome, int tipo){
		if (tipo == 0) this.addDef(n, nome); else this.addRef(n, nome);
	}
	
	public HashMap<Node, LinkedList<Pair<String, String>>> getDependencies() {
		return dependencies;
	}




	public void setDependencies(
			HashMap<Node, LinkedList<Pair<String, String>>> dependencies) {
		this.dependencies = dependencies;
	}
	
	
	
	/**
	 * Inserts a new node into the graph along with its own 
	 * list of outgoing edges and contained variables; 
	 * 
	 * @param node - the node to insert
	 * @param edges - the edges which leave the node
	 * @param variables - the variables contained in the node
	 * 
	 */
	public void insertNode(Node node, LinkedList<Edge> edges, LinkedList<Pair<String, String>> variables) {
		super.insertNode(node, edges);
		for(Pair<String, String> p : variables){
			this.insertVariableToNode(node, p);
		}
	}
	
	
	
	/**
	 * 
	 * @param node - the node which is the source of the edge to insert
	 * @param edge - the edge to insert
	 */
	public void insertEdgeToNode(Node node, Edge edge) {
		super.insertEdgeToNode(node, edge);
	}
	
	
	/**
	 * Inserts a variable of type (ID, CONTEXT) in the 
	 * dependencies of the node;
	 * 
	 * @param node the node which have the variable as its constituent
	 * @param var the variable to insert
	 * 
	 */
	public void insertVariableToNode(Node node, Pair<String, String> var) {
		if(this.dependencies.containsKey(node) && ! this.dependencies.get(node).contains(var)) {
			this.dependencies.get(node).add(var);
		}
	}


	
	
	public void updateGraph(Node n, String label, LinkedList<Node> srcs, LinkedList<Pair<String, String>> vars) {
		this.insertNode(n, new LinkedList<Edge>(), vars);
		//nova edge
		for(Node src : srcs) {
			Edge new_e = new Edge(label, n);
			this.insertEdgeToNode(src, new_e);
		}
		
	}
	
	
	
	
	
	/**
	 * Adds the nodes START and STOP to the graph
	 * and links the START node to the initial node and the
	 * sources nodes to the STOP node.
	 * 
	 * @param sources - the nodes that shall be connected to the STOP node; 
	 * 
	 */
	public void wrapCFG(LinkedList<Node> sources, String label){
		if (this._start != null || this._stop != null) return;
		
		this._start = new Node("START");
		this._stop = new Node("STOP");
		
		this.insertNode(this._start, new LinkedList<Edge>(), new LinkedList<Pair<String,String>>());
		Edge start_to_first = new Edge("", this.getGraph().entrySet().iterator().next().getKey());
		this.insertEdgeToNode(this._start, start_to_first);
		
		this.insertNode(this._stop, new LinkedList<Edge>(), new LinkedList<Pair<String,String>>());
		for(Node n : sources ){
			Edge last_to_stop = new Edge(label, this._stop);
			this.insertEdgeToNode(n, last_to_stop);
		}
	}
	
	public String toDot(String name){
		StringBuilder sb = new StringBuilder();
		for(Entry<Node, LinkedList<Edge>> n : this.getGraph().entrySet()){
			sb.append(n.getKey().getMemAddr()).append(" [label=\"").append(n.getKey().getSanitizedValue());
			if (this._showDefsRefs && this._vars.containsKey(n.getKey())) 
				sb.append(this._vars.get(n.getKey()).getDefs().toString()).append(this._vars.get(n.getKey()).getRefs().toString());
			sb.append("\"];\n");
			for(Edge e : n.getValue()){
				//sb.append('"').append(n.getKey().getSanitizedValue()).append('"');
				sb.append(n.getKey().getMemAddr());
				//if (!n.getKey().getLabel().equals("")) sb.append(" [label=\"").append(n.getKey().getLabel()).append("\"]");
				sb.append(" -> ").append(e.getTarget().getMemAddr());
				if (!e.getLabel().equals("")) sb.append(" [label=").append(e.getSanitizedLabel()).append("]");
				sb.append(";\n");
			}
		}
		return sb.toString();
	}
	
	public String toDotDigraph(String name){
		StringBuilder sb = new StringBuilder(" digraph ");
		sb.append(name).append(" {\n");
		sb.append(this.toDot(name));
		sb.append("}");
		return sb.toString();
	}

	@Override
	public String toString() {
		return "CFG [" + this.getGraph().toString() + "]" + this.dependencies.toString();
	}
	
	
	
	
	
	
	
	
	
	
}
