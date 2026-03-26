package mk.ukim.finki.emt.emtlab.model.views;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Getter
@Table(name="popular_books")
public class PopularBooksView {

    @Id
    private String name;

    private Integer rentCount;
}
