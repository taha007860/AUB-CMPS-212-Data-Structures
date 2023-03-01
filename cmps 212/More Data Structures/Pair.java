    public final class Pair<T1, T2>{
	public T1 first;
	public T2 second;

	public Pair(){
		first = null;
		second = null;
	}

	public Pair(T1 firstValue, T2 secondValue){
		first = firstValue;
		second = secondValue;
	}

	public Pair(Pair<T1, T2> pairToCopy){
		first = pairToCopy.first;
		second = pairToCopy.second;
	}
}
