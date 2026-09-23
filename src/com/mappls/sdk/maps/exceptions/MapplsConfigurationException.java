package com.mappls.sdk.maps.exceptions;

/* JADX INFO: loaded from: classes4.dex */
public class MapplsConfigurationException extends RuntimeException {
    public MapplsConfigurationException() {
        super("\nUsing MapView requires calling Mappls.getInstance(Context context) before inflating or creating the view. The access token parameter is required when using a Mappls service.\nPlease see https://about.mappls.com/api/signup to get Keys.");
    }

    public MapplsConfigurationException(String str) {
        super(str);
    }
}
