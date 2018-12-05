public class Book {
    private int id;
    private String tytul;
    private String autor;
    private int rok;
    private int isbn;

    public Book() {
    }

    public Book(String tytul, String autor, int rok, int isbn) {
        this.tytul = tytul;
        this.autor = autor;
        this.rok = rok;
        this.isbn = isbn;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
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
}
