package com.google.android.libraries.navigation.internal.zb;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class al implements u {
    private final u a;
    private final Object b;

    public al(u uVar, Object obj) {
        com.google.android.libraries.navigation.internal.zj.b.d(uVar, "log site key");
        this.a = uVar;
        com.google.android.libraries.navigation.internal.zj.b.d(obj, "log site qualifier");
        this.b = obj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof al)) {
            return false;
        }
        al alVar = (al) obj;
        return this.a.equals(alVar.a) && this.b.equals(alVar.b);
    }

    public final int hashCode() {
        Object obj = this.b;
        return obj.hashCode() ^ this.a.hashCode();
    }

    public final String toString() {
        Object obj = this.b;
        return "SpecializedLogSiteKey{ delegate='" + String.valueOf(this.a) + "', qualifier='" + obj.toString() + "' }";
    }
}
