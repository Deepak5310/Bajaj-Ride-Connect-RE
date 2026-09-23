package com.google.android.libraries.navigation.internal.sk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bp {
    private final String a;
    private final String b;

    public bp(String str, String str2) {
        this.b = str2;
        this.a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bp)) {
            return false;
        }
        bp bpVar = (bp) obj;
        if (this.b.equals(bpVar.b)) {
            return this.a.equals(bpVar.a);
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() + 32;
        return iHashCode + (iHashCode * 31) + this.b.hashCode();
    }
}
