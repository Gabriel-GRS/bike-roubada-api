package bikeroubada.api.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import bikeroubada.api.model.Bike;

public interface BikeRepository extends JpaRepository<Bike, Long> {
    Page<Bike> findAllByAtivoTrue(Pageable paginacao);

}
