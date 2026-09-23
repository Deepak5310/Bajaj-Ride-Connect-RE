package com.google.android.libraries.navigation.internal.tc;

import com.google.android.libraries.navigation.internal.aac.be;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.hx.ap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g implements com.google.android.libraries.navigation.internal.nt.u {
    final j a;
    String b;

    public g(j jVar, String str) {
        this.a = jVar;
        this.b = str;
    }

    public final bj a(com.google.android.libraries.navigation.internal.nt.a aVar) {
        ap.NAVIGATION_INTERNAL.f();
        String str = (String) aVar.a();
        String str2 = this.b;
        if (str2.equals(str) || str2.equals("UNKNOWN")) {
            this.b = str;
            return be.a;
        }
        this.a.d(true);
        return be.a;
    }
}
