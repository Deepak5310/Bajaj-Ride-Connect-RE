package com.google.android.libraries.navigation.internal.jy;

import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bq;
import com.google.android.libraries.navigation.internal.zp.cc;
import com.google.android.libraries.navigation.internal.zp.cd;
import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class l implements Serializable {
    protected l() {
    }

    public abstract int a();

    public final cd b() {
        cc ccVar = (cc) cd.a.q();
        int iA = a();
        if (!ccVar.b.H()) {
            ccVar.v();
        }
        cd cdVar = (cd) ccVar.b;
        bq bqVar = cdVar.b;
        if (!bqVar.c()) {
            cdVar.b = bi.w(bqVar);
        }
        cdVar.b.i(iA);
        return (cd) ccVar.t();
    }
}
