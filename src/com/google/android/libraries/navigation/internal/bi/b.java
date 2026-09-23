package com.google.android.libraries.navigation.internal.bi;

import com.google.android.libraries.navigation.internal.afl.lz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends j {
    public final lz a;
    public final com.google.android.libraries.navigation.internal.gh.d b;
    public final com.google.android.libraries.navigation.internal.gg.e c;
    private final boolean d;
    private final long e;

    public b(lz lzVar, com.google.android.libraries.navigation.internal.gh.d dVar, boolean z, long j, com.google.android.libraries.navigation.internal.gg.e eVar) {
        this.a = lzVar;
        this.b = dVar;
        this.d = z;
        this.e = j;
        this.c = eVar;
    }

    @Override // com.google.android.libraries.navigation.internal.bi.j
    public final long a() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.bi.j
    public final com.google.android.libraries.navigation.internal.gg.e b() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.bi.j
    public final com.google.android.libraries.navigation.internal.gh.d c() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.bi.j
    public final lz d() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.bi.j
    public final boolean e() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            if (this.a.equals(jVar.d()) && this.b.equals(jVar.c()) && this.d == jVar.e() && this.e == jVar.a()) {
                jVar.f();
                if (this.c.equals(jVar.b())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.bi.j
    public final void f() {
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.gg.e eVar = this.c;
        com.google.android.libraries.navigation.internal.gh.d dVar = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(dVar) + ", " + this.d + ", " + this.e + ", 0, " + String.valueOf(eVar) + "}";
    }

    public final int hashCode() {
        int iN;
        lz lzVar = this.a;
        if (lzVar.H()) {
            iN = lzVar.n();
        } else {
            int iN2 = lzVar.ak;
            if (iN2 == 0) {
                iN2 = lzVar.n();
                lzVar.ak = iN2;
            }
            iN = iN2;
        }
        int iHashCode = (((((iN ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ (true != this.d ? 1237 : 1231)) * 1000003;
        long j = this.e;
        return ((iHashCode ^ ((int) (j ^ (j >>> 32)))) * (-721379959)) ^ this.c.hashCode();
    }
}
