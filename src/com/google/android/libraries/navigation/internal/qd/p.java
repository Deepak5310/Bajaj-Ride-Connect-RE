package com.google.android.libraries.navigation.internal.qd;

import com.google.android.libraries.geo.mapcore.internal.model.aq;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p {
    public long a = 0;
    public aq b;

    public p(aq aqVar) {
        this.b = aqVar;
    }

    public final synchronized void a() {
        this.a++;
    }

    public final synchronized void b(aq aqVar) {
        this.b = aqVar;
        a();
    }
}
