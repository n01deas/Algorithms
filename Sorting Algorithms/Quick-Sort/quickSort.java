package quickSort;

import java.util.Random;

public class Mainclass {
	
	//zufälliges Befüllen eines Arrrays
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
	
	public static void quickSort(int[] arr) {
		
		_quickSort(0, arr.length - 1, arr);
		
	}
	
	//rekurisve Methode
	private static void _quickSort(int leftIndex, int rightIndex, int[] arr) {
		
		if (leftIndex >= rightIndex) {
			return; 
		}
		
		int i = leftIndex;
		int k = rightIndex -1;
		int pivot = arr[rightIndex];
		
		do {
			while (arr[i] <= pivot && i < rightIndex) {
				i++;
			}
			while(arr[k] >= pivot && k > leftIndex) {
				k--;
			} 
			if(i<k) {
				int temp = arr[i];
				arr[i] = arr[k];
				arr[k] = temp;
			}
		} while (i < k);
		
		if(arr[i] > pivot) {
			int temp = arr[i];
			arr[i] = arr[rightIndex];
			arr[rightIndex] = temp;
		}
		//rekursiver Aufruf
		_quickSort(leftIndex, i - 1, arr);
		_quickSort(i + 1, rightIndex, arr);
	} 
	
	public static void main(String[] args) {
		int[] arr = new int[5];
		System.out.println("Zufälliges befüllen und Ausgeben eines Arrays");
		randomFill(arr);
		printArray(arr);
		
		System.out.println("Sortieren und Ausgeben des Arrays");
		quickSort(arr);
		printArray(arr);
		
	}
}