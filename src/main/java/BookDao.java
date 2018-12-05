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
        final String bookU = "insert into książki(tytuł, autor, rok,isbn) values(?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(bookU);
        statement.setString(1, book.getTytul());
        statement.setString(2, book.getAutor());
        statement.setInt(3, book.getRok());
        statement.setInt(4, book.getIsbn());
        statement.executeUpdate();
    }
    public Book read(int id) throws SQLException {
        final String query = "select * from książki where id=?";
        PreparedStatement select = connection.prepareStatement(query);
        select.setInt(1, id);
        ResultSet resultSet = select.executeQuery();
        Book result = null;
        if(resultSet.next()) {
            result = new Book();
            result.setTytul(resultSet.getString("Tytuł"));
            result.setAutor(resultSet.getString("Autor"));
            result.setRok(resultSet.getInt("Rok wydania"));
            result.setIsbn(resultSet.getInt("ISBN"));
        }
        return result;
    }
    public List<Book> allByAuthorsName(String autor) throws SQLException {
        final String query = "select * from książki where autor=?";
        PreparedStatement select = connection.prepareStatement(query);
        select.setString(1, autor);
        ResultSet resultSet = select.executeQuery();
        List<Book> result = new ArrayList<Book>();
        while(resultSet.next()) {
            Book book = new Book();
            book.setTytul(resultSet.getString("Tytuł"));
            book.setAutor(resultSet.getString("Autor"));
            book.setRok(resultSet.getInt("Rok wydania"));
            book.setIsbn(resultSet.getInt("ISBN"));
            result.add(book);
        }
        return result;
    }
}


