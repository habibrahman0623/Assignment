package tOne_Seven;

public class Seven<T> {
	
	public <T extends Comparable<T>> void isEqualTo(T t1,T t2){
		
		
		if(t1.equals(t2))
			System.out.println("they are equal");
		else System.out.println("they are not equal");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Seven<Integer> seven1=new Seven<Integer>();
		
		seven1.isEqualTo(3,4);
		seven1.isEqualTo(3,3);
		seven1.isEqualTo("habib","habib");
		seven1.isEqualTo("habib","habibur");
	}

}
