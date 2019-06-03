package tOne_Four;

public class Four {
public  <T extends Comparable<T>> void selectionSort(T[] t){
		
		for(int i=0;i<t.length;i++){
			T min=t[i],aux;
			int temp=i;
			for(int j=i+1;j<t.length;j++){
				
				if(t[j].compareTo(min)<0){
					min=t[j];
					temp=j;
				}
			}
			aux=t[i];
			t[i]=t[temp];
			t[temp]=aux;
		}
		for(int k=0;k<t.length;k++){
			System.out.println(t[k]);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer [] intArray={1,82,36,3,64,85};
		Double [] doubleArray={1.2,3.4,1.4,6.7,4.5};
		
		Four four=new Four();
		four.selectionSort(intArray);
		four.selectionSort(doubleArray);
		
		
	}

}
