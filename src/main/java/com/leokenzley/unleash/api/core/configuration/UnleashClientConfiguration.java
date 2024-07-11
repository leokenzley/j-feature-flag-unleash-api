package com.leokenzley.unleash.api.core.configuration;

import io.getunleash.DefaultUnleash;
import io.getunleash.util.UnleashConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.file.Paths;

@Configuration
public class UnleashClientConfiguration {
    @Value("unleash.api-name")
    private String apiName;
    @Value("${unleash.api-token}")
    private String apiToken;
    @Value("${unleash.instance}")
    private String instance;

    @Value("${unleash.url}")
    private String url;

    @Bean
    public DefaultUnleash unleashClient(){
        var unleash = UnleashConfig.builder()
                .appName(apiName)
                .instanceId(instance)
                .unleashAPI(url)
                .apiKey(apiToken)
                .build();
        return new DefaultUnleash(unleash);
    }
}
