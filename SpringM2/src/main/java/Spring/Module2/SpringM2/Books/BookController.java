package Spring.Module2.SpringM2.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(path = "SeeAllBooks")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping(path = "AddBook")
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }
    @DeleteMapping(path = "/Book{bookId}")
    public void deleteBook(@PathVariable("bookId") Long bookId) {
        bookService.deleteBook(bookId);
    }
    @PutMapping(path = "Update{bookId}genre")
    public void updateBook(
            @PathVariable("bookId") Long bookId
            , @RequestParam(required = false) String genre) {
        bookService.updateBookGenre(bookId, genre);
    }
    @PutMapping(path = "{bookId}/publicationYear")
    public void updateBookPublicationYear(
            @PathVariable("bookId") Long bookId
            , @RequestParam(required = false) Integer publicationYear) {
        bookService.updateBookPublicationYear(bookId, publicationYear);
    }
}
