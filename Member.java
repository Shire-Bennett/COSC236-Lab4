package lab4.library;

import java.util.ArrayList;

public class Member {
    private int memberId;
    private String name;
    private ArrayList<Book> borrowedBooks;

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        borrowedBooks = new ArrayList<>();
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public boolean hasBorrowedBooks() {
        return !borrowedBooks.isEmpty();
    }

    public boolean borrowBook(Book book) {
        if (book == null || !book.borrowBook()) {
            return false;
        }

        borrowedBooks.add(book);
        return true;
    }

    public boolean returnBook(Book book) {
        if (!borrowedBooks.contains(book)) {
            return false;
        }

        borrowedBooks.remove(book);
        book.returnBook();
        return true;
    }
}