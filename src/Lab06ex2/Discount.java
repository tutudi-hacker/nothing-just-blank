package Lab06ex2;

public class Discount {
    public double apply(double amount) {
        return amount * 0.95;
    }

    public static void main(String[] args) {
        double originalPrice = 100.0;

        Discount baseDiscount = new Discount();
        SeasonalDiscount seasonalWithSuper = new SeasonalDiscount();
        SeasonalDiscountWithoutSuper seasonalWithoutSuper = new SeasonalDiscountWithoutSuper();

        System.out.println("Original Price: $" + originalPrice);
        System.out.println("Base Discount (5% off): $" + baseDiscount.apply(originalPrice));
        System.out.println("Seasonal Discount WITH super (5% off, then 10% off): $" + seasonalWithSuper.apply(originalPrice));
        System.out.println("Seasonal Discount WITHOUT super (only 10% off): $" + seasonalWithoutSuper.apply(originalPrice));
    }
}

class SeasonalDiscount extends Discount {
    @Override
    public double apply(double amount) {
        double afterBaseDiscount = super.apply(amount);
        return afterBaseDiscount * 0.90;
    }
}

class SeasonalDiscountWithoutSuper extends Discount {
    @Override
    public double apply(double amount) {
        return amount * 0.90;
    }
}
