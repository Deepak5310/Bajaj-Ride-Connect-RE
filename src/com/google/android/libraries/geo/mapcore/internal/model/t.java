package com.google.android.libraries.geo.mapcore.internal.model;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class t implements cc {
    private com.google.android.libraries.navigation.internal.dm.s a;
    private com.google.android.libraries.navigation.internal.oe.as b;
    private final com.google.android.libraries.navigation.internal.adi.an c;
    private final cd d;

    public t(com.google.android.libraries.navigation.internal.dm.s sVar, com.google.android.libraries.navigation.internal.adi.an anVar, cd cdVar, com.google.android.libraries.navigation.internal.oe.as asVar) {
        this.a = sVar;
        this.b = asVar;
        this.c = anVar;
        this.d = cdVar;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cc
    public final int a() {
        return 0;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cc
    public final synchronized com.google.android.libraries.navigation.internal.dm.s b() {
        return this.a;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cc
    public final synchronized com.google.android.libraries.navigation.internal.oe.as c() {
        return this.b;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cc
    public final com.google.android.libraries.navigation.internal.adi.an d() {
        return this.c;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cc
    public final synchronized void e(com.google.android.libraries.navigation.internal.dm.s sVar) {
        this.a = sVar;
    }

    public final synchronized boolean equals(Object obj) {
        com.google.android.libraries.navigation.internal.dm.s sVar;
        com.google.android.libraries.navigation.internal.oe.as asVar;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        synchronized (tVar) {
            sVar = tVar.a;
            asVar = tVar.b;
        }
        return com.google.android.libraries.navigation.internal.yx.am.a(this.a, sVar) && com.google.android.libraries.navigation.internal.yx.am.a(this.b, asVar) && com.google.android.libraries.navigation.internal.yx.am.a(this.c, tVar.c) && com.google.android.libraries.navigation.internal.yx.am.a(this.d, tVar.d);
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cc
    public final synchronized void f(com.google.android.libraries.navigation.internal.oe.as asVar) {
        this.b = asVar;
    }

    public final synchronized int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, this.c, this.d});
    }
}
