package com.example.springboot.config;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.example.springboot.repository.AuditLogsRepository;

@EnableJpaRepositories(basePackageClasses = AuditLogsRepository.class)
@Configuration
public class PostgresDBConfig {

    @Bean
    CommandLineRunner commandLineRunner(AuditLogsRepository auditLogsRepository) {
        return strings -> {
            //usersSQLRepository.save(new Users("Peter", "Development"));
            //usersSQLRepository.save(new Users("Sam", "Operations"));
        };
    }

}
