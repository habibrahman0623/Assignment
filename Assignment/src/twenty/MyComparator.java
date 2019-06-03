package twenty;

import java.util.Comparator;

public class MyComparator implements Comparator<Double> {

	@Override
	public int compare(Double d1, Double d2) {
		// TODO Auto-generated method stub
		return (int) (d2-d1);
	}

}
