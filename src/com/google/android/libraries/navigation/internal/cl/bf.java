package com.google.android.libraries.navigation.internal.cl;

import com.google.android.libraries.navigation.internal.adr.cf;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class bf {
    public abstract bg a();

    public abstract void b(cf cfVar);

    public final bg c() {
        bg bgVarA = a();
        n nVar = (n) bgVarA;
        com.google.android.libraries.navigation.internal.ol.aq aqVar = nVar.a;
        com.google.android.libraries.navigation.internal.oo.f fVar = nVar.b;
        boolean z = true;
        if (aqVar != null && fVar != null) {
            z = false;
        }
        com.google.android.libraries.navigation.internal.yx.ar.l(z, "You cannot set V2 MapStyle properties when V3 Style properties are set.");
        return bgVarA;
    }
}
