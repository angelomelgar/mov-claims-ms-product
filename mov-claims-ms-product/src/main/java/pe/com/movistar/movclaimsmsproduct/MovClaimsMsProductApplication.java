package pe.com.movistar.movclaimsmsproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MovClaimsMsProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovClaimsMsProductApplication.class, args);
	}

}
