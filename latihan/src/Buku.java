public class Buku {

    String isbn;
    String judul;

    public Buku(String isbn, String judul) {
        this.isbn = isbn;
        this.judul = judul;
    }

    public void infoBuku() {
        System.out.println(isbn + " - " + judul);
    }
}