package com.google.android.libraries.navigation.internal.mx;

import com.google.android.libraries.navigation.internal.ms.ck;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.ms.cw;
import com.google.android.libraries.navigation.internal.ms.cx;
import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.am;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class a extends c {
    private Object f;

    protected a(cw cwVar, ck ckVar, cx cxVar, StackTraceElement[] stackTraceElementArr) {
        super(cwVar, ckVar, cxVar, stackTraceElementArr);
    }

    @Override // com.google.android.libraries.navigation.internal.mx.c, com.google.android.libraries.navigation.internal.ms.bw
    public final void a() {
        super.a();
        this.f = null;
    }

    @Override // com.google.android.libraries.navigation.internal.mx.c
    public final ak e(ak akVar) {
        akVar.g("propertyValue", this.f);
        return akVar;
    }

    protected abstract Object f(cs csVar);

    @Override // com.google.android.libraries.navigation.internal.mx.c
    protected final void g(cx cxVar, cs csVar, boolean z) {
        boolean z2 = true;
        if (!this.e && !z) {
            z2 = false;
        }
        Object objF = f(csVar);
        if (!z2 && am.a(objF, this.f)) {
            return;
        }
        this.f = objF;
        if (!cxVar.a(this.b, this.f, this.d) && !this.c.a(this.b, this.f, this.d)) {
            h();
        }
        this.e = false;
    }
}
