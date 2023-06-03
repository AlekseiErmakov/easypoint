package com.geo.easypoint.common.files;

public record DownloadResponse(
        String fileName, byte[] file
) {
}
