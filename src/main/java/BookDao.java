import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteka?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "admin";
    private Connection connection;

    public BookDao()throws SQLException {
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void saveBook(Book book) throws SQLException {
        final String bookU = "insert into ksiazki(tytuł, autor, rok,isbn) values(?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(bookU);
        statement.setString(1, book.getTytuł());
        statement.setString(2, book.getAutor());
        statement.setInt(3, book.getRok());
        statement.setInt(4, book.getIsbn());
        statement.executeUpdate();
    }
    public List<Book> allByAuthorsName(String autor) throws SQLException {
        final String query = "select * from ksiazki where autor=?";
        PreparedStatement select = connection.prepareStatement(query);
        select.setString(1, autor);
        ResultSet resultSet = select.executeQuery();
        List<Book> result = new ArrayList<Book>();
        while(resultSet.next()) {
            Book book = new Book();
            book.setTytuł(resultSet.getString("tytuł"));
            book.setAutor(resultSet.getString("autor"));
            book.setRok(resultSet.getInt("rok"));
            book.setIsbn(resultSet.getInt("isbn"));
            result.add(book);
        }
        return result;
    }
}


