package com.google.android.libraries.navigation.internal.ui;

import com.google.android.libraries.navigation.internal.bp.ai;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.ea.d;
import com.google.android.libraries.navigation.internal.uc.g;
import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements Serializable {
    public final g a;
    public final boolean b;
    final int c;
    final int d;
    public final Float e;
    public final Float f;
    public final boolean g;
    public final com.google.android.libraries.navigation.internal.ue.b h;
    public final d i;
    public final com.google.android.libraries.navigation.internal.si.g j;
    final ai k;
    public final boolean l;
    public final com.google.android.libraries.navigation.internal.sz.a m;

    public b(g gVar, boolean z, bq bqVar, Float f, Float f2, boolean z2, com.google.android.libraries.navigation.internal.ue.b bVar, d dVar, com.google.android.libraries.navigation.internal.si.g gVar2, ai aiVar, boolean z3, com.google.android.libraries.navigation.internal.sz.a aVar) {
        int iHashCode;
        this.a = gVar;
        this.b = z;
        if (bqVar != null) {
            this.c = bqVar.i;
            iHashCode = bqVar.hashCode();
        } else {
            iHashCode = -1;
            this.c = -1;
        }
        this.d = iHashCode;
        this.e = f;
        this.f = f2;
        this.g = z2;
        this.h = bVar;
        this.i = dVar;
        this.j = gVar2;
        this.k = aiVar;
        this.l = z3;
        this.m = aVar;
    }
}
