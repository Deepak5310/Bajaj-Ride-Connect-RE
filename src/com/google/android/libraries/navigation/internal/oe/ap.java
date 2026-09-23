package com.google.android.libraries.navigation.internal.oe;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ap implements Comparable {
    public final String a;
    public final String b;
    public final com.google.android.libraries.navigation.internal.adi.an c;
    public final boolean d;

    public ap(String str, com.google.android.libraries.navigation.internal.adi.an anVar) {
        this(str + "." + anVar.name(), str, anVar, true);
    }

    private ap(String str, String str2, com.google.android.libraries.navigation.internal.adi.an anVar, boolean z) {
        this.b = str;
        this.a = str2;
        this.c = anVar;
        this.d = z;
    }

    public static ap a() {
        return new ap("m", com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_BASE);
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.b.compareTo(((ap) obj).b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ap) {
            return com.google.android.libraries.navigation.internal.yx.am.a(this.b, ((ap) obj).b);
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return this.b;
    }

    public ap(String str, String str2, com.google.android.libraries.navigation.internal.adi.an anVar) {
        this(str, str2, anVar, false);
    }
}
