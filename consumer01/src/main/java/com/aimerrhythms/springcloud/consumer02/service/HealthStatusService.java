package com.aimerrhythms.springcloud.consumer02.service;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Service;

/**
 * @author aimerrhythms
 * @data 2020/6/22 23:44
 */
@Service
public class HealthStatusService implements HealthIndicator {

    private Boolean status = true;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public Health health() {
        return status ? new Health.Builder().up().build() : new Health.Builder().down().build();
    }
}
