package com.google.android.libraries.navigation.internal.aga;

/* JADX INFO: renamed from: com.google.android.libraries.navigation.internal.aga.do, reason: invalid class name */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class Cdo {
    public final com.google.android.libraries.navigation.internal.afx.aw a;
    public com.google.android.libraries.navigation.internal.afx.r b;
    public boolean c = false;
    public com.google.android.libraries.navigation.internal.afx.s d = com.google.android.libraries.navigation.internal.afx.s.a(com.google.android.libraries.navigation.internal.afx.r.IDLE);

    public Cdo(com.google.android.libraries.navigation.internal.afx.aw awVar, com.google.android.libraries.navigation.internal.afx.r rVar) {
        this.a = awVar;
        this.b = rVar;
    }

    public final com.google.android.libraries.navigation.internal.afx.r a() {
        return this.d.a;
    }

    public final void b(com.google.android.libraries.navigation.internal.afx.r rVar) {
        boolean z;
        this.b = rVar;
        if (rVar == com.google.android.libraries.navigation.internal.afx.r.READY || rVar == com.google.android.libraries.navigation.internal.afx.r.TRANSIENT_FAILURE) {
            z = true;
        } else if (rVar != com.google.android.libraries.navigation.internal.afx.r.IDLE) {
            return;
        } else {
            z = false;
        }
        this.c = z;
    }
}
