package randomForest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main{ 
	RandomForest forest;
	Node data;
	public Main(RandomForest forest,Node data) {
		// TODO Auto-generated constructor stub
		this.forest=forest;
		this.data=data;
	}
	public void createTestCaseData(){
		Set<Double>classSet=new TreeSet<Double>();
		Map<Double,Integer>map=new TreeMap<Double, Integer>();
		for(int i=0;i<data.decision.size();i++){
			classSet.add(data.decision.get(i));
		}
		for (Double setValue : classSet) {
			for(int i=0;i<data.decision.size();i++){
				if(data.decision.get(i).equals(setValue)){
					Integer oldValue=map.get(setValue);
					map.put(setValue, oldValue+1);
				}
			}
		}
		for (Double setValue : classSet) {
			int temp=map.get(setValue)/10;
			for(;;){
				
			}
		}
		
		
	}
	
	public void accuracyCheck(){
		Random random=new Random();
		int numberOfTestCase=(int)(data.decision.size()*0.1);
		int numberOfAttributes=data.attributeList.get(0).size();
		List<Double>accurecyList=new ArrayList<Double>();
		for(int k=0;k<10;k++){
			List<List<Double>>testCase=new ArrayList<List<Double>>();
			List<Double> test = new ArrayList<>();
			List<Integer>rows  = new ArrayList<>();
			for(int i=0;i<numberOfTestCase;i++){
				int temp=random.nextInt(data.decision.size());
				rows.add(temp);
				for(int j=0;j<numberOfAttributes;j++){
					test.add(data.attributeList.get(temp).get(j));
					//System.out.print(data.attributeList.get(temp).get(j)+" ");
				}
				testCase.add(test);
				//System.out.println();
			}
			List<Integer>accurecyCheck=new ArrayList<Integer>();
			Double accurecy;
			for(int i=0;i<numberOfTestCase;i++){
				Double originalDecision=data.decision.get(rows.get(i));
				//System.out.print(rows.get(i)+" "+originalDecision+" ");
				Double decisionFromForest=forest.traverseForest(testCase.get(i));
				if(originalDecision.equals(decisionFromForest)){
					accurecyCheck.add(1);
				}
			}
			accurecy=(accurecyCheck.size()*1.0)/(1.0*numberOfTestCase)*100.0;
			accurecyList.add(accurecy);
			//System.out.println(accurecyCheck.size()+" "+accurecy+" "+numberOfTestCase);
			
		}
		System.out.println("Number of Attributes: "+numberOfAttributes);
		System.out.println("Number of Test Case: "+numberOfTestCase);
		Statistics stat=new Statistics(accurecyList);
		System.out.println("Accuracy:"+stat.mean()+"%");
		//System.out.println(stat.standardDeviation());

	}
	
	public static void main(String[] args) 
	{
		try
		{
			BufferedReader file= new BufferedReader(new FileReader("F:/data.txt"));
			Node data=new Node(); 
			
			Integer numberOfTrees = 9;
			
			while(true)
			{
				String currentLine = file.readLine();
				if(currentLine==null)
					break;
				String[] tokens = currentLine.split(",");
				
				List<Double> temp=new ArrayList<>();
				
				for(int counter=0; counter<tokens.length-1; counter++)
				{
					Double dataToBeInserted = Double.parseDouble(tokens[counter]);
					temp.add(dataToBeInserted);
				}
				data.decision.add(Double.parseDouble(tokens[tokens.length-1]));
				data.attributeList.add(temp);
			}
			file.close();
			
			RandomForest forest = new RandomForest();
			
			for(int counter=0; counter<numberOfTrees; counter++)
			{
				//System.out.println("Tree :" + counter);
				DecisionTree decisionTree = new DecisionTree();
				decisionTree.buildTree(data,0);
				forest.rForest.add(decisionTree);
			}
			Main main=new Main(forest,data);
			main.accuracyCheck();
		}
		catch(IOException exception)
		{
			System.out.println("File does not found");
			exception.printStackTrace();
		}
	}
}