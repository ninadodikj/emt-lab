package mk.ukim.finki.emt.emtlab.specification;

import mk.ukim.finki.emt.emtlab.model.domain.Book;
import mk.ukim.finki.emt.emtlab.model.dto.BookFilter;
import org.springframework.data.jpa.domain.Specification;

public class BookSpecification {
    public static Specification<Book> buildFrom (BookFilter filter){
        Specification<Book> spec = (root, query, cb) -> cb.conjunction();

        if (filter == null) {
            return spec;
        }

        if (filter.category() != null) {
            spec = spec.and((root, query, cb) ->
                    cb.equal(root.get("category"), filter.category()));
        }

        if (filter.state() != null) {
            spec = spec.and((root, query, cb) ->
                    cb.equal(root.get("state"), filter.state()));
        }

        if (filter.authorId() != null) {
            spec = spec.and((root, query, cb) ->
                    cb.equal(root.get("author").get("id"), filter.authorId()));
        }

        if (Boolean.TRUE.equals(filter.availableCopiesOnly())) {
            spec = spec.and((root, query, cb) ->
                    cb.greaterThan(root.get("availableCopies"), 0));
        }

        return spec;
    }
}
