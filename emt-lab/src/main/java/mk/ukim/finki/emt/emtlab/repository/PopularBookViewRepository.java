package mk.ukim.finki.emt.emtlab.repository;

import mk.ukim.finki.emt.emtlab.model.views.PopularBooksView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PopularBookViewRepository extends JpaRepository<PopularBooksView, String> {

    Optional<PopularBooksView> findTopByOrderByRentCountDesc();


}
