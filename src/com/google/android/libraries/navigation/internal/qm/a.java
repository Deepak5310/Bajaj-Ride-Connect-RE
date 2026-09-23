package com.google.android.libraries.navigation.internal.qm;

import com.google.android.libraries.navigation.internal.adi.an;
import com.google.android.libraries.navigation.internal.gg.i;
import com.google.android.libraries.navigation.internal.gg.n;
import com.google.android.libraries.navigation.internal.kk.k;
import com.google.android.libraries.navigation.internal.kk.l;
import com.google.android.libraries.navigation.internal.km.aq;
import com.google.android.libraries.navigation.internal.km.p;
import com.google.android.libraries.navigation.internal.km.w;
import com.google.android.libraries.navigation.internal.km.x;
import com.google.android.libraries.navigation.internal.km.y;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static void a(com.google.android.libraries.navigation.internal.kl.a aVar, an anVar, i iVar, aq aqVar) {
        y yVar = new y("NetworkFetchEndToEndLatency".concat(String.valueOf(p.b(anVar))), w.MAP);
        n nVar = iVar.b;
        x xVarA = p.a(anVar);
        long millis = nVar.c.toMillis() - iVar.b.b.toMillis();
        ar.s((l) aVar.a(yVar), "No histogram for %s", yVar.b);
        ((l) aVar.a(yVar)).a(millis);
        ((k) aVar.a(xVarA)).a(aqVar.y);
    }

    public static void b(com.google.android.libraries.navigation.internal.kl.a aVar, an anVar, aq aqVar) {
        ((k) aVar.a(p.a(anVar))).a(aqVar.y);
    }
}
