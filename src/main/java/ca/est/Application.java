package ca.est;

import java.util.Arrays;

import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.aot.hint.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportRuntimeHints;
import org.thymeleaf.expression.Lists;

import ca.est.service.Oauth2Service;
import ca.est.controller.AuthorizationConsentController;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Estevam Meneses
 */
@Slf4j
@SpringBootApplication
@ImportRuntimeHints(Application.DemoAuthorizationServerApplicationRuntimeHintsRegistrar.class)
public class Application implements CommandLineRunner{
	
	@Autowired
	Oauth2Service oauth2Service;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	static class DemoAuthorizationServerApplicationRuntimeHintsRegistrar implements RuntimeHintsRegistrar {

		@Override
		public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
			// Thymeleaf
			hints.reflection().registerTypes(
					Arrays.asList(
							TypeReference.of(AuthorizationConsentController.ScopeWithDescription.class),
							TypeReference.of(Lists.class)
					), builder ->
							builder.withMembers(MemberCategory.DECLARED_FIELDS,
									MemberCategory.INVOKE_DECLARED_CONSTRUCTORS, MemberCategory.INVOKE_DECLARED_METHODS)
			);
		}

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		oauth2Service.loadAuthorizationAndConsent();
		log.info("H2 database: http://localhost:9000/h2");
		log.info("Swagger UI: http://localhost:9000/swagger-ui.html");
	}
}