package kruskal;

import java.util.Comparator;

public class MyComarator implements Comparator<Edge> {

	@Override
	public int compare(Edge e1, Edge e2) {
		// TODO Auto-generated method stub
		return e1.Weight-e2.Weight;
	}

}
