package org.klodnicki.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApiVersionConfig {

    @Value("${api.version}")
    private String apiVersion;

    public String getApiVersion() {
        return apiVersion;
    }
}
