import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Adding the json file which has books stored in it
        BookProcessor bookProcessor = new BookProcessor("src/books.json");

        // Initialize the scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Infinite loop for the menu until the user chooses to exit
        while (true) {
            // Menu options for user
            System.out.println("\n=================Book Menu=================");
            System.out.println("=========Enter 1 to Display All Books======");
            System.out.println("=======Enter 2 to Find Books by Author=====");
            System.out.println("=====Enter 3 to Calculate Average Price====");
            System.out.println("==Enter 4 to Display Highest Priced Book===");
            System.out.println("====Enter 5 to Find Books by Category======");
            System.out.println("=============Enter 6 to Exit===============");

            // Read the user input
            int choice = scanner.nextInt();
            scanner.nextLine(); // get on the nextline.

            // Executing the  action based on user input
            switch (choice) {
                case 1:
                    // Display all books
                    bookProcessor.displayAllBooks();
                    break;

                case 2:

                    System.out.print("Enter Author Name: ");
                    String author = scanner.nextLine();
                    // Find and display books of the specified author
                    bookProcessor.findBooksByAuthor(author);
                    break;

                case 3:
                    // Calculate and display the average price of the books
                    bookProcessor.calculateAveragePrice();
                    break;

                case 4:
                    // Display the book with the highest price
                    bookProcessor.displayHighestPricedBook();
                    break;

                case 5:
                    System.out.print("Enter Category: ");
                    String category = scanner.nextLine();
                    // Find and display books in the specified category
                    bookProcessor.findBooksByCategory(category);
                    break;

                case 6:
                    // Exit the program
                    System.out.println("Exiting");
                    scanner.close();
                    return;

                default:
                    // Handle invalid choices
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
