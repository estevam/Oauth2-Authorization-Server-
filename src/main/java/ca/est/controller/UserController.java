
package ca.est.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Estevam Meneses
 */
@RestController

public class UserController {
	//private final UserService userService;

	/**
	@PostMapping("/user")
	public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest req) {
		var response = this.userService.save(req);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	*/

	@GetMapping("/oidc-principal")
	public OidcUser getOidcUserPrincipal(@AuthenticationPrincipal OidcUser principal) {
		return principal;
	}
	
    @GetMapping("/user/name")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }
}