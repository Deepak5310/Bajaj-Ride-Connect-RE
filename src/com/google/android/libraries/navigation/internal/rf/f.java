package com.google.android.libraries.navigation.internal.rf;

import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.oq.h;
import com.google.android.libraries.navigation.internal.pb.m;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements h {
    final float a = 65.0f;
    private final m b;

    public f(m mVar, com.google.android.libraries.navigation.internal.oq.g gVar) {
        this.b = mVar;
        mVar.b = new e(gVar);
    }

    @Override // com.google.android.libraries.navigation.internal.oq.h
    public final float a(float f) {
        if (f >= 13.5f) {
            return 65.0f;
        }
        if (f > 11.75f) {
            return (((f - 11.75f) * 20.0f) / 1.75f) + 45.0f;
        }
        if (f > 10.0f) {
            return (((f - 10.0f) * 15.0f) / 1.75f) + 30.0f;
        }
        return 30.0f;
    }

    @Override // com.google.android.libraries.navigation.internal.oq.h
    public final float b(float f, x xVar) {
        return this.b.c(f, xVar);
    }

    @Override // com.google.android.libraries.navigation.internal.oq.h
    public final com.google.android.libraries.navigation.internal.oq.f c(com.google.android.libraries.navigation.internal.oq.f fVar) {
        return com.google.android.libraries.navigation.internal.pd.d.b(this.b.d(com.google.android.libraries.navigation.internal.pd.d.c(fVar)));
    }
}
