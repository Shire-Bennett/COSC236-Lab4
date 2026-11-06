package lab4.library;

public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();
        LibrarianController controller = new LibrarianController(library);

        System.out.println("*** Library Management System ***");

        System.out.println("\n*** Adding books ***");
        controller.addBook("Dune", "Frank Herbert");
        controller.addBook("1984", "George Orwell");
        controller.addBook("Moby Dick", "Herman Melville");

        System.out.println("\n*** Registering members ***");
        controller.registerMember(1, "Alice");
        controller.registerMember(2, "Bob");

        System.out.println("\n*** Displaying catalog ***");
        controller.showCatalog();

        System.out.println("\n*** Displaying members ***");
        controller.showMembers();

        System.out.println("\n*** Looking up a book ***");
        controller.lookupBook("Dune");

        System.out.println("\n*** Looking up a member ***");
        controller.lookupMember("Alice");

        System.out.println("\n*** Alice borrows Dune ***");
        controller.borrowBook("Dune", "Alice");

        System.out.println("\n*** Bob borrows 1984 ***");
        controller.borrowBook("1984", "Bob");

        System.out.println("\n*** Showing available books ***");
        controller.showAvailableBooks();

        System.out.println("\n*** Bob tries to borrow Dune ***");
        controller.borrowBook("Dune", "Bob");

        System.out.println("\n*** Alice returns Dune ***");
        controller.returnBook("Dune", "Alice");

        System.out.println("\n*** Bob borrows Dune ***");
        controller.borrowBook("Dune", "Bob");

        System.out.println("\n*** Trying to remove borrowed Dune ***");
        controller.removeBook("Dune");

        System.out.println("\n*** Trying to remove Bob ***");
        controller.removeMember("Bob");

        System.out.println("\n*** Bob returns his books ***");
        controller.returnBook("Dune", "Bob");
        controller.returnBook("1984", "Bob");

        System.out.println("\n*** Removing a book ***");
        controller.removeBook("Moby Dick");

        System.out.println("\n*** Removing a member ***");
        controller.removeMember("Bob");

        System.out.println("\n*** Final catalog ***");
        controller.showCatalog();

        System.out.println("\n*** Final members ***");
        controller.showMembers();
    }
}