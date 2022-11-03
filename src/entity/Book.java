package entity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Book {
    @Id
    @Column(name="isbn")
    private String isbn;
    @Column(name="book_name")
    private String name;
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "publisher_code")
    private Publisher publisher;

    @OneToMany(mappedBy = "book", cascade = {CascadeType.PERSIST})
    private Set<Chapter> chapters = new HashSet<>();
    

    public Book() {
    }

    public Book(String isbn, String name, Publisher publisher) {
        this.isbn = isbn;
        this.name = name;
        this.publisher = publisher;
    }
    
    public void addChapter(Chapter chapter){
        this.chapters.add(chapter);
        chapter.setBook(this);
    }
    public void removeChapter(Chapter chapter){
        this.chapters.remove(chapter);
        chapter.setBook(null);
    }
    public String getIsbn(){return isbn;}

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Publisher getPublisher() {
        return this.publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Set<Chapter> getChapters() {
        return this.chapters;
    }

    public void setChapters(Set<Chapter> chapters) {
        this.chapters = chapters;
    }



    

    @Override
    public String toString() {
        return "{" +
            " isbn='" + getIsbn() + "'" +
            ", name='" + getName() + "'" +
            ", publisher='" + getPublisher() + "'" +
            ", chapters='" + getChapters() + "'" +
            "}";
    }
  

    
    

}
