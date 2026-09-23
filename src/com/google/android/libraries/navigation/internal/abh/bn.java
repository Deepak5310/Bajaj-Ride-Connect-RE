package com.google.android.libraries.navigation.internal.abh;

import com.google.android.gms.maps.model.FeatureLayerOptions;
import com.google.android.gms.maps.model.FeatureType;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bn extends com.google.android.libraries.navigation.internal.lz.e {
    final Map a;
    final Set b;
    final String c;
    private final com.google.android.libraries.navigation.internal.abf.z d = com.google.android.libraries.navigation.internal.abf.z.a;
    private final String e;
    private final String f;
    private final dw g;
    private com.google.android.libraries.navigation.internal.lz.x h;
    private final ed i;
    private final ht j;
    private final boolean k;

    public bn(FeatureLayerOptions featureLayerOptions, dw dwVar, Map map, ed edVar, ht htVar) {
        String featureType = featureLayerOptions.getFeatureType();
        this.e = featureType;
        String datasetId = featureLayerOptions.getDatasetId();
        this.f = datasetId;
        this.g = dwVar;
        this.a = map;
        this.i = edVar;
        this.b = new HashSet();
        this.j = htVar;
        boolean z = true;
        if (!dwVar.f(featureType) && !dwVar.e(datasetId)) {
            z = false;
        }
        this.k = z;
        this.c = featureType.equals(FeatureType.DATASET) ? datasetId : featureType;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.f
    public final String a() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.f
    public final String b() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.f
    public final void c(com.google.android.libraries.navigation.internal.lz.r rVar) {
        try {
            this.d.a();
            this.b.add(rVar);
            this.i.F(this.c, this.b);
            this.g.d(this.e, this.f, "FeatureLayer");
            this.j.c(com.google.android.libraries.navigation.internal.abx.b.FEATURE_LAYER_ADD_CLICK_LISTENER);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lz.f
    public final void d(com.google.android.libraries.navigation.internal.lz.r rVar) {
        try {
            this.d.a();
            this.b.remove(rVar);
            this.i.F(this.c, this.b);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lz.f
    public final void e(com.google.android.libraries.navigation.internal.lz.x xVar) {
        int i;
        this.d.a();
        this.h = xVar;
        if (!this.k) {
            this.g.d(this.e, this.f, "FeatureLayer");
            xVar = null;
        }
        String str = this.e;
        if (str.equals(FeatureType.DATASET)) {
            str = this.f;
        }
        if (xVar != this.a.get(str)) {
            if (xVar != null) {
                this.a.put(str, xVar);
            } else {
                this.a.remove(str);
            }
            com.google.android.libraries.navigation.internal.yz.fd.j(this.a);
            this.i.T(new bj());
        }
        if (this.e.equals(FeatureType.DATASET)) {
            i = 19;
        } else {
            if (bm.a.containsKey(this.e)) {
                i = ((com.google.android.libraries.navigation.internal.ace.fp) bm.a.get(this.e)).u;
            } else {
                i = 0;
            }
        }
        ht htVar = this.j;
        com.google.android.libraries.navigation.internal.zp.an anVar = (com.google.android.libraries.navigation.internal.zp.an) com.google.android.libraries.navigation.internal.zp.ao.a.q();
        com.google.android.libraries.navigation.internal.zp.ad adVar = (com.google.android.libraries.navigation.internal.zp.ad) com.google.android.libraries.navigation.internal.zp.ae.a.q();
        if (!adVar.b.H()) {
            adVar.v();
        }
        com.google.android.libraries.navigation.internal.zp.ae aeVar = (com.google.android.libraries.navigation.internal.zp.ae) adVar.b;
        aeVar.b |= 1;
        aeVar.c = i;
        if (!anVar.b.H()) {
            anVar.v();
        }
        com.google.android.libraries.navigation.internal.zp.ao aoVar = (com.google.android.libraries.navigation.internal.zp.ao) anVar.b;
        com.google.android.libraries.navigation.internal.zp.ae aeVar2 = (com.google.android.libraries.navigation.internal.zp.ae) adVar.t();
        aeVar2.getClass();
        aoVar.c = aeVar2;
        aoVar.b = 2;
        htVar.d();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.f
    public final boolean f() {
        this.d.a();
        return this.k;
    }
}
