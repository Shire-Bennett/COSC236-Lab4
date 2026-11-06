package lab4.library;

public class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public boolean borrowBook() {
        if (!isAvailable) {
            return false;
        }

        isAvailable = false;
        return true;
    }

    public void returnBook() {
        isAvailable = true;
    }
}
