package machineLearnning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RegressionCalculation {
	
	private List<List<Double>> traineeData = new ArrayList<List<Double>>();
	private List<Double>listOfTheta= new ArrayList<Double>();
	private Double alpha=0.0001;
	
	public RegressionCalculation(List<List<Double>> datalist) {
		// TODO Auto-generated constructor stub
		traineeData=datalist;
	}
	public List<Double> thetaCalculation(){
		for(int k=0;k<traineeData.get(0).size();k++){
			listOfTheta.add(0.0);
		}
		for(int i=0;i<5;i++){
			List<Double>tempThetalist=new ArrayList<>();
			for(int j=0;j<traineeData.get(0).size();j++){
				Double tempTheta=listOfTheta.get(j)-alpha*differenciationOfJ(listOfTheta, j);
				tempThetalist.add(tempTheta);
			}
			listOfTheta.clear();
			listOfTheta.addAll(tempThetalist);
		}
		
		return listOfTheta;
	}
	public Double differenciationOfJ(List<Double> tempThitalist,int J){
		
		Double differenciationValue=0.0;
		for(int i=0;i<traineeData.size();i++){
			differenciationValue+=(hxi(i, tempThitalist)-traineeData.get(i).get(traineeData.get(0).size()-1))*traineeData.get(i).get(J);
		}
		differenciationValue=differenciationValue*2/traineeData.size();
		
		return differenciationValue;
	}
	public Double hxi(int rowNumber,List<Double> tempThitalist){
		Double hxiValue=tempThitalist.get(0);
		for(int i=1;i<tempThitalist.size();i++){
			hxiValue+=tempThitalist.get(i)*traineeData.get(rowNumber).get(i-1);
		}
		
		return hxiValue;
	}
	
	public double estimateDecission(List<Double>attributeList){
		Double decission=listOfTheta.get(0);
		for(int i=0;i<attributeList.size();i++){
			decission+=attributeList.get(i)*listOfTheta.get(i+1);
		}
		
		return decission;
	}
}
