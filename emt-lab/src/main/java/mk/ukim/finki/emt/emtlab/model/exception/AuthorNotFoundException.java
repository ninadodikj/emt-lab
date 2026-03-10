package mk.ukim.finki.emt.emtlab.model.exception;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(Long id) {

        super("Author with id %d does not exist".formatted(id));
    }
}
