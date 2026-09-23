package com.google.android.libraries.navigation.internal.gm;

import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.ca;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements com.google.android.libraries.navigation.internal.gh.e {
    private final com.google.android.libraries.navigation.internal.yx.an c;
    final com.google.android.libraries.navigation.internal.fw.a b = new e(this);
    public final ca a = new ca();

    public f(com.google.android.libraries.navigation.internal.yx.an anVar) {
        this.c = anVar;
    }

    @Override // com.google.android.libraries.navigation.internal.gh.e
    public final bj a() {
        bj bjVarI;
        if (!this.c.g()) {
            return az.g(new com.google.android.libraries.navigation.internal.gg.p(com.google.android.libraries.navigation.internal.gg.o.b));
        }
        if (!this.c.g()) {
            return az.h(null);
        }
        com.google.android.libraries.navigation.internal.gh.b bVarB = b();
        if (bVarB != null) {
            return az.h(bVarB);
        }
        synchronized (this) {
            bjVarI = az.i(this.a);
        }
        return bjVarI;
    }

    public final com.google.android.libraries.navigation.internal.gh.b b() {
        if (!this.c.g()) {
            return null;
        }
        String strA = ((com.google.android.libraries.navigation.internal.fw.b) this.c.c()).a();
        if (strA == null) {
            ((com.google.android.libraries.navigation.internal.fw.b) this.c.c()).b(this.b);
            strA = ((com.google.android.libraries.navigation.internal.fw.b) this.c.c()).a();
        }
        if (strA != null) {
            return new com.google.android.libraries.navigation.internal.gh.a("apiToken", strA);
        }
        return null;
    }
}
