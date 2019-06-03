package tOne_Eight;

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
		
		Pair<String, Integer>pair1=new Pair<>();
		Pair<String, String>pair2=new Pair<>();
		pair1.setFirst("key");
		pair1.setSecond(5);
		pair2.setFirst("First name");
		pair2.setSecond("Last name");

	}
}
