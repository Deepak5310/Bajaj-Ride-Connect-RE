package com.mappls.sdk.maps.exceptions;

/* JADX INFO: loaded from: classes4.dex */
public class InvalidLatLngBoundsException extends RuntimeException {
    public InvalidLatLngBoundsException(int i) {
        super("Cannot create a LatLngBounds from " + i + " items");
    }
}
