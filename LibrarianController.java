package lab4.library;

public class LibrarianController {
    private Library library;

    public LibrarianController(Library library) {
        this.library = library;
    }

    public void addBook(String title, String author) {
        library.addBook(title, author);
    }

    public void registerMember(int memberId, String name) {
        library.registerMember(memberId, name);
    }

    public void removeBook(String title) {
        library.removeBook(title);
    }

    public void removeMember(String name) {
        library.removeMember(name);
    }

    public void borrowBook(String title, String memberName) {
        Member member = library.findMemberByName(memberName);
        Book book = library.findBookByTitle(title);

        if (member == null) {
            System.out.println("Member not found.");
        } else if (book == null) {
            System.out.println("Book not found.");
        } else if (member.borrowBook(book)) {
            System.out.println(memberName
                    + " has successfully borrowed " + title);
        } else {
            System.out.println("Request rejected: "
                    + title + " is already borrowed.");
        }
    }

    public void returnBook(String title, String memberName) {
        Member member = library.findMemberByName(memberName);
        Book book = library.findBookByTitle(title);

        if (member == null) {
            System.out.println("Member not found.");
        } else if (book == null) {
            System.out.println("Book not found.");
        } else if (member.returnBook(book)) {
            System.out.println(memberName
                    + " has successfully returned " + title);
        } else {
            System.out.println(memberName + " didn't borrow " + title);
        }
    }

    public void lookupBook(String title) {
        Book book = library.findBookByTitle(title);

        if (book == null) {
            System.out.println("Book not found.");
        } else {
            System.out.println("Found: " + book.getTitle()
                    + " by " + book.getAuthor());
        }
    }

    public void lookupMember(String name) {
        Member member = library.findMemberByName(name);

        if (member == null) {
            System.out.println("Member not found.");
        } else {
            System.out.println("Found: " + member.getName()
                    + ", ID: " + member.getMemberId());
        }
    }

    public void showCatalog() {
        library.showCatalog();
    }

    public void showAvailableBooks() {
        library.showAvailableBooks();
    }

    public void showMembers() {
        library.showMembers();
    }
}