package bubbleSort;

import java.util.Random;

public class Mainclass {

	/**
	* zufälliges Befüllen eines Arrays mit Zahlen
	*/
	public static void randomFill(int[] arr) {
		
		Random r = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(100);
		}
	}
	
	/**
	* Methode die den Array auf der Konsole ausgibt
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
	* Der bubbleSort algorithmus der den Array sortiert
	*/
	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int k = 0; k < arr.length - 1; k++) {
				if(arr[k] > arr[k+1]) {
					
					int temp = arr[k];
					arr[k] = arr[k+1];
					arr[k+1] = temp;
				}
			}
		}
	}
	
	/*
	* Mainmethode die ein Array der Größe 5 erstellt, den zufällig befüllten Array und den sortieren Array ausgibt
	*/
	public static void main(String[] args) {
		int[] arr = new int[5];
		System.out.println("Zufälliges befüllen und Ausgeben eines Arrays");
		randomFill(arr);
		printArray(arr);
		
		System.out.println("Sortieren und Ausgeben des Arrays");
		bubbleSort(arr);
		printArray(arr);
		
	}

}