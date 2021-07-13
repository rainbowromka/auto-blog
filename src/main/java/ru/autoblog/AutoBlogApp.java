package ru.autoblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class AutoBlogApp {
	Boolean isCleanDb = true;

	public static void main(String[] args) {
		SpringApplication.run(AutoBlogApp.class, args);
	}

	@Bean
	@Profile("!production")
	public FlywayMigrationStrategy cleanMigrationStrategy() {
		FlywayMigrationStrategy strategy = flyway -> {
			if (isCleanDb) {
				flyway.clean();
				flyway.migrate();
			}
		};
		return strategy;
	}

}
