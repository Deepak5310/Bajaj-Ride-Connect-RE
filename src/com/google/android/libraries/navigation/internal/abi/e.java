package com.google.android.libraries.navigation.internal.abi;

import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class e extends Handler {
    final /* synthetic */ f a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(f fVar, Handler handler) {
        super(handler.getLooper());
        this.a = fVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            f fVar = this.a;
            fVar.j.onShowPress(fVar.p);
            return;
        }
        if (i == 2) {
            f fVar2 = this.a;
            fVar2.i.removeMessages(3);
            fVar2.m = true;
            fVar2.j.onLongPress(fVar2.p);
            return;
        }
        if (i != 3) {
            throw new IllegalStateException("Unknown message ".concat(String.valueOf(String.valueOf(message))));
        }
        f fVar3 = this.a;
        GestureDetector.OnDoubleTapListener onDoubleTapListener = fVar3.k;
        if (onDoubleTapListener == null || fVar3.l) {
            return;
        }
        onDoubleTapListener.onSingleTapConfirmed(fVar3.p);
    }
}
