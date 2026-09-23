package com.google.android.libraries.navigation.internal.mx;

import com.google.android.libraries.navigation.internal.ms.bw;
import com.google.android.libraries.navigation.internal.ms.ck;
import com.google.android.libraries.navigation.internal.ms.dd;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class r extends d {
    private final dd c;
    private final w d;
    private final w f;

    public r(dd ddVar, w wVar, w wVar2) {
        super(wVar.a());
        ar.b(wVar.a() == wVar2.a(), "thenProperty and elseProperty should have the same ViewProperty");
        this.c = ddVar;
        ar.r(wVar, "ifThenElse thenProperty cannot be null");
        this.d = wVar;
        ar.r(wVar2, "ifThenElse elseProperty cannot be null");
        this.f = wVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.mx.d, com.google.android.libraries.navigation.internal.mx.w
    public final boolean c() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.mx.w
    public final bw d(ck ckVar) {
        return new q(this.a, ckVar, this.b, this.c, this.d, this.f);
    }
}
