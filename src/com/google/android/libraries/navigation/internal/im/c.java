package com.google.android.libraries.navigation.internal.im;

import com.google.android.libraries.navigation.internal.aag.l;
import java.net.URL;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c {
    public static l a(URL url) {
        String host = url.getHost();
        int defaultPort = url.getDefaultPort();
        return new com.google.android.libraries.navigation.internal.aag.c(host, defaultPort, defaultPort);
    }
}
