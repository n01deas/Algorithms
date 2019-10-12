package formattingDecimalNumbers;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class formattingDecimalNumbers {

    public static void main(String[] args) {
    	
    	/*
    	 * formating with decimal komma
    	 */
    	
        double bigD = (double)1537959.274561024;
        double mediumD = (double)512 / 128;
        double smallD = (double)6.27456 / 1024;
        
        
        /*
         * standard output with full accuracy
         */
        System.out.println("Standardformat:");
        System.out.println("big double: " + bigD);
        System.out.println("medium double: " + mediumD);
        System.out.println("small double: " + smallD);
        
        
        /*
         * formatting with at least 3 digits before the decimal point and possibly 2 digits after the decimal point
         */
        System.out.println("\nFormatiert:");
        
        DecimalFormat format = new DecimalFormat("###000.##");
        
        System.out.println("big double: " + format.format(new Double(bigD)));
        System.out.println("medium double: " + format.format(new Double(mediumD)));
        System.out.println("small double: " + format.format(new Double(smallD)));
        
        
        /*
         * with localized formatting
         */
        System.out.println("\nUS-Locale:");
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        
        ((DecimalFormat) numberFormat).applyPattern("###.##");
        String zahl = numberFormat.format(new Double(bigD));
        
        System.out.println("formatierter String:");
        System.out.println(zahl);
        
        double d = new Double(zahl).doubleValue();
        System.out.println("beschnittener double-Wert:");
        System.out.println(d * 2);
    }
} 
