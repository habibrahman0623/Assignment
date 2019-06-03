package randomForest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RandomForest 
{
	public List<DecisionTree> rForest = new ArrayList<>();
	Map<Double, Double> probability = new TreeMap<>();
	
	
	public Double traverseForest(List<Double> testSet)
	{
		double max = -100;
		double finalDecision = -1;
		int totalTrees = rForest.size();
		
		for(DecisionTree dt:rForest)
		{
			Map<Double, Double> counter = new TreeMap<>();
			dt.traverse(dt.root, testSet);
			List<Double> decisions = dt.decision;

			int totalMembers = decisions.size();
			for(Double d:decisions)
			{
				//System.out.println(d);
				if(!counter.containsKey(d))
					counter.put(d, 1.0/totalMembers);
				else
				{
					Double oldValue=counter.get(d);
					counter.remove(d);
					counter.put(d, (oldValue+1.0)/totalMembers);
				}
			}
				
			for(Double d:counter.keySet())
			{
				if(!probability.containsKey(d))
					probability.put(d, counter.get(d));
				else
				{
					Double oldValue=probability.get(d);
					probability.put(d, oldValue + counter.get(d));
				}
			}
			//System.out.println();
		}
		
		for(Double d: probability.keySet())
		{
			if(probability.get(d)>max)
			{
				max = probability.get(d);
				finalDecision = d;
			}
		}

		//System.out.println("The final decision is: " + finalDecision);
		return finalDecision;
	}
}
