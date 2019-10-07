package hau.edu.ph.ObprogL.repository;

import hau.edu.ph.ObprogL.model.Shirt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShirtRepository extends JpaRepository<Shirt, Integer> {
}
