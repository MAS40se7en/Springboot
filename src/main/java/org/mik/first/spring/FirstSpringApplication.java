package org.mik.first.spring;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.mik.first.spring"})
@OpenAPIDefinition(
	info=@Info(
		title = "MIK App",
			version = "v1",
			description = "Mik application REST interface",
			contact = @Contact( name="Zamek", email = "monirsaker4@gmail.com")
	),
		servers = @Server(url = "http://localhost:8080")
)
public class FirstSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringApplication.class, args);
	}

}
