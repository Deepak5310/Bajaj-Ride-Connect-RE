package com.google.android.libraries.navigation.internal.lc;

import android.content.Context;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class g extends com.google.android.libraries.navigation.internal.lt.c {
    final /* synthetic */ h a;
    private final Context b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(h hVar, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        this.a = hVar;
        this.b = context.getApplicationContext();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.what != 1) {
            int i = message.what;
            return;
        }
        int iE = this.a.e(this.b);
        int i2 = ak.d;
        if (iE == 1 || iE == 2 || iE == 3 || iE == 9) {
            this.a.b(this.b, iE);
        }
    }
}
