package Spring.Module2.SpringM2.Books;

import Spring.Module2.SpringM2.Library.Author.Author;
import Spring.Module2.SpringM2.LibraryMember.LibraryMembers;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table
public class Book {
    @Id
    @SequenceGenerator(
        name = "book_sequence",
        sequenceName = "book_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )

    private Long id;
    private String title;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "books_by_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> author;
    private Integer publicationYear;
    private String genre;

    @ManyToOne
    @JoinColumn(name = "library_member_id")
    private LibraryMembers libraryMember;


    public Book() {}
    public Book(String title, Set<Author> author, Integer publicationYear, String genre, LibraryMembers libraryMember) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.genre = genre;
        this.libraryMember = libraryMember;
    }

    public Book(Long id, String title, Set<Author> author, Integer publicationYear, String genre, LibraryMembers libraryMember) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.genre = genre;
        this.libraryMember = libraryMember;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public Set<Author> getAuthor() {return author;}
    public void setAuthor(Set<Author> author) {this.author = author;}
    public Integer getPublicationYear() {return publicationYear;}
    public void setPublicationYear(Integer publicationYear) {this.publicationYear = publicationYear;}
    public String getGenre() {return genre;}
    public void setGenre(String genre) {this.genre = genre;}
    public LibraryMembers getLibraryMember() {return libraryMember;}
    public void setLibraryMember(LibraryMembers libraryMember) {this.libraryMember = libraryMember;}

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear=" + publicationYear +
                ", genre='" + genre + '\'' +
                '}';
    }
}
