package practice.algorithm;

public class RecurseApp_2 {
	// check if the text is mirror-like
	// e.g. abcdedcba
	
	public static void main(String[] args) {
		MyArray arrchar = new MyArray();
		//practice.algorithm.RecurseApp_2 [] myArr = new practice.algorithm.RecurseApp_2[1000];

		arrchar.addStr("abcde");
		arrchar.printOut();
		System.out.println(isSymmetry(arrchar));
		
		arrchar.clear();
		arrchar.addStr("abcdedcba");
		arrchar.printOut();
		System.out.println(isSymmetry(arrchar));
		
		arrchar.clear();
		arrchar.addStr("abcdabcd");
		arrchar.printOut();
		System.out.println(isSymmetry(arrchar));
	}

	public static boolean isSymmetry(MyArray arr) {
		if (arr.getLen() == 0) {
			return false;
		}

		if (arr.getLen() < 2) {
			return true;
		}

		if (arr.getIdx(0) == arr.getIdx(arr.getLen()-1)) {
			arr.rmIdx(0);
			arr.rmIdx(arr.getLen()-1);
			return isSymmetry(arr);
		} else {
			return false;
		}
	}
}
