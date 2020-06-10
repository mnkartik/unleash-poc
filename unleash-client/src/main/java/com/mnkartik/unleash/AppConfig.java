package com.mnkartik.unleash;

import no.finn.unleash.DefaultUnleash;
import no.finn.unleash.Unleash;
import no.finn.unleash.util.UnleashConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Unleash unleash() {
        UnleashConfig config = UnleashConfig.builder()
                .appName("java-test")
                .instanceId("instance x")
                .unleashAPI("http://localhost:4242/api")
                .customHttpHeader("Authorization","12312Random")
                .customHttpHeader("X-VZW-Header", "CustomHeaderValue")
                .build();

        return new DefaultUnleash(config);
    }
}
