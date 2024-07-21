package Spring.Module2.SpringM2.Library.Author;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    public void deleteAuthor(Long authorId) {
        boolean authorIdExists = authorRepository.existsById(authorId);
        if (!authorIdExists) {
            throw new IllegalStateException("Author does not exist");
        }
        authorRepository.deleteById(authorId);
    }

    @Transactional
    public void updateAuthor(Long authorId, String name){
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new IllegalStateException("Author does not exist"));
        if (name != null && !name.isEmpty() && !Objects.equals(author.getName(), name)) {
            author.setName(name);
        }
    }
}
