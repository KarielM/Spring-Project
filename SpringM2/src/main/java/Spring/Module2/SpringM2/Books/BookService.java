package Spring.Module2.SpringM2.Books;

import Spring.Module2.SpringM2.Library.Author.Author;
import Spring.Module2.SpringM2.Library.Author.AuthorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Autowired
    AuthorRepository authorRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Transactional
    public void addBook(Book book) {
        if (book.getAuthor() == null || book.getAuthor().isEmpty()) {
            throw new RuntimeException("No authors provided");
        }

        Set<Author> authors = new HashSet<>();
        List<Long> missingAuthorIds = new ArrayList<>();

        for (Author author : book.getAuthor()) {
            Long authorId = author.getAuthorId();

            if (authorId == null) {
                System.out.println("Author ID must not be null");
                continue;
            }

            Author existingAuthor = authorRepository.findById(authorId)
                    .orElse(null);

            if (existingAuthor != null) {
                authors.add(existingAuthor);
            } else {
                missingAuthorIds.add(authorId);
            }
        }

        if (!missingAuthorIds.isEmpty()) {
            String message = "The following authors were not found and not added: " + missingAuthorIds;
            System.out.println(message);
        }

        book.setAuthor(authors);
        bookRepository.save(book);
    }

    public void deleteBook(Long bookId){
        boolean bookExists = bookRepository.existsById(bookId);
        if (!bookExists) {
            System.out.println("Book not found");
        }
        bookRepository.deleteById(bookId);
    }
    @Transactional
    public void updateBookGenre(Long bookId, String genre){
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new IllegalStateException("Book not found"));
        if (genre != null && !genre.isEmpty() && !Objects.equals(book.getGenre(), genre)){
            book.setGenre(genre);
        }
    }
    @Transactional
    public void updateBookPublicationYear(Long bookId, Integer publicationYear){
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new IllegalStateException("Book not found"));
        if (publicationYear != null && !String.valueOf(publicationYear).isEmpty() && !Objects.equals(book.getPublicationYear(), publicationYear)){
            book.setPublicationYear(publicationYear);
        }
    }

}
