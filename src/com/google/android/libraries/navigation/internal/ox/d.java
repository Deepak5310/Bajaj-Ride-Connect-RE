package com.google.android.libraries.navigation.internal.ox;

import com.google.android.libraries.geo.mapcore.internal.model.cl;
import com.google.android.libraries.geo.mapcore.internal.model.q;
import com.google.android.libraries.navigation.internal.kk.k;
import com.google.android.libraries.navigation.internal.km.p;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    public static void a(com.google.android.libraries.navigation.internal.kl.a aVar, int i, cl clVar) {
        int iOrdinal = ((q) clVar).a.ordinal();
        if (iOrdinal == 0) {
            ((k) aVar.a(p.al)).a(i);
            return;
        }
        if (iOrdinal == 1) {
            ((k) aVar.a(p.ak)).a(i);
        } else if (iOrdinal == 2) {
            ((k) aVar.a(p.am)).a(i);
        } else {
            if (iOrdinal != 3) {
                return;
            }
            ((k) aVar.a(p.aj)).a(i);
        }
    }
}
