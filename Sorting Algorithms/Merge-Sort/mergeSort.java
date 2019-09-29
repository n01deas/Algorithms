package mergesort;

import java.util.Random;

public class Mainclass {
	
	/*
	 * NICHT FERTIG
	 */

	//befüllt einen Array mit zufälligen Namen
			public static void randomFill(int[] arr) {
				
				Random r = new Random();
				for (int i = 0; i < arr.length; i++) {
					arr[i] = r.nextInt(100);
				}
			}
			
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
			
			public static int[] sort(int[] array)
			{

				if (array.length > 1) {
					int mitte = (int)(array.length / 2);

					int[] links = new int[mitte];
					for (int i = 0; i <= mitte - 1; i++) {
						links[i] = array[i];
					}

					int[] rechts = new int[array.length - mitte];
					for (int i = mitte; i <= array.length - 1; i++) {
						rechts[i - mitte] = array[i];
					}

					links = sort(links);
					rechts = sort(rechts);

					return merge(links, rechts);
				}
				else
				{
					return array;
				}
			}

		private static int[] merge(int[] links, int[] rechts)
		{
			int[] neueArray = new int[links.length + rechts.length];
			int indexLinks = 0;
			int indexRechts = 0;
			int indexErgebnis = 0;

			while (indexLinks < links.length && indexRechts < rechts.length) {
				if (links[indexLinks] < rechts[indexRechts]) {
					neueArray[indexErgebnis] = links[indexLinks];
					indexLinks += 1;
				} else {
					neueArray[indexErgebnis] = rechts[indexRechts];
					indexRechts += 1;
				}
				indexErgebnis += 1;
			}

			while (indexLinks < links.length) {
				neueArray[indexErgebnis] = links[indexLinks];
				indexLinks += 1;
				indexErgebnis += 1;
			}

			while (indexRechts < rechts.length) {
				neueArray[indexErgebnis] = rechts[indexRechts];
				indexRechts += 1;
				indexErgebnis += 1;
			}

			return neueArray;
		}
			
			public static void main(String[] args) {
				
			int[] arr = new int[5];
				
			System.out.println("Zufälliges befüllen und Ausgeben eines Arrays");
			randomFill(arr);
			printArray(arr);
				
			System.out.println("Sortieren und Ausgeben des Arrays");
			sort(arr);
			printArray(arr);

			}
}