package mk.ukim.finki.emt.emtlab.repository;

import mk.ukim.finki.emt.emtlab.model.domain.BookRentActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRentActivityRepository extends JpaRepository<BookRentActivity, Long> {

}
