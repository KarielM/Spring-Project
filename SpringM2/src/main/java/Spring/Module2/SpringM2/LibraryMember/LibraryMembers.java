package Spring.Module2.SpringM2.LibraryMember;


import Spring.Module2.SpringM2.Books.Book;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table
public class LibraryMembers {
    @Id
    @SequenceGenerator(
            name = "member_sequence",
            sequenceName = "member_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "member_sequence"
    )

    private Long id;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "libraryMember")
    @JsonIgnore
    private Set<Book> books;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    @JsonIgnore
    public Set<Book> getBooks() {return books;}
    public void setBooks(Set<Book> books) {this.books = books;}

    @Override
    public String toString() {
        return "LibraryMembers{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", books=" + books +
                '}';
    }
}
