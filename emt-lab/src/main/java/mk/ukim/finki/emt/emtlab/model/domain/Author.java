package mk.ukim.finki.emt.emtlab.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "authors")
public class Author extends BaseAuditableEntity{

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @ManyToOne
    @JoinColumn(name = "country_id",nullable = false)
    private Country country;

    public Author(String surname, String name, Country country) {
        this.surname = surname;
        this.name = name;
        this.country = country;
    }
}
