package Spring.Module2.SpringM2.Library.Author;

import Spring.Module2.SpringM2.Books.Book;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table
public class Author {
    @Id
    @SequenceGenerator(
            name = "author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "author_sequence"
    )

    private Long authorId;
    private String name;

    @ManyToMany(mappedBy = "author")
    @JsonIgnore
    Set<Book> books;


    public Author() {}
    public Author(String name, Set<Book> books) {
        this.name = name;
        this.books = books;
    }
    public Author(Long id, String name, Set<Book> books) {
        this.authorId = id;
        this.name = name;
        this.books = books;
    }

    public Long getAuthorId() {return authorId;}
    public void setAuthorId(Long authorId) {this.authorId = authorId;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public Set<Book> getBooks() {return books;}
    public void setBooks(Set<Book> books) {this.books = books;}

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
