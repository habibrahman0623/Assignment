package randomForest;

import java.util.List;

public class MultiValuedNode 
{
	public Node lChild;
	public Node rChild;
	public double iGained;
	public List<Double> weightMatrix;
	public int thresholdColumn1 = -1;
	public int thresholdColumn2 = -1;
	
	public MultiValuedNode() 
	{

	}
	public MultiValuedNode(Node lChild, Node rChild, double iGained) 
	{
		this.lChild = lChild;
		this.rChild = rChild;
		this.iGained = iGained;
	}
}
