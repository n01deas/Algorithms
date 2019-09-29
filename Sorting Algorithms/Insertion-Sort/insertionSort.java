package insertionSort;

import java.util.Random;

public class Mainclass {
	
		/*
		 *  zufälliges Befüllen eines Arrays
		 */
	
		public static void randomFill(int[] arr) {
			
			Random r = new Random();
			for (int i = 0; i < arr.length; i++) {
				arr[i] = r.nextInt(100);
			}
		}
		
		/*
		 * Ausgeben des Arrays auf der Konsole 
		 */
		
		public static void printArray(int[] arr) {
			if(arr.length == 0) {
				System.out.println("[ ]");
				return;
			}
			
			System.out.print("[");
			for (int i = 0; i < arr.length - 1; i++) {
				System.out.print(arr[i] + ", ");
				
			}
			System.out.println(arr[arr.length - 1] + "]");
		}

		/*
		 * InsertionSort algorithmus der den Array sortiert
		 */
		
		public static void insertionSort(int[] arr) {
			for (int i = 1; i < arr.length; i++) {
				int valuetoSort = arr[i];
				int k = i;
				while (k > 0 && arr[k-1] >valuetoSort) {
					arr[k] = arr[k-1];
					k--;
				}
				arr[k] = valuetoSort;
			}
		}

		/*
		 * Erstellen eines Arrays der Länge 5
		 * Ausgeben des unsortierten - & sortierten Arrays
		 */
	public static void main(String[] args) {
		int[] arr = new int[5];
		
		System.out.println("Zufälliges befüllen und Ausgeben eines Arrays");
		randomFill(arr);
		printArray(arr);
		
		System.out.println("Sortieren und Ausgeben des Arrays");
		insertionSort(arr);
		printArray(arr);

	}

}