package practice.sorting;

public class SortApp {

	public static void main(String[] args) {
		ArrSort testArr = new ArrSort(20);
		testArr.insertToTail(11);
		testArr.insertToTail(2);
		testArr.insertToTail(35);
		testArr.insertToTail(40);
		testArr.insertToTail(4);
		testArr.insertToTail(2);
		testArr.insertToTail(7);
		testArr.insertToTail(15);
		testArr.insertToTail(11);
		testArr.insertToTail(100);
		testArr.insertToTail(0);
		testArr.insertToTail(2);

		testArr.show();

		//System.out.println("sort the array...");
//		testArr.bubbleSort();
		testArr.bubbleDoubleSort();
//		testArr.chooseSort();
//		testArr.insertSort();
		//System.out.println("the median of the array is : " + testArr.median());

//		testArr.noDupsWithChoose();
		testArr.show();
	}

}

