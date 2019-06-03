package burstBalloon;

import java.util.Arrays;

public class BurstBalloon {
	
	int[] balloons;
	int numberOfCoin;
	
	public class Permutation{
		
		int[][] mylist;
		int k;
		
		public Permutation(int sizeOfArray) {
			// TODO Auto-generated constructor stub
			
			int numberOfPermutation = numberOfPermutation(sizeOfArray);
			mylist = new int[numberOfPermutation][sizeOfArray];
		}

		private int numberOfPermutation(int sizeOfArray) {
			// TODO Auto-generated method stub
			int count = 1;
			for(int i = sizeOfArray; i > 0; i--){
				count *= i;
			}
			return count;
		}
		
		public void permute(int[] list, int startIndex, int endIndex){
			
			if(startIndex == endIndex){
				for(int i = 0; i < list.length; i++){
					mylist[k][i] = list[i];
				}
				k++;
			}
			
			else{
				for(int i = startIndex; i<= endIndex; i++){
					list = swap(list,i,startIndex);
					permute(list, startIndex+1, endIndex);
					list = swap(list,i,startIndex);
				}
			}
		}

		private int[] swap(int[] list, int i, int startIndex) {
			// TODO Auto-generated method stub
			int temp;
			temp = list[i];
			list[i] = list[startIndex];
			list[startIndex] = temp;
			return list;
		}
	}
		
	public BurstBalloon(int[] balloons) {
		// TODO Auto-generated constructor stub
		this.balloons = balloons;
				
	}
	
	public int burst(){
		
		int max = Integer.MIN_VALUE;
		int numberOfBalloon = balloons.length;
		Permutation permutation = new Permutation(numberOfBalloon);
		permutation.permute(balloons, 0, numberOfBalloon-1);
		int[][] permutedList = permutation.mylist;
		int numberOfPemutation = permutedList.length;
		
		for(int i = 0; i < numberOfPemutation; i++){
			int coin = 0;
			int[] temp = new int[numberOfBalloon];
			for(int k = 0; k < numberOfBalloon; k++){
				temp[k] = balloons[k];
			}
			for(int j = 0; j < numberOfBalloon; j++){
				
				int loc = getLocation(permutedList[i][j], temp);
				
				if(loc == 0){
					coin += temp[loc]*temp[loc+1];
				}
				else if(loc == numberOfBalloon-1){
					coin += temp[loc-1]*temp[loc];
				}
				else {
					coin += temp[loc-1]*temp[loc]*temp[loc+1];
				}
				temp = updateBalloons(temp,loc);
			}
			
			if(coin > max){
				max = coin;
			}
		}
		return max;
	}
	
	private int[] updateBalloons(int[]list, int loc) {
		// TODO Auto-generated method stub
		
		for(int i = loc; i < list.length-1; i++){
			list[i] = list[i+1];
		}
		list[list.length-1] = 1;
		return list;
		
	}

	public int getLocation(int value, int[] list){
		
		for(int i = 0; i < list.length; i++){
			if(list[i] == value){
				return i;
			}
		}
		
		return -1;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] balloons = {1,2,3,4,5};
		BurstBalloon burstBalloon = new BurstBalloon(balloons);
		System.out.println(burstBalloon.burst());

	}

}
