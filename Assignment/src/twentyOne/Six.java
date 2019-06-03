package twentyOne;

public class Six {
	
	public <T> void printArray(T[]inputArray){
		
		for(int i=0;i<inputArray.length;i++){
			System.out.println(inputArray[i]);
		}
	}
	public void printArray(String[] array){
		for(int i=0;i<array.length;i++){
			System.out.printf("%-10s\t",array[i]);
			if((i+1)%4==0){
				System.out.println();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer [] intArray={1,82,36,3,64,85};
		String [] array={"Habibur","Rahman","Chowdhury","Shahid","Chowdhury","hfbhdfbh","yfhusdyvsu"};
		Six six=new Six();
		six.printArray(intArray);
		six.printArray(array);

	}

}
