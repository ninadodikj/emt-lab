package mk.ukim.finki.emt.emtlab.model.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(Long id) {
        super("A book with id %d does not exist.".formatted(id));
    }
}
