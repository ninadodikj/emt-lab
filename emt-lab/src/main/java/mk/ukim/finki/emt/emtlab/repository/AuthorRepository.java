package mk.ukim.finki.emt.emtlab.repository;

import mk.ukim.finki.emt.emtlab.model.domain.Author;
import mk.ukim.finki.emt.emtlab.model.projection.AuthorDetailedProjection;
import mk.ukim.finki.emt.emtlab.model.projection.BookDetailedProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query(value= """
        select a.name as name,a.surname as surname,c.name as CountryName
        from authors a join countries c on a.country_id=c.id
                where a.id=:id
        """,nativeQuery = true)
    Optional<AuthorDetailedProjection> findAuthorDetailedBy(@Param("id") Long id);
}
