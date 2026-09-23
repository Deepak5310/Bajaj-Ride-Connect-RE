package com.google.android.libraries.navigation.internal.qw;

import com.google.android.libraries.geo.mapcore.internal.model.cc;
import com.google.android.libraries.geo.mapcore.internal.model.cq;
import com.google.android.libraries.geo.mapcore.internal.model.t;
import com.google.android.libraries.navigation.internal.ael.ar;
import java.lang.ref.SoftReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a {
    final SoftReference a;
    final cc b;

    public a(cc ccVar) {
        ar arVar = cq.a;
        cc ccVar2 = true != (ccVar instanceof t) ? null : ccVar;
        this.b = ccVar2;
        this.a = ccVar2 == null ? new SoftReference(ccVar) : null;
    }
}
