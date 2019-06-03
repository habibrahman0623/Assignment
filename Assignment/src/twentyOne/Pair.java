package twentyOne;

public class Pair <F,S> {

	private F first;
	private S second;
	public F getFirst() {
		return first;
	}
	public void setFirst(F first) {
		this.first = first;
	}
	public S getSecond() {
		return second;
	}
	public void setSecond(S second) {
		this.second = second;
	}
	
	public static void main(String[] args) {
		
		Pair<String, Integer>pair=new Pair<>();
		pair.setFirst("key");
		pair.setSecond(5);
	}
}
