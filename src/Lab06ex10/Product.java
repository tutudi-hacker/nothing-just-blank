package Lab06ex10;

interface TrackViewsMixin {
    int getViews();
    void setViews(int views);

    default void recordView() {
        setViews(getViews() + 1);
    }

    default void displayViews() {
        System.out.println("Total Views: " + getViews());
    }
}

interface DiscountMixin {
    double getPrice();

    default double calculateDiscountedPrice(double discountPercent) {
        return getPrice() * (1.0 - (discountPercent / 100.0));
    }
}

public class Product {
    protected String name;
    protected double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public void displayProduct() {
        System.out.println("Product: " + this.name + " | Base Price: $" + this.price);
    }

    public static void main(String[] args) {
        DigitalProduct ebook = new DigitalProduct("Java Design Patterns E-Book", 40.0, "PDF");

        ebook.displayProduct();
        ebook.recordView();
        ebook.recordView();
        ebook.recordView();
        ebook.displayViews();

        double salePrice = ebook.calculateDiscountedPrice(25.0);
        System.out.println("Price after 25% discount: $" + salePrice);
    }
}

class DigitalProduct extends Product implements TrackViewsMixin, DiscountMixin {
    private String fileFormat;
    private int views;

    public DigitalProduct(String name, double price, String fileFormat) {
        super(name, price);
        this.fileFormat = fileFormat;
        this.views = 0;
    }

    @Override
    public int getViews() {
        return this.views;
    }

    @Override
    public void setViews(int views) {
        this.views = views;
    }

    @Override
    public void displayProduct() {
        System.out.println("Digital Product: " + this.name + " [" + this.fileFormat + "] | Base Price: $" + this.price);
    }
}
