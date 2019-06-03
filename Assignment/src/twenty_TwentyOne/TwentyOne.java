package twenty_TwentyOne;

import java.util.PriorityQueue;


public class TwentyOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PriorityQueue<Double>queue=new PriorityQueue<>(1, new MyComparator());
		queue.add(4.3);
		queue.add(8.3);
		queue.add(3.3);
		
		while (queue.size()>0) {
			System.out.println(queue.poll());
		}
	}

}
