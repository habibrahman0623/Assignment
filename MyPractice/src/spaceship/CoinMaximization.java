package spaceship;

public class CoinMaximization {
	
	int[][] grid;
	int spaceshipColumn;
	
	public CoinMaximization(int[][] gridInput, int spaceshipPosition) {
		// TODO Auto-generated constructor stub
		grid = gridInput;
		spaceshipColumn = spaceshipPosition;
	}
	
	public int possibleMaxCoin(){
		int maxCoin = 0;
		int coin = 0;
		int[] enemyList = identifyEnemy();
		for(int i = enemyList.length-1; i >=0; i--){
			coin = collectCoin(useBomb(i));
			if(coin > maxCoin){
				maxCoin = coin;
			}
		}
		
		return maxCoin;
	}
	
	public int[][] useBomb(int row){
		int[][] list = new int[grid.length][grid[0].length];
		for(int i = list.length-1; i >=0; i--){
			for(int j = 0; j < list[0].length; j++){
				if(i <= row && i >= row-4 && grid[i][j] == 2){
					list[i][j] = 0;
				}
				else {
					list[i][j] = grid[i][j];
				}
			}
		}
		
		return list;
	}
	
	public int[] identifyEnemy(){
		
		int numberOfRows = grid.length;
		int numberOfColumn = grid[0].length;
		int[] enemyRows = new int[numberOfRows];
		int count = 0;
		for(int i = 0; i < numberOfRows-4; i++){
			for(int j = 0; j < numberOfColumn; j++){
				if(grid[i][j] == 2){
					enemyRows[count++] = i;
					break;
				}
			}
		}
		
		return enemyRows;
	}
	
	public int collectCoin(int[][] myGrid){
		
		int[][] coinGrid = new int[myGrid.length][myGrid[0].length+2];
		int rowSize = coinGrid.length;
		int columnSize = coinGrid[0].length;
		int maxCoin = 0;
		boolean flag = false;
		for(int i = 0; i < rowSize; i++){
			coinGrid[i][0] = -1;
			coinGrid[i][columnSize-1] = -1;
		}
		for(int  i = 0; i < columnSize; i++){
			coinGrid[rowSize-1][i] = -1;
		}
		if(myGrid[rowSize-1][spaceshipColumn] != 2){
			coinGrid[rowSize-1][spaceshipColumn+1] = myGrid[rowSize-1][spaceshipColumn];
			flag = true;
		}
		if(myGrid[rowSize-1][spaceshipColumn-1] != 2){
			coinGrid[rowSize-1][spaceshipColumn] = myGrid[rowSize-1][spaceshipColumn-1];
			flag = true;
		}
		if(myGrid[rowSize-1][spaceshipColumn+1] != 2){
			coinGrid[rowSize-1][spaceshipColumn+2] = myGrid[rowSize-1][spaceshipColumn+1];
			flag = true;
		}
		if(!flag){
			return 0;
		}
		for(int i = rowSize-2; i >= 0; i--){
			flag = false;
			for(int j = 1; j < columnSize-1; j++){
				int value = maxValue(coinGrid[i+1][j-1], coinGrid[i+1][j],coinGrid[i+1][j+1]);
				if(value >= 0 && myGrid[i][j-1] != 2){
					coinGrid[i][j] = value + myGrid[i][j-1];					
					flag = true;
					if(coinGrid[i][j] > maxCoin){
						maxCoin = coinGrid[i][j];
					}
				}
				else {
					coinGrid[i][j] = -1;
				}
			}
			if(!flag){
				break;
			}
		}
		
		return maxCoin;
	}
	
	public int maxValue(int a, int b, int c){
		int max = Math.max(a, b);
		max = Math.max(max, c);
	
		return max;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] list = {{1,1,1,2,2},{2,2,2,2,1},{2,1,2,0,0},{1,2,0,2,2},{0,1,1,0,0},{1,0,2,2,1}};
		CoinMaximization coinMaximization = new CoinMaximization(list, 2);
		System.out.println(coinMaximization.possibleMaxCoin());

	}

}
