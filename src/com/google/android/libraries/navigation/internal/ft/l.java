package com.google.android.libraries.navigation.internal.ft;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.yx.aq;
import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class l implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.agl.a c;
    private final com.google.android.libraries.navigation.internal.agl.a d;

    public l(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, com.google.android.libraries.navigation.internal.agl.a aVar4) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        final k kVar = new k((Context) this.a.a(), ((aa) this.b).a());
        bn bnVarA = ((com.google.android.libraries.navigation.internal.nj.b) this.c).a();
        final com.google.android.libraries.navigation.internal.afo.a aVarC = com.google.android.libraries.navigation.internal.afr.e.c(this.d);
        bnVarA.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.ft.i
            @Override // java.lang.Runnable
            public final void run() {
                com.google.android.libraries.navigation.internal.nk.d dVar = ((com.google.android.libraries.navigation.internal.nk.s) aVarC.a()).a().h;
                if (dVar == null) {
                    dVar = com.google.android.libraries.navigation.internal.nk.d.a;
                }
                k kVar2 = kVar;
                if (!dVar.c) {
                    kVar2.b.d();
                    return;
                }
                TelephonyManager telephonyManager = kVar2.c;
                String simCountryIso = telephonyManager.getSimCountryIso();
                if (aq.c(simCountryIso) && telephonyManager.getPhoneType() != 2) {
                    simCountryIso = telephonyManager.getNetworkCountryIso();
                }
                if (aq.c(simCountryIso)) {
                    simCountryIso = Locale.getDefault().getCountry();
                }
                kVar2.f = simCountryIso.toUpperCase(Locale.ROOT);
                if (k.f(kVar2.a)) {
                    kVar2.b.f(kVar2.f);
                }
            }
        });
        return kVar;
    }
}
