package practice.queues;

public class QueueApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		QueueNormal theQ = new QueueNormal(5);
		
		theQ.insert(20);
		theQ.insert(30);
		theQ.insert(50);
		theQ.insert(3);
		
		while (!theQ.isEmpty()) {
			long n = theQ.remove();
			System.out.println(n + " ");
		}
		System.out.println("");
	}

}

