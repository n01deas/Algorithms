package sequentialSearch;

import java.util.ArrayList;

import java.util.Collections;

public class Mainclass {

	public static void main(String[] args) {
		
		Mainclass seqSearch = new Mainclass();
		
		int result = seqSearch.search(seqSearch.data, 345);
		
		int result2 = seqSearch.search(seqSearch.dataS, "sit");

		switch(result) {
		case -1:
			System.out.println("Das Element wurde nicht gefunden");
			break;
		default:
			System.out.println("Das Element wurde an der Stelle " + result);
			break;
		}
		
		switch(result2) {
		case -1:
			System.out.println("Das Element wurde nicht gefunden");
			break;
		default:
			System.out.println("Das Element befindet sich and der Stelle " + result2);
			break;
		}
		
	}
	
	private ArrayList<Integer> data;
	
	private ArrayList<String> dataS;
	
	public Mainclass(){
		
		data = new ArrayList<Integer>();
		Collections.addAll(data, 103, 281 , 214, 4053, 345 , 345 ,435);
//		Collections.sort(data);
		
		dataS = new ArrayList<String>();
		Collections.addAll(dataS, "Lorem", "ipsum", "dolor", "sit", "amit");
	}

	public <ItemT> int search(ArrayList<ItemT> list, ItemT item ) {
		
		for (int i = 0; i < list.size(); i++) {
			
			if (list.get(i).equals(item)) {
				return i;
			}
			
		}	
		return -1;
	}
	
}