package com.google.android.libraries.navigation.internal.lh;

import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c extends com.google.android.libraries.navigation.internal.lt.c {
    final /* synthetic */ k a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(k kVar, Looper looper) {
        super(looper);
        this.a = kVar;
    }

    private static final void a(Message message) {
        d dVar = (d) message.obj;
        dVar.b();
        dVar.f();
    }

    private static final boolean b(Message message) {
        return message.what == 2 || message.what == 1 || message.what == 7;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Object obj;
        if (this.a.p.get() != message.arg1) {
            if (b(message)) {
                a(message);
                return;
            }
            return;
        }
        if ((message.what == 1 || message.what == 7 || message.what == 4 || message.what == 5) && !this.a.m()) {
            a(message);
            return;
        }
        if (message.what == 4) {
            this.a.m = new com.google.android.libraries.navigation.internal.lc.a(message.arg2);
            k kVar = this.a;
            if (!kVar.f480n && !TextUtils.isEmpty(kVar.c()) && !TextUtils.isEmpty(null)) {
                try {
                    Class.forName(kVar.c());
                    k kVar2 = this.a;
                    if (!kVar2.f480n) {
                        kVar2.H(3, null);
                        return;
                    }
                } catch (ClassNotFoundException unused) {
                }
            }
            com.google.android.libraries.navigation.internal.lc.a aVar = this.a.m;
            if (aVar == null) {
                aVar = new com.google.android.libraries.navigation.internal.lc.a(8);
            }
            this.a.g.a(aVar);
            return;
        }
        if (message.what == 5) {
            com.google.android.libraries.navigation.internal.lc.a aVar2 = this.a.m;
            if (aVar2 == null) {
                aVar2 = new com.google.android.libraries.navigation.internal.lc.a(8);
            }
            this.a.g.a(aVar2);
            return;
        }
        if (message.what == 3) {
            this.a.g.a(new com.google.android.libraries.navigation.internal.lc.a(message.arg2, message.obj instanceof PendingIntent ? (PendingIntent) message.obj : null));
            return;
        }
        if (message.what == 6) {
            this.a.H(5, null);
            z zVar = this.a.q;
            if (zVar != null) {
                zVar.a.a(message.arg2);
            }
            k kVar3 = this.a;
            int i = message.arg2;
            kVar3.F();
            this.a.y(5, 1, null);
            return;
        }
        if (message.what == 2 && !this.a.l()) {
            a(message);
            return;
        }
        if (!b(message)) {
            int i2 = message.what;
            new Exception();
            return;
        }
        d dVar = (d) message.obj;
        synchronized (dVar) {
            obj = dVar.d;
        }
        if (obj != null) {
            dVar.d();
        }
        synchronized (dVar) {
            dVar.e = true;
        }
        dVar.f();
    }
}
