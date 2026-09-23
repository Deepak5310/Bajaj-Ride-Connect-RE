package com.google.android.libraries.navigation.internal.ael;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dm extends p {
    final Cdo a;
    s b = b();
    final /* synthetic */ dq c;

    public dm(dq dqVar) {
        this.c = dqVar;
        this.a = new Cdo(dqVar);
    }

    private final s b() {
        Cdo cdo = this.a;
        if (cdo.hasNext()) {
            return cdo.next().iterator();
        }
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.s
    public final byte a() {
        s sVar = this.b;
        if (sVar == null) {
            throw new NoSuchElementException();
        }
        byte bA = sVar.a();
        if (!this.b.hasNext()) {
            this.b = b();
        }
        return bA;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b != null;
    }
}
