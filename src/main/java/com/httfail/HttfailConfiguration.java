package com.httfail;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class HttfailConfiguration extends Configuration {
    @Min(0)
    private Integer defaultStatus;

    @NotNull
    private String defaultReason;

    @JsonProperty
    public Integer getDefaultStatus() {
        return defaultStatus;
    }

    @JsonProperty
    public void setDefaultStatus(Integer defaultStatus) {
        this.defaultStatus = defaultStatus;
    }

    @JsonProperty
    public String getDefaultReason() {
        return defaultReason;
    }

    @JsonProperty
    public void setDefaultReason(String defaultReason) {
        this.defaultReason = defaultReason;
    }
}