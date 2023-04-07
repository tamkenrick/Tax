public class TaxCal {
//    2100000
//    132000
    public Double taxCal(Double income, Double lessMPF, Boolean isJoint) {
//        System.out.println("Less MPF : "+lessMPF);
        double lessBasicAllowance = isJoint ? 132000 * 2 : 132000;
//        System.out.println("Less Basic Allowance : "+lessBasicAllowance);
        Double netIncome = income - lessMPF - lessBasicAllowance;
        if (netIncome <= 0) {
            return 0d;
        } else if (netIncome <= 50000) {
            return Math.floor(netIncome * 0.02);
        } else if (netIncome <= 100000) {
            return Math.floor(1000 + ((netIncome - 50000) * 0.06));
        } else if (netIncome <= 150000) {
            return Math.floor(1000 + 3000 + ((netIncome - 100000) * 0.10));
        } else if (netIncome <= 200000) {
            return Math.floor(1000 + 3000 + 5000 + ((netIncome - 150000) * 0.14));
        } else if (netIncome > 200000) {
            return Math.floor(1000 + 3000 + 5000 + 7000 + ((netIncome - 200000) * 0.17));
        }
        return null;
    }

    public Double taxStandardCal(Double income, Double lessMPF, Boolean isJoint) {
//        System.out.println("Less MPF : "+lessMPF);
        double lessBasicAllowance = isJoint ? 132000 * 2 : 132000;
//        System.out.println("Less Basic Allowance : "+lessBasicAllowance);
        Double netIncome = income - lessMPF;
        return netIncome <= 0 ? 0 : Math.floor(netIncome * 0.15);
    }
}
