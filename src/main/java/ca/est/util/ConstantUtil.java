/**
 * @author Estevam Meneses
 */
package ca.est.util;

/**
 * @author Estevam Meneses
 */
public final class ConstantUtil {
	
	public static final String CONSENT_PAGE_URI = "/oauth2/consent";
    public static final String LOGIN = "/login";
    
	/**
	 * whitelisting endpoints 
	 */
    public static final String[] WHITE_LIST = {
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/v2/api-docs/**",
            "/swagger-resources/**",
            "/api-docs/**",
            "/swagger-ui.html",
            "/actuator/**",
            "/static/**",
            "/templates/**",
            "/favicon.ico",
            "/assets/**",
            "/login",
            "/logout"
    }; 
}