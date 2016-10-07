package com.httfail;

import com.codahale.metrics.health.HealthCheck;

public class HttfailHealthcheck extends HealthCheck {

    public HttfailHealthcheck() {}

    @Override
    protected Result check() throws Exception {
        // for a fail-y service, we sure seem to always be happy
        return Result.healthy();
    }
}