package com.google.android.libraries.navigation.internal.mx;

import com.google.android.libraries.navigation.internal.ms.ck;
import com.google.android.libraries.navigation.internal.ms.cw;
import com.google.android.libraries.navigation.internal.ms.cx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class d implements w {
    private static final StackTraceElement[] c = new StackTraceElement[0];
    public final cw a;
    public final StackTraceElement[] b = c;

    public d(cw cwVar) {
        this.a = cwVar;
    }

    @Override // com.google.android.libraries.navigation.internal.mx.w
    public final cw a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.mx.w
    public void b(cx cxVar, ck ckVar) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.navigation.internal.mx.w
    public boolean c() {
        return false;
    }
}
