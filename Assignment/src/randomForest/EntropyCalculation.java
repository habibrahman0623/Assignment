package randomForest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class EntropyCalculation 
{
	public MultiValuedNode findThreshold(Node group)
	{	
		Random columnShuffleFactor = new Random();
		MultiValuedNode threshold=new MultiValuedNode();
		List<MultiValuedNode> listOfThreshold = new ArrayList<>();
		List<Double> identityMatrix = new ArrayList<>();
		
		if(group.decision.size()==0)
			return null;
		
		int numberOfAttributes = group.attributeList.get(0).size();
		int testCase = (int)Math.ceil(Math.sqrt(numberOfAttributes));
		double max = -10000;
		
		for(int i=0; i<group.attributeList.size(); i++)
			identityMatrix.add(1.0);
		
		for(int counter=0; counter<testCase; counter++)
		{
			List<Double> weightMatrix = new ArrayList<>();
			List<Double> differanceMatrix = new ArrayList<>();
			int columnNumber1 = columnShuffleFactor.nextInt(numberOfAttributes);
			int columnNumber2;
			
			while(true)
			{
				columnNumber2 = columnShuffleFactor.nextInt(group.attributeList.get(0).size());
				
				if(columnNumber1!=columnNumber2)
					break;
			}
			
			//System.out.println("Column: " + columnNumber1 + "," + columnNumber2);
			
			for(int i=0; i<3; i++)
			{
				weightMatrix.add(columnShuffleFactor.nextInt()+columnShuffleFactor.nextDouble());
			}
			
			for(int i=0; i<group.attributeList.size(); i++)
				differanceMatrix.add(group.attributeList.get(i).get(columnNumber1)*weightMatrix.get(0)+group.attributeList.get(i).get(columnNumber2)*weightMatrix.get(1)+identityMatrix.get(i)*weightMatrix.get(2));
			
			
			MultiValuedNode mv = countIGained(group,differanceMatrix);
			mv.thresholdColumn1 = columnNumber1;
			mv.thresholdColumn2 = columnNumber2;
			mv.weightMatrix = weightMatrix;
			listOfThreshold.add(mv);
		}

		for(MultiValuedNode m:listOfThreshold)
		{
			if(max<m.iGained)
			{
				max=m.iGained;
				threshold=m;
			}
		}
		
		return threshold;
	}
	
	private MultiValuedNode countIGained(Node group, List<Double> differanceMatrix)
	{
		
		Node leftChild=new Node();
		Node rightChild=new Node();
		int totalMembers=group.attributeList.size();
		double parentEntropy=countEntropy(group,totalMembers);
		
		for(int i=0; i<differanceMatrix.size(); i++)
		{
			double tempElement = differanceMatrix.get(i);
			double decision = group.decision.get(i);
			
			if(tempElement<0.0)
			{
				leftChild.attributeList.add(group.attributeList.get(i));
				leftChild.decision.add(decision);
			}
			else
			{
				rightChild.attributeList.add(group.attributeList.get(i));
				rightChild.decision.add(decision);
			}
		}
		int membersOfLeftChild=leftChild.attributeList.size();
		int membersOfRightChild=rightChild.attributeList.size();
		double lChildEntropy=countEntropy(leftChild,membersOfLeftChild);
		double rChildEntropy=countEntropy(rightChild,membersOfRightChild);
		double avgChildEntropy=((double)membersOfLeftChild/(double)totalMembers)*lChildEntropy+((double)membersOfRightChild/(double)totalMembers)*rChildEntropy;
		
		double iGained=parentEntropy-avgChildEntropy;
		
		MultiValuedNode mv=new MultiValuedNode(leftChild,rightChild,iGained);
		return mv;
	}
	public double countEntropy(Node groupData, int numberOfMembers)
	{
		double result=0;
		Map<Double, Integer> temp = new TreeMap<>();
		for(Double d:groupData.decision)
		{
			if(temp.containsKey(d))
			{
				int oldValue=temp.get(d);
				temp.put(d, oldValue+1);
			}
			else
				temp.put(d,1);
		}
		
		for(Double d: temp.keySet())
		{
			double x= (double)temp.get(d)/(double)numberOfMembers;
			
			result=result-(x*((double)Math.log10(x)/(double)Math.log10(2)));
		}

		temp.clear();
		return result;
	}
}
