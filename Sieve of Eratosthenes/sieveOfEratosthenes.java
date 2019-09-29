import java.util.Scanner;

public class Mainclass {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Geben Sie eine Nummer ein:");
		System.out.print(">");
		
		int inputWert = scan.nextInt();
		scan.close();
		
		
		boolean[] istPrimzahl = new boolean[inputWert];
		istPrimzahl[0] = false;
		for (int i = 0; i < inputWert; i++) {
			istPrimzahl[i] = true;
		}
		
		for (int k = 0; k <= inputWert; k++) {
			if (istPrimzahl[k-1]) {
				
				System.out.println(k);
				
				for (int j = k*k; j <= inputWert; j+= k) {
					istPrimzahl[j-1] = false;
					
				}
			}
		}
	}

}