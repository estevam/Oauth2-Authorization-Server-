/**
 * @author Estevam Meneses
 */
package ca.est.request;

import lombok.Data;
/**
 * @author Estevam Meneses
 */
@Data
public class CreateUserRequest {
  private String username;
  private String password;
}