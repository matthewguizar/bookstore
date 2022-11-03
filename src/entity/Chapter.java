package entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Chapter {
    @EmbeddedId
    private ChapterId chapterId;

    @ManyToOne
    @JoinColumn(name="book_isbn")
    @MapsId("isbn")
    private Book book;

    @Column(name = "title")
    private String title;

    public Chapter() {
    }
    public Chapter(ChapterId chapterId, String title){
        this.chapterId = chapterId;
        this.title = title;
    }

    public void setBook(Book book){
        this.book = book;
    }


    public ChapterId getChapterId() {
        return this.chapterId;
    }

    public void setChapterId(ChapterId chapterId) {
        this.chapterId = chapterId;
    }

    public Book getBook() {
        return this.book;
    }


    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



   

    @Override
    public String toString() {
        return "{" +
            " chapterId='" + getChapterId() + "'" +
            ", title='" + getTitle() + "'" +
            "}";
    }

    

  

}
