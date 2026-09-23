package com.google.android.libraries.navigation.internal.ms;

import android.content.Context;
import android.view.View;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cb extends bv {
    cs a;
    cq b;

    public cb(View view, ax axVar, bx bxVar, cc ccVar, bt btVar, int i, boolean z) {
        super(view, axVar, bxVar, ccVar, btVar, i, z);
    }

    @Override // com.google.android.libraries.navigation.internal.ms.ck
    public final cs b(cs csVar, Context context) {
        if (csVar == null) {
            return null;
        }
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ms.ck
    public final void d(cs csVar) {
        this.a = csVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ms.ck
    public final cq e() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ms.ck
    public final void f(cq cqVar) {
        this.b = cqVar;
    }
}
