package lab5;
public class book {
    private String title;
    private String author;
    private double price;

    public book() {
        this.title = "Unknown Title";
        this.author = "Unknown Author";
        this.price = 0.0;
    }

    public book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("--- Book Details ---");
        System.out.println("Title:  " + title);
        System.out.println("Author: " + author);
        System.out.println("Price:  $" + price);
        System.out.println();
    }

    public static void main(String[] args) {
        book defaultBook = new book();
        defaultBook.displayDetails();

        book customBook = new book("The Great Gatsby", "F. Scott Fitzgerald", 14.99);
        customBook.displayDetails();
    }
}
