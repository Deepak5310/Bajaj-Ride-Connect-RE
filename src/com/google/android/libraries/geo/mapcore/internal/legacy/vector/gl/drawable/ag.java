package com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class ag {
    protected final com.google.android.libraries.geo.mapcore.internal.model.ba b;
    protected final int c;

    public ag(com.google.android.libraries.geo.mapcore.internal.model.ba baVar, int i) {
        this.b = baVar;
        this.c = i;
    }

    public boolean equals(Object obj) {
        ag agVar;
        return (obj instanceof ag) && (agVar = (ag) obj) != null && this.b.equals(agVar.b) && this.c == agVar.c;
    }

    public int hashCode() {
        return ((this.b.hashCode() + 31) * 31) + this.c;
    }
}
