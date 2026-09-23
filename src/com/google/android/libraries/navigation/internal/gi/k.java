package com.google.android.libraries.navigation.internal.gi;

import com.google.android.libraries.navigation.internal.afx.bg;
import com.google.android.libraries.navigation.internal.afx.bk;
import com.google.android.libraries.navigation.internal.afx.bl;
import com.google.android.libraries.navigation.internal.afx.bo;
import com.google.common.net.HttpHeaders;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k {
    public static final bl a;

    static {
        bg bgVar = bo.d;
        int i = bl.b;
        new bk("X-Gmm-Client-bin", bgVar);
        bl.a("Hello", bo.b);
        bl.a(HttpHeaders.ACCEPT_LANGUAGE, bo.b);
        bl.a("X-Goog-Api-Key", bo.b);
        bl.a("X-Android-Cert", bo.b);
        bl.a("X-Android-Package", bo.b);
        bl.a("X-Device-Boot-Count", bo.b);
        bl.a("X-Device-Elapsed-Time", bo.b);
        new bk("X-Geo-bin", bo.d);
        new bk("X-Client-Data-bin", bo.d);
        new bk("X-Client-Time-Format-bin", bo.d);
        bl.a("cookie-nid", bo.b);
        bl.a("cookie-debug", bo.b);
        bl.a("adspam-essential-cookie", bo.b);
        new bk("client-response-data-bin", bo.d);
        new bk("x-goog-ext-353267353-bin", bo.d);
        new bk("reset-signal-bin", bo.d);
        bl.a("server-timing", bo.b);
        bl.a("X-Goog-Request-Params", bo.b);
        a = new bk("x-server-version-bin", bo.d);
        new bk("X-Goog-Signed-Out-State-bin", bo.d);
    }
}
