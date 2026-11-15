package Lab06ex9;

import java.util.ArrayList;
import java.util.List;

public abstract class Transport {
    protected double distance;

    public Transport(double distance) {
        this.distance = distance;
    }

    public abstract double calculate_fare();

    public void display_fare() {
        System.out.println(this.getClass().getSimpleName() + " (Distance: " + this.distance + " km) -> Fare: $" + calculate_fare());
    }

    public static void main(String[] args) {
        List<Transport> trips = new ArrayList<>();
        trips.add(new BusTransport(12.0));
        trips.add(new MetroTransport(8.5));
        trips.add(new TaxiTransport(6.0));

        for (Transport trip : trips) {
            trip.display_fare();
        }
    }
}

class BusTransport extends Transport {
    public BusTransport(double distance) {
        super(distance);
    }

    @Override
    public double calculate_fare() {
        return this.distance * 1.5;
    }
}

class MetroTransport extends Transport {
    public MetroTransport(double distance) {
        super(distance);
    }

    @Override
    public double calculate_fare() {
        return 10 + (this.distance * 2);
    }
}

class TaxiTransport extends Transport {
    public TaxiTransport(double distance) {
        super(distance);
    }

    @Override
    public double calculate_fare() {
        return 20 + (this.distance * 5);
    }
}
