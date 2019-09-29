package binarySearch;

import java.util.Arrays;

import java.util.Random;


public class Mainclass {

    public void binarySearch(int[] intArr, int start, int schluss, int zahl) {
        
        int grenze = start + ((schluss - start) / 2);
        
        if (intArr.length == 0) {
        	
            System.out.println("Der Array ist leer");
            return;
        }
        
        if (grenze >= intArr.length){
        	
            System.out.println("Die " + zahl + " ist nicht im Array enthalten.");
            return;
        }

        if (zahl > intArr[grenze]) {
        	
        	binarySearch(intArr, grenze + 1, schluss, zahl);
        	
        } 
        else if (zahl < intArr[grenze] && start != grenze) {
        	
        	binarySearch(intArr, start, grenze - 1, zahl);
        	
        }
        else if(zahl == intArr[grenze]) {
        	
            System.out.println(zahl + " an Position " + grenze + " enthalten.");
            
        } 
        else{
        	
            System.out.println(zahl + " nicht im Array enthalten.");
        }
    }

    public static void main(String[] args) {
    	
    	int[] arrayToSort = new int[30];
    	
     //   int[] arrayToSort = { 5, 3, 5, 228, 14, 69, 18, 27, 109, 85 };
    	
        randomFill(arrayToSort);
    	
        Arrays.sort(arrayToSort);
        
        Mainclass bs = new Mainclass();
        bs.binarySearch(arrayToSort, 0, arrayToSort.length - 1, 5);
       
    }
    
    public static void randomFill(int[] arrayToSort) {

		Random r = new Random();
		
		for (int i = 0; i < arrayToSort.length; i++) {
			arrayToSort[i] = r.nextInt(100);
    }
    } 
}