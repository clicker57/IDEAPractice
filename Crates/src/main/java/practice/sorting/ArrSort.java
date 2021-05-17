package practice.sorting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created by Philip on 5/18/16.
 */
public class ArrSort {
	private static final Logger logger = LoggerFactory.getLogger(ArrSort.class);

	private int[] arr = new int[100];
	private int nElem = 0;

	public ArrSort(int length) {
		if (length <= 0) {
			logger.warn("Invalid length of array. Use default length 100.");
		} else {
			arr = new int[length];
		}
	}

	public ArrSort() {}

	public void show() {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i < nElem; i++) {
			sb.append(arr[i]).append(" ");
		}
		logger.info("The array is : {}", sb);
	}

	public void extendLength(int lenPlus) {
		if (lenPlus <= 0) {
			logger.error("invalid param: lenPlus must be positive integer.");
			return;
		}
		arr = Arrays.copyOf(arr, arr.length + lenPlus);
	}

	public void insertToTail(int value) {
		if (nElem >= arr.length) {
			logger.warn("Array is auto-extended by 10 because it is full.");
			extendLength(10);
		}
		arr[nElem++] = value;
	}

	public void bubbleSort() {
		for (int i=nElem-1; i>0; i--) {
			boolean isSorted = true;
			for (int j=0; j<i; j++) {
				// bubble the biggest one to the right side
				if (arr[j] > arr[j+1]) {
					swap(j, j+1);
					isSorted = false;
				}
			}
			if (isSorted) {
				return;
			}
		}
	}

	public void bubbleDoubleSort() {
		for (int outRight=nElem-1, outLeft=0; outRight>outLeft; outRight--, outLeft++) {
			int in=outLeft;
			for (; in<outRight; in++) {
				if (arr[in] > arr[in+1]) {     // bubble the biggest one to the right side
					swap(in, in+1);
				}
			}
			for (; in>outLeft; in--) {
				if (arr[in] < arr[in-1]) {     // bubble the smallest one to the left side
					swap(in, in-1);
				}
			}
		}
	}

	public void chooseSort() {
		int tmp;

		for (int i=0; i<nElem; i++) {        // from left to right
			tmp = i;
			for (int j=i; j<nElem; j++) {
				 if (arr[j] < arr[tmp]) {    // choose the smallest one's index
					 tmp = j;
				 }
			}
			swap(i, tmp);
		}
	}

	public void insertSort() {
		int in, out;

		for (out=1; out<nElem; out++) {
			int tmp = arr[out];
			in = out;
			while(in>0 && tmp<arr[in-1]) {   // the smaller goes left
				arr[in] = arr[in-1];
				in--;
			}
			arr[in] = tmp;
		}
	}



	public int median() {
		insertSort();

		return arr[nElem/2];
	}

	/**
	 * implementation with the thought of selection sort.
	 * still need O(n^2).
	 */
	public void noDupsWithChoose() {
		int tmp;
		for (int i=0; i<nElem; i++) {
			tmp = i;
			for (int j=i+1; j<nElem; j++) {
				if (arr[j] < arr[tmp]) {
					tmp = j;
				} else if (arr[j] == arr[tmp]) {
					// delete the duplicated element
					if (nElem - 1 - j >= 0) System.arraycopy(arr, j + 1, arr, j, nElem - 1 - j);
					nElem--;
					j--;
				}
			}
			swap(i, tmp);
		}
	}

	private void swap(int a, int b) {
		if (a<0 || a>=nElem || b<0 || b>=nElem) {
			System.out.println("out of index");
			return;
		}

		if (a == b) {
			System.out.println("same index, no need to switch.");
			return;
		}

		int tmpElem;
		tmpElem = arr[a];
		arr[a] = arr[b];
		arr[b] = tmpElem;
	}
}
