package com.google.android.libraries.navigation.internal.bs;

import com.google.android.libraries.navigation.internal.adr.bm;
import com.google.android.libraries.navigation.internal.adr.ka;
import com.google.android.libraries.navigation.internal.adu.s;
import com.google.android.libraries.navigation.internal.aes.h;
import com.google.android.libraries.navigation.internal.afl.bz;
import com.google.android.libraries.navigation.internal.afl.lr;
import com.google.android.libraries.navigation.internal.bp.ck;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public com.google.android.libraries.navigation.internal.acc.b d;
    public h e;
    public bm.a f;
    public boolean g;
    public s i;
    public lr a = lr.a;
    private final List j = new ArrayList();
    public final List b = new ArrayList();
    private final HashMap k = new HashMap();
    public com.google.android.libraries.navigation.internal.ady.h c = com.google.android.libraries.navigation.internal.ady.h.a;
    private final bz l = bz.a;
    private final Long m = null;
    public boolean h = false;

    public final void b(ck ckVar) {
        this.j.add(ckVar);
    }

    public final b a() {
        lr lrVar = this.a;
        if (lrVar.d != 64) {
            ka kaVar = lrVar.f;
            if (kaVar == null) {
                kaVar = ka.a;
            }
            if ((kaVar.b & 1) == 0) {
                throw new UnsupportedOperationException("Travel mode must be set");
            }
            ka kaVar2 = this.a.f;
            if (kaVar2 == null) {
                kaVar2 = ka.a;
            }
            if ((kaVar2.b & 2) == 0) {
                throw new UnsupportedOperationException("Travel mode Filtering must be set");
            }
        }
        lr lrVar2 = this.a;
        List list = this.j;
        List list2 = this.b;
        return new b(lrVar2, ev.o(list), ev.o(list2), this.l, this.c, this.d, this.e, this.f, this.g, null, this.h, false, null, this.k);
    }
}
