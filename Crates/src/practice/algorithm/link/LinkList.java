package practice.algorithm.link;

public class LinkList {
	private Link head;

	public void displayList() {
		Link cur = head;

		while (cur != null) {
			cur.displayLink();
			cur = cur.next;
		}
		System.out.println("");
	}

	public void insertLink(int id) {
		Link newLink = new Link(id);
		newLink.next = head;
		head = newLink;
	}

	public void reverseList() {
		Link tmpLink;
		Link cur = head.next;
		Link pre = head;

		if (cur == null) {
			System.out.println("List is empty.");
			return;
		}

		while (cur.next != null) {
			tmpLink = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmpLink;
		}
		cur.next = pre;

		head.next = null;
		head = cur;
	}
}
