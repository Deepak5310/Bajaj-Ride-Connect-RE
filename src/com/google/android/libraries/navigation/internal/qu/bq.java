package com.google.android.libraries.navigation.internal.qu;

import com.google.android.libraries.navigation.internal.afm.dc;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class bq {
    public static boolean l(dc dcVar) {
        return dcVar.equals(dc.PREFETCH_OFFLINE_MAP) || dcVar.equals(dc.PREFETCH_SAVE_THIS_ROUTE);
    }

    public abstract com.google.android.libraries.navigation.internal.gp.b a();

    public abstract com.google.android.libraries.geo.mapcore.internal.model.cd b();

    public abstract com.google.android.libraries.navigation.internal.qv.i c();

    public abstract com.google.android.libraries.navigation.internal.adi.an d();

    public abstract dc e();

    public abstract String f();

    public abstract boolean g();

    public abstract boolean h();

    public abstract boolean i();

    public abstract boolean j();

    public abstract void k();

    public final boolean m() {
        dc dcVarE = e();
        return dcVarE.equals(dc.PREFETCH_AREA) || dcVarE.equals(dc.PREFETCH_ROUTE) || dcVarE.equals(dc.PREFETCH_OFFLINE_MAP) || dcVarE.equals(dc.PREFETCH_SAVE_THIS_ROUTE);
    }
}
