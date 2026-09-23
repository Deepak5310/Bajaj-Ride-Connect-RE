package com.google.android.libraries.navigation.internal.mx;

import com.google.android.libraries.navigation.internal.ms.ck;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.ms.cw;
import com.google.android.libraries.navigation.internal.ms.cx;
import com.google.android.libraries.navigation.internal.yx.ak;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class s extends c {
    final Object f;

    public s(cw cwVar, ck ckVar, cx cxVar, StackTraceElement[] stackTraceElementArr, Object obj) {
        super(cwVar, ckVar, cxVar, stackTraceElementArr);
        this.f = obj;
    }

    @Override // com.google.android.libraries.navigation.internal.mx.c
    public final ak e(ak akVar) {
        akVar.g("propertyValue", this.f);
        return akVar;
    }

    @Override // com.google.android.libraries.navigation.internal.mx.c
    protected final void g(cx cxVar, cs csVar, boolean z) {
        if (this.e || z) {
            if (!cxVar.a(this.b, this.f, this.d) && !this.c.a(this.b, this.f, this.d)) {
                h();
            }
            this.e = false;
        }
    }
}
