import java.util.Scanner;

public class Main {

    private static boolean isRunning = true;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LibraryService library = new LibraryService();

        AutoSaveTask autoSave = new AutoSaveTask(library);
        Thread autoSaveThread = new Thread(autoSave);
        autoSaveThread.setDaemon(true);
        autoSaveThread.start();

        System.out.println("====================================");
        System.out.println("     📚 Library Management System   ");
        System.out.println("====================================");

        while (isRunning) {
            showMenu();
            System.out.print("Enter choice: ");
            int choice = getInt(sc);

            switch (choice) {

                case 1:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    library.addBook(title, author);
                    break;

                case 2:
                    System.out.print("Enter Member name: ");
                    String name = sc.nextLine();
                    library.addMember(name);
                    break;

                case 3:
                    System.out.print("Enter Book ID to issue: ");
                    int bIssue = getInt(sc);

                    System.out.print("Enter Member ID: ");
                    int mIssue = getInt(sc);

                    library.issueBook(bIssue, mIssue);
                    break;

                case 4:
                    System.out.print("Enter Book ID to return: ");
                    int bReturn = getInt(sc);

                    System.out.print("Enter Member ID: ");
                    int mReturn = getInt(sc);

                    library.returnBook(bReturn, mReturn);
                    break;

                case 5:
                    System.out.println("---- All Books ----");
                    library.showAllBooks();
                    break;

                case 6:
                    System.out.println("---- All Members ----");
                    library.showAllMembers();
                    break;

                case 7:
                    exitSystem();
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

            System.out.println("\n------------------------------------\n");
        }
    }

    public static void showMenu() {
        System.out.println("Choose an option:");
        System.out.println("1. Add Book");
        System.out.println("2. Add Member");
        System.out.println("3. Issue Book");
        System.out.println("4. Return Book");
        System.out.println("5. View All Books");
        System.out.println("6. View All Members");
        System.out.println("7. Exit");
    }

    public static void exitSystem() {
        System.out.println("Saving data and exiting...");
        isRunning = false;
        System.out.println("Goodbye 👋");
        System.exit(0);
    }

    private static int getInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Please enter a valid number!");
            sc.next();
        }
        int value = sc.nextInt();
        sc.nextLine();
        return value;
    }
}
