package tOne_Fiive;

public class Five {
	
	public <T> void printArray(T[]inputArray){
		for(int i=0;i<inputArray.length;i++){
			System.out.println(inputArray[i]);
		}
	}
	public <T extends Comparable<T>> void printArray(T[]inputArray,T low,T high){
		for(int i=0;i<inputArray.length;i++){
			if(inputArray[i].compareTo(low)>=0&&inputArray[i].compareTo(high)<=0){
				System.out.println(inputArray[i]);
			}
			else {
				System.out.println("InvalidSubscriptException\n");
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer [] intArray={1,82,36,3,64,85};
		Double [] doubleArray={1.2,3.4,1.4,6.7,4.5};
		
		Five five=new Five();
		five.printArray(intArray);
		five.printArray(doubleArray);
		
		five.printArray(intArray, 1, 90);
		five.printArray(doubleArray, 1.0,5.6 );
	}


}
