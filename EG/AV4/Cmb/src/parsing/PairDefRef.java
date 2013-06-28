package parsing;


public class PairDefRef<FIRST, SECOND> extends Pair<FIRST, SECOND> {
	public FIRST getDefs() {
		return this.fst();
	}


	/**
	 * @param first the first to set
	 */
	public void setDefs(FIRST defs) {
		this.setFirst(defs);
	}


	/**
	 * @return the second
	 */
	public SECOND getRefs() {
		return this.snd();
	}


	/**
	 * @param second the second to set
	 */
	public void setRefs(SECOND refs) {
		this.setSecond(refs);
	}
}
