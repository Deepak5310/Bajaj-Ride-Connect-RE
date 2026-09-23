package com.google.android.libraries.navigation.internal.yh;

import android.net.Uri;
import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.ael.di;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ac extends au {
    public static final au a = new ac();

    private ac() {
    }

    @Override // com.google.android.libraries.navigation.internal.yh.au
    public final /* bridge */ /* synthetic */ at a(m mVar, String str, Executor executor, com.google.android.libraries.navigation.internal.xy.f fVar, d dVar) {
        com.google.android.libraries.navigation.internal.ael.ar arVarB;
        com.google.android.libraries.navigation.internal.yx.ar.q(dVar);
        b bVar = (b) mVar;
        if (bVar.f) {
            arVarB = com.google.android.libraries.navigation.internal.ael.ar.b();
        } else {
            com.google.android.libraries.navigation.internal.ael.ar arVar = com.google.android.libraries.navigation.internal.ael.ar.a;
            di diVar = di.a;
            arVarB = com.google.android.libraries.navigation.internal.ael.ar.a;
        }
        com.google.android.libraries.navigation.internal.ym.a aVar = new com.google.android.libraries.navigation.internal.ym.a(bVar.b, arVarB);
        Uri uri = bVar.a;
        return new ae(str, az.h(uri), aVar, executor, fVar, bVar.c, new com.google.android.libraries.navigation.internal.yr.n());
    }

    @Override // com.google.android.libraries.navigation.internal.yh.au
    public final String b(d dVar) {
        com.google.android.libraries.navigation.internal.yx.ar.q(dVar);
        return "singleproc";
    }
}
