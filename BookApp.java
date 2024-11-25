import java.util.Scanner;

public class BookApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the number of books: ");
        int n = in.nextInt();
        in.nextLine();  // Consume the newline character

        stock[] arr = new stock[n];
        System.out.println("Enter the title, author, price, and stock:");

        // Input book details
        for (int i = 0; i < n; i++) {
            System.out.print("Book " + (i + 1) + " Title: ");
            String t = in.nextLine();

            System.out.print("Book " + (i + 1) + " Author: ");
            String a = in.nextLine();

            System.out.print("Book " + (i + 1) + " Price: ");
            double p = in.nextDouble();

            System.out.print("Book " + (i + 1) + " Stock: ");
            int s = in.nextInt();
            in.nextLine();  // Consume the newline character

            arr[i] = new stock(t, a, p, s);
        }

        // Menu for issuing and returning books
        boolean running = true;
        while (running) {
            System.out.println("\n1. Display all books");
            System.out.println("2. Issue a book");
            System.out.println("3. Return a book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = in.nextInt();
            in.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    // Display all books
                    for (int i = 0; i < n; i++) {
                        System.out.println("\nBook " + (i + 1) + ":");
                        arr[i].displayStock();
                    }
                    break;

                case 2:
                    // Issue a book
                    System.out.print("Enter the book title to issue: ");
                    String titleToIssue = in.nextLine();
                    boolean issued = false;

                    for (int i = 0; i < n; i++) {
                        if (arr[i].title.equalsIgnoreCase(titleToIssue)) {
                            arr[i].issueBook();
                            issued = true;
                            break;
                        }
                    }
                    if (!issued) {
                        System.out.println("Book not found!");
                    }
                    break;

                case 3:
                    // Return a book
                    System.out.print("Enter the book title to return: ");
                    String titleToReturn = in.nextLine();
                    boolean returned = false;

                    for (int i = 0; i < n; i++) {
                        if (arr[i].title.equalsIgnoreCase(titleToReturn)) {
                            arr[i].returnBook();
                            returned = true;
                            break;
                        }
                    }
                    if (!returned) {
                        System.out.println("Book not found!");
                    }
                    break;

                case 4:
                    // Exit the program
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        in.close();
    }
}

class bookStore {
    String author;
    String title;
    double price;

    bookStore() {
        author = null;
        title = null;
        price = 0;
    }

    bookStore(String s1, String s2, double x) {
        author = s1;
        title = s2;
        price = x;
    }

    void display() {
        System.out.println("Title : " + title + "\nAuthor : " + author + "\nPrice : " + price);
    }
}

class stock extends bookStore {
    int stock;

    stock() {
        super();
    }

    stock(String s1, String s2, double x, int s) {
        super(s1, s2, x);
        stock = s;
    }

    void displayStock() {
        display();
        System.out.println("Available Stock : " + stock);
    }

    void issueBook() {
        if (stock == 0) {
            System.out.println("Stock is not available!");
            return;
        }
        stock--;
        System.out.println("Book issued successfully!");
    }

    void returnBook() {
        System.out.println("Returned Successfully!");
        stock++;
    }
}
