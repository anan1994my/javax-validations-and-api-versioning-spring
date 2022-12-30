package com.example.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum ApiVersion {
    v1;

    public static ApiVersion fromHeader(String contentType) {
        Pattern pattern = Pattern.compile("application/vnd\\.com\\.(v1)\\+json");
        Matcher matcher = pattern.matcher(contentType);
        if (matcher.matches()) {
            String str = matcher.group(1);
            return ApiVersion.valueOf(str);
        }
        throw new IllegalArgumentException("Invalid header: " + contentType);
    }
}
