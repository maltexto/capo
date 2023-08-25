package dev.maltexto.capo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.maltexto.capo.entities.Movement;
import dev.maltexto.capo.repositories.MovementRepository;

@Service
public class MovementService {

    @Autowired
    private MovementRepository movementRepository;

    @Transactional
    public Movement createMovement(Movement movement) {
        return movementRepository.save(movement);
    }

    public Page<Movement> getMovements(Pageable pageable) {
        return movementRepository.findAll(pageable);
    }

}
