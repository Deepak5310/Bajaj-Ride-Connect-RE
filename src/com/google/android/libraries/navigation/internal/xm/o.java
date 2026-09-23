package com.google.android.libraries.navigation.internal.xm;

import com.google.android.libraries.navigation.internal.ael.ao;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class o implements Runnable {
    final /* synthetic */ s a;

    public o(s sVar) {
        this.a = sVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.a.a.d(ao.a);
        } catch (Exception e) {
            int i = t.b;
            this.a.a.ap(e);
        }
    }
}
