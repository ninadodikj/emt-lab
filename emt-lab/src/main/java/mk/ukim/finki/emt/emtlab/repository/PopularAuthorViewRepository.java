package mk.ukim.finki.emt.emtlab.repository;

import mk.ukim.finki.emt.emtlab.model.views.PopularAuthorView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PopularAuthorViewRepository extends JpaRepository<PopularAuthorView, String> {

    Optional<PopularAuthorView> findTopByOrderByRentCountDesc();

}
