package com.google.android.libraries.navigation.internal.jy;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class d extends l {
    public final int a;

    public d(int i) {
        this.a = i;
    }

    @Override // com.google.android.libraries.navigation.internal.jy.l
    public final int a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof l) && this.a == ((l) obj).a();
    }

    public final int hashCode() {
        return this.a ^ 1000003;
    }

    public final String toString() {
        return "{" + this.a + "}";
    }
}
