package randomForest;

import java.util.ArrayList;
import java.util.List;

public class DecisionTree 
{
	public Node root;
	List<Double> decision = new ArrayList<>();
	
	public DecisionTree()
	{
		
	}
	
	public void buildTree(Node data, int currentDepth)
	{
		EntropyCalculation ec= new EntropyCalculation();
		MultiValuedNode mv = ec.findThreshold(data);
		
		if(mv==null || currentDepth>9)
			return;
		
		data.leftChild = mv.lChild;
		data.rightChild = mv.rChild;
		data.thresholdColumn1 = mv.thresholdColumn1;
		data.thresholdColumn2 = mv.thresholdColumn2;
		data.weightMatrix = mv.weightMatrix;
		if(root==null)
			this.root=data;		
		
		buildTree(data.leftChild, currentDepth+1);
		buildTree(data.rightChild, currentDepth+1);
	}
	
	public void traverse(Node current, List<Double> testSet)
	{
		if(current.leftChild==null && current.rightChild==null)
		{
			this.decision = current.decision;

			return;
		}
		
		Double result = testSet.get(current.thresholdColumn1) * current.weightMatrix.get(0) + testSet.get(current.thresholdColumn2) * current.weightMatrix.get(1) + 1 * current.weightMatrix.get(2);
		
		if(result<0)
			traverse(current.leftChild, testSet);
		else
			traverse(current.rightChild, testSet);
	}
}
