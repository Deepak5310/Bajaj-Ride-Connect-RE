package com.google.android.libraries.navigation.internal.afz;

import com.google.android.libraries.navigation.internal.afx.aj;
import com.google.android.libraries.navigation.internal.afx.cd;
import com.google.android.libraries.navigation.internal.afx.ce;
import com.google.android.libraries.navigation.internal.afx.cl;
import com.google.android.libraries.navigation.internal.aga.at;
import com.google.android.libraries.navigation.internal.aga.az;
import com.google.android.libraries.navigation.internal.aga.dd;
import com.google.android.libraries.navigation.internal.aga.ev;
import com.google.android.libraries.navigation.internal.aga.u;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.places.api.model.PlaceTypes;
import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class g implements u {
    public dd a;
    public com.google.android.libraries.navigation.internal.afx.c b;
    private final aj c;
    private final InetSocketAddress d;
    private final Object e = new Object();
    private final Set f = Collections.newSetFromMap(new IdentityHashMap());
    private boolean g;
    private boolean h;
    private boolean i;

    public g(InetSocketAddress inetSocketAddress, com.google.android.libraries.navigation.internal.afx.c cVar, Executor executor, ev evVar) {
        ar.r(inetSocketAddress, PlaceTypes.ADDRESS);
        this.d = inetSocketAddress;
        this.c = aj.a(getClass(), inetSocketAddress.toString());
        cd cdVar = az.a;
        ar.r(executor, "executor");
        ar.r(evVar, "transportTracer");
        com.google.android.libraries.navigation.internal.afx.c cVar2 = com.google.android.libraries.navigation.internal.afx.c.a;
        com.google.android.libraries.navigation.internal.afx.a aVar = new com.google.android.libraries.navigation.internal.afx.a(com.google.android.libraries.navigation.internal.afx.c.a);
        aVar.b(at.a, ce.PRIVACY_AND_INTEGRITY);
        aVar.b(at.b, cVar);
        this.b = aVar.a();
    }

    @Override // com.google.android.libraries.navigation.internal.aga.de
    public final Runnable a(dd ddVar) {
        this.a = ddVar;
        synchronized (this.e) {
        }
        return new f(this);
    }

    @Override // com.google.android.libraries.navigation.internal.afx.al
    public final aj b() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.aga.de
    public final void c(cl clVar) {
        synchronized (this.e) {
            if (this.g) {
                return;
            }
            synchronized (this.e) {
                if (this.h) {
                    return;
                }
                this.h = true;
                this.a.d(clVar);
                synchronized (this.e) {
                    this.g = true;
                }
                synchronized (this.e) {
                    if (this.g && !this.i && this.f.isEmpty()) {
                        this.i = true;
                        this.a.e();
                    }
                }
            }
        }
    }

    public final String toString() {
        InetSocketAddress inetSocketAddress = this.d;
        return super.toString() + "(" + String.valueOf(inetSocketAddress) + ")";
    }
}
