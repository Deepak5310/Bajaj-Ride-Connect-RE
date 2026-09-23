package com.google.android.libraries.navigation.internal.tc;

import android.app.PendingIntent;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.libraries.navigation.internal.le.bd;
import com.google.android.libraries.navigation.internal.le.bi;
import com.google.android.libraries.navigation.internal.lh.be;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements com.google.android.libraries.navigation.internal.sp.b {
    private final Context a;
    private final com.google.android.libraries.navigation.internal.fz.d b;
    private PendingIntent c;
    private com.google.android.libraries.navigation.internal.lu.a d;

    public a(Context context, com.google.android.libraries.navigation.internal.fz.d dVar) {
        this.a = context;
        this.b = dVar;
    }

    @Override // com.google.android.libraries.navigation.internal.sp.b
    public final void a(com.google.android.libraries.navigation.internal.sp.c cVar) {
        this.b.b();
        com.google.android.libraries.navigation.internal.fs.b.a();
    }

    @Override // com.google.android.libraries.navigation.internal.sp.b
    public final void b(boolean z) {
        Object obj = this.d;
        if (obj == null) {
            return;
        }
        this.d = null;
        ar.q(this.c);
        final PendingIntent pendingIntent = this.c;
        bi biVar = new bi();
        biVar.a = new bd() { // from class: com.google.android.libraries.navigation.internal.lv.m
            @Override // com.google.android.libraries.navigation.internal.le.bd
            public final void a(Object obj2, Object obj3) throws RemoteException {
                PendingIntent pendingIntent2 = pendingIntent;
                be.j(pendingIntent2);
                ((l) ((a) obj2).u()).f(pendingIntent2);
                ((com.google.android.libraries.navigation.internal.me.aa) obj3).b(null);
            }
        };
        biVar.c = 2402;
        ((com.google.android.libraries.navigation.internal.ld.o) obj).j(biVar.a());
    }
}
