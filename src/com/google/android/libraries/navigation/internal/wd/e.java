package com.google.android.libraries.navigation.internal.wd;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import com.google.android.libraries.navigation.internal.acd.v;
import com.google.android.libraries.navigation.internal.ky.o;
import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.zb.j;
import com.google.android.libraries.navigation.internal.zp.ar;
import com.google.android.libraries.navigation.internal.zp.ay;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class e implements g {
    private static final j f = j.e("com.google.android.libraries.navigation.internal.wd.e");
    private static final NetworkRequest g = new NetworkRequest.Builder().addCapability(12).build();
    public final Context a;
    public long b;
    Object d;
    public final fd e;
    private final o h;
    private final String i;
    private final String j;
    private final int l;
    private final Set k = new HashSet();
    final List c = new ArrayList();

    public e(Context context, int i, String str, o oVar) {
        ez ezVar = new ez();
        ezVar.f(2, v.EDGE);
        ezVar.f(4, v.CDMA);
        ezVar.f(11, v.IDEN);
        ezVar.f(8, v.HSDPA);
        ezVar.f(9, v.HSUPA);
        ezVar.f(10, v.HSPA);
        ezVar.f(15, v.HSPAP);
        ezVar.f(14, v.EHRPD);
        ezVar.f(13, v.LTE);
        this.e = ezVar.d();
        this.j = context.getPackageName();
        this.i = str;
        this.l = i;
        this.a = context.getApplicationContext();
        this.h = oVar;
        j();
    }

    @Override // com.google.android.libraries.navigation.internal.wd.g
    public final synchronized f a(com.google.android.libraries.navigation.internal.abx.b bVar) {
        return b(bVar, null);
    }

    @Override // com.google.android.libraries.navigation.internal.wd.g
    public final synchronized f b(com.google.android.libraries.navigation.internal.abx.b bVar, String str) {
        d dVar;
        dVar = new d(this, bVar, str);
        this.k.add(dVar);
        return dVar;
    }

    @Override // com.google.android.libraries.navigation.internal.wd.g
    public final synchronized void c(com.google.android.libraries.navigation.internal.abx.b bVar) {
        Iterator it2 = this.k.iterator();
        while (it2.hasNext()) {
            if (((f) it2.next()).a() == bVar) {
                it2.remove();
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.wd.g
    public final synchronized void d() {
        if (this.d != null) {
            ((ConnectivityManager) this.a.getSystemService("connectivity")).unregisterNetworkCallback((ConnectivityManager.NetworkCallback) this.d);
            this.d = null;
            this.c.clear();
            this.b = 0L;
        }
        ArrayList arrayList = new ArrayList(this.k);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((f) arrayList.get(i)).b(100);
        }
        this.k.clear();
    }

    @Override // com.google.android.libraries.navigation.internal.wd.g
    public final void e() {
        j();
    }

    @Override // com.google.android.libraries.navigation.internal.wd.g
    public final void f(com.google.android.libraries.navigation.internal.abx.b bVar, int i) {
        i((ay) g(bVar, i, 0).t());
    }

    public ar g(com.google.android.libraries.navigation.internal.abx.b bVar, int i, int i2) {
        ar arVar = (ar) ay.a.q();
        if (!arVar.b.H()) {
            arVar.v();
        }
        String str = this.j;
        ay ayVar = (ay) arVar.b;
        str.getClass();
        ayVar.b |= 8;
        ayVar.f = str;
        String str2 = this.i;
        if (!arVar.b.H()) {
            arVar.v();
        }
        ay ayVar2 = (ay) arVar.b;
        ayVar2.b |= 2;
        ayVar2.d = str2;
        int i3 = this.l;
        if (!arVar.b.H()) {
            arVar.v();
        }
        ay ayVar3 = (ay) arVar.b;
        int i4 = i3 - 1;
        if (i3 == 0) {
            throw null;
        }
        ayVar3.q = i4;
        ayVar3.b |= 262144;
        if (!arVar.b.H()) {
            arVar.v();
        }
        ay ayVar4 = (ay) arVar.b;
        ayVar4.b |= 131072;
        ayVar4.p = 0;
        if (!arVar.b.H()) {
            arVar.v();
        }
        ay ayVar5 = (ay) arVar.b;
        ayVar5.b |= 32768;
        ayVar5.f664n = i;
        if (!arVar.b.H()) {
            arVar.v();
        }
        ay ayVar6 = (ay) arVar.b;
        ayVar6.b |= 65536;
        ayVar6.o = i2;
        if (!arVar.b.H()) {
            arVar.v();
        }
        ay ayVar7 = (ay) arVar.b;
        ayVar7.m = bVar.fX;
        ayVar7.b |= 8192;
        return arVar;
    }

    public final synchronized void h(f fVar) {
        this.k.add(fVar);
    }

    public void i(ay ayVar) {
        this.h.f(ayVar).c();
    }

    public final synchronized void j() {
        if (this.d == null) {
            this.d = new c(this);
            ((ConnectivityManager) this.a.getSystemService("connectivity")).registerNetworkCallback(g, (ConnectivityManager.NetworkCallback) this.d);
        }
    }

    public final synchronized void k(f fVar) {
        this.k.remove(fVar);
    }

    public final synchronized boolean l(f fVar) {
        return this.k.contains(fVar);
    }
}
