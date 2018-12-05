import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj tytuł: ");
        String title = scanner.nextLine();
        System.out.println("Podaj autora: ");
        String author = scanner.nextLine();
        System.out.println("Podaj rok wydania: ");
        int year = scanner.nextInt();
        System.out.println("Podaj numer ISBN: ");
        int isbn = scanner.nextInt();

        Book book = new Book(title, author, year, isbn);
        try {
            BookDao bookDao = new BookDao();
            bookDao.saveBook(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Scanner scannerNext = new Scanner(System.in);
        System.out.println("Podaj autora by wyszukać pozycję: ");
        String lastName = scannerNext.nextLine();
        try {
            BookDao dao = new BookDao();
            List<Book> booksByAuthorsName = dao.allByAuthorsName(lastName);
            System.out.println(booksByAuthorsName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
