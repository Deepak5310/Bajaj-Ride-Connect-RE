package com.google.android.libraries.navigation.internal.zm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements com.google.android.libraries.navigation.internal.agl.a {
    public final Object a;

    public a(Object obj) {
        this.a = obj;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final Object a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        Object obj2 = this.a;
        if (obj2 == null) {
            return aVar.a == null;
        }
        return obj2.equals(aVar.a);
    }

    public final int hashCode() {
        Object obj = this.a;
        if (obj == null) {
            return 37;
        }
        return obj.hashCode();
    }

    public final String toString() {
        return "Providers.of(" + String.valueOf(this.a) + ")";
    }
}
