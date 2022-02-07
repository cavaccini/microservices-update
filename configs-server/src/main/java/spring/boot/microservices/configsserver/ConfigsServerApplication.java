package spring.boot.microservices.configsserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigsServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigsServerApplication.class, args);
	}

}
