package com.mappls.sdk.maps;

/* JADX INFO: loaded from: classes4.dex */
class MapStrictModeException extends RuntimeException {
    MapStrictModeException(String str) {
        super(String.format("Map detected an error that would fail silently otherwise: %s", str));
    }
}
