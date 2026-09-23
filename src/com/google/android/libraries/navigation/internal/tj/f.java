package com.google.android.libraries.navigation.internal.tj;

import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.al;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class f {
    public final com.google.android.libraries.navigation.internal.db.r a;
    public final String b;
    public final boolean c;
    public final boolean d;

    public f(e eVar) {
        this.a = eVar.a;
        this.b = eVar.b;
        this.c = eVar.c;
        this.d = eVar.d;
    }

    final ak a() {
        ak akVarB = al.b(this);
        akVarB.g("myLocation", this.a);
        akVarB.g("currentRoadName", this.b);
        return akVarB.e("dataConnectionReady", this.c).e("gpsReady", this.d);
    }

    public String toString() {
        return a().toString();
    }
}
