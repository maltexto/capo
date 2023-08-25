package dev.maltexto.capo.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import dev.maltexto.capo.entities.Movement;
import dev.maltexto.capo.entities.Product;
import dev.maltexto.capo.entities.enums.MovementType;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface MovementRepository extends PagingAndSortingRepository<Movement, Long> {

    Page<Movement> findByProduct(Product product, Pageable pageable);

    Page<Movement> findByMovementType(MovementType movementType, Pageable pageable);

    @Query("SELECT m FROM Movement m WHERE m.date BETWEEN ?1 AND ?2")
    Page<Movement> findByMovementDateRange(Date initialDate, Date finalDate, Pageable pageable);
}
