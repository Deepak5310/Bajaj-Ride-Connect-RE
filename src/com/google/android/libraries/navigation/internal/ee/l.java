package com.google.android.libraries.navigation.internal.ee;

import androidx.core.os.BuildCompat;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class l {
    static /* synthetic */ String d(com.google.android.libraries.navigation.internal.adu.m mVar, String str) {
        return mVar.eU + str;
    }

    public abstract m a();

    public abstract void b(p... pVarArr);

    public final m c() {
        if (!BuildCompat.isAtLeastO()) {
            b(new p[0]);
        }
        return a();
    }
}
