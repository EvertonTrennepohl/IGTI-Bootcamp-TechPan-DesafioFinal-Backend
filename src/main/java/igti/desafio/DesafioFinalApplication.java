package igti.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class DesafioFinalApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(DesafioFinalApplication.class, args);
	}
}
