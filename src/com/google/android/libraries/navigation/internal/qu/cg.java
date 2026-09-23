package com.google.android.libraries.navigation.internal.qu;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cg {
    public final com.google.android.libraries.navigation.internal.mj.a a;
    public final com.google.android.libraries.navigation.internal.adi.an b;
    public long c = (long) (Math.random() * 5000.0d);
    public long d;

    public cg(com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.adi.an anVar) {
        this.a = aVar;
        this.b = anVar;
        this.d = aVar.f().toEpochMilli() + this.c;
        anVar.name();
    }
}
