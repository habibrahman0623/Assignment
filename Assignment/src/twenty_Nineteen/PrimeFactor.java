package twenty_Nineteen;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PrimeFactor {
	
	Set<Integer>primeSet=new HashSet<Integer>();
	
	public Boolean isPrime(int num){
		Boolean flag=true;
		int temp=(int) Math.sqrt(num);
		for(int i=2;i<=temp;i++){
			if(num%i==0){
				flag=false;
				break;
			}
		}
		
		return flag;
	}
	
	public void primeFactors(int num){
		while(num%2==0){
			num=num/2;
			primeSet.add(2);
		}
		int temp=(int) Math.sqrt(num);
		for(int i=3;i<=temp;i+=2){
			if(num%i==0){
				num=num/i;
				primeSet.add(i);
				i=1;
				temp=(int) Math.sqrt(num);
			}
		}
		if(num>2)
			primeSet.add(num);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.println("Enter your number");
		int num=input.nextInt();
		PrimeFactor pf=new PrimeFactor();
		
		if(!pf.isPrime(num)){
			pf.primeFactors(num);
			for (Integer number : pf.primeSet) {
				System.out.println(number);
			}
		}
		else
			System.out.println("It is a prime number");
	}

}
