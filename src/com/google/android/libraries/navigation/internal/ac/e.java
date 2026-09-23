package com.google.android.libraries.navigation.internal.ac;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.google.android.libraries.navigation.internal.ms.cn;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class e extends Handler {
    public e(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.obj instanceof View) {
            View view = (View) message.obj;
            view.cancelPendingInputEvents();
            cn.a(view).onClick(view);
        }
    }
}
