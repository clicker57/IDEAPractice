package practice.algorithm.tree;

public class Tree {
	private Node root;
	Queue queue = new Queue();

	public void searchByLevel() {
		if (root != null) {
			queue.pushQ(root);
		}
		else {
			System.out.println("tree is empty.");
			return;
		}

		while (queue!=null) {
			// display node
			queue.displayFirst();
			Node popNode = queue.popQ();

			// put left child into queue
			if (popNode.left != null) {
				queue.pushQ(popNode.left);
			}
			// put right child into queue
			if (popNode.right != null) {
				queue.pushQ(popNode.right);
			}
		}
	}
}
