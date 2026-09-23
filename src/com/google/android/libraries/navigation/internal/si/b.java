package com.google.android.libraries.navigation.internal.si;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends d {
    public final boolean a;

    public b(boolean z) {
        this.a = z;
    }

    @Override // com.google.android.libraries.navigation.internal.si.d
    public final boolean a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof d) && this.a == ((d) obj).a();
    }

    public final int hashCode() {
        return (true != this.a ? 1237 : 1231) ^ 1000003;
    }

    public final String toString() {
        return "{" + this.a + "}";
    }
}
