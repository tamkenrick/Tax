import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        TaxCal taxCal = new TaxCal();

        Scanner scan = new Scanner(System.in);
        double income1, income2 = 0;
        do {
            System.out.print("Please fill in the first people income : ");
            while (!scan.hasNextFloat()) {
                System.out.println("That's not a number!");
                System.out.print("Please fill in the first people income : ");
                scan.next();
            }
            income1 = scan.nextFloat();
        } while (income1 < 0);


        do {
            System.out.print("Please fill in the second people income : ");
            while (!scan.hasNextFloat()) {
                System.out.println("That's not a number!");
                System.out.print("Please fill in the second people income : ");
                scan.next();
            }
            income2 = scan.nextFloat();
        } while (income2 < 0);


        Double lessMPF1 = ((income1 * 0.05) <= 18000) ? (income1 * 0.05) : 18000;
        Double lessMPF2 = ((income2 * 0.05) <= 18000) ? (income2 * 0.05) : 18000;

        // 判斷輸入的是否是整數
        Double standardTax1 = taxCal.taxStandardCal(income1, lessMPF1, false);
        Double tax1 = taxCal.taxCal(income1, lessMPF1, false);
        Double lowestTax1 = Math.min(standardTax1, tax1);
        System.out.println("Tax required for 1st people (separate): " + lowestTax1);

        Double standardTax2 = taxCal.taxStandardCal(income2, lessMPF2, false);
        Double tax2 = taxCal.taxCal(income2, lessMPF2, false);
        Double lowestTax2 = Math.min(standardTax2, tax2);
        System.out.println("Tax required for 2nd people (separate): " + lowestTax2);

        Double separateTaxTotal = lowestTax1 + lowestTax2;
        System.out.println("Sum of separate Tax: " + separateTaxTotal);

        Double jointTax = taxCal.taxCal((income1 + income2), (lessMPF1 + lessMPF2), true);
//        Double jointStandardTax = taxCal.taxStandardCal((income1 + income2), (lessMPF1 + lessMPF2), true);
//        Double jointlowestTax = Math.min(jointTax, jointStandardTax);
        System.out.println("Tax required for both people (joint): " + jointTax);

        System.out.println();
        Double minTax = Math.min(separateTaxTotal, jointTax);
        if (minTax.equals(jointTax)) {
            System.out.println("Joint Assessment should be recommended for them.");
        } else if (minTax.equals(separateTaxTotal)) {
            System.out.println("Separapte Assessment should be recommended for them.");
        }
        System.out.println("Total Tax Payable : " + minTax);
    }



}
