package com.google.android.libraries.navigation.internal.tn;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class p {
    public static o a() {
        a aVar = new a();
        aVar.d("");
        aVar.l("");
        aVar.e("");
        aVar.i("");
        aVar.g("");
        aVar.h("");
        aVar.k("");
        aVar.j("");
        aVar.c("");
        aVar.f("");
        aVar.b("");
        aVar.m("");
        return aVar;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof p) && toString().equals(obj.toString());
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public abstract String toString();
}
