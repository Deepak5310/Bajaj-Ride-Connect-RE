package com.google.android.libraries.navigation.internal.uc;

import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class j {
    public g a;
    public Float b;
    public Float c;
    public boolean d;
    public com.google.android.libraries.navigation.internal.ue.b e;

    public j() {
        this.a = g.FOLLOWING;
    }

    public j(k kVar) {
        this.a = g.FOLLOWING;
        ar.q(kVar);
        this.a = kVar.a;
        this.b = kVar.b;
        this.c = kVar.c;
        this.d = kVar.d;
        this.e = kVar.e;
    }

    public k a() {
        b();
        return new k(this);
    }

    protected void b() {
    }

    public final void c() {
        this.c = null;
    }

    public final void d() {
        this.b = null;
    }
}
