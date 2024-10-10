package co.simplon.sql_injection.mappers;

import co.simplon.sql_injection.dtos.SessionDto;
import co.simplon.sql_injection.entities.User;

public class SessionMapper {

	public static SessionDto entityToSessionDto(User user) {
		return new SessionDto(user.getUserName(), user.getEmail(), user.isAdminRole());
	}
}
