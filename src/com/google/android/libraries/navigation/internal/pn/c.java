package com.google.android.libraries.navigation.internal.pn;

import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c extends Handler {
    final /* synthetic */ f a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(f fVar, Handler handler) {
        super(handler.getLooper());
        this.a = fVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            this.a.k.i();
            return;
        }
        if (i == 2) {
            f fVar = this.a;
            fVar.j.removeMessages(3);
            fVar.f517n = true;
            fVar.k.a(fVar.q);
            return;
        }
        if (i != 3) {
            throw new RuntimeException("Unknown message ".concat(String.valueOf(String.valueOf(message))));
        }
        f fVar2 = this.a;
        GestureDetector.OnDoubleTapListener onDoubleTapListener = fVar2.l;
        if (onDoubleTapListener == null || fVar2.m) {
            return;
        }
        onDoubleTapListener.onSingleTapConfirmed(fVar2.q);
    }
}
