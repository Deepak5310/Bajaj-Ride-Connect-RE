package com.google.android.libraries.navigation.internal.uc;

import com.google.android.libraries.navigation.internal.afl.fd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends i {
    public final fd a;
    public final boolean b;
    public final boolean c;

    public b(fd fdVar, boolean z, boolean z2) {
        this.a = fdVar;
        this.b = z;
        this.c = z2;
    }

    @Override // com.google.android.libraries.navigation.internal.uc.i
    public final fd a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.uc.i
    public final boolean b() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.uc.i
    public final boolean c() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (this.a.equals(iVar.a()) && this.b == iVar.b() && this.c == iVar.c()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ (true != this.b ? 1237 : 1231)) * 1000003) ^ (true == this.c ? 1231 : 1237);
    }

    public final String toString() {
        return "{" + String.valueOf(this.a) + ", " + this.b + ", " + this.c + "}";
    }
}
