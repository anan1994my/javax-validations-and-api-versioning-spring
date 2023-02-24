package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiVersionTest {

    @Test
    public void fromHeader_test_v2() {
        String contentType = "application/vnd.com.v2+json";
        assertEquals(ApiVersion.v2, ApiVersion.fromHeader(contentType));
    }

    @Test
    public void getTargetApiVersions_v3_returns_v1_v2_v3() {
        ApiVersion[] targetApiGroups = ApiVersion.v3.getTargetApiVersions();
        assertArrayEquals(new ApiVersion[] {ApiVersion.v1, ApiVersion.v2, ApiVersion.v3}, targetApiGroups);
    }
}
