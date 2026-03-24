package mk.ukim.finki.emt.emtlab.repository;

import mk.ukim.finki.emt.emtlab.model.enums.Category;
import mk.ukim.finki.emt.emtlab.model.views.MaterializedBookView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterializedBookViewRepository extends JpaRepository<MaterializedBookView, Category> {
    @Modifying
    @Query(value="refresh materialized view materialized_book_view",nativeQuery = true)
    void refresh();
}
