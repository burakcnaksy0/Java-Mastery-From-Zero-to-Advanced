package L0_PatikaQuestions;

import java.util.Comparator;
import java.util.TreeSet;


public class D5_HomeworkSorterwithBook {

    /*
    Book isminde bir sınıf tasarlayınız. Bu sınıf Comparable interface'den kalıtım alıp
    "compareTo" metodunu override ediniz. Bu metodun içinde kitabı A'dan Z'ye isme göre
    sıralayan kodu yazınız. Bu sınıftan 5 tane nesne oluşturun ve nesneleri Set tipinde
    bir yapısında saklayınız. Sonra ikinci kez Set tipinden bir veri yapısı kullanın ve
    kitapları sayfa sayısına göre sıralamasını sağlayınız.

    Book sınıfı kitap ismi, sayfa sayısı, yazarın ismi, yayın tarihi değişkenlerinden oluşmaktadır.
     */
    public static void main(String[] args) {
        TreeSet<Book> books = new TreeSet<>();

        Book b1 = new Book("Vadideki Zambak", "Honoré de Balzac", "1835", 336);
        Book b2 = new Book("Suç ve Ceza", "Fyodor Dostoyevski", "1866", 1152);
        Book b3 = new Book("Satranç", "Stefan Zweig", "1942", 72);
        Book b4 = new Book("Martin Eden", "Jack London", "1909", 496);
        Book b5 = new Book("Beyaz Diş", "Jack London", "1906", 256);

        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);
        books.add(b5);

        // A'dan Z'ye isme göre sırala
        System.out.println("Kitaplar A'dan Z'ye isme göre sıralandı:");
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println();
        TreeSet<Book> booksByPages = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                if (b1.numberPages > b2.numberPages) {
                    return 1;
                } else if (b1.numberPages < b2.numberPages) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        booksByPages.addAll(books);

        System.out.println("Sayfa sayısına göre sıralandı:");
        for (Book book : booksByPages) {
            System.out.println(book);
        }

    }
}

class Book implements Comparable<Book> {
    String bookTitle;
    String authorName;
    String publicationDate;
    int numberPages;

    public Book(String bookTitle, String authorName, String publicationDate, int numberPages) {
        this.bookTitle = bookTitle;
        this.authorName = authorName;
        this.publicationDate = publicationDate;
        this.numberPages = numberPages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookTitle='" + bookTitle + '\'' +
                ", authorName='" + authorName + '\'' +
                ", publicationDate='" + publicationDate + '\'' +
                ", numberPages=" + numberPages +
                '}';
    }

    @Override
    public int compareTo(Book o) {
        if (this.bookTitle.compareTo(o.bookTitle) < 0) {
            return -1;
        } else if (this.bookTitle.compareTo(o.bookTitle) > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
