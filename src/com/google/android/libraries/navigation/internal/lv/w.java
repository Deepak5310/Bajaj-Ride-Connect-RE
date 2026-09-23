package com.google.android.libraries.navigation.internal.lv;

import android.os.RemoteException;
import com.google.android.libraries.navigation.internal.le.ao;
import com.google.android.libraries.navigation.internal.le.aq;
import com.google.android.libraries.navigation.internal.le.bd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class w implements bd {
    public aq a;
    public boolean b = true;
    final /* synthetic */ x c;
    private final v d;

    public w(x xVar, aq aqVar, v vVar) {
        this.c = xVar;
        this.a = aqVar;
        this.d = vVar;
    }

    @Override // com.google.android.libraries.navigation.internal.le.bd
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) throws RemoteException {
        ao aoVar;
        boolean z;
        ah ahVar = (ah) obj;
        synchronized (this) {
            aoVar = this.a.b;
            z = this.b;
            this.a.a();
        }
        if (aoVar == null) {
            ((com.google.android.libraries.navigation.internal.me.aa) obj2).b(false);
        } else {
            this.d.a(ahVar, aoVar, z, (com.google.android.libraries.navigation.internal.me.aa) obj2);
        }
    }

    public final synchronized aq b() {
        return this.a;
    }

    public final synchronized void c(aq aqVar) {
        aq aqVar2 = this.a;
        if (aqVar2 != aqVar) {
            aqVar2.a();
            this.a = aqVar;
        }
    }
}
