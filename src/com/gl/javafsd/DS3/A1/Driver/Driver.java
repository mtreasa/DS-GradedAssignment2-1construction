package com.gl.javafsd.DS3.A1.Driver;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Enter the total number of floors in the building: ");
			int noOfFloors = scan.nextInt();
			int[] sizeOfFloors = new int[noOfFloors];
			char breakFlag = 0;
			for (int i = 0; i < noOfFloors; i++) {
				int day = i + 1;
				System.out.println("Size of the floor on Day " + day);
				int floorSize = scan.nextInt();
				for (int j = 0; j <= i; j++) {
					if (i == 0) {
						sizeOfFloors[i] = floorSize;
						break;
					} else if (floorSize == sizeOfFloors[j]) {
						System.out.println("Floor Size should be distinct; Start over.");
						breakFlag = 'X';
						return;
					} else if (j == i)
						sizeOfFloors[i] = floorSize;
				}
				if (breakFlag == 'X')
					break;
			}
				Construct objConstruct = new Construct();
				objConstruct.buildFloors(sizeOfFloors, noOfFloors);
		}

	}

}