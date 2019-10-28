package practice.algorithm;

import java.util.GregorianCalendar;

public class MyArray {
	private char [] a;
	private int num=0;

	public static void main(String arg[]) {
        MyArray testArr = new MyArray();
        System.out.println(testArr.action(new int[] {3,1,2,9}));

        int[] tArr = new int[2];
        System.out.println();

		GregorianCalendar specialDay = new GregorianCalendar(2016, 0, 32);
    }

    public int[] action(int[] nums) {
        // TODO implement your code here.
        int[] a={1,2}, b={4,9,0};

        return new int[]{a[0]};
    }

	public void addStr(String s) {
		a = s.toCharArray();
		num = s.length();
	}
	
	public void rmIdx(int i) {
		if (i<0 || i>=num) {
			System.out.println("remove failed. Invalid index " + i);
		}
		else {
			for (int j=i; j<num-1; j++) {
				a[j] = a[j+1];
			}
			num--;
//			System.out.println("index " + i + " is removed.");
		}
	}
	
	public int getLen() {
		return num;
	}
	
	public char getIdx(int i) {
		if (i>=num || i<0) {
			return '\0';
		}
		else {
			return a[i];
		}
	}
	
	public void printOut() {
		for (int i=0; i<num; i++) {
			System.out.print(a[i]);
		}
		System.out.println();
	}
	
	public void clear() {
		num = 0;
	}
}