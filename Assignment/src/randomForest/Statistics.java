package randomForest;

import java.util.ArrayList;
import java.util.List;

public class Statistics {
	
	List<Double>numberList=new ArrayList<Double>();
	public Statistics(List<Double>list) {
		// TODO Auto-generated constructor stub
		numberList=list;
	}
	public Double mean(){
		Double mean=0.0;
		for(int i=0;i<numberList.size();i++){
			mean+=numberList.get(i);
		}
		return mean/numberList.size();
	}
	public Double varience(){
		Double varience=0.0;
		for(int i=0;i<numberList.size();i++){
			varience+=(numberList.get(i)-mean())*(numberList.get(i)-mean());
		}
		return varience/numberList.size();
	}
	public Double standardDeviation(){
		
		return Math.sqrt(varience());
	}


}
