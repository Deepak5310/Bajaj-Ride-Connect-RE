package com.google.android.libraries.navigation.internal.px;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class p extends dj {
    private final int a;

    public p(int i) {
        this.a = i;
    }

    @Override // com.google.android.libraries.navigation.internal.px.dj
    public final int a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof dj) && this.a == ((dj) obj).a();
    }

    public final int hashCode() {
        return this.a ^ 1000003;
    }

    public final String toString() {
        return "{" + this.a + "}";
    }
}
