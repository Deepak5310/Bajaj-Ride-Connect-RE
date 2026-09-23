package com.google.android.libraries.navigation.internal.mx;

import com.google.android.libraries.navigation.internal.ms.al;
import com.google.android.libraries.navigation.internal.ms.bw;
import com.google.android.libraries.navigation.internal.ms.ck;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.ms.cw;
import com.google.android.libraries.navigation.internal.ms.cx;
import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.cb;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class c implements bw {
    public final cw b;
    public final cx c;
    public final ck d;
    boolean e = true;
    private final StackTraceElement[] f;

    public c(cw cwVar, ck ckVar, cx cxVar, StackTraceElement[] stackTraceElementArr) {
        this.b = cwVar;
        this.d = ckVar;
        this.c = cxVar;
        this.f = stackTraceElementArr;
    }

    private final boolean f(cx cxVar) {
        return cxVar.b(this.b, this.d);
    }

    @Override // com.google.android.libraries.navigation.internal.ms.bw
    public void a() {
        this.e = true;
    }

    @Override // com.google.android.libraries.navigation.internal.ms.bw
    public final void b(cx cxVar, cs csVar, boolean z) {
        al.a.set(this.d.c.getContext());
        g(cxVar, csVar, z);
        al.a.remove();
    }

    @Override // com.google.android.libraries.navigation.internal.ms.bw
    public final boolean c() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.ms.bw
    public void d(cx cxVar) {
        if (cxVar != null && !f(cxVar)) {
            f(this.c);
        }
        a();
    }

    public abstract ak e(ak akVar);

    protected abstract void g(cx cxVar, cs csVar, boolean z);

    protected final void h() {
        cw cwVar = this.b;
        if ((cwVar instanceof com.google.android.libraries.navigation.internal.ms.e) && ((com.google.android.libraries.navigation.internal.ms.e) cwVar).a()) {
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Property declaration");
        illegalArgumentException.setStackTrace(this.f);
        throw new cb("ViewPropertyBinder was unable to apply property after trying all possible appliers. This probably means you are trying to apply a property to a kind of view that doesn't support it.\n ".concat(toString()), illegalArgumentException);
    }

    public final String toString() {
        ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        akVarB.g("propertyType", this.b);
        akVarB.g("layout", this.d.f);
        akVarB.g("view", this.d.c);
        return e(akVarB).toString();
    }
}
