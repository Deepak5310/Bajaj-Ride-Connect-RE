package com.google.android.libraries.navigation.internal.gm;

import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.ca;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aq implements com.google.android.libraries.navigation.internal.gh.e {
    public ca a;
    private final com.google.android.libraries.navigation.internal.il.a b;
    private final AtomicBoolean c = new AtomicBoolean(false);

    public aq(com.google.android.libraries.navigation.internal.il.a aVar) {
        this.b = aVar;
    }

    private final synchronized void c() {
        if (this.c.getAndSet(true)) {
            return;
        }
        this.b.c();
    }

    @Override // com.google.android.libraries.navigation.internal.gh.e
    public final synchronized bj a() {
        com.google.android.libraries.navigation.internal.gh.b bVarB = b();
        if (bVarB != null) {
            return az.h(bVarB);
        }
        if (this.a == null) {
            this.a = new ca();
        }
        return az.i(this.a);
    }

    public final synchronized com.google.android.libraries.navigation.internal.gh.b b() {
        c();
        if (!this.b.e()) {
            return null;
        }
        return new com.google.android.libraries.navigation.internal.gh.a("ZwiebackCookie", this.b.a());
    }
}
