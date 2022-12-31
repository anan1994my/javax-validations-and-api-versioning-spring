package com.example.demo;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum ApiVersion {
    v1(ApiV1.class),
    v2(ApiV2.class);

    public interface ApiVersionGroup {};

    public interface ApiV1 extends ApiVersionGroup {}
    public interface ApiV2  extends ApiVersionGroup {}
    private final Class<? extends ApiVersionGroup> apiVersionGroup;

    ApiVersion(Class<? extends ApiVersionGroup> apiVersionGroup) {
        this.apiVersionGroup = apiVersionGroup;
    }

    public Class<? extends ApiVersionGroup> getApiVersionGroup() {
        return apiVersionGroup;
    }

    public static ApiVersion fromHeader(String contentType) {
        Pattern pattern = Pattern.compile("application/vnd\\.com\\.(v\\d+)\\+json");
        Matcher matcher = pattern.matcher(contentType);
        if (matcher.matches()) {
            String str = matcher.group(1);
            return ApiVersion.valueOf(str);
        }
        throw new IllegalArgumentException("Invalid header: " + contentType);
    }
}
