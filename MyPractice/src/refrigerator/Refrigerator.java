package refrigerator;

public class Refrigerator {
	
	Node[] nodelist;
	Node[][] permutedCustomers;
	public class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			// TODO Auto-generated constructor stub
			this.x =x;
			this.y = y;
		}
		
		public int distanceFromAnotherNode(Node node){
			return (Math.abs(x-node.x) + Math.abs(y-node.y));
		}
	}
	
	public class Permutation{
		Node[][] permutedList;
		int k;
		
		public Permutation(Node[] nodelist) {
			// TODO Auto-generated constructor stub
			int numberOfNode = nodelist.length;
			int numberOfPermutation = numberOfPermutation(numberOfNode);
			permutedList = new Node[numberOfPermutation][numberOfNode];
		}
		
		public void permute(Node[] nodelist, int startIndex, int endIndex){
			
			if(startIndex == endIndex){
				for(int i = 0; i < nodelist.length; i++){
					permutedList[k][i] = nodelist[i];
				}
				k++;
			}
			else{
				
				for(int i = startIndex; i<=endIndex; i++){
					nodelist = swap(nodelist,startIndex,i);
					permute(nodelist, startIndex+1, endIndex);
					nodelist = swap(nodelist,startIndex,i);
					
				}
			}
		}

		private Node[] swap(Node[] nodelist, int startIndex, int i) {
			// TODO Auto-generated method stub
			Node temp = nodelist[startIndex];
			nodelist[startIndex] = nodelist[i];
			nodelist[i] = temp;
			
			return nodelist;
		}

		private int numberOfPermutation(int numberOfNode) {
			// TODO Auto-generated method stub
			int count = 1;
			for(int i = numberOfNode; i > 0; i--){
				count *= i;
			}
			return count;
		}
	}
	
	public Refrigerator(int[] list) {
		// TODO Auto-generated constructor stub
		int numberOfNOde = list.length/2;
		nodelist = new Node[numberOfNOde];
		int index = 0;
		
		for(int i = 0; i < list.length; i+=2){
			nodelist[index++] = new Node(list[i], list[i+1]);
		}
		Node[] customers = new Node[nodelist.length-2];
		for(int i = 0; i < customers.length; i++){
			customers[i] = nodelist[i+2];
		}
		Permutation permutation = new Permutation(customers);
		permutation.permute(customers, 0, customers.length-1);
		permutedCustomers = permutation.permutedList;
	}
	
	public int shortestDistance(){
		int minimumDistance = Integer.MAX_VALUE;
		int size = permutedCustomers.length;
		for(int i = 0; i < size; i++){
			int distance = 0;
			for(int j = 0; j < permutedCustomers[0].length-1; j++){
				distance += permutedCustomers[i][j].distanceFromAnotherNode(permutedCustomers[i][j+1]);
			}
			distance = distance + nodelist[0].distanceFromAnotherNode(permutedCustomers[i][0]) + nodelist[1].distanceFromAnotherNode(permutedCustomers[i][permutedCustomers[0].length-1]); 
			if(distance < minimumDistance){
				minimumDistance = distance;
			}
		}
		
		return minimumDistance;
		
	}
	
	public static void main(String[] args){
		
		int [] list = {88,81,85,80,19,22,31,15,27,29,30,10,20,26,5,14};
		Refrigerator refrigerator = new Refrigerator(list);
		System.out.println(refrigerator.shortestDistance());
	}

}
