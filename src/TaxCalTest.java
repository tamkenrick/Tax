import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaxCalTest {

    @Test
    public void testTaxCal() {
        TaxCal cal = new TaxCal();
        Double income = 450000d;
        Double lessMPF = 18000d;
        Double result = 33000d;
        assertEquals("Income is 450000, lessMPF is 18000 result must be 33000", result, cal.taxCal(income,lessMPF,false));
    }

    @Test
    public void testJointTaxCal() {
        TaxCal cal = new TaxCal();
        Double income = 450000d+450000d;
        Double lessMPF = 18000d+18000d;
        Double result = 84000d;
        assertEquals("Income is 450000 and 450000, lessMPF is 18000 and 18000,joint result must be 84000", result, cal.taxCal(income,lessMPF,true));
    }

    @Test
    public void testTaxStandardCal() {
        TaxCal cal = new TaxCal();
        Double income = 450000d;
        Double lessMPF = 18000d;
        Double result = 64800d;
        assertEquals("Income is 450000, lessMPF is 18000 result must be 64800", result, cal.taxStandardCal(income,lessMPF,false));
    }
}