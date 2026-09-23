package com.google.android.libraries.navigation.internal.ke;

import com.google.android.libraries.navigation.internal.jy.v;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.zp.bk;
import com.google.android.libraries.navigation.internal.zp.cf;
import com.google.android.libraries.navigation.internal.zt.ap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class q {
    public v a;
    public ap b;
    public String c;
    public String d;
    public cf e;
    public com.google.android.libraries.navigation.internal.zy.n f;
    public com.google.android.libraries.navigation.internal.jy.j h;
    private bk i;
    public boolean g = false;
    private final com.google.android.libraries.navigation.internal.kd.f j = new com.google.android.libraries.navigation.internal.kd.f();

    public final r a() {
        v vVar = this.a;
        ar.q(vVar);
        com.google.android.libraries.navigation.internal.jy.j jVar = this.h;
        ar.q(jVar);
        return new r(vVar, jVar, this.b, this.c, this.d, this.e, null, false, this.i, this.j);
    }

    public final synchronized void b(bk bkVar) {
        this.i = bkVar;
    }
}
