package os;

import java.util.Comparator;

public class PairComarator implements Comparator<Pair>{

	@Override
	public int compare(Pair o1, Pair o2) {
		// TODO Auto-generated method stub
		return o1.segmentNumber-o2.segmentNumber;
	}

}
