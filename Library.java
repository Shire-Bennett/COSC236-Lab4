package lab4.library;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> catalog;
    private ArrayList<Member> members;

    public Library() {
        catalog = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(String title, String author) {
        if (title == null || title.trim().isEmpty()
                || author == null || author.trim().isEmpty()) {
            System.out.println("A book needs a title and author.");
            return;
        }

        if (findBookByTitle(title) != null) {
            System.out.println(title + " already exists.");
            return;
        }

        catalog.add(new Book(title, author));
        System.out.println(title + " has been added.");
    }

    public void registerMember(int memberId, String name) {
        if (memberId <= 0 || name == null || name.trim().isEmpty()) {
            System.out.println("A member needs a positive ID and a name.");
            return;
        }

        for (Member member : members) {
            if (member.getMemberId() == memberId
                    || member.getName().equalsIgnoreCase(name)) {
                System.out.println("Member ID or name already exists.");
                return;
            }
        }

        members.add(new Member(memberId, name));
        System.out.println(name + " has been registered.");
    }

    public Book findBookByTitle(String title) {
        for (Book book : catalog) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }

        return null;
    }

    public Member findMemberByName(String name) {
        for (Member member : members) {
            if (member.getName().equalsIgnoreCase(name)) {
                return member;
            }
        }

        return null;
    }

    public void removeBook(String title) {
        Book book = findBookByTitle(title);

        if (book == null) {
            System.out.println("Book not found.");
        } else if (!book.isAvailable()) {
            System.out.println("Cannot remove a borrowed book.");
        } else {
            catalog.remove(book);
            System.out.println(title + " has been removed.");
        }
    }

    public void removeMember(String name) {
        Member member = findMemberByName(name);

        if (member == null) {
            System.out.println("Member not found.");
        } else if (member.hasBorrowedBooks()) {
            System.out.println("Member must return their books first.");
        } else {
            members.remove(member);
            System.out.println(name + " has been removed.");
        }
    }

    public void showCatalog() {
        System.out.println("Library catalog:");

        for (Book book : catalog) {
            String status;

            if (book.isAvailable()) {
                status = "Available";
            } else {
                status = "Borrowed";
            }

            System.out.println(book.getTitle() + " by "
                    + book.getAuthor() + " - " + status);
        }
    }

    public void showAvailableBooks() {
        System.out.println("Available books:");

        for (Book book : catalog) {
            if (book.isAvailable()) {
                System.out.println(book.getTitle());
            }
        }
    }

    public void showMembers() {
        System.out.println("Library members:");

        for (Member member : members) {
            System.out.println(member.getMemberId()
                    + " - " + member.getName());
        }
    }
}