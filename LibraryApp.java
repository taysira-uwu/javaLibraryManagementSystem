import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> books = new ArrayList<>();

        while (true) {

            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add a book");
            System.out.println("2. Display all books");
            System.out.println("3. Remove a book");
            System.out.println("4. Search for a book");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");

            int choice;

            // check if input is a number
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("❌ Please enter a valid number.");
                scanner.nextLine();
                continue;
            }

            if (choice == 1) {

                // add a book
                System.out.print("Enter book name: ");
                String bookName = scanner.nextLine().trim();

                // prevent empty book name
                if (bookName.isEmpty()) {
                    System.out.println("❌ Book name cannot be empty.");
                } else {
                    books.add(bookName);
                    System.out.println("✅ Book added successfully.");
                }

            } else if (choice == 2) {

                // display all books
                System.out.println("\n📚 Book List:");
                if (books.isEmpty()) {
                    System.out.println("No books available.");
                } else {
                    for (int i = 0; i < books.size(); i++) {
                        System.out.println((i + 1) + ". " + books.get(i));
                    }
                }

                // show total number of books
                System.out.println("Total books: " + books.size());

            } else if (choice == 3) {

                // remove a book
                System.out.print("Enter the book name to remove: ");
                String bookToRemove = scanner.nextLine().toLowerCase();

                boolean removed = false;

                for (int i = 0; i < books.size(); i++) {
                    // compare names without case sensitivity
                    if (books.get(i).toLowerCase().equals(bookToRemove)) {

                        // ask for confirmation
                        System.out.print("Are you sure you want to delete this book? (y/n): ");
                        String confirm = scanner.nextLine();

                        if (confirm.equalsIgnoreCase("y")) {
                            books.remove(i);
                            System.out.println("🗑️ Book removed successfully.");
                        } else {
                            System.out.println("❌ Delete cancelled.");
                        }

                        removed = true;
                        break;
                    }
                }

                if (!removed) {
                    System.out.println("❌ Book not found.");
                }

            } else if (choice == 4) {

                // search for a book
                System.out.print("Enter the book name to search: ");
                String searchBook = scanner.nextLine().toLowerCase();

                boolean found = false;

                for (String book : books) {
                    // ignore case while searching
                    if (book.toLowerCase().equals(searchBook)) {
                        found = true;
                        break;
                    }
                }

                if (found) {
                    System.out.println("🔍 Book found in the library.");
                } else {
                    System.out.println("❌ Book not found.");
                }

            } else if (choice == 5) {

                // exit program
                System.out.println("👋 Program terminated. Goodbye!");
                break;

            } else {
                System.out.println("❌ Invalid choice.");
            }
        }

        scanner.close();
    }
}