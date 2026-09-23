package com.google.android.libraries.geo.mapcore.internal.model;

import com.google.android.libraries.navigation.internal.adg.ds;
import com.google.android.libraries.navigation.internal.adg.ee;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public abstract class aj {
    public abstract ds a();

    public abstract ee b();

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVar = new com.google.android.libraries.navigation.internal.yx.ak("");
        akVar.g("tiePoint", b().name());
        akVar.g("justification", a().name());
        return akVar.toString();
    }
}
