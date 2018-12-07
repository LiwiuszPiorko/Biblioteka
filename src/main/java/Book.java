public class Book {
    private int id;
    private String tytuł;
    private String autor;
    private int rok;
    private int isbn;

    public Book() {
    }

    public Book(String tytuł, String autor, int rok, int isbn) {
        this.tytuł = tytuł;
        this.autor = autor;
        this.rok = rok;
        this.isbn = isbn;
    }

    public String getTytuł() {
        return tytuł;
    }

    public void setTytuł(String tytuł) {
        this.tytuł = tytuł;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getRok() {
        return rok;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", tytuł='" + tytuł + '\'' +
                ", autor='" + autor + '\'' +
                ", rok=" + rok +
                ", isbn=" + isbn +
                '}';
    }
}
