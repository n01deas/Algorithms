package performanceMeasurement;

public class Mainclass {

	public static void main(String[] args) {
	
		//unterschiedliche Arrays für die Algortihmen + bef�llen
		
		//Bubblesort
		int[] bubbleArray = new int[10000];
		bubbleSort.Mainclass.randomFill(bubbleArray);
		
		//InsertionSort
		int[] insertionArray = new int[10000];
		insertionSort.Mainclass.randomFill(insertionArray);
		
		//QuickSort
		int[] quickArray = new int[10000];
		quickSort.Mainclass.randomFill(quickArray);
		
		
//		Alternative
//		int[] arrInsertion = Arrays.copyOf(bubbleArray, bubbleArray.length);
//		int[] quickArray = Arrays.copyOf(bubbleArray, bubbleArray.length);

		/*
		*Performance in MS
		*/
		
		System.out.println("Starting performance Measurment ...");
		{
			//Zeit mit dem Time stamp
			long start = System.currentTimeMillis();
			bubbleSort.Mainclass.bubbleSort(bubbleArray);
			long end = System.currentTimeMillis();
			long diff = end - start; // => Gitb die Zeit
			
			System.out.println("Bubble Sort: " + diff  + "ms");
			
			
		}
		{
			long start = System.currentTimeMillis();
			quickSort.Mainclass.quickSort(quickArray);
			long end = System.currentTimeMillis();
			long diff = end - start; // => Gitb die Zeit
			
			System.out.println("Quick Sort: " + diff  + "ms");
			
			
		}
		{
			long start = System.currentTimeMillis();
			insertionSort.Mainclass.insertionSort(insertionArray);
			long end = System.currentTimeMillis();
			long diff = end - start; // => Gitb die Zeit
			
			System.out.println("Insertion Sort: " + diff + "ms");			
		}
		
		System.out.println("Done Performance Measurement");
	}
}