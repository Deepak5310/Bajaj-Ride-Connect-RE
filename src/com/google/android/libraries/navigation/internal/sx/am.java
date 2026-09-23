package com.google.android.libraries.navigation.internal.sx;

import android.content.Context;
import com.google.android.libraries.navigation.internal.afl.lz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class am extends Exception {
    public final lz a;
    public final long b;
    public final Context c;
    public final boolean d;
    public final com.google.android.libraries.navigation.internal.fw.g e;
    public final int f;

    public am(com.google.android.libraries.navigation.internal.bi.j jVar, Context context, com.google.android.libraries.navigation.internal.fw.g gVar) {
        this.a = jVar.d();
        this.b = jVar.a();
        this.c = context;
        this.d = jVar.e();
        int iC = com.google.android.libraries.navigation.internal.bi.m.c(jVar.d());
        this.f = iC == 0 ? com.google.android.libraries.navigation.internal.adq.be.a : iC;
        this.e = gVar;
    }
}
