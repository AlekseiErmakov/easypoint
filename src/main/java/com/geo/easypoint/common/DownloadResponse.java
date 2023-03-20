package com.geo.easypoint.common;

public record DownloadResponse(
        String fileName, byte[] file
) {
}
