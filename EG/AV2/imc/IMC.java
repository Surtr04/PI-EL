package imc;

/**
 * @author Nuno Oliveira
 * @date 2 de Dez de 2012
 *
 */


import java.util.HashSet;
import java.util.Set;


public class IMC {

	private Set<String> states;
	private Set<String> initial_states;
	private Set<String> goal_states;
	private Set<Transition> transitions;
	
	
	public IMC() {
		this.states = new HashSet<String>();
		this.initial_states = new HashSet<String>();
		this.goal_states = new HashSet<String>();
		this.transitions = new HashSet<Transition>();
	}


	/**
	 * @param states the set of states in the IMC
	 * @param transitions the set of both markovian and interactive transitions in the IMC 
	 * @param initial_state the initial state of the IMC
	 */
	public IMC(Set<String> states, Set<String> initial_states, Set<Transition> transitions, Set<String> goal_states) {
		super();
		this.states = states;
		this.initial_states = initial_states;
		this.transitions = transitions;
		this.goal_states = goal_states;
	}
	
	/**
	 * 
	 * @param imc the imc to "clone"
	 */
	public IMC(IMC imc){
		this.states = new HashSet<String>();
		for(String s : imc.getStates()){
			this.states.add(s);
		}
		
		this.initial_states = new HashSet<String>();
		for(String s : imc.getInitial_states()){
			this.initial_states.add(s);
		}
		
		this.goal_states = new HashSet<String>();
		for(String s : imc.getGoal_states()){
			this.goal_states.add(s);
		}
		
		this.transitions = new HashSet<Transition>();
		for(Transition t : imc.getTransitions()){
			this.transitions.add(t.copy());
		}
	}


	

	
	/**
	 * @return the states
	 */
	public Set<String> getStates() {
		return states;
	}


	/**
	 * @param states the states to set
	 */
	public void setStates(Set<String> states) {
		this.states = states;
	}
	
	
	
	
	
	/**
	 * @return the initial_states
	 */
	public Set<String> getInitial_states() {
		return initial_states;
	}


	/**
	 * @param initial_states the initial_states to set
	 */
	public void setInitial_states(Set<String> initial_states) {
		this.initial_states = initial_states;
	}


	/**
	 * @return the goal_states
	 */
	public Set<String> getGoal_states() {
		return goal_states;
	}


	/**
	 * @param goal_states the goal_states to set
	 */
	public void setGoal_states(Set<String> goal_states) {
		this.goal_states = goal_states;
	}


	/**
	 * @return the transitions
	 */
	public Set<Transition> getTransitions() {
		return transitions;
	}


	/**
	 * @param transitions the transitions to set
	 */
	public void setTransitions(Set<Transition> transitions) {
		this.transitions = transitions;
	}


	
	/**
	 * @param t the new transition to add
	 */
	public void addTransition(Transition t){
		this.transitions.add(t);
	}
	
	/**
	 * @param s the state identifier to add as initial state 
	 */
	public void addInitialState(String s){
		this.initial_states.add(s);
		this.states.add(s);
	}
	
	
	/**
	 * @param s the state identifier to add as goal state
	 */
	public void addGoalState(String s){
		this.goal_states.add(s);
		this.states.add(s);
	}
	
	
	public void addState(String s){
		this.states.add(s);
	}
	
	
	
	
	
	
	
		
	
	
	
	/**
	 * Returns a String version of the IMC in a dot compliant format.
	 * 
	 * @return string version of the IMC in a dot compliant format
	 */
	public String toDotFormat() {
		StringBuffer sb = new StringBuffer();
		sb.append("digraph \"imc\" { \n").
		append("graph [	fontname = \"Helvetica-Oblique\", fontsize = 10]; \n").
		append("edge [	fontname = \"Helvetica-Oblique\", fontsize = 10]; \n").
		append("node [	shape=circle, fontname = \"Helvetica-Oblique\", fontsize = 10] ; \n");
		for(String s : initial_states){
			sb.append("\""+ s +"\" [shape=circle, style=filled, fillcolor=green] ; \n");
		}
		for(String s : goal_states){
			sb.append("\""+ s +"\" [shape=circle, style=filled, fillcolor=red] ; \n");
		}
		for(Transition t : this.transitions) {
			if(t instanceof MarkovianTransition){
				sb.append("\"" + t.getStart_state() + "\"").
					append(" -> ").
						append("\"" + t.getFinal_state() + "\" ").
							append("[label = \"" + ((MarkovianTransition)t).getRate() + "\"] ; \n");
				
			}
			else {
				if(t instanceof InteractiveTransition){
					sb.append("\"" + t.getStart_state() + "\"").
						append(" -> ").
							append("\"" + t.getFinal_state() + "\" ").
								append("[label = \"" + ((InteractiveTransition)t).getAction() + "\" style=dashed] ; \n");
					
				}
				
			}
		}
		
		sb.append("}");
		return sb.toString();
	}
	
	

	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "IMC [total states: " + this.states.size() + "\ninitial states: " + this.initial_states.size() + ", \ngoal states: "
				+ this.goal_states.size() + ", \nnumber of transitions: " + this.transitions.size() + "\ntransisions: " + this.transitions + "]";
	}

	
	
	
	
	
	
	//UTILITIES
	
	
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((goal_states == null) ? 0 : goal_states.hashCode());
		result = prime * result
				+ ((initial_states == null) ? 0 : initial_states.hashCode());
		result = prime * result
				+ ((transitions == null) ? 0 : transitions.hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof IMC))
			return false;
		IMC other = (IMC) obj;
		if (goal_states == null) {
			if (other.goal_states != null)
				return false;
		} else if (!goal_states.equals(other.goal_states))
			return false;
		if (initial_states == null) {
			if (other.initial_states != null)
				return false;
		} else if (!initial_states.equals(other.initial_states))
			return false;
		if (transitions == null) {
			if (other.transitions != null)
				return false;
		} else if (!transitions.equals(other.transitions))
			return false;
		return true;
	}
	

}
