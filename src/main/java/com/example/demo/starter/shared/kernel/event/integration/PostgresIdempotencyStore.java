package com.example.demo.starter.shared.kernel.event.integration;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class PostgresIdempotencyStore implements IdempotencyStore {

    private final JdbcTemplate jdbc;

    public PostgresIdempotencyStore(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public boolean exists(UUID key) {
        Integer count = jdbc.queryForObject(
                "SELECT COUNT(*) FROM idempotency_store WHERE idempotency_key = ?",
                Integer.class,
                key.toString()
        );
        return count != null && count > 0;
    }

    @Override
    public void save(UUID key) {
        jdbc.update(
                "INSERT INTO idempotency_store(idempotency_key, processed_at) VALUES(?, now())",
                key.toString()
        );
    }
}

