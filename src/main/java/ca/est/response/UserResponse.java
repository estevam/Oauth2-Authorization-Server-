package ca.est.response;

import java.util.Collection;

import ca.est.entity.Oauth2Authority;
import ca.est.entity.Oauth2User;
import lombok.Data;

/**
 * @author Estevam Meneses
 */
@Data
public class UserResponse {
	private String username;
	private String password;
	private Collection<Oauth2Authority> authorities;

	@SuppressWarnings("unchecked")
	public UserResponse(Oauth2User user) {
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.authorities = (Collection<Oauth2Authority>) user.getAuthorities();
	}
}