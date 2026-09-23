package com.google.android.libraries.navigation.internal.afx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class s {
    public final r a;
    public final cl b;

    public s(r rVar, cl clVar) {
        com.google.android.libraries.navigation.internal.yx.ar.r(rVar, "state is null");
        this.a = rVar;
        com.google.android.libraries.navigation.internal.yx.ar.r(clVar, "status is null");
        this.b = clVar;
    }

    public static s a(r rVar) {
        com.google.android.libraries.navigation.internal.yx.ar.b(rVar != r.TRANSIENT_FAILURE, "state is TRANSIENT_ERROR. Use forError() instead");
        return new s(rVar, cl.b);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.a.equals(sVar.a) && this.b.equals(sVar.b);
    }

    public final int hashCode() {
        cl clVar = this.b;
        return clVar.hashCode() ^ this.a.hashCode();
    }

    public final String toString() {
        if (this.b.c()) {
            return this.a.toString();
        }
        r rVar = this.a;
        cl clVar = this.b;
        return String.valueOf(rVar) + "(" + String.valueOf(clVar) + ")";
    }
}
