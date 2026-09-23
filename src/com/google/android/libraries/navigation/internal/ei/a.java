package com.google.android.libraries.navigation.internal.ei;

import com.google.android.libraries.navigation.internal.adu.m;
import com.google.android.libraries.navigation.internal.ee.t;
import com.google.android.libraries.navigation.internal.vz.i;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.fo;
import com.google.android.libraries.navigation.internal.yz.fs;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    private final fs a;
    private final i b;

    public a(i iVar) {
        this.b = iVar;
        fo foVar = new fo();
        for (t tVar : t.values()) {
            m mVar = tVar.aw;
            Integer numValueOf = mVar == null ? null : Integer.valueOf(mVar.eU);
            if (numValueOf != null) {
                foVar.f(numValueOf, Integer.valueOf(tVar.av));
            }
        }
        this.a = foVar.d();
    }

    public static final boolean c(int i) {
        return c.a.contains(Integer.valueOf(i));
    }

    public static final boolean d(int i) {
        return e.a.contains(Integer.valueOf(i));
    }

    public static final boolean e(int i) {
        return !d.a.contains(Integer.valueOf(i));
    }

    public final fd a() {
        return this.b.a();
    }

    public final fs b() {
        return this.a;
    }
}
