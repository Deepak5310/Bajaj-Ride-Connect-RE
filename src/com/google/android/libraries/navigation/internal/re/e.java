package com.google.android.libraries.navigation.internal.re;

import com.google.android.libraries.navigation.internal.oe.r;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.ol.l;
import com.google.android.libraries.navigation.internal.ol.m;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class e implements l {
    public final x a;
    public com.google.android.libraries.navigation.internal.adg.b b;

    public e(r rVar, com.google.android.libraries.navigation.internal.adg.b bVar) {
        x xVar = new x();
        this.a = xVar;
        xVar.L(rVar.a, rVar.b);
        this.b = bVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.l
    public final void a(m mVar) {
        mVar.b(this.a);
        mVar.b = this.b;
    }
}
