package config;

import animals.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "main")
public class ProjectConfig {
    @Bean
    @Primary
    Parrot parrotOne() {
        var rio = new Parrot();
        rio.setName("Rio");
        return rio;
    }

    @Bean(name="parotte")
    Parrot parrotTwo() {
        var parroterinio = new Parrot();
        parroterinio.setName("Parroterinio");
        return parroterinio;
    }

    @Bean
    String itsOverCaption() {
        return "Its over..";
    }

    @Bean
    Integer nineK() {
        return 9000;
    }
}
