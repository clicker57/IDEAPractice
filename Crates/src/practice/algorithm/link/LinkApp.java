package practice.algorithm.link;

public class LinkApp {

	public static void main(String[] args) {
		LinkList myList = new LinkList();
		
		myList.insertLink(11);
		myList.insertLink(22);
		myList.insertLink(33);
		myList.insertLink(44);
		
		myList.displayList();
		
		myList.reverseList();
		
		myList.displayList();
	}

}

