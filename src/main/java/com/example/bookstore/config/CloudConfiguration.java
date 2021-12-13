package com.example.bookstore.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "cloudinary")
public class CloudConfiguration {

    private String cloudName;
    private String apiKey;
    private String apiSecret;

    public String getCloudName() {
        return cloudName;
    }

    public CloudConfiguration setCloudName(String cloudName) {
        this.cloudName = cloudName;
        return this;
    }

    public String getApiKey() {
        return apiKey;
    }

    public CloudConfiguration setApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public String getApiSecret() {
        return apiSecret;
    }

    public CloudConfiguration setApiSecret(String apiSecret) {
        this.apiSecret = apiSecret;
        return this;
    }
}
