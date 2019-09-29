package palindromes;

/**
 * Importieren der Scanner Klasse
 * 
 * @author Jonas Schmid
 * @version 1.0
 */

import java.util.Scanner;

public class Palindrome {
		
		public static void main(String[] args) {
			
			System.out.println("Bitte geben Sie ein Word ein, das Sie prüfen möchten:");
			System.out.print(">");
			
			/**
			 * Erzeugen eines Scannerobjekts
			 */
			Scanner scan = new Scanner(System.in);
			
			/**
			 * Die auf der Konsole eingelesene Linie wird in Kleinbuchstaben in der variablen userinput gespeichert
			 * Außerdem werden Leerzeichen gelöscht
			 */
	        String usereingabe = scan.nextLine().toLowerCase().replaceAll(" ", "");
	        
	        /**
	         * Der userinput wird in einen char array übergeben
	         */
	        char[] wort = usereingabe.toCharArray(); 
	        
	        /**
	         * Ausgabe auf der Konsole: Prüfung der methode istPalindrom mit dem eingebenen Wort
	         */
	        System.out.println(istPalindrom(wort));  
	        
	        /**
	         * schließen des Scanners
	         */
	        scan.close();
	    }
		
		/**
		 * Methode um zu überprüfen ob es sich um ein Palindrom handelt.
		 * Erstes if checkt ob das wort mit dem selben Buchstaben anfängt und endet, wenn das nicht der fall ist, ist es kein palindrom
		 * Danach wird der 2te Buchstabe und der zweit letzte Buchstabe auf Gleichheit geprüft, und so weiter...
		 * 
		 * @param wort Der Methode wird der char array wort als Parameter mitgegeben, da dieser überprüft werden soll
		 * @return	Die Ausgabe der Methode kann entweder true oder false sein
		 */
	    public static boolean istPalindrom(char[] wort){
	    	int anfangsbuchstabe = 0;
	        int letzterbuchstabe = wort.length - 1;
	        
	        while (letzterbuchstabe > anfangsbuchstabe) {
	        	
	            if (wort[anfangsbuchstabe] != wort[letzterbuchstabe]) {
	                return false;
	            }
	            
	            ++anfangsbuchstabe;
	            --letzterbuchstabe;
	        }
	        
	        return true;
	    }
	}
