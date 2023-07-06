package net.radonfhir.connector.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = {"net.radonfhir.connector", "ca"})
@ConfigurationPropertiesScan(basePackages = {"net.radonfhir.connector", "ca"})
@EnableConfigurationProperties()
@EnableScheduling
public class BasicConnectorApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicConnectorApplication.class, args);
    }
}
