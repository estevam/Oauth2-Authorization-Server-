/**
 * @author Estevam Meneses
 */
package ca.est.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.server.authorization.JdbcOAuth2AuthorizationConsentService;
import org.springframework.security.oauth2.server.authorization.JdbcOAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.OAuth2Authorization;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationConsent;
import org.springframework.security.oauth2.server.authorization.client.JdbcRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author Estevam Meneses
 */
@Service
public class Oauth2Service {

	@Autowired
	JdbcOAuth2AuthorizationConsentService consentService;
	@Autowired
	JdbcOAuth2AuthorizationService authorizationService;

	@Autowired
	JdbcRegisteredClientRepository jdbcRegisteredClientRepository;

	public void loadAuthorizationAndConsent() {
		saveAuth2AuthorizationConsent("messaging-client", "Estevam", "ROLE_ADMIN");
		//saveAuth2Authorization();
	}

	private void saveAuth2AuthorizationConsent(String registeredClientId, String principalName,
			String uthorizationConsentAuthorities) {

		OAuth2AuthorizationConsent.Builder builder = OAuth2AuthorizationConsent.withId(registeredClientId,
				principalName);

		if (uthorizationConsentAuthorities != null) {
			for (String authority : StringUtils.commaDelimitedListToSet(uthorizationConsentAuthorities)) {
				builder.authority(new SimpleGrantedAuthority(authority));
			}
		}
		consentService.save(builder.build());
	}

	/**
	 * Not use in use 
	 */
	public void saveAuth2Authorization() {
		RegisteredClient registeredClient = jdbcRegisteredClientRepository.findById("messaging-client");
		OAuth2Authorization.Builder builder = OAuth2Authorization.withRegisteredClient(registeredClient);
		authorizationService.save(builder.build());

	}
}
