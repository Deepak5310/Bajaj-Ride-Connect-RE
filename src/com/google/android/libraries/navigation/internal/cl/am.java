package com.google.android.libraries.navigation.internal.cl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class am implements com.google.android.libraries.navigation.internal.oh.a {
    @Override // com.google.android.libraries.navigation.internal.oh.a
    public final float a(com.google.android.libraries.navigation.internal.op.g gVar, com.google.android.libraries.navigation.internal.qk.q qVar, com.google.android.libraries.navigation.internal.oe.x xVar, com.google.android.libraries.navigation.internal.adg.b bVar, com.google.android.libraries.navigation.internal.qk.s sVar) {
        float f = ((com.google.android.libraries.navigation.internal.oq.b) qVar.h.g()).e < 15.0f ? 1.0f : 0.0f;
        if (sVar != null) {
            sVar.a(xVar, bVar, com.google.android.libraries.navigation.internal.b.b.h(f, "SecondCalloutIsNotRelevantAtZoom:"));
        }
        return f;
    }
}
