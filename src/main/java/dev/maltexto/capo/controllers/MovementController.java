package dev.maltexto.capo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.maltexto.capo.entities.Movement;
import dev.maltexto.capo.services.MovementService;

@RestController
public class MovementController {

	@Autowired
	private MovementService movementService;

	@GetMapping("/movements")
	public ResponseEntity<Page<Movement>> getMovements(
			@PageableDefault(size = 10, sort = { "id" }) Pageable pageable) {

		Page<Movement> movements = movementService.getMovements(pageable);
		return ResponseEntity.status(HttpStatus.OK).body(movements);
	}

	@PostMapping("/movements")
	public ResponseEntity<Movement> createMovement(@RequestBody Movement movement) {
		Movement createdMovement = movementService.createMovement(movement);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdMovement);
	}
}
