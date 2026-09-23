package com.google.android.libraries.navigation.internal.qp;

import com.google.android.libraries.geo.mapcore.internal.model.cd;
import com.google.android.libraries.navigation.internal.adi.an;
import com.google.android.libraries.navigation.internal.yx.ao;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class aa {
    public abstract com.google.android.libraries.navigation.internal.gd.h a();

    public abstract com.google.android.libraries.navigation.internal.gp.b b();

    public abstract cd c();

    public abstract p d();

    public abstract an e();

    public abstract String f();

    public abstract boolean g();

    public final ao h() {
        return new ao(e(), c());
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.gd.h hVarA = a();
        com.google.android.libraries.navigation.internal.yx.ak akVarA = com.google.android.libraries.navigation.internal.yx.al.a(aa.class);
        akVarA.g("paintTileType", e().name());
        akVarA.g("coords", c());
        akVarA.g("versionId", f());
        com.google.android.libraries.navigation.internal.yx.ak akVarE = akVarA.e("enableUnchangedEpochDetection", g());
        akVarE.g("networkTileCallback", d());
        akVarE.g("requestPriority", hVarA.name());
        return akVarE.toString();
    }
}
