package com.leokenzley.unleash.api.api.controller;

import com.leokenzley.unleash.api.core.configuration.UnleashClientConfiguration;
import com.leokenzley.unleash.api.domain.enumeration.UnleashFeatureFlagEnum;
import io.getunleash.DefaultUnleash;
import io.getunleash.UnleashContext;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/verify-feature-flag")
public class VerifyFeatureFlagController {
    @Autowired
    private DefaultUnleash unleashClient;

    @GetMapping("/verify")
    public ResponseEntity<String> verify(@RequestHeader("X-client-identifyer") String clientIdentifyer){
        UnleashContext context = UnleashContext.builder().userId(clientIdentifyer).build();
        if(unleashClient.isEnabled(UnleashFeatureFlagEnum.TEST_NEW_FEATURE_FLAG.name(), context)){
            return ResponseEntity.ok("Client enable: "+clientIdentifyer);
        }
        return ResponseEntity.ok("Client NOT enable: "+clientIdentifyer);
    }
}
