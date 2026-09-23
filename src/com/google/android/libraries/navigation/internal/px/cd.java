package com.google.android.libraries.navigation.internal.px;

import android.util.SparseArray;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class cd {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.px.cd");
    private final com.google.android.libraries.geo.mapcore.renderer.ax i;
    private final com.google.android.libraries.navigation.internal.agl.a j;
    private final SparseArray b = new SparseArray();
    private final Map c = new HashMap();
    private boolean g = false;
    private final Map h = new WeakHashMap();
    private final Set d = new HashSet();
    private final Set e = new HashSet();
    private final Set f = new HashSet();

    public cd(com.google.android.libraries.geo.mapcore.renderer.ax axVar, com.google.android.libraries.navigation.internal.agl.a aVar) {
        this.i = axVar;
        this.j = aVar;
    }

    private final com.google.android.libraries.navigation.internal.ol.aa e(ai aiVar) {
        com.google.android.libraries.navigation.internal.ol.aa aaVarE = aiVar.e();
        if (aaVarE == null) {
            ek ekVarA = aiVar.A();
            b bVar = (b) ekVarA;
            WeakReference weakReference = (WeakReference) this.h.get(bVar.a);
            aaVarE = weakReference == null ? null : (cb) weakReference.get();
            if (aaVarE == null) {
                aaVarE = new cb(ekVarA);
                this.h.put(bVar.a, new WeakReference(aaVarE));
            }
        }
        if (!(aaVarE instanceof com.google.android.libraries.navigation.internal.pp.f)) {
            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).g(new IllegalStateException(String.format("%s implements %s but not %s.", aaVarE.getClass().getName(), com.google.android.libraries.navigation.internal.ol.o.class.getName(), com.google.android.libraries.navigation.internal.pp.a.class.getName())))).F((char) 940)).o();
        }
        return aaVarE;
    }

    public final synchronized void a(ai aiVar, com.google.android.libraries.navigation.internal.yx.an anVar) {
        if (this.g) {
            return;
        }
        aiVar.C(32);
        int iA = aiVar.B().a();
        cc ccVar = (cc) this.b.get(iA);
        if (ccVar == null) {
            cc ccVar2 = new cc(aiVar.B(), !((com.google.android.libraries.navigation.internal.om.n) this.j.a()).i());
            this.b.put(iA, ccVar2);
            ccVar = ccVar2;
        }
        com.google.android.libraries.navigation.internal.qq.ap apVar = (com.google.android.libraries.navigation.internal.qq.ap) ccVar.c();
        apVar.l(aiVar);
        this.c.put(aiVar, apVar);
        com.google.android.libraries.navigation.internal.ol.aa aaVarE = e(aiVar);
        if (aaVarE instanceof com.google.android.libraries.navigation.internal.pp.f) {
            ((com.google.android.libraries.navigation.internal.pp.f) aaVarE).H((dj) anVar.f());
        }
        this.i.d(apVar, aaVarE);
    }

    public final synchronized void b() {
        Iterator it2 = com.google.android.libraries.navigation.internal.yz.de.b(this.d, this.e, this.f, this.c.keySet()).iterator();
        while (it2.hasNext()) {
            ((ai) it2.next()).D(32);
        }
        Iterator it3 = this.c.values().iterator();
        while (it3.hasNext()) {
            this.i.m((com.google.android.libraries.geo.mapcore.renderer.aj) it3.next());
        }
        this.c.clear();
        this.d.clear();
        this.e.clear();
        this.f.clear();
        for (int i = 0; i < this.b.size(); i++) {
            ((cc) this.b.valueAt(i)).e();
        }
        this.b.clear();
        this.g = true;
    }

    public final synchronized void c(ai aiVar) {
        if (this.g) {
            return;
        }
        com.google.android.libraries.navigation.internal.qq.ap apVar = (com.google.android.libraries.navigation.internal.qq.ap) this.c.remove(aiVar);
        if (apVar != null) {
            this.i.m(apVar);
            apVar.k();
            cc ccVar = (cc) this.b.get(aiVar.B().a());
            if (ccVar != null) {
                ccVar.g(apVar);
            }
        }
        aiVar.D(32);
    }

    final synchronized void d(ai aiVar, com.google.android.libraries.navigation.internal.yx.an anVar) {
        com.google.android.libraries.navigation.internal.ol.aa aaVarE = e(aiVar);
        if (aaVarE instanceof com.google.android.libraries.navigation.internal.pp.f) {
            ((com.google.android.libraries.navigation.internal.pp.f) aaVarE).H((dj) anVar.f());
        }
    }
}
