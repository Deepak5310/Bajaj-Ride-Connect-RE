package com.google.android.libraries.navigation.internal.fw;

import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class l implements com.google.android.libraries.navigation.internal.fy.a {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.fw.l");

    public static final URL b() {
        try {
            return new URL("https://clients4.google.com/glm/mmap");
        } catch (MalformedURLException e) {
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(531)).s("Invalid non-zero-rated service address: %s", "https://clients4.google.com/glm/mmap");
            throw new IllegalArgumentException(e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.fy.a
    public final URL a() {
        try {
            return new URL("https://clients4.google.com/glm/mmap");
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
