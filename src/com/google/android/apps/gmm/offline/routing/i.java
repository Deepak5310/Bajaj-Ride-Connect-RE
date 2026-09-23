package com.google.android.apps.gmm.offline.routing;

import com.google.android.libraries.navigation.internal.adr.at;
import com.google.android.libraries.navigation.internal.afl.lb;
import com.google.android.libraries.navigation.internal.afl.lh;
import com.google.android.libraries.navigation.internal.afl.lk;
import com.google.android.libraries.navigation.internal.afl.ll;
import com.google.android.libraries.navigation.internal.afl.mc;
import com.google.android.libraries.navigation.internal.afl.me;
import com.google.android.libraries.navigation.internal.afl.mf;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
class i {
    public static final byte[] a;
    private static final com.google.android.libraries.navigation.internal.zb.j b = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.apps.gmm.offline.routing.i");

    static {
        mc mcVar = (mc) mf.a.q();
        int i = me.c;
        if (!mcVar.b.H()) {
            mcVar.v();
        }
        mf mfVar = (mf) mcVar.b;
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        mfVar.e = i2;
        mfVar.b |= 2;
        lk lkVar = (lk) ll.a.q();
        lb lbVar = (lb) lh.a.q();
        at atVar = at.NO_ROUTES_FOUND;
        if (!lbVar.b.H()) {
            lbVar.v();
        }
        lh lhVar = (lh) lbVar.b;
        lhVar.g = atVar.i;
        lhVar.b |= 8;
        if (!lkVar.b.H()) {
            lkVar.v();
        }
        ll llVar = (ll) lkVar.b;
        lh lhVar2 = (lh) lbVar.t();
        lhVar2.getClass();
        llVar.c = lhVar2;
        llVar.b |= 1;
        if (!mcVar.b.H()) {
            mcVar.v();
        }
        mf mfVar2 = (mf) mcVar.b;
        ll llVar2 = (ll) lkVar.t();
        llVar2.getClass();
        mfVar2.c = llVar2;
        mfVar2.b |= 1;
        a = ((mf) mcVar.t()).m();
    }

    static void a(com.google.android.apps.gmm.jni.util.c cVar) {
        if (cVar == null) {
            return;
        }
        if (cVar.a.equals(com.google.android.libraries.navigation.internal.aei.a.RESOURCE_EXHAUSTED)) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 442)).p("OfflineRoutingHelpers");
        } else {
            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) b.d(com.google.android.libraries.navigation.internal.nl.a.a).g(cVar)).F((char) 441)).o();
        }
    }
}
