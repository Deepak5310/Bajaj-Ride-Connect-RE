package com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
class a extends n {
    public final com.google.android.libraries.geo.mapcore.internal.model.ai a;
    public final m b;

    public a(com.google.android.libraries.geo.mapcore.internal.model.ai aiVar, m mVar) {
        Objects.requireNonNull(aiVar);
        this.a = aiVar;
        Objects.requireNonNull(mVar);
        this.b = mVar;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.n
    public final m a() {
        return this.b;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.n
    public final com.google.android.libraries.geo.mapcore.internal.model.ai b() {
        return this.a;
    }

    public final String toString() {
        m mVar = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(mVar) + "}";
    }
}
