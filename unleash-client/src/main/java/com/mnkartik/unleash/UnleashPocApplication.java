package com.mnkartik.unleash;

import no.finn.unleash.Unleash;
import no.finn.unleash.UnleashContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class UnleashPocApplication {

    @Autowired
    private Unleash unleash;

    public static void main(String[] args) {
        SpringApplication.run(UnleashPocApplication.class, args);
    }


    @GetMapping("/feature")
    public String featureEnabled(@RequestHeader("userId") String userIdHeader) {
        System.out.println("useridHeader = " + userIdHeader);

        UnleashContext ctx = UnleashContext.builder()
                .userId(userIdHeader)
                .build();

        if (unleash.isEnabled("splfeature", ctx)) {
            return "Special feature is enabled";
        } else {
            return "Special feature is disabled";
        }
    }

}

