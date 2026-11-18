package Lab06ex3;

import java.util.ArrayList;
import java.util.List;

interface Trackable {
    void track();
}

public abstract class DeliveryService implements Trackable {
    protected String trackingId;
    protected double distanceKm;

    public DeliveryService(String trackingId, double distanceKm) {
        this.trackingId = trackingId;
        this.distanceKm = distanceKm;
    }

    public abstract double calculate_eta();

    public static void main(String[] args) {
        List<DeliveryService> deliveries = new ArrayList<>();
        deliveries.add(new CourierService("CR-101", 30.0));
        deliveries.add(new DroneDelivery("DR-202", 15.0));
        deliveries.add(new CargoTruck("CT-303", 180.0));

        for (DeliveryService service : deliveries) {
            service.track();
            System.out.println("Estimated Time of Arrival: " + service.calculate_eta() + " hours\n");
        }
    }
}

class CourierService extends DeliveryService {
    public CourierService(String trackingId, double distanceKm) {
        super(trackingId, distanceKm);
    }

    @Override
    public void track() {
        System.out.println("Courier [" + this.trackingId + "]: Package is out for local van delivery.");
    }

    @Override
    public double calculate_eta() {
        return this.distanceKm / 40.0;
    }
}

class DroneDelivery extends DeliveryService {
    public DroneDelivery(String trackingId, double distanceKm) {
        super(trackingId, distanceKm);
    }

    @Override
    public void track() {
        System.out.println("Drone [" + this.trackingId + "]: Airborne at 120m altitude heading to drop zone.");
    }

    @Override
    public double calculate_eta() {
        return this.distanceKm / 60.0;
    }
}

class CargoTruck extends DeliveryService {
    public CargoTruck(String trackingId, double distanceKm) {
        super(trackingId, distanceKm);
    }

    @Override
    public void track() {
        System.out.println("Cargo Truck [" + this.trackingId + "]: In transit on highway route.");
    }

    @Override
    public double calculate_eta() {
        return (this.distanceKm / 60.0) + 1.0;
    }
}
