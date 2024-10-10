package co.simplon.sql_injection.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.sql_injection.dtos.LoginDto;
import co.simplon.sql_injection.dtos.SessionDto;
import co.simplon.sql_injection.services.SessionService;

@RestController
@CrossOrigin("*")
@RequestMapping("/login")
public class SessionController {

	private final SessionService service;

	public SessionController(SessionService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<SessionDto> login(@RequestBody LoginDto input) {
		return ResponseEntity.ok(service.login(input));
	}
}
