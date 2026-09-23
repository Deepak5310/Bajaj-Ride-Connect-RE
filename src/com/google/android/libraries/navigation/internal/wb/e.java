package com.google.android.libraries.navigation.internal.wb;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum e {
    ON_CREATE("onCreate"),
    ON_START("onStart"),
    ON_RESUME("onResume"),
    ON_PAUSE("onPause"),
    ON_STOP("onStop"),
    ON_DESTROY("onDestroy");

    private final String h;

    e(String str) {
        this.h = str;
    }

    final String a() {
        return "NavView.".concat(String.valueOf(this.h));
    }
}
