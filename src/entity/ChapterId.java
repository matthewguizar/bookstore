package entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ChapterId  implements Serializable{

    @Column(name="isbn")
    private String isbn;
    @Column(name = "chapter_num")
    private int chapterNum;


    public ChapterId() {
    }

    public ChapterId(String isbn, int chapterNum) {
        this.isbn = isbn;
        this.chapterNum = chapterNum;
    }
    

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ChapterId)) {
            return false;
        }
        ChapterId chapterId = (ChapterId) o;
        return Objects.equals(isbn, chapterId.isbn) && chapterNum == chapterId.chapterNum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, chapterNum);
    }
   

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getChapterNum() {
        return this.chapterNum;
    }

    public void setChapterNum(int chapterNum) {
        this.chapterNum = chapterNum;
    }



    @Override
    public String toString() {
        return "{" +
            " isbn='" + getIsbn() + "'" +
            ", chapterNum='" + getChapterNum() + "'" +
            "}";
    }
    


    
}
