package rockClimbing;

public class RockCLimbingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] costs = {{3,2,5,4,8},{5,7,5,6,1},{4,4,6,2,3},{2,8,9,5,8}};
		RockClimbing climbing = new RockClimbing(costs);
		climbing.runDynamicAlgorithm();
		climbing.printCosts();

	}

}
