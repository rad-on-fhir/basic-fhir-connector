package net.radonfhir.connector.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"net.radonfhir.connector"})
@ConfigurationPropertiesScan(basePackages = {"net.radonfhir.connector"})
@EnableConfigurationProperties()
public class BasicConnectorApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicConnectorApplication.class, args);
    }
}
