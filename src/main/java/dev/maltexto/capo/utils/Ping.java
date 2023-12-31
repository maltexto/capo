package dev.maltexto.capo.utils;

import java.time.ZonedDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ping {

	@GetMapping()
	public String ping() {
		return ZonedDateTime.now().toString();
	}
}
