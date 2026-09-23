package com.google.android.libraries.navigation.internal.hr;

import android.content.Context;
import android.os.Build;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.adi.ab;
import com.google.android.libraries.navigation.internal.ael.x;
import com.google.android.libraries.navigation.internal.afl.ag;
import com.google.android.libraries.navigation.internal.afl.ah;
import com.google.android.libraries.navigation.internal.afl.ai;
import com.google.android.libraries.navigation.internal.afl.aj;
import com.google.android.libraries.navigation.internal.yx.aq;
import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class m implements Runnable {
    final com.google.android.libraries.navigation.internal.hj.i a;
    final Locale b;
    final com.google.android.libraries.navigation.internal.ir.a c;
    final String d;
    final boolean e;
    public volatile boolean f = false;
    final /* synthetic */ o g;
    private volatile com.google.android.libraries.navigation.internal.gg.b h;

    public m(o oVar, com.google.android.libraries.navigation.internal.hj.i iVar, Locale locale, com.google.android.libraries.navigation.internal.ir.a aVar, String str, boolean z) {
        this.g = oVar;
        this.a = iVar;
        this.b = locale;
        this.c = aVar;
        this.d = str;
        this.e = z;
    }

    final void a() {
        this.f = true;
        if (this.h != null) {
            this.h.a();
        }
    }

    /* JADX WARN: Type inference failed for: r8v1, types: [com.google.android.libraries.navigation.internal.fz.d, com.google.android.libraries.navigation.internal.hm.f] */
    @Override // java.lang.Runnable
    public final void run() {
        if (this.f) {
            return;
        }
        com.google.android.libraries.navigation.internal.zb.j jVar = o.a;
        o oVar = this.g;
        com.google.android.libraries.navigation.internal.hj.i iVar = this.a;
        Locale locale = this.b;
        com.google.android.libraries.navigation.internal.hu.b bVar = com.google.android.libraries.navigation.internal.hu.b.GWS;
        l lVar = new l(this, bVar);
        String[] strArr = com.google.android.libraries.navigation.internal.nw.e.a;
        Trace.beginAsyncSection("ClientParametersFetcher.fetch", 1);
        b bVar2 = oVar.e;
        ((com.google.android.libraries.navigation.internal.gq.e) bVar2.a.a()).b().e = iVar;
        com.google.android.libraries.navigation.internal.kk.m mVarA = ((com.google.android.libraries.navigation.internal.kk.n) ((com.google.android.libraries.navigation.internal.kl.a) bVar2.b.a()).a(com.google.android.libraries.navigation.internal.hw.a.b)).a();
        Context context = bVar2.e;
        com.google.android.libraries.navigation.internal.afo.a aVar = bVar2.c;
        com.google.android.libraries.navigation.internal.afo.a aVar2 = bVar2.d;
        ?? r8 = bVar2.f;
        ai aiVar = (ai) aj.a.q();
        aiVar.c(((com.google.android.libraries.navigation.internal.hm.d) r8).Z().ad());
        x xVarAb = r8.ab();
        if (!aiVar.b.H()) {
            aiVar.v();
        }
        aj ajVar = (aj) aiVar.b;
        xVarAb.getClass();
        ajVar.b |= 4;
        ajVar.e = xVarAb;
        com.google.android.libraries.navigation.internal.fs.b.a();
        ag agVar = (ag) ah.a.q();
        if (!agVar.b.H()) {
            agVar.v();
        }
        ah.g((ah) agVar.b);
        boolean z = com.google.android.libraries.navigation.internal.ir.b.a(context) >= 131072;
        if (!agVar.b.H()) {
            agVar.v();
        }
        ah ahVar = (ah) agVar.b;
        ahVar.b |= 2;
        ahVar.d = z;
        boolean z2 = com.google.android.libraries.navigation.internal.ir.b.a(context) >= 196608;
        if (!agVar.b.H()) {
            agVar.v();
        }
        ah ahVar2 = (ah) agVar.b;
        ahVar2.b |= 4;
        ahVar2.e = z2;
        if (!agVar.b.H()) {
            agVar.v();
        }
        ah.e((ah) agVar.b);
        if (!agVar.b.H()) {
            agVar.v();
        }
        ah ahVar3 = (ah) agVar.b;
        ahVar3.b |= 16;
        ahVar3.g = true;
        String str = true == aq.c(null) ? "" : null;
        if (!agVar.b.H()) {
            agVar.v();
        }
        ah ahVar4 = (ah) agVar.b;
        str.getClass();
        ahVar4.b |= 64;
        ahVar4.i = str;
        if (!agVar.b.H()) {
            agVar.v();
        }
        ah ahVar5 = (ah) agVar.b;
        ahVar5.b |= 256;
        ahVar5.j = false;
        ab abVarA = ((com.google.android.libraries.navigation.internal.iq.a) aVar.a()).a(com.google.android.libraries.navigation.internal.fz.b.b(r8), locale);
        if (!agVar.b.H()) {
            agVar.v();
        }
        ah ahVar6 = (ah) agVar.b;
        abVarA.getClass();
        ahVar6.h = abVarA;
        ahVar6.b |= 32;
        String str2 = Build.DEVICE;
        if (!agVar.b.H()) {
            agVar.v();
        }
        ah ahVar7 = (ah) agVar.b;
        str2.getClass();
        ahVar7.b |= 1024;
        ahVar7.l = str2;
        String str3 = Build.FINGERPRINT;
        if (!agVar.b.H()) {
            agVar.v();
        }
        ah ahVar8 = (ah) agVar.b;
        str3.getClass();
        ahVar8.b |= 2048;
        ahVar8.m = str3;
        String str4 = Build.MANUFACTURER;
        if (!agVar.b.H()) {
            agVar.v();
        }
        ah ahVar9 = (ah) agVar.b;
        str4.getClass();
        ahVar9.b |= 4096;
        ahVar9.f296n = str4;
        String str5 = Build.MODEL;
        if (!agVar.b.H()) {
            agVar.v();
        }
        ah ahVar10 = (ah) agVar.b;
        str5.getClass();
        ahVar10.b |= 8192;
        ahVar10.o = str5;
        ah ahVar11 = (ah) agVar.t();
        if (!aiVar.b.H()) {
            aiVar.v();
        }
        aj ajVar2 = (aj) aiVar.b;
        ahVar11.getClass();
        ajVar2.d = ahVar11;
        ajVar2.b |= 1;
        this.h = ((com.google.android.libraries.navigation.internal.gq.e) bVar2.a.a()).c().a((aj) aiVar.t(), new a(bVar2, mVarA, lVar, locale), bVar2.g);
        ((com.google.android.libraries.navigation.internal.kk.k) ((com.google.android.libraries.navigation.internal.kl.a) this.g.b.a()).a(com.google.android.libraries.navigation.internal.hw.a.r)).a(bVar.d);
    }
}
