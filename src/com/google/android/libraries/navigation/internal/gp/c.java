package com.google.android.libraries.navigation.internal.gp;

import com.google.android.libraries.navigation.internal.adi.af;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c implements com.google.android.libraries.navigation.internal.fy.a {
    final /* synthetic */ URL a;
    final /* synthetic */ com.google.android.libraries.navigation.internal.agl.a b;

    public c(URL url, com.google.android.libraries.navigation.internal.agl.a aVar) {
        this.a = url;
        this.b = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.fy.a
    public final URL a() {
        if ((((af) this.b.a()).b & 32) != 0) {
            try {
                return new URL(((af) this.b.a()).g);
            } catch (MalformedURLException unused) {
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 614)).p("Malformed Paint URL in client parameters.");
            }
        }
        return this.a;
    }
}
