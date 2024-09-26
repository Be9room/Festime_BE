package Be9room.festime;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(servers = {@Server(url = "/", description = "https://api.festime.submeet.shop/")})
public class FestimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FestimeApplication.class, args);
	}

}
