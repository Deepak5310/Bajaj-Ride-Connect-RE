package com.google.android.libraries.geo.mapcore.internal.legacy.internal.vector.gl;

import com.google.android.libraries.geo.mapcore.internal.model.ai;
import com.google.android.libraries.geo.mapcore.internal.model.bs;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
abstract class n {
    public abstract bs[] a(ai aiVar);

    final int b(ai aiVar) {
        return a(aiVar).length;
    }

    final bs c(ai aiVar, int i) {
        bs[] bsVarArrA = a(aiVar);
        return bsVarArrA.length > i ? bsVarArrA[i] : bs.a;
    }
}
