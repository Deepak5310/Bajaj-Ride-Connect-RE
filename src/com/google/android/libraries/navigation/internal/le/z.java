package com.google.android.libraries.navigation.internal.le;

import android.os.Handler;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class z {
    final /* synthetic */ ai a;

    public z(ai aiVar) {
        this.a = aiVar;
    }

    public final void a(boolean z) {
        Handler handler = this.a.p;
        handler.sendMessage(handler.obtainMessage(1, Boolean.valueOf(z)));
    }
}
