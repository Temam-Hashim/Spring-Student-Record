package com.example.demo.configuration;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlywayRepairService {

    private final Flyway flyway;

    @Autowired
    public FlywayRepairService(Flyway flyway) {
        this.flyway = flyway;
    }

    public void performRepair() {
        flyway.repair();
    }
}

