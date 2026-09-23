package com.google.android.libraries.navigation.internal.wd;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.SystemClock;
import com.google.android.libraries.navigation.internal.acd.ml;
import com.google.android.libraries.navigation.internal.acd.v;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.yz.gs;
import com.google.android.libraries.navigation.internal.zp.ao;
import com.google.android.libraries.navigation.internal.zp.ar;
import com.google.android.libraries.navigation.internal.zp.ay;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements f {
    int a;
    final /* synthetic */ e b;
    private final com.google.android.libraries.navigation.internal.abx.b c;
    private final String d;
    private final long e = SystemClock.elapsedRealtime();
    private final List f = new ArrayList();

    public d(e eVar, com.google.android.libraries.navigation.internal.abx.b bVar, String str) {
        this.b = eVar;
        this.c = bVar;
        this.d = str;
    }

    @Override // com.google.android.libraries.navigation.internal.wd.f
    public final com.google.android.libraries.navigation.internal.abx.b a() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.wd.f
    public final void b(int i) {
        if (this.b.l(this)) {
            int iElapsedRealtime = (int) (SystemClock.elapsedRealtime() - this.e);
            this.a = iElapsedRealtime;
            ar arVarG = this.b.g(this.c, iElapsedRealtime, i);
            String str = this.d;
            if (str != null) {
                if (!arVarG.b.H()) {
                    arVarG.v();
                }
                ay ayVar = (ay) arVarG.b;
                ay ayVar2 = ay.a;
                ayVar.b |= 4194304;
                ayVar.t = str;
            }
            for (ao aoVar : this.f) {
                if (!arVarG.b.H()) {
                    arVarG.v();
                }
                ay ayVar3 = (ay) arVarG.b;
                ay ayVar4 = ay.a;
                aoVar.getClass();
                bz bzVar = ayVar3.v;
                if (!bzVar.c()) {
                    ayVar3.v = bi.A(bzVar);
                }
                ayVar3.v.add(aoVar);
            }
            c(arVarG);
            this.b.i((ay) arVarG.t());
            int i2 = ((ay) arVarG.b).r;
            int i3 = ((ay) arVarG.b).s;
            this.b.k(this);
        }
    }

    public final void c(ar arVar) {
        e eVar = this.b;
        long j = eVar.b;
        if (j == 0 || j > this.e || eVar.c.isEmpty()) {
            int i = ml.b;
            if (!arVar.b.H()) {
                arVar.v();
            }
            ay ayVar = (ay) arVar.b;
            ay ayVar2 = ay.a;
            int i2 = i - 1;
            if (i == 0) {
                throw null;
            }
            ayVar.r = i2;
            ayVar.b |= 524288;
            return;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) this.b.a.getSystemService("connectivity");
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities((Network) gs.d(this.b.c));
        if (networkCapabilities == null) {
            return;
        }
        if (networkCapabilities.hasTransport(1)) {
            int i3 = ml.c;
            if (!arVar.b.H()) {
                arVar.v();
            }
            ay ayVar3 = (ay) arVar.b;
            ay ayVar4 = ay.a;
            int i4 = i3 - 1;
            if (i3 == 0) {
                throw null;
            }
            ayVar3.r = i4;
            ayVar3.b |= 524288;
            return;
        }
        if (networkCapabilities.hasTransport(0)) {
            int i5 = ml.d;
            if (!arVar.b.H()) {
                arVar.v();
            }
            ay ayVar5 = (ay) arVar.b;
            ay ayVar6 = ay.a;
            int i6 = i5 - 1;
            if (i5 == 0) {
                throw null;
            }
            ayVar5.r = i6;
            ayVar5.b |= 524288;
            int subtype = connectivityManager.getNetworkInfo((Network) gs.d(this.b.c)).getSubtype();
            e eVar2 = this.b;
            Integer numValueOf = Integer.valueOf(subtype);
            if (eVar2.e.containsKey(numValueOf)) {
                v vVar = (v) this.b.e.get(numValueOf);
                if (!arVar.b.H()) {
                    arVar.v();
                }
                ay ayVar7 = (ay) arVar.b;
                ayVar7.s = vVar.s;
                ayVar7.b |= 1048576;
            }
        }
    }
}
