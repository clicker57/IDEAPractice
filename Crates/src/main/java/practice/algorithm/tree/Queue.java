package practice.algorithm.tree;

public class Queue {
	int nNum = 0;
	Node [] arr;

	public void displayFirst() {
		arr[0].displayNode();
	}

	public void pushQ(Node node) {
		arr[nNum] = node;
		nNum++;
	}

	public Node popQ() {
		Node tmp = arr[0];
		for (int i=0; i < nNum; i++) {
			arr[i] = arr[i+1];
		}
		nNum--;
		return tmp;
	}
}
