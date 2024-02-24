/**
 * @author Estevam Meneses
 */
package ca.est.request;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.oauth2.core.AuthorizationGrantType;

import lombok.Data;

/**
 * @author Estevam Meneses
 */
@Data
public class CreateClientRequest {
  private String id;
  private String secret;
  private Set<AuthorizationGrantType> grantTypes;
//  private ClientAuthenticationMethod authenticationMethod;
  private Set<String> redirectUris;
  private Collection<String> scopes;
}