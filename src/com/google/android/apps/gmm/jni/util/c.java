package com.google.android.apps.gmm.jni.util;

import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yx.aq;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends RuntimeException {
    public final com.google.android.libraries.navigation.internal.aei.a a;
    public final int b;
    private final int c;

    public c(String str, int i, int i2, int i3) {
        super(str);
        this.a = (com.google.android.libraries.navigation.internal.aei.a) an.i(com.google.android.libraries.navigation.internal.aei.a.b(i)).e(com.google.android.libraries.navigation.internal.aei.a.UNKNOWN);
        this.b = i2;
        this.c = i3;
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return getClass().getName() + ": " + aq.b(getMessage()) + " {canonicalCode=" + this.a.name() + ", loggedCode=" + this.b + ", posixErrno=" + this.c + "}";
    }
}
