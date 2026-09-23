package com.google.android.libraries.navigation.internal.sk;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class di implements com.google.android.libraries.navigation.internal.aac.as {
    final /* synthetic */ c a;
    final /* synthetic */ dj b;

    public di(dj djVar, c cVar) {
        this.a = cVar;
        this.b = djVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void a(Throwable th) {
        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1484)).p("VoiceGuidance-error");
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final /* bridge */ /* synthetic */ void b(Object obj) {
        Cdo cdo = (Cdo) obj;
        if (cdo.a) {
            ad adVar = (ad) Objects.requireNonNull(cdo.b);
            if (adVar == ad.NEVER_PLAY_ALERT) {
                this.b.a.c();
                return;
            } else if (adVar == ad.WAIT_TO_PLAY_ALERT) {
                return;
            }
        }
        dj djVar = this.b;
        c cVar = this.a;
        com.google.android.libraries.navigation.internal.th.c cVarH = djVar.a.p.h();
        int iE = cVar.e();
        int i = iE - 1;
        if (iE == 0) {
            throw null;
        }
        if (i == 0) {
            cVarH.e();
        } else if (i == 1) {
            cVarH.f();
        } else if (i == 4) {
            cVarH.c();
        } else if (i == 5) {
            cVarH.d();
        }
        this.a.c(this.b.a.u);
        cVarH.b();
    }
}
