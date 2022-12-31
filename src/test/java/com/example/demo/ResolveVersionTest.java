package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResolveVersionTest {

    @Test
    public void test_v1() {
        String contentType = "application/vnd.com.v1+json";
        assertEquals(ApiVersion.v1, ApiVersion.fromHeader(contentType));
    }

    @Test
    public void test_v2() {
        String contentType = "application/vnd.com.v2+json";
        assertEquals(ApiVersion.v2, ApiVersion.fromHeader(contentType));
    }
}
