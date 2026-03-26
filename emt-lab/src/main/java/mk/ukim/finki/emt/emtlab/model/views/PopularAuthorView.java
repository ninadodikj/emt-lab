package mk.ukim.finki.emt.emtlab.model.views;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Getter
@Table(name="popular_authors_view")
public class PopularAuthorView {

    @Id
    private String fullName;

    private Integer rentCount;
}
