package practice.queues;

/**
 * Created by Philip on 5/18/16.
 */
public class QueueNormal {
	private int maxSize;
	private long[] queueArr;
	private int front, rear;
	private int nItems;

	public QueueNormal (int n) {
		maxSize = n;
		queueArr = new long[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}

	public void insert(long elem) {
		if (rear == maxSize-1) {
			rear = -1;
		}
		queueArr[++rear] = elem;
		nItems++;
	}

	public long remove() {
		long temp = queueArr[front++];
		if (front == maxSize) {
			front = 0;
		}
		nItems--;
		return temp;
	}

	public long peekFront() {
		return queueArr[front];
	}

	public long peekN(int idx) {
		return queueArr[idx];
	}

	public boolean isEmpty() {
		return (nItems==0);
	}

	public boolean isFull() {
		return (nItems==maxSize);
	}

	public int size() {
		return nItems;
	}

	public void display(String s) {
		System.out.println(s);
		System.out.println("practice.algorithm.tree.Queue status: ");
		for (int i=0; i<size(); i++) {
			System.out.print(peekN(i));
			System.out.print(" ");
		}
		System.out.println("");
	}
}
