package com.google.android.libraries.geo.mapcore.renderer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class ae implements Comparable {
    public static final ae a = new ae(0, 0, 0, 0);
    public final long b;
    public final long c;
    public final long d;
    public final long e;

    public ae(long j, long j2, long j3, long j4) {
        this.b = j;
        this.c = j2;
        this.d = j3;
        this.e = j4;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(ae aeVar) {
        if (aeVar == null) {
            return 1;
        }
        long j = this.b;
        long j2 = aeVar.b;
        if (j < j2) {
            return -1;
        }
        if (j != j2) {
            return 1;
        }
        long j3 = this.c;
        long j4 = aeVar.c;
        if (j3 < j4) {
            return -1;
        }
        if (j3 != j4) {
            return 1;
        }
        long j5 = this.d;
        long j6 = aeVar.d;
        if (j5 < j6) {
            return -1;
        }
        return j5 == j6 ? 0 : 1;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ae)) {
            return false;
        }
        ae aeVar = (ae) obj;
        return this.b == aeVar.b && this.c == aeVar.c && this.d == aeVar.d && this.e == aeVar.e;
    }

    public final int hashCode() {
        int iA = ad.a(this.b);
        long j = this.e;
        return ((((((iA + 31) * 31) + ad.a(this.c)) * 31) + ad.a(this.d)) * 31) + ad.a(j);
    }

    public final String toString() {
        return "[plane: " + this.b + ", grade: " + this.c + ", within grade: " + this.d + ", id: " + this.e + "]";
    }
}
