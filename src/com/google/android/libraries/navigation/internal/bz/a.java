package com.google.android.libraries.navigation.internal.bz;

import com.google.android.libraries.navigation.internal.adr.el;
import com.google.android.libraries.navigation.internal.adr.fm;
import com.google.android.libraries.navigation.internal.adr.fn;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.zb.h;
import com.google.android.libraries.navigation.internal.zb.j;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements cs {
    private static final j a = j.e("com.google.android.libraries.navigation.internal.bz.a");

    public a(an anVar, el elVar) {
        if (!anVar.g()) {
            ((h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F('d')).p("ReportTransitDelayController is null. Check the that the entry point leading to this usage includes a module filling the optional binding.");
        }
        fm fmVar = (elVar.c == 25 ? (fn) elVar.d : fn.a).g;
        String str = (fmVar == null ? fm.a : fmVar).b;
    }
}
