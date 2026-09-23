package com.google.android.libraries.navigation.internal.mx;

import com.google.android.libraries.navigation.internal.ms.bw;
import com.google.android.libraries.navigation.internal.ms.ck;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.ms.cw;
import com.google.android.libraries.navigation.internal.ms.cx;
import com.google.android.libraries.navigation.internal.ms.dd;
import com.google.android.libraries.navigation.internal.yx.ak;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class q extends c {
    private final dd f;
    private final w g;
    private final w h;
    private bw i;
    private bw j;
    private bw k;

    public q(cw cwVar, ck ckVar, StackTraceElement[] stackTraceElementArr, dd ddVar, w wVar, w wVar2) {
        super(cwVar, ckVar, com.google.android.libraries.navigation.internal.ms.a.e, stackTraceElementArr);
        this.f = ddVar;
        this.g = wVar;
        this.h = wVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.mx.c, com.google.android.libraries.navigation.internal.ms.bw
    public final void a() {
        super.a();
        bw bwVar = this.k;
        if (bwVar != null) {
            bwVar.a();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.mx.c, com.google.android.libraries.navigation.internal.ms.bw
    public final void d(cx cxVar) {
        super.d(cxVar);
        bw bwVar = this.i;
        if (bwVar != null) {
            bwVar.d(cxVar);
        }
        bw bwVar2 = this.j;
        if (bwVar2 != null) {
            bwVar2.d(cxVar);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.mx.c
    public final ak e(ak akVar) {
        bw bwVar = this.k;
        if (bwVar != null) {
            akVar.e("expressionValue", bwVar == this.i);
        } else {
            akVar.g("expressionValue", "<not evaluated>");
        }
        akVar.g("thenBinding", this.i);
        akVar.g("elseBinding", this.j);
        return akVar;
    }

    @Override // com.google.android.libraries.navigation.internal.mx.c
    protected final void g(cx cxVar, cs csVar, boolean z) {
        bw bwVar;
        this.d.c.getContext();
        if (((Boolean) this.f.a(csVar)).booleanValue()) {
            if (this.i == null) {
                this.i = this.g.d(this.d);
            }
            bwVar = this.i;
        } else {
            if (this.j == null) {
                this.j = this.h.d(this.d);
            }
            bwVar = this.j;
        }
        if (bwVar != this.k) {
            this.k = bwVar;
            bwVar.a();
        }
        this.k.b(cxVar, csVar, z);
        this.e = false;
    }
}
