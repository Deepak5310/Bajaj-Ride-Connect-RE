package com.google.android.libraries.navigation.internal.ms;

import android.content.Context;
import android.view.View;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class an extends bv {
    final bx a;
    final by b;

    public an(View view, ax axVar, bx bxVar, by byVar, bx bxVar2, cc ccVar, bt btVar, int i, boolean z) {
        super(view, axVar, bxVar2, ccVar, btVar, i, z);
        this.a = bxVar;
        this.b = byVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ms.ck
    public final bx a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ms.ck
    public final cs b(cs csVar, Context context) {
        if (csVar == null) {
            return null;
        }
        return (cs) this.b.a(csVar, context);
    }
}
