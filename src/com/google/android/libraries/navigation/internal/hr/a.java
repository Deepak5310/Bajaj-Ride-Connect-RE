package com.google.android.libraries.navigation.internal.hr;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.afl.am;
import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a implements com.google.android.libraries.navigation.internal.gg.e {
    final /* synthetic */ com.google.android.libraries.navigation.internal.kk.m a;
    final /* synthetic */ com.google.android.libraries.navigation.internal.gg.e b;
    final /* synthetic */ Locale c;
    final /* synthetic */ b d;

    public a(b bVar, com.google.android.libraries.navigation.internal.kk.m mVar, com.google.android.libraries.navigation.internal.gg.e eVar, Locale locale) {
        this.a = mVar;
        this.b = eVar;
        this.c = locale;
        this.d = bVar;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.e
    public final void a(com.google.android.libraries.navigation.internal.gg.i iVar, com.google.android.libraries.navigation.internal.gg.o oVar) {
        this.a.a();
        String[] strArr = com.google.android.libraries.navigation.internal.nw.e.a;
        Trace.endAsyncSection("ClientParametersFetcher.fetch", 1);
        this.b.a(iVar, oVar);
    }

    @Override // com.google.android.libraries.navigation.internal.gg.e
    public final /* bridge */ /* synthetic */ void b(com.google.android.libraries.navigation.internal.gg.i iVar, Object obj) {
        this.a.a();
        String[] strArr = com.google.android.libraries.navigation.internal.nw.e.a;
        Trace.endAsyncSection("ClientParametersFetcher.fetch", 1);
        this.b.b(iVar, (am) obj);
    }
}
