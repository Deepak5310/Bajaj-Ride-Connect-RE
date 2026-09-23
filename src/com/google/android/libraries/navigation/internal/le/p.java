package com.google.android.libraries.navigation.internal.le;

import android.os.Looper;
import android.os.Message;
import android.util.Pair;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p extends com.google.android.libraries.navigation.internal.lt.c {
    public p() {
        super(Looper.getMainLooper());
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i != 1) {
            if (i == 2) {
                ((q) message.obj).g(com.google.android.libraries.navigation.internal.ld.ab.d);
                return;
            } else {
                int i2 = message.what;
                new Exception();
                return;
            }
        }
        Pair pair = (Pair) message.obj;
        com.google.android.libraries.navigation.internal.ld.y yVar = (com.google.android.libraries.navigation.internal.ld.y) pair.second;
        try {
            bl.a();
        } catch (RuntimeException e) {
            q.h(yVar);
            throw e;
        }
    }

    public p(Looper looper) {
        super(looper);
    }
}
