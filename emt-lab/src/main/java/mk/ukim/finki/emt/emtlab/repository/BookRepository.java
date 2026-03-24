package mk.ukim.finki.emt.emtlab.repository;

import mk.ukim.finki.emt.emtlab.model.domain.Book;
import mk.ukim.finki.emt.emtlab.model.projection.BookDetailedProjection;
import mk.ukim.finki.emt.emtlab.model.projection.BookProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long>, JpaSpecificationExecutor<Book> {

    List<Book> findAllByIdBetween(Long a, Long b);

    @Query(value="select b.id,b.name,b.category,b.state,b.available_copies "+" from books b ",nativeQuery = true)
    List<BookProjection> findAllProjection();
    @Query(value= """
        select b.id as id,b.name as name,b.category as category,
        b.state as state,b.available_copies as available_copies,
        a.name as AuthorName,a.surname as AuthorSurname,c.name as CountryName
        from books b join authors a on b.author_id=a.id join countries c on a.country_id=c.id
                where b.id=:id
        """,nativeQuery = true)
    Optional<BookDetailedProjection> findBookDetailedById(@Param("id") Long id);

    @EntityGraph(value="book-entity-graph",type=EntityGraph.EntityGraphType.FETCH)
    List<Book> findAllWithAuthorAndCountryBy();

    @EntityGraph(value="book-entity-graph",type=EntityGraph.EntityGraphType.FETCH)
    Optional<Book> findWithAuthorAndCountryById(Long id);
}
