package Lab06ex8;
import java.util.ArrayList;
import java.util.List;

public class RentalItem {
    protected String itemName;
    protected int days;

    public RentalItem(String itemName, int days) {
        this.itemName = itemName;
        this.days = days;
    }

    public double calculate_cost() {
        return 0.0;
    }

    public static void main(String[] args) {
        List<RentalItem> rentals = new ArrayList<>();
        rentals.add(new CarRental("Toyota Camry", 3, 50.0, 25.0));
        rentals.add(new BikeRental("Mountain Bike", 4, 12.0));
        rentals.add(new ToolRental("Power Drill", 2, 15.0, 10.0));
        rentals.add(new CameraRental("Sony A7 IV", 5, 35.0, 15.0));

        double totalCost = 0.0;
        for (RentalItem item : rentals) {
            double cost = item.calculate_cost();
            totalCost += cost;
            System.out.println(item.getClass().getSimpleName() + " (" + item.itemName + " for " + item.days + " days) -> Cost: $" + cost);
        }
        System.out.println("Total Rental Cost: $" + totalCost);
    }
}

class CarRental extends RentalItem {
    private double dailyRate;
    private double insuranceFee;

    public CarRental(String itemName, int days, double dailyRate, double insuranceFee) {
        super(itemName, days);
        this.dailyRate = dailyRate;
        this.insuranceFee = insuranceFee;
    }

    @Override
    public double calculate_cost() {
        return (this.days * this.dailyRate) + this.insuranceFee;
    }
}

class BikeRental extends RentalItem {
    private double dailyRate;

    public BikeRental(String itemName, int days, double dailyRate) {
        super(itemName, days);
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculate_cost() {
        return this.days * this.dailyRate;
    }
}

class ToolRental extends RentalItem {
    private double dailyRate;
    private double maintenanceDeposit;

    public ToolRental(String itemName, int days, double dailyRate, double maintenanceDeposit) {
        super(itemName, days);
        this.dailyRate = dailyRate;
        this.maintenanceDeposit = maintenanceDeposit;
    }

    @Override
    public double calculate_cost() {
        return (this.days * this.dailyRate) + this.maintenanceDeposit;
    }
}

class CameraRental extends RentalItem {
    private double dailyRate;
    private double lensKitFee;

    public CameraRental(String itemName, int days, double dailyRate, double lensKitFee) {
        super(itemName, days);
        this.dailyRate = dailyRate;
        this.lensKitFee = lensKitFee;
    }

    @Override
    public double calculate_cost() {
        return (this.days * this.dailyRate) + (this.days * this.lensKitFee);
    }
}
