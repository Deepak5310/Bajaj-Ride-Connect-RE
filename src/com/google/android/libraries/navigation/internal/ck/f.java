package com.google.android.libraries.navigation.internal.ck;

import com.google.android.libraries.navigation.internal.adg.ex;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class f extends bn {
    public final com.google.android.libraries.navigation.internal.yx.an a;
    public final ex b;
    public final ex c;

    public f(com.google.android.libraries.navigation.internal.yx.an anVar, ex exVar, ex exVar2) {
        this.a = anVar;
        this.b = exVar;
        this.c = exVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.bn
    public final com.google.android.libraries.navigation.internal.yx.an a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.bn
    public final ex b() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.bn
    public final ex c() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        ex exVar;
        ex exVar2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof bn) {
            bn bnVar = (bn) obj;
            if (this.a.equals(bnVar.a()) && ((exVar = this.b) != null ? exVar.equals(bnVar.c()) : bnVar.c() == null) && ((exVar2 = this.c) != null ? exVar2.equals(bnVar.b()) : bnVar.b() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() ^ 1000003;
        ex exVar = this.b;
        int iHashCode2 = ((iHashCode * 1000003) ^ (exVar == null ? 0 : exVar.hashCode())) * 1000003;
        ex exVar2 = this.c;
        return iHashCode2 ^ (exVar2 != null ? exVar2.hashCode() : 0);
    }

    public final String toString() {
        ex exVar = this.c;
        ex exVar2 = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(exVar2) + ", " + String.valueOf(exVar) + "}";
    }
}
