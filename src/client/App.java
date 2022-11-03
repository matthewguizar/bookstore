package client;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Book;
import entity.Chapter;
import entity.ChapterId;
import entity.Publisher;
import util.HibernateUtil;

public class App {
    public static void main(String[] args) {
        Session session = HibernateUtil.SessionFactory().openSession();
        session.getTransaction().begin();

        // Publisher publisher = new Publisher("ORIE", "O'Reilly Media, Inc");
        // Book book = new Book("9781449334376", "Just Hibernate", publisher);
        
        // ChapterId chapter1Id = new ChapterId(book.getIsbn(), 1);
        // Chapter  chapter1 = new Chapter(chapter1Id, "Basics");
        // book.addChapter(chapter1);

        // ChapterId chapter2Id = new ChapterId(null, 2);
        // Chapter chapter2 = new Chapter(chapter2Id, "Fundamentals");
        // book.addChapter(chapter2);

        // session.persist(book);

        Book book = (Book) session.get(Book.class, "9781449334376");
        System.out.println(book);

        session.getTransaction().commit();
        session.close();
        System.exit(0);
        


    }
}
