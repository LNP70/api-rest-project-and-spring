package fr.eseo.twic.petnkeu.apiserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:database.properties")
public class ApiServerDatabasePropertyConfig {
}
