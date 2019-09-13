package atg.fingerfood.hikaripoolbug.configuration;

import atg.fingerfood.hikaripoolbug.repository.BarRepository;
import atg.fingerfood.hikaripoolbug.repository.FooBarRepository;
import atg.fingerfood.hikaripoolbug.repository.FooRepository;
import atg.fingerfood.hikaripoolbug.service.BarService;
import atg.fingerfood.hikaripoolbug.service.FooBarService;
import atg.fingerfood.hikaripoolbug.service.FooService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HikariPoolBugConfiguration {
    @Bean
    FooService fooService(FooRepository fooRepository) {
        return new FooService(fooRepository);
    }

    @Bean
    BarService barService(BarRepository barRepository) {
        return new BarService(barRepository);
    }

    @Bean
    FooBarService fooBarService(FooBarRepository fooBarRepository) {
        return new FooBarService(fooBarRepository);
    }
}
