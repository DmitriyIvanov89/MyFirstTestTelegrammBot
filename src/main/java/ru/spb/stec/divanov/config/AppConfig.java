package ru.spb.stec.divanov.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.spb.stec.divanov.components.Bot;

@Configuration
public class AppConfig {

    @Bean
    public Bot bot() {
        return new Bot();
    }
}
