package com.google.android.libraries.navigation.internal.gi;

import com.drew.metadata.iptc.IptcDirectory;
import com.facebook.common.util.UriUtil;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class a implements com.google.android.libraries.navigation.internal.fy.a {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.gi.a");

    public static URL b(String str) {
        try {
            URL url = new URL("https://mobilemaps-pa.googleapis.com:443");
            if (!url.getProtocol().equals(UriUtil.HTTPS_SCHEME)) {
                ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(IptcDirectory.TAG_ORIGINATING_PROGRAM)).s("https is required for service address: %s", "https://mobilemaps-pa.googleapis.com:443");
            }
            return url;
        } catch (MalformedURLException e) {
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(578)).s("Invalid gRPC service address: %s", "https://mobilemaps-pa.googleapis.com:443");
            throw new IllegalArgumentException(e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.fy.a
    public final URL a() {
        return b("https://mobilemaps-pa.googleapis.com:443");
    }
}
