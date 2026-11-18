package Lab06ex1;

public class InsurancePolicy {
    protected double baseRate;

    public InsurancePolicy(double baseRate) {
        this.baseRate = baseRate;
    }

    public double calculate_premium() {
        return this.baseRate;
    }

    public static void main(String[] args) {
        InsurancePolicy healthPolicy = new HealthInsurance(500.0);
        InsurancePolicy carPolicy = new CarInsurance(800.0);

        System.out.println("Overridden Health Premium: $" + healthPolicy.calculate_premium());
        System.out.println("Overridden Car Premium: $" + carPolicy.calculate_premium());

        CarInsurance specificCarPolicy = new CarInsurance(800.0);
        System.out.println("Overloaded Car Premium (Age 22): $" + specificCarPolicy.calculate_premium(22));
        System.out.println("Overloaded Car Premium (Age 22, 2 accidents): $" + specificCarPolicy.calculate_premium(22, 2));
    }
}

class HealthInsurance extends InsurancePolicy {
    public HealthInsurance(double baseRate) {
        super(baseRate);
    }

    @Override
    public double calculate_premium() {
        return this.baseRate * 1.2;
    }
}

class CarInsurance extends InsurancePolicy {
    public CarInsurance(double baseRate) {
        super(baseRate);
    }

    @Override
    public double calculate_premium() {
        return this.baseRate * 1.15;
    }

    public double calculate_premium(int ageOfDriver) {
        double premium = calculate_premium();
        if (ageOfDriver < 25) {
            premium += 200.0;
        }
        return premium;
    }

    public double calculate_premium(int age, int accidentHistory) {
        double premium = calculate_premium(age);
        premium += (accidentHistory * 150.0);
        return premium;
    }
}
