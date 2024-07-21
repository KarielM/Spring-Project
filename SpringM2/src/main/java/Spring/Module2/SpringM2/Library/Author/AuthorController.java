package Spring.Module2.SpringM2.Library.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "authors")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @PostMapping(path = "AddAuthor")
    public void addAuthor(@RequestBody Author author) {
        authorService.addAuthor(author);
    }

    @DeleteMapping(path = "Author{authorId}")
    public void deleteAuthor(@PathVariable("authorId") Long authorId) {
        authorService.deleteAuthor(authorId);
    }

    @PutMapping(path ="ChangeName{authorId}")
    public void updateAuthor(
            @PathVariable("authorId") Long authorId,
            @RequestParam(required = false) String name) {
        authorService.updateAuthor(authorId, name);
    }

}
