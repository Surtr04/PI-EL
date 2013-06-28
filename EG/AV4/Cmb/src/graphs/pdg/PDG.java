package graphs.pdg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Map.Entry;

import parsing.Pair;

import graphs.Edge;
import graphs.Graph;
import graphs.Node;
import graphs.TipoNode;
import graphs.cfg.CFG;

public class PDG extends Graph {
	private Node _entry;
	private CFG _cfg;
	private Graph _flows;
	
	
	public PDG(CFG c){
		this._cfg = c;
		this._flows = new Graph();
		Node start = this._cfg.get_start();
		Stack<Node> stck = new Stack<>();
		this._entry = new Node("Entry", TipoNode.DESCONHECIDO);
		this.insertNode(this._entry, new LinkedList<Edge>());
		stck.push(this._entry);
		for(Edge e : this._cfg.getGraph().get(start)){
			this.trataCD(e.getTarget(), stck);
			this.trataFD(e.getTarget(), new HashMap<String, HashSet<Node>>());
		}
	}
	
	public PDG(LinkedHashMap<Node, LinkedList<Edge>> graph) {
		super(graph);
		// TODO Auto-generated constructor stub
	}

	public PDG() {
		// TODO Auto-generated constructor stub
	}

	private HashSet<Node> getVars(String s, HashMap<String, HashSet<Node>> vars){
		if (vars.containsKey(s)) return vars.get(s); else return new HashSet<Node>();
	}
	private Node trataFD(Node t, HashMap<String, HashSet<Node>> defs, Stack<HashMap<String, HashSet<Node>>> extra){
		return this.trataFD(t, defs, false, extra);
	}
	private Node trataFD(Node t, HashMap<String, HashSet<Node>> defs){
		return this.trataFD(t, defs, false, new Stack<HashMap<String, HashSet<Node>>>());
	}
	private Node trataFD(Node t, HashMap<String, HashSet<Node>> defs, boolean up){
		return this.trataFD(t, defs, up, new Stack<HashMap<String, HashSet<Node>>>());
	}
	private void simpleRecur(Node t, Node n, HashMap<String, HashSet<Node>> defs){
		Edge new_e;
		for(String s : this._cfg.getRefs(n)){
			for(Node ne : this.getVars(s, defs)){
				new_e = new Edge("", n);
				this._flows.insertEdgeToNode(ne, new_e);
			}
		}
		if (t == n) return;
		for (Edge e : this._cfg.getGraph().get(n))
			this.simpleRecur(t, e.getTarget(), defs);
	}
	private Node trataFD(Node t, HashMap<String, HashSet<Node>> defs, boolean up, Stack<HashMap<String, HashSet<Node>>> extra){
		Edge new_e;
		if (this._flows.getGraph().containsKey(t)){ //It's a While
			this.simpleRecur(t, this._cfg.getGraph().get(t).get(0).getTarget(), defs);
			return t;
		} 
		this._flows.insertNode(t, new LinkedList<Edge>());
		
		for(String s : this._cfg.getRefs(t)){
			for(Node n : this.getVars(s, defs)){
				new_e = new Edge("", t);
				this._flows.insertEdgeToNode(n, new_e);
			}
		}
		
		for(String s : this._cfg.getDefs(t)){
			if (!defs.containsKey(s)) defs.put(s, new HashSet<Node>());
			defs.get(s).clear();
			defs.get(s).add(t);
		}
		
		
		if (t.isIfEnds()){
			if (up) return t;
			for (Entry<String, HashSet<Node>> s : extra.pop().entrySet()){
				if (!defs.containsKey(s.getKey())) defs.put(s.getKey(), new HashSet<Node>());
				defs.get(s.getKey()).addAll(s.getValue());
			}
		}
			
		LinkedList<Edge> es = this._cfg.getGraph().get(t);
		HashMap<String, HashSet<Node>> d1;
		Node n;
		switch(t.getTipo()){
			case IF:
				d1 = this.getDefsClone(defs);
				this.trataFD(es.get(0).getTarget(), defs, true);
				extra.add(defs);
				this.trataFD(es.get(1).getTarget(), d1, extra);
				break;
			case WHILE:
				d1 = this.getDefsClone(defs);
				this.trataFD(es.get(0).getTarget(), defs, true);
				for (Entry<String, HashSet<Node>> s : d1.entrySet())
					defs.get(s.getKey()).addAll(s.getValue());
				this.trataFD(es.get(1).getTarget(), defs, extra);
				break;
			case DESCONHECIDO: break;
			default: 
				if (es.size() > 0) this.trataFD(es.get(0).getTarget(), defs, up, extra);
				break;
		}
		return t;
		
	}
	
	private HashMap<String, HashSet<Node>> getDefsClone(HashMap<String, HashSet<Node>> defs){
		HashMap<String, HashSet<Node>> nd = new HashMap<>();
		for(Entry<String, HashSet<Node>> e: defs.entrySet())
			nd.put(e.getKey(), (HashSet<Node>)e.getValue().clone());
		return nd;
	}
	
	private void trataCD(Node t, Stack<Node> sup){
		Stack<Node> clone = (Stack<Node>) sup.clone();
		if (this.getGraph().containsKey(t) || t.getTipo() == TipoNode.DESCONHECIDO) return;
		this.insertNode(t, new LinkedList<Edge>());
		Edge new_e = new Edge("", t);
		this.insertEdgeToNode(clone.peek(), new_e);
		
		if (t.isIfEnds()) clone.pop();
		if (t.getTipo() == TipoNode.IF || t.getTipo() == TipoNode.WHILE) clone.push(t);
		
		for(Edge e : this._cfg.getGraph().get(t)){
			if (e.getLabel().equals("false") && t.getTipo() == TipoNode.WHILE) clone.pop(); 
			this.trataCD(e.getTarget(), clone);
		}
		
	}


	
	public String toDot(String name){
		StringBuilder sb = new StringBuilder();
		for(Entry<Node, LinkedList<Edge>> n : this.getGraph().entrySet()){
			sb.append(n.getKey().getMemAddr()).append(" [label=\"").append(n.getKey().getSanitizedValue()).append("\"];\n");
			for(Edge e : n.getValue()){
				//sb.append('"').append(n.getKey().getSanitizedValue()).append('"');
				sb.append(n.getKey().getMemAddr());
				//if (!n.getKey().getLabel().equals("")) sb.append(" [label=\"").append(n.getKey().getLabel()).append("\"]");
				sb.append(" -> ").append(e.getTarget().getMemAddr());
				if (!e.getLabel().equals("")) sb.append(" [label=").append(e.getSanitizedLabel()).append("]");
				sb.append(";\n");
			}
		}
		for(Entry<Node, LinkedList<Edge>> n : this._flows.getGraph().entrySet()){
			for(Edge e : n.getValue()){
				//sb.append('"').append(n.getKey().getSanitizedValue()).append('"');
				sb.append(n.getKey().getMemAddr());
				//if (!n.getKey().getLabel().equals("")) sb.append(" [label=\"").append(n.getKey().getLabel()).append("\"]");
				sb.append(" -> ").append(e.getTarget().getMemAddr()).append(" [style=dotted]");
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
}
