package com.gl.javafsd.DS3.A1.Driver;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Construct {

	static Stack<Integer> feasibleFloors = new Stack<Integer>();
	Queue<Integer> qfeasibleFloors = new LinkedList<Integer>();
	int day;

	public Construct() {
		System.out.println("The order of Construction is as follows:");
	}

	public void buildFloors(int[] sizeOfFloors, int noOfFloors) {
		int[] sortedSizeOfFloors = sizeOfFloors.clone();
		// sort the size of floors in ascending order

		Arrays.sort(sortedSizeOfFloors);
		// System.out.println(Arrays.toString(sortedSizeOfFloors));

		// iterate through number of floors to find the day with the biggest size
		int jnoOfFloors = noOfFloors - 1;
		feasibilityCheck(sizeOfFloors, sortedSizeOfFloors, jnoOfFloors, noOfFloors);
	}

	public void feasibilityCheck(int[] sizeOfFloors, int[] sortedSizeOfFloors, int jnoOfFloors, int inoOfFloors) {
		int tmpi = 0;
		int[] qtmpfloor = new int[inoOfFloors];
		for (int j = jnoOfFloors; j >= 0; j--) {
			//int[] qtmpfloor = new int[inoOfFloors];
			innerloop: for (int i = tmpi; i < inoOfFloors; i++) {
				day = i + 1;
				System.out.println("Day: " + day);
				//System.out.println("size of floors: " + sizeOfFloors[i]);
				//System.out.println("Sorted size of floors: " + sortedSizeOfFloors[j]);
				if (sizeOfFloors[i] == sortedSizeOfFloors[j]) {
					qfeasibleFloors.add(sizeOfFloors[i]);
					sizeOfFloors[i] = 0;
					//System.out.println("qtmpfloor:" + Arrays.toString(qtmpfloor));
					//System.out.println("sortedSizeOfFloors:" + Arrays.toString(sortedSizeOfFloors));
					Arrays.sort(qtmpfloor);
					reverse(qtmpfloor);
					if (qtmpfloor[0] != 0) {
				//		int tmpj = j;
						j = feasibilityCheck1(qtmpfloor, qfeasibleFloors, sortedSizeOfFloors, --j);
					
						//System.out.println("j out: " + j);
						//display(qfeasibleFloors);
					} else {
						display(qfeasibleFloors);
					}
					tmpi = ++i;
					break innerloop;
				} else {
					qtmpfloor[i] = sizeOfFloors[i];
				}
			}
		}
	}

	public int feasibilityCheck1(int[] qtmpfloor, Queue<Integer> qfeasibleFloors, int[] sortedSizeOfFloors, int tmpj) {
		int retj = 0;
		int index = qtmpfloor.length - 1;
		int lastelement = qtmpfloor[index];
		int valuefound = 0;

		// System.out.println("qfeasibleFloors:" + qfeasibleFloors);
		// System.out.println("sortedSizeOfFloors:" +
		// Arrays.toString(sortedSizeOfFloors));
		// System.out.println("qtmpfloor:" + Arrays.toString(qtmpfloor));
		outerloop: for (int j = tmpj; j >= 0; j--) {
	
			innerloop: for (Integer item : qtmpfloor) {
				if (sortedSizeOfFloors[j] == item) {
					valuefound++;
					qfeasibleFloors.add(item);
					retj = j;
					//System.out.println("qfeasibleFloors:" + qfeasibleFloors);
					break innerloop;
				}
				else if (valuefound == 0 && j == tmpj) {
					//System.out.println("j in:" + j);
					//System.out.println("tmpj :" + tmpj);
					retj = j;
					retj++;
				}
				if (lastelement == item) {
					// System.out.println("qfeasibleFloors:" + qfeasibleFloors);
					break outerloop;
				}
			}
		}
		display(qfeasibleFloors);
		return retj;
	}

	public void display(Queue<Integer> qfeasibleFloors) {
		while (!qfeasibleFloors.isEmpty()) {
			System.out.println(qfeasibleFloors.poll());
		}
		feasibleFloors.clear();
	}

	public static void reverse(int[] array) {
		// Length of the array
		int n = array.length;
		// Swapping the first half elements with last half
		// elements
		for (int i = 0; i < n / 2; i++) {
			// Storing the first half elements temporarily
			int temp = array[i];
			// Assigning the first half to the last half
			array[i] = array[n - i - 1];
			// Assigning the last half to the first half
			array[n - i - 1] = temp;
		}
	}
}
