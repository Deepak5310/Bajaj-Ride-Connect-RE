package com.google.android.libraries.navigation.internal.ve;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c extends d {
    private final boolean a;

    public c(boolean z) {
        this.a = z;
    }

    @Override // com.google.android.libraries.navigation.internal.ve.d
    public final boolean c() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof d) && this.a == ((d) obj).c();
    }

    public final int hashCode() {
        return (true != this.a ? 1237 : 1231) ^ 1000003;
    }

    public final String toString() {
        return "{" + this.a + "}";
    }
}
