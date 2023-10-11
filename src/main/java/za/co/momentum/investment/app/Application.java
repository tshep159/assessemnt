package za.co.momentum.investment.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing//For auditing purpose(Using hibernate inverse

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
