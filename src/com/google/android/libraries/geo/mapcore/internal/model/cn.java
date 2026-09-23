package com.google.android.libraries.geo.mapcore.internal.model;

import com.google.android.libraries.navigation.internal.adg.eh;
import com.google.android.libraries.navigation.internal.adg.jn;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.yz.ma;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class cn {
    public ev a;
    public List b;
    public eh c;
    byte[] d;
    public jn e;
    public List f;
    public ev g;
    public com.google.android.libraries.navigation.internal.adg.bu[] h;
    public byte[] i;
    public int j;
    public com.google.android.libraries.navigation.internal.oe.as k;
    public fd l;
    private final ce m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final com.google.android.libraries.navigation.internal.dm.s f64n;
    private ev o;
    private int p;
    private com.google.android.libraries.navigation.internal.adi.an q;

    public cn(com.google.android.libraries.navigation.internal.dm.s sVar, com.google.android.libraries.navigation.internal.adi.an anVar, ce ceVar) {
        int i = ev.d;
        this.a = lv.a;
        this.o = lv.a;
        this.p = -1;
        this.c = eh.a;
        this.d = null;
        this.q = com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_BASE;
        this.g = lv.a;
        this.i = bv.d;
        this.j = 0;
        this.k = com.google.android.libraries.navigation.internal.oe.as.UNKNOWN;
        this.l = ma.b;
        this.f64n = sVar;
        this.q = anVar;
        this.m = ceVar;
    }

    public final cq a() {
        ev evVarO;
        com.google.android.libraries.navigation.internal.yx.ca.a(this.q != null);
        com.google.android.libraries.navigation.internal.adi.an anVar = this.q;
        ev evVar = this.a;
        ev evVar2 = this.o;
        int i = this.p;
        List arrayList = this.b;
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        List list = arrayList;
        eh ehVar = this.c;
        jn jnVar = this.e;
        List list2 = this.f;
        if (list2 == null) {
            int i2 = ev.d;
            evVarO = lv.a;
        } else {
            evVarO = ev.o(list2);
        }
        ev evVar3 = evVarO;
        ev evVar4 = this.g;
        com.google.android.libraries.navigation.internal.adg.bu[] buVarArr = this.h;
        return new cq(this.m, this.f64n, anVar, evVar, evVar2, i, list, ehVar, null, jnVar, evVar3, evVar4, buVarArr == null ? new com.google.android.libraries.navigation.internal.adg.bu[0] : buVarArr, this.i, this.j, this.k, this.l);
    }

    public cn(cq cqVar, com.google.android.libraries.navigation.internal.dm.s sVar, com.google.android.libraries.navigation.internal.adi.an anVar, cd cdVar) {
        int i = ev.d;
        this.a = lv.a;
        this.o = lv.a;
        this.p = -1;
        this.c = eh.a;
        this.d = null;
        this.q = com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_BASE;
        this.g = lv.a;
        this.i = bv.d;
        this.j = 0;
        this.k = com.google.android.libraries.navigation.internal.oe.as.UNKNOWN;
        this.l = ma.b;
        ce ceVar = cqVar.b;
        this.m = new ce(cdVar, ceVar.b, ceVar.c, ceVar.e, ceVar.f);
        this.f64n = sVar;
        this.q = anVar;
        this.a = cqVar.c;
        this.o = cqVar.d;
        this.p = cqVar.e;
        this.b = cqVar.f;
        this.f = cqVar.j;
        this.g = cqVar.k;
        this.i = cqVar.r;
        boolean z = cqVar.p;
        this.j = cqVar.q;
        byte[] bArr = cqVar.o;
        this.c = cqVar.g;
        byte[] bArr2 = cqVar.h;
        this.d = null;
        this.e = cqVar.i;
        this.k = cqVar.f65n;
    }
}
