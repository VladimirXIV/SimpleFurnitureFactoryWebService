package noncom.just.fun.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages ={"noncom.just.fun.controller",
		                      "noncom.just.fun.serviceImpl"})
@EnableJpaRepositories(basePackages = {"noncom.just.fun.repository"})
@EntityScan(basePackages = {"noncom.just.fun.model"})
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
