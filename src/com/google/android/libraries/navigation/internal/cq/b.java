package com.google.android.libraries.navigation.internal.cq;

import com.google.android.libraries.navigation.internal.ol.aq;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends r {
    public com.google.android.libraries.navigation.internal.oo.f a;
    public aq b;
    public com.google.android.libraries.navigation.internal.oo.f c;
    public aq d;
    public com.google.android.libraries.navigation.internal.oo.f e;
    public aq f;
    public com.google.android.libraries.navigation.internal.oo.f g;
    public aq h;
    public com.google.android.libraries.navigation.internal.oo.f i;
    private aq j;

    @Override // com.google.android.libraries.navigation.internal.cq.r
    public final r a(aq aqVar) {
        Objects.requireNonNull(aqVar);
        this.j = aqVar;
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.cq.r
    public final w b() {
        com.google.android.libraries.navigation.internal.oo.f fVar;
        aq aqVar;
        com.google.android.libraries.navigation.internal.oo.f fVar2;
        aq aqVar2 = this.j;
        if (aqVar2 == null || (fVar = this.a) == null || (aqVar = this.b) == null || (fVar2 = this.c) == null) {
            throw new IllegalStateException();
        }
        return new w(aqVar2, fVar, aqVar, fVar2, this.d, this.e, this.f, this.g, this.h, this.i);
    }
}
