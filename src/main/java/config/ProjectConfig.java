package config;

import main.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    @Bean
    Parrot parrotOne() {
        var rio = new Parrot("Rio");
        return rio;
    }

    @Bean(name="parotte")
    Parrot parrotTwo() {
        var parroterinio = new Parrot("Parroterinio");
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
