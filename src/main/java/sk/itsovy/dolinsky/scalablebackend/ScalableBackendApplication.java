package sk.itsovy.dolinsky.scalablebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class ScalableBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScalableBackendApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/events/*"))
				.apis(RequestHandlerSelectors.basePackage("sk.itsovy.dolinsky.scalablebackend"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Set-top box events API",
				"API for set-top box events",
				"1.0",
				"Free to use",
				new Contact("Admin User", "http://globallogic.com", "a@b.com"),
				"API License",
				"http://globallogic.com",
				Collections.emptyList()
		);
	}


}
