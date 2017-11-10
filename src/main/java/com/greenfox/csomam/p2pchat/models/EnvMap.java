package com.greenfox.csomam.p2pchat.models;

import java.util.Map;

public class EnvMap {

    private Map<String, String> environmentVariables;

    public EnvMap() {
        this.environmentVariables = System.getenv();
    }

    public Map<String, String> getEnvironmentVariables() {
        return environmentVariables;
    }

    public void setEnvironmentVariables(Map<String, String> environmentVariables) {
        this.environmentVariables = environmentVariables;
    }
}
