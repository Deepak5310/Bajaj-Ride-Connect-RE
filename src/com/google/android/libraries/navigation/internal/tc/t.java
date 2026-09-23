package com.google.android.libraries.navigation.internal.tc;

import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.al;
import com.google.android.libraries.navigation.internal.zr.cw;
import com.google.android.libraries.navigation.internal.zr.cx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class t {
    final cw a = (cw) cx.a.q();

    public final String toString() {
        ak akVarB = al.b(this);
        akVarB.e("ONLINE", ((cx) this.a.b).c);
        akVarB.e("OFFLINE", ((cx) this.a.b).d);
        akVarB.e("REROUTING", ((cx) this.a.b).e);
        return akVarB.toString();
    }
}
