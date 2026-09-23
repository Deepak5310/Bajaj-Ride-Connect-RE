package com.google.android.libraries.navigation.internal.le;

import android.os.DeadObjectException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c extends g {
    protected final l a;

    public c(l lVar) {
        super(2);
        this.a = lVar;
    }

    @Override // com.google.android.libraries.navigation.internal.le.g
    public final void d(com.google.android.libraries.navigation.internal.ld.ab abVar) {
        try {
            this.a.e(abVar);
        } catch (IllegalStateException unused) {
        }
    }

    @Override // com.google.android.libraries.navigation.internal.le.g
    public final void e(Exception exc) {
        try {
            this.a.e(new com.google.android.libraries.navigation.internal.ld.ab(10, exc.getClass().getSimpleName() + ": " + exc.getLocalizedMessage()));
        } catch (IllegalStateException unused) {
        }
    }

    @Override // com.google.android.libraries.navigation.internal.le.g
    public final void f(ae aeVar) throws DeadObjectException {
        try {
            this.a.d(aeVar.b);
        } catch (RuntimeException e) {
            e(e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.le.g
    public final void g(u uVar, boolean z) {
        l lVar = this.a;
        uVar.a.put(lVar, Boolean.valueOf(z));
        lVar.c(new s(uVar, lVar));
    }
}
