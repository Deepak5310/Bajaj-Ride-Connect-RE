package com.google.android.libraries.navigation.internal.xm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
enum w {
    PROD("navigationsdkusage.googleapis.com"),
    STAGING("staging-navigationsdkusage.sandbox.googleapis.com"),
    AUTOPUSH("autopush-navigationsdkusage.sandbox.googleapis.com"),
    EMPTY("");

    final String e;
    final String f;

    w(String str) {
        this.e = str;
        this.f = !str.isEmpty() ? com.google.android.libraries.navigation.internal.b.b.g(str, "https://", "/v1:reportUsage") : "";
    }
}
