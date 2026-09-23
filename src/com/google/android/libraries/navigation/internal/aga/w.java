package com.google.android.libraries.navigation.internal.aga;

import java.util.ArrayList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class w {
    private ArrayList a = new ArrayList();
    private volatile com.google.android.libraries.navigation.internal.afx.r b = com.google.android.libraries.navigation.internal.afx.r.IDLE;

    final void a(com.google.android.libraries.navigation.internal.afx.r rVar) {
        com.google.android.libraries.navigation.internal.yx.ar.r(rVar, "newState");
        if (this.b == rVar || this.b == com.google.android.libraries.navigation.internal.afx.r.SHUTDOWN) {
            return;
        }
        this.b = rVar;
        if (this.a.isEmpty()) {
            return;
        }
        ArrayList arrayList = this.a;
        this.a = new ArrayList();
        if (arrayList.size() <= 0) {
            return;
        }
        throw null;
    }
}
