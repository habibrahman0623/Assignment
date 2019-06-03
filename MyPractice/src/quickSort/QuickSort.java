package quickSort;

public class QuickSort {
	
	private Double[] myArray;
	
	public QuickSort(Double[] inputArray) {
		// TODO Auto-generated constructor stub
		
		myArray = inputArray;
		int size = myArray.length - 1;
		sort(myArray, 0, size);
	}
	
	public void print_sorted_Array(){
		
		for (Double double1 : myArray) {
			System.out.println(double1);
		}
	}
	
	
	
	public void sort(Double[] array, int low, int high)
	{
		if(low >= high){
			return;
		}
		int pivot_index = partition(array, low, high);
		sort(array, low, pivot_index - 1);
		sort(array, pivot_index + 1, high);
	}

	private int partition(Double[] array, int low, int high) {
		// TODO Auto-generated method stub
		Double temp;
		int i = low - 1;
		for(int j = low; j < high; j++){
			if(array[j] < array[high]){
				
				i += 1;
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		temp = array[i + 1];
		array[i + 1] = array[high];
		array[high] = temp;
		
		return i + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Double[] mylist = {1.0,5.0,-100.0,3.0,8.0,4.0,7.0,2.0};
		QuickSort quickSort = new QuickSort(mylist);
		quickSort.print_sorted_Array();
		

	}

}
