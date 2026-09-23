package com.google.android.libraries.navigation.internal.le;

import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aq {
    public volatile Object a;
    public volatile ao b;
    private final Executor c;

    public aq(Looper looper, Object obj, String str) {
        this.c = new com.google.android.libraries.navigation.internal.lm.a(looper);
        com.google.android.libraries.navigation.internal.lh.be.k(obj, "Listener must not be null");
        this.a = obj;
        com.google.android.libraries.navigation.internal.lh.be.h(str);
        this.b = new ao(obj, str);
    }

    public final void a() {
        this.a = null;
        this.b = null;
    }

    public final void b(final ap apVar) {
        this.c.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.le.an
            @Override // java.lang.Runnable
            public final void run() {
                ap apVar2 = apVar;
                Object obj = this.a.a;
                if (obj == null) {
                    return;
                }
                apVar2.a(obj);
            }
        });
    }
}
