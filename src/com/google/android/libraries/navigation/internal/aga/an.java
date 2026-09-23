package com.google.android.libraries.navigation.internal.aga;

import com.google.firebase.sessions.settings.RemoteSettings;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class an extends com.google.android.libraries.navigation.internal.afx.bz {
    private static final boolean a = com.google.android.libraries.navigation.internal.afx.ch.b(an.class.getClassLoader());

    @Override // com.google.android.libraries.navigation.internal.afx.bt
    public final com.google.android.libraries.navigation.internal.afx.by a(URI uri, com.google.android.libraries.navigation.internal.afx.br brVar) {
        if (!"dns".equals(uri.getScheme())) {
            return null;
        }
        String path = uri.getPath();
        com.google.android.libraries.navigation.internal.yx.ar.r(path, "targetPath");
        com.google.android.libraries.navigation.internal.yx.ar.i(path.startsWith(RemoteSettings.FORWARD_SLASH_STRING), "the path component (%s) of the target (%s) must start with '/'", path, uri);
        String strSubstring = path.substring(1);
        uri.getAuthority();
        return new am(strSubstring, brVar, az.b, new com.google.android.libraries.navigation.internal.yx.bm(), a);
    }

    @Override // com.google.android.libraries.navigation.internal.afx.bt
    public final String b() {
        return "dns";
    }

    @Override // com.google.android.libraries.navigation.internal.afx.bz
    public final Collection c() {
        return Collections.singleton(InetSocketAddress.class);
    }

    @Override // com.google.android.libraries.navigation.internal.afx.bz
    protected final void d() {
    }

    @Override // com.google.android.libraries.navigation.internal.afx.bz
    public final void e() {
    }
}
