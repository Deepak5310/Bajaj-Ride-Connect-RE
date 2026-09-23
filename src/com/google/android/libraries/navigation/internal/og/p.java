package com.google.android.libraries.navigation.internal.og;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p {
    private final AtomicReference a;
    private final com.google.android.libraries.navigation.internal.oq.e b;
    private final g c;
    private final Set d;

    public p(com.google.android.libraries.navigation.internal.oq.d dVar, com.google.android.libraries.navigation.internal.ni.a aVar, com.google.android.libraries.navigation.internal.om.p pVar) {
        com.google.android.libraries.navigation.internal.oq.e eVarG = com.google.android.libraries.navigation.internal.oq.f.g();
        this.b = eVarG;
        com.google.android.libraries.navigation.internal.oq.f.g();
        new com.google.android.libraries.navigation.internal.nt.p(false);
        this.d = new HashSet();
        Objects.requireNonNull(pVar);
        AtomicReference atomicReference = new AtomicReference(dVar.a());
        this.a = atomicReference;
        eVarG.m((com.google.android.libraries.navigation.internal.oq.f) atomicReference.get());
        new h(aVar, dVar);
        new o(aVar);
        dVar.b();
        this.c = new g();
        dVar.b();
    }

    public final synchronized void a(com.google.android.libraries.navigation.internal.pc.c cVar) {
        this.c.a(cVar);
    }
}
