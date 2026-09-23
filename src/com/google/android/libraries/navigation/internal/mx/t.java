package com.google.android.libraries.navigation.internal.mx;

import com.google.android.libraries.navigation.internal.ms.bw;
import com.google.android.libraries.navigation.internal.ms.ck;
import com.google.android.libraries.navigation.internal.ms.cw;
import com.google.android.libraries.navigation.internal.ms.cx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class t extends d {
    private final Object c;
    private final cx d;
    private final boolean f;

    public t(cw cwVar, Object obj, cx cxVar, boolean z) {
        super(cwVar);
        this.c = obj;
        this.d = cxVar;
        this.f = z;
    }

    public t(cw cwVar, Object obj, boolean z) {
        this(cwVar, obj, com.google.android.libraries.navigation.internal.ms.a.e, z);
    }

    @Override // com.google.android.libraries.navigation.internal.mx.d, com.google.android.libraries.navigation.internal.mx.w
    public final void b(cx cxVar, ck ckVar) {
        if (!this.f) {
            super.b(cxVar, ckVar);
        } else {
            if (cxVar.a(this.a, this.c, ckVar)) {
                return;
            }
            this.d.a(this.a, this.c, ckVar);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.mx.d, com.google.android.libraries.navigation.internal.mx.w
    public final boolean c() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.mx.w
    public final bw d(ck ckVar) {
        return new s(this.a, ckVar, this.d, this.b, this.c);
    }
}
