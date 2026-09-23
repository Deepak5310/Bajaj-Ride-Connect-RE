package com.google.android.libraries.navigation.internal.jy;

import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.zp.ca;
import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class z implements Serializable {
    static y g() {
        e eVar = new e();
        eVar.c(ca.VISIBILITY_VISIBLE);
        eVar.b(-1);
        return eVar;
    }

    public abstract int a();

    public abstract com.google.android.libraries.navigation.internal.hc.a b();

    public abstract com.google.android.libraries.navigation.internal.hc.a c();

    public abstract com.google.android.libraries.navigation.internal.hc.a d();

    public abstract com.google.android.libraries.navigation.internal.hc.a e();

    public abstract ca f();

    public final String toString() {
        ak akVar = new ak("ImpressionParams");
        akVar.h();
        akVar.g("visibility", f().name());
        ak akVarC = akVar.c("elementIndex", a());
        akVarC.g("geoUgcData", b());
        akVarC.g("mapsData", c());
        akVarC.g("tronData", e());
        akVarC.g("mapsImpressionData", d());
        return akVarC.toString();
    }
}
