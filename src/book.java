import java.util.Scanner;

class Book {
    String id, title, author, Status = "AVAILABLE"; // Wrapped in quotes
    double price; 

    Book(String id, String title, String author, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }
}

class LibraryMain { // Removed 'public' so it runs inside book.java
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0;
        
        System.out.print("Enter your Book (N): ");
        int n = sc.nextInt();
        sc.nextLine();
        
        Book[] store = new Book[n]; // Fixed capital B
        
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Book " + (i + 1) + " ---"); // Fixed \n
            System.out.print("ID: ");
            String id = sc.nextLine();
            System.out.print("Title: ");
            String title = sc.nextLine();
            System.out.print("Author: ");
            String author = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            sc.nextLine();
            
            store[i] = new Book(id, title, author, price);
            total += price; 
        }
        
        System.out.println("\n--- All book details ----"); // Fixed \n
        for (Book b : store) { // Fixed array name from 'library' to 'store'
            System.out.printf("ID: %s | Title: %s | Author: %s | Price: $%.2f\n", b.id, b.title, b.author, b.price);
        }
        
        double averagePrice = (n > 0) ? (total / n) : 0.0; // Fixed variable name from totalPrice to total
        System.out.printf("\nAverage Price of All Books: $%.2f\n", averagePrice);

        sc.close();
    }
}
