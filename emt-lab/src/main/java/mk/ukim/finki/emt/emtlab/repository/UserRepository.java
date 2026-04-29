package mk.ukim.finki.emt.emtlab.repository;

import mk.ukim.finki.emt.emtlab.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select name, surname, email from users", nativeQuery = true)
    List<User> findAllWithNameSurnameAndEmail();

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);
}

