package machineLearnning;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fileReader=new FileReader("F:/pima-indians-diabetes.data");
		fileReader.openFile();
		List<List<Double>> inputList = fileReader.readRecords();
		fileReader.closeFile();
		
		RegressionCalculation rc=new RegressionCalculation(inputList);
		List<Double>thetalist=new ArrayList<>();
		thetalist.addAll(rc.thetaCalculation());
		
		for(int i=0;i<thetalist.size();i++){
			System.out.println(thetalist.get(i));
		}
		List<Double> attributeList=new ArrayList<>();
		attributeList.addAll(inputList.get(8));
		attributeList.remove(8);
		Double decission=rc.estimateDecission(attributeList);
		System.out.println("estimate decission "+ decission);
		System.out.println("original value "+ inputList.get(5).get(inputList.get(8).size()-1));

	}

}
