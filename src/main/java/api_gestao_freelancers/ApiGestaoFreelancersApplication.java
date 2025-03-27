package api_gestao_freelancers;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "API Gestão Freelancers", version = "1.0", description = "API para gestão de freelancers"))
@SpringBootApplication
public class ApiGestaoFreelancersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGestaoFreelancersApplication.class, args);
	}

}
