package com.google.android.libraries.navigation.internal.abh;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ay extends Handler {
    public ay(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        ((com.google.android.libraries.navigation.internal.abg.n) message.obj).a();
    }
}
