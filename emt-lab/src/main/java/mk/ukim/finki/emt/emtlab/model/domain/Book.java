package mk.ukim.finki.emt.emtlab.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mk.ukim.finki.emt.emtlab.model.enums.Category;
import mk.ukim.finki.emt.emtlab.model.enums.State;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="books")
@NamedEntityGraph(
        name="book-entity-graph",
        attributeNodes = {
                @NamedAttributeNode(value="author",subgraph = "author-subgraph"),
        },
        subgraphs = {
                @NamedSubgraph(
                        name="author-subgraph",
                        attributeNodes = {
                                @NamedAttributeNode("country")
                        }
                )
        }
)
public class Book extends BaseAuditableEntity{
    @Column(nullable = false,unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    @JoinColumn(name="author_id",nullable = false)
    private Author author;

    @Enumerated(EnumType.STRING)
    private State state;

    @Column(nullable = false)
    private Integer availableCopies;

    public Book(String name, Category category, Author author, State state, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.state = state;
        this.availableCopies = availableCopies;
    }
}
