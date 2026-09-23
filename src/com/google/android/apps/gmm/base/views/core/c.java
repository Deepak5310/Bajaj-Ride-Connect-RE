package com.google.android.apps.gmm.base.views.core;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
final class c extends Handler {
    final WeakReference a;

    public c(WeakReference weakReference) {
        super(Looper.getMainLooper());
        this.a = weakReference;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        GmmProgressBar gmmProgressBar = (GmmProgressBar) this.a.get();
        if (gmmProgressBar == null) {
            return;
        }
        int i = message.what;
        if (i == 1) {
            SystemClock.elapsedRealtime();
            gmmProgressBar.setVisibility(0);
        } else {
            if (i != 2) {
                return;
            }
            gmmProgressBar.setVisibility(4);
            int length = gmmProgressBar.a.length;
        }
    }
}
