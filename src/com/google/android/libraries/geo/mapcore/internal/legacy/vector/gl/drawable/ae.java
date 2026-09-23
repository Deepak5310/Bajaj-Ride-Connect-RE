package com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class ae extends ag {
    public final com.google.android.libraries.navigation.internal.pt.d a;

    public ae(com.google.android.libraries.geo.mapcore.internal.model.ba baVar, int i, com.google.android.libraries.navigation.internal.pt.d dVar) {
        super(baVar, i);
        this.a = dVar;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.ag
    public final boolean equals(Object obj) {
        ae aeVar;
        return (obj instanceof ae) && (aeVar = (ae) obj) != null && com.google.android.libraries.navigation.internal.yx.am.a(this.b, aeVar.b) && com.google.android.libraries.navigation.internal.yx.am.a(this.a, aeVar.a);
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.ag
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.a, Integer.valueOf(this.c)});
    }
}
