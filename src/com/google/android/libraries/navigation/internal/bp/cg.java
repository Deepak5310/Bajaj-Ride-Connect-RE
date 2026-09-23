package com.google.android.libraries.navigation.internal.bp;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class cg implements Serializable {
    public static cg d(com.google.android.libraries.navigation.internal.oe.r rVar, int i) {
        return new s(rVar, i, Math.max(10, 200));
    }

    public abstract int a();

    public abstract int b();

    public abstract com.google.android.libraries.navigation.internal.oe.r c();
}
