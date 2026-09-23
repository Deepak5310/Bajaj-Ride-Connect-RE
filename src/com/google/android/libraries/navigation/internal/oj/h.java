package com.google.android.libraries.navigation.internal.oj;

import com.google.android.libraries.navigation.internal.adg.Cdo;
import com.google.android.libraries.navigation.internal.adg.dy;
import com.google.android.libraries.navigation.internal.adg.ef;
import com.google.android.libraries.navigation.internal.ol.aq;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class h {
    public static h e(com.google.android.libraries.navigation.internal.ot.h hVar, com.google.android.libraries.navigation.internal.oo.f fVar, com.google.android.libraries.navigation.internal.ot.g gVar) {
        return new g(fVar == null ? hVar.b(gVar) : hVar.c(fVar, gVar));
    }

    public static h f(aq aqVar) {
        return new e(aqVar == null ? (dy) ef.a.q() : aqVar.d());
    }

    public abstract Cdo a(Object obj);

    public abstract dy b();

    public abstract Object d();
}
