package co.simplon.sql_injection.services;

import org.springframework.stereotype.Service;

import co.simplon.sql_injection.dtos.LoginDto;
import co.simplon.sql_injection.dtos.SessionDto;
import co.simplon.sql_injection.mappers.SessionMapper;
import co.simplon.sql_injection.repositories.CustomRepository;

@Service
public class SessionService {

	CustomRepository repo;

	public SessionService(CustomRepository repo) {
		this.repo = repo;
	}

	public SessionDto login(LoginDto input) {
		return SessionMapper.entityToSessionDto(repo.login(input));
	}
}
