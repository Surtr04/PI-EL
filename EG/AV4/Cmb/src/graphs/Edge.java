package graphs;

public class Edge {
	private String _label;
	private Node _target;
	
	
	public Edge(String label, Node target) {
		super();
		this._label = label;
		this._target = target;
		
	}


	public Edge() {
		super();
		this._label = "";
		this._target = new Node();
	}


	
	
	public String getLabel() {
		return _label;
	}

	public String getSanitizedLabel(){
		return this._label.replace("\"", "\\\"");
	}
	

	public void setLabel(String label) {
		this._label = label;
	}


	public Node getTarget() {
		return _target;
	}


	public void setTarget(Node target) {
		this._target = target;
	}


	@Override
	public String toString() {
		return "--- " + _label + " --->" + _target ;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_label == null) ? 0 : _label.hashCode());
		result = prime * result + ((_target == null) ? 0 : _target.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (_label == null) {
			if (other._label != null)
				return false;
		} else if (!_label.equals(other._label))
			return false;
		if (_target == null) {
			if (other._target != null)
				return false;
		} else if (!_target.equals(other._target))
			return false;
		return true;
	}


		
	
	
	
	
	
	
	
	
	
}
