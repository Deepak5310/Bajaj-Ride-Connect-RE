package com.google.android.libraries.navigation.internal.px;

import com.google.android.libraries.navigation.internal.adg.fs;
import com.google.android.libraries.navigation.internal.yz.ev;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class x extends b {
    private volatile transient fs l;
    private volatile transient int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private volatile transient boolean f545n;
    private volatile transient int o;
    private volatile transient boolean p;

    public x(com.google.android.libraries.navigation.internal.adg.ef efVar, com.google.android.libraries.navigation.internal.adg.ef efVar2, int i, long j, com.google.android.libraries.navigation.internal.oe.j jVar, String str, ej ejVar, boolean z, ev evVar, String str2, cg cgVar, float f, float f2, com.google.android.libraries.navigation.internal.adl.w wVar, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, com.google.android.libraries.navigation.internal.adq.ah ahVar, com.google.android.libraries.geo.mapcore.internal.model.v vVar, int i2, com.google.android.libraries.navigation.internal.adg.es esVar, boolean z16, boolean z17, boolean z18, com.google.android.libraries.navigation.internal.ado.j jVar2, boolean z19, boolean z20, boolean z21, boolean z22, com.google.android.libraries.navigation.internal.adl.as asVar, boolean z23, com.google.android.libraries.geo.mapcore.internal.model.av avVar, com.google.android.libraries.navigation.internal.or.c cVar) {
        super(efVar, efVar2, i, j, jVar, str, ejVar, z, evVar, str2, cgVar, f, f2, wVar, z2, z3, z4, z5, z6, z7, z8, z9, z10, z11, z12, z13, z14, z15, ahVar, vVar, i2, esVar, z16, z17, z18, jVar2, z19, z20, z21, z22, asVar, z23, avVar, cVar);
    }

    @Override // com.google.android.libraries.navigation.internal.px.ep, com.google.android.libraries.navigation.internal.px.ek
    public final int T() {
        if (!this.f545n) {
            synchronized (this) {
                if (!this.f545n) {
                    this.m = super.T();
                    this.f545n = true;
                }
            }
        }
        return this.m;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ep, com.google.android.libraries.navigation.internal.px.ek
    public final int U() {
        if (!this.p) {
            synchronized (this) {
                if (!this.p) {
                    this.o = super.U();
                    this.p = true;
                }
            }
        }
        return this.o;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ep, com.google.android.libraries.navigation.internal.px.ek
    public final fs V() {
        if (this.l == null) {
            synchronized (this) {
                if (this.l == null) {
                    this.l = super.V();
                    if (this.l == null) {
                        throw new NullPointerException("mapsMetadataContainer() cannot return null");
                    }
                }
            }
        }
        return this.l;
    }
}
