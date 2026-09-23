package com.google.android.libraries.navigation.internal.oe;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i extends j {
    public i(long j, long j2) {
        super(j, j2);
    }

    public static i a(String str) {
        j jVarE = j.e(str);
        if (jVarE != null) {
            return new i(jVarE.b, jVarE.c);
        }
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.oe.j
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i) && this.c == ((i) obj).c;
    }

    @Override // com.google.android.libraries.navigation.internal.oe.j
    public final int hashCode() {
        long j = this.c;
        return (int) (j ^ (j >>> 32));
    }
}
