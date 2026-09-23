package com.google.android.libraries.navigation.internal.bp;

import com.google.android.libraries.navigation.internal.adr.ll;
import com.google.maps.android.BuildConfig;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class w extends cm {
    public final com.google.android.libraries.navigation.internal.oe.r a;
    private final long b;
    private final int c;
    private final int d;

    public w(com.google.android.libraries.navigation.internal.oe.r rVar, long j, int i, int i2) {
        this.a = rVar;
        this.b = j;
        this.c = i;
        this.d = i2;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.cm
    public final int a() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.cm
    public final long b() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.cm
    public final com.google.android.libraries.navigation.internal.oe.r c() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.cm
    public final int d() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        int i;
        if (obj == this) {
            return true;
        }
        if (obj instanceof cm) {
            cm cmVar = (cm) obj;
            if (this.a.equals(cmVar.c()) && this.b == cmVar.b() && this.c == cmVar.a() && ((i = this.d) != 0 ? i == cmVar.d() : cmVar.d() == 0)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() ^ 1000003;
        int i = this.d;
        int iA = i == 0 ? 0 : ll.a(i);
        long j = this.b;
        return (((((iHashCode * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ this.c) * 1000003) ^ iA;
    }

    public final String toString() {
        int i = this.d;
        return "{" + String.valueOf(this.a) + ", " + this.b + ", " + this.c + ", " + String.valueOf(i != 0 ? ll.toString$ar$edu$badbf1e6_0(i) : BuildConfig.TRAVIS) + "}";
    }
}
