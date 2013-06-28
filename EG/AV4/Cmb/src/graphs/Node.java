package graphs;

public class Node {
	private String _value;
	private String _label;
	private TipoNode _tipo;
	private boolean _ifEnds;
	
	public Node(String value, TipoNode t, String label) {
		super();
		this._value = value;
		this._label = label;
		this._tipo = t;
		this._ifEnds = false;
	}
	
	public Node(String value, TipoNode t) {
		this(value, t, "");
	}

	public Node(String value) {
		this(value, TipoNode.DESCONHECIDO, "");
	}
	
	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public TipoNode getTipo(){
		return this._tipo;
	}
	
	public String getValue() {
		return _value;
	}
	
	public String getSanitizedValue(){
		return this._value.replace("\"", "\\\"");
	}

	public void setValue(String value) {
		this._value = value;
	}


	
	
	@Override
	public String toString() {
		return _value;
	}

	
	public int getMemAddr(){return System.identityHashCode(this);}

	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}*/


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (_value == null) {
			if (other._value != null)
				return false;
		} else if (!_value.equals(other._value))
			return false;
		return true;
	}


	public String getLabel() {
		return _label;
	}


	public void setLabel(String label) {
		this._label = label;
	}

	public boolean isIfEnds() {
		return _ifEnds;
	}


	public void setIfEnds(boolean ifEnds) {
		this._ifEnds = ifEnds;
	}

}
