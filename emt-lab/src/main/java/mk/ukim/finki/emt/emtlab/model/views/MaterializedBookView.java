package mk.ukim.finki.emt.emtlab.model.views;

import jakarta.persistence.*;
import lombok.Getter;
import mk.ukim.finki.emt.emtlab.model.enums.Category;
import org.hibernate.annotations.Immutable;

@Entity
@Getter
@Immutable
@Table(name="materialized_book_view")
public class MaterializedBookView {

    @Id
    @Enumerated(EnumType.STRING)
    private Category category;

    private Integer totalBooks;

    private Integer totalCopies;

    private Integer totalBadBooks;
}
