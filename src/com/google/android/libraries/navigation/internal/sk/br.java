package com.google.android.libraries.navigation.internal.sk;

import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class br implements com.google.android.libraries.navigation.internal.gg.e {
    final /* synthetic */ bs a;
    private final bq b;

    public br(bs bsVar, bq bqVar) {
        this.a = bsVar;
        this.b = bqVar;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.e
    public final void a(com.google.android.libraries.navigation.internal.gg.i iVar, com.google.android.libraries.navigation.internal.gg.o oVar) {
        synchronized (this.a) {
            this.a.c(this.b);
            this.a.f = null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.gg.e
    public final /* bridge */ /* synthetic */ void b(com.google.android.libraries.navigation.internal.gg.i iVar, Object obj) {
        com.google.android.libraries.navigation.internal.afm.aj ajVar = (com.google.android.libraries.navigation.internal.afm.aj) obj;
        synchronized (this.a) {
            if (ajVar.b.size() == 0) {
                bq bqVar = this.b;
                if (bqVar.d > 0) {
                    this.a.e(bqVar);
                } else {
                    this.a.c(bqVar);
                    this.a.f = null;
                }
                return;
            }
            com.google.android.libraries.navigation.internal.afm.ai aiVar = (com.google.android.libraries.navigation.internal.afm.ai) ajVar.b.get(0);
            int i = aiVar.d;
            if (i == 200) {
                bq bqVar2 = this.b;
                Locale locale = bqVar2.a;
                String str = bqVar2.b;
                long j = aiVar.e;
                String str2 = this.a.a;
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.a.d(this.b, new bo(locale.toString(), str, j, jCurrentTimeMillis, jCurrentTimeMillis, str2), aiVar.f.B());
            } else if (i == 304) {
                bq bqVar3 = this.b;
                bo boVar = bqVar3.c;
                if (boVar != null) {
                    boVar.d = System.currentTimeMillis();
                    this.a.f();
                } else {
                    this.a.c(bqVar3);
                }
            } else {
                this.a.c(this.b);
            }
            this.a.f = null;
        }
    }
}
