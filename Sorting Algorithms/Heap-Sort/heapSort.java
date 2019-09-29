package heapSort;

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
		
		public static void heapSort(int arr[]){
			
			int n = arr.length; 
			  
	        // Build heap (rearrange array) 
	        for (int i = n / 2 - 1; i >= 0; i--) 
	            heapify(arr, n, i); 

	        for (int i=n-1; i>=0; i--) 
	        { 
	            // Move current root to end 
	            int temp = arr[0]; 
	            arr[0] = arr[i]; 
	            arr[i] = temp; 
	  
	            // call max heapify on the reduced heap 
	            heapify(arr, i, 0); 
	        } 
	    } 
	  
	    // To heapify a subtree rooted with node i which is 
	    // an index in arr[]. n is size of heap 
	    static void heapify(int arr[], int n, int i) 
	    { 
	        int largest = i; // Initialize largest as root 
	        int l = 2*i + 1; // left = 2*i + 1 
	        int r = 2*i + 2; // right = 2*i + 2 
	  
	        // If left child is larger than root 
	        if (l < n && arr[l] > arr[largest]) 
	            largest = l; 
	  
	        // If right child is larger than largest so far 
	        if (r < n && arr[r] > arr[largest]) 
	            largest = r; 
	  
	        // If largest is not root 
	        if (largest != i) 
	        { 
	            int swap = arr[i]; 
	            arr[i] = arr[largest]; 
	            arr[largest] = swap; 
	  
	            // Recursively heapify the affected sub-tree 
	            heapify(arr, n, largest); 
	        } 
	    } 
		

	public static void main(String[] args) {
	
		int[] arr = new int[5];
		System.out.println("Zufälliges befüllen und Ausgeben eines Arrays");
		randomFill(arr);
		printArray(arr);
		
		System.out.println("Sortieren und Ausgeben des Arrays");
		heapSort(arr);
		printArray(arr);
		
	}
}