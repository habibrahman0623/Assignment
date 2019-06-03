package randomForest;

import java.util.ArrayList;
import java.util.List;

public class Node 
{
	public Node leftChild;
	public Node rightChild;
	public List<List<Double>> attributeList = new ArrayList<>();
	public List<Double> decision = new ArrayList<>();
	public List<Double> weightMatrix;
	public int thresholdColumn1 = -1;
	public int thresholdColumn2 = -1;
}
