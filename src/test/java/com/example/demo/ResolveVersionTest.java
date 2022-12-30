package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResolveVersionTest {

    @Test
    public void test() {
        String contentType = "application/vnd.com.v1+json";
        assertEquals(ApiVersion.v1, ApiVersion.fromHeader(contentType));
    }
}
