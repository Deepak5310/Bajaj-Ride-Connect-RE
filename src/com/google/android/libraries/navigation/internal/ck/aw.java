package com.google.android.libraries.navigation.internal.ck;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class aw implements Comparable {
    public final com.google.android.libraries.navigation.internal.ol.aq a;
    public final com.google.android.libraries.navigation.internal.ol.aq b;
    public final int c;

    public aw(com.google.android.libraries.navigation.internal.ol.aq aqVar, com.google.android.libraries.navigation.internal.ol.aq aqVar2, int i) {
        this.a = aqVar;
        this.b = aqVar2;
        this.c = i;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.c - ((aw) obj).c;
    }
}
