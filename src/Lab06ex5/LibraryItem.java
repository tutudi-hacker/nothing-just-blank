package Lab06ex5;

public class LibraryItem {
    protected String _title;
    protected String _id;

    public LibraryItem(String title, String id) {
        this._title = title;
        this._id = id;
    }

    public void display_info() {
        System.out.println("Item ID: " + this._id + " | Title: " + this._title);
    }

    public static void main(String[] args) {
        Book book = new Book("Clean Code", "BK-101", "Robert C. Martin");
        book.display_info();
    }
}

class Book extends LibraryItem {
    private String author;

    public Book(String title, String id, String author) {
        super(title, id);
        this.author = author;
    }

    @Override
    public void display_info() {
        System.out.println("[Book] " + this._title + " by " + this.author + " (ID: " + this._id + ")");
    }
}
