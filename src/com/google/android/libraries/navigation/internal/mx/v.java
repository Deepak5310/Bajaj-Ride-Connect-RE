package com.google.android.libraries.navigation.internal.mx;

import com.google.android.libraries.navigation.internal.ms.bw;
import com.google.android.libraries.navigation.internal.ms.by;
import com.google.android.libraries.navigation.internal.ms.ck;
import com.google.android.libraries.navigation.internal.ms.cw;
import com.google.android.libraries.navigation.internal.ms.cx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class v extends b {
    private final by c;
    private final cx d;

    public v(cw cwVar, by byVar, cx cxVar) {
        super(cwVar);
        this.c = byVar;
        this.d = cxVar;
    }

    @Override // com.google.android.libraries.navigation.internal.mx.w
    public final bw d(ck ckVar) {
        return new u(this.a, ckVar, this.d, this.b, this.c);
    }
}
