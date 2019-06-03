package rockClimbing;

public class RockClimbing {
	
	public int[][] costList;
	public int [][] optimumCostList;
	
	public RockClimbing(int[][] costs) {
		// TODO Auto-generated constructor stub
		costList = costs;
		int sizeI = costList.length;
		int sizeJ = costList[0].length;
		optimumCostList = new int[sizeI][sizeJ+2];
		int max = Integer.MAX_VALUE;
		for(int i = 0; i < sizeI; i++){
			optimumCostList[i][0] = max;
			optimumCostList[i][sizeJ+1] = max;
		}
		for(int i = 0; i < sizeJ; i++){
			optimumCostList[0][i+1] = costList[0][i];
			
		}
	}
	
	public void runDynamicAlgorithm(){
		
		int sizeI = optimumCostList.length;
		int sizeJ = optimumCostList[0].length;
		int a, b, c;
		for(int i = 1; i < sizeI; i++){
			for(int j = 1; j < sizeJ - 1; j++){
				int min = 0;
				a = optimumCostList[i-1][j-1];
				b = optimumCostList[i-1][j];
				c = optimumCostList[i-1][j+1];
				min = Math.min(a, b);
				min = Math.min(min, c);
				optimumCostList[i][j] = min + costList[i][j-1];
			}
		}
	}
	
	public void printCosts(){
		for(int i = 0; i < optimumCostList.length; i++){
			for(int j = 1; j < optimumCostList[0].length -1; j++){
				System.out.print(optimumCostList[i][j] + " ");
			}
			System.out.println();
		}
	}

}
