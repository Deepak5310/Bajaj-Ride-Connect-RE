package com.google.android.libraries.navigation.internal.gp;

import com.drew.metadata.iptc.IptcDirectory;
import com.facebook.common.util.UriUtil;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.gp.u");

    public static final URL a() {
        try {
            URL url = new URL("https://www.google.com/maps/vt");
            if (!UriUtil.HTTPS_SCHEME.equals(url.getProtocol())) {
                ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(IptcDirectory.TAG_COPYRIGHT_NOTICE)).s("Paint server URL should be an https URL: %s", "https://www.google.com/maps/vt");
            }
            return url;
        } catch (MalformedURLException e) {
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(IptcDirectory.TAG_SOURCE)).s("Invalid paint service address: %s", "https://www.google.com/maps/vt");
            throw new IllegalArgumentException(e);
        }
    }
}
