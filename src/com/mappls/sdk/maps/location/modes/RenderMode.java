package com.mappls.sdk.maps.location.modes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes4.dex */
public final class RenderMode {
    public static final int COMPASS = 4;
    public static final int GPS = 8;
    public static final int NORMAL = 18;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    private RenderMode() {
    }
}
