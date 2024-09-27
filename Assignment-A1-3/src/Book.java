import java.util.List;

public class Book {
    // Attributes of the Book class
    private String title;         // The title of the book
    private String author;        // The author of the book
    private Metadata data;    // data containing additional details about the book

    // Getter for the book title
    public String getTitle() {
        return title;
    }

    // Setter for the book title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for the author's name
    public String getAuthor() {
        return author;
    }

    // Setter for the author's name
    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter for the book's metadata
    public Metadata getdata() {
        return data;
    }

    // Setter for the book's metadata
    public void setData(Metadata data) {
        this.data = data;
    }

    // Method to display information about the book
    public void displayBookInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + data.getPrice());
        System.out.println("Categories: " + data.getCategories());
        System.out.println("ISBN: " + data.getIsbn());
        System.out.println("Pages: " + data.getPages());

    }

    // Nested class to hold metadata details about the book
    public  class Metadata {
        private double price;                    // The price of the book
        private List<String> categories;         // Categories for book
        private String isbn;                     // ISBN  of the book
        private int pages;                       // Number of pages in the book

        // Getter for the price
        public double getPrice() {
            return price;
        }

        // Setter for the price
        public void setPrice(double price) {
            this.price = price;
        }

        // Getter for categories
        public List<String> getCategories() {
            return categories;
        }

        // Setter for categories
        public void setCategories(List<String> categories) {
            this.categories = categories;
        }

        // Getter for the ISBN
        public String getIsbn() {
            return isbn;
        }

        // Setter for the ISBN
        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        // Getter for the number of pages
        public int getPages() {
            return pages;
        }

        // Setter for the number of pages
        public void setPages(int pages) {
            this.pages = pages;
        }
    }
}
