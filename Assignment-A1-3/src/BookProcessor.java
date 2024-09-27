import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class BookProcessor {
    // List to hold all the books processed from the JSON file
    private List<Book> books;

    // Constructor to convert the JSON file into list of books
    public BookProcessor(String filePath) {
        try {
            // Read the JSON file content into a String (single line)
            String json = new String(Files.readAllBytes(Paths.get(filePath)));

            // Use Gson to directly convert the JSON string into a list of books
            Gson gson = new Gson();
            books = List.of(gson.fromJson(json, Book[].class));  // Deserialize to array and convert to List
        } catch (Exception e) {
            System.err.println("Error reading JSON file");
        }
    }
    // Method to display information about all books
    public void displayAllBooks() {
        // Iterate through the list of books and display each  info
        books.forEach(Book::displayBookInfo);
    }

    // Method to find and display books by a specific author
    public void findBooksByAuthor(String author) {
        // Filter the list to find books matching the specified author
        List<Book> filteredBooks = books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());

        // Display the filtered books
        filteredBooks.forEach(Book::displayBookInfo);
    }

    // Method to calculate and display the average price of all books
    public void calculateAveragePrice() {
        // Calculate the average price
        double averagePrice = books.stream()
                .mapToDouble(book -> book.getdata().getPrice())
                .average()
                .orElse(0); // Default to 0 if there are no books

        // Print the average price to the console
        System.out.println("Average Price: " + averagePrice);
    }

    // Method to display the book with the highest price
    public void displayHighestPricedBook() {
        // Find the book with the maximum price
        Optional<Book> highestPricedBook = books.stream()
                .max((b1, b2) -> Double.compare(b1.getdata().getPrice(), b2.getdata().getPrice()));

        // checking if there is any high priced book
        highestPricedBook.ifPresent(book -> {
            System.out.println("Highest Priced Book:");
            book.displayBookInfo();
        });
    }

    // Method to find  books belonging to a specific category
    public void findBooksByCategory(String category) {
        // Filter the list
        List<Book> filteredBooks = books.stream()
                .filter(book -> book.getdata().getCategories().contains(category))
                .collect(Collectors.toList());

        // Display the filtered books
        filteredBooks.forEach(Book::displayBookInfo);
    }
}
