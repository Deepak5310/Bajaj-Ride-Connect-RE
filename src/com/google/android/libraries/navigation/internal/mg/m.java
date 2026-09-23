package com.google.android.libraries.navigation.internal.mg;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.libraries.navigation.internal.ld.q;
import com.google.android.libraries.navigation.internal.ld.r;
import com.google.android.libraries.navigation.internal.lh.ab;
import com.google.android.libraries.navigation.internal.lh.p;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m extends ab {
    private final AtomicReference t;

    public m(Context context, Looper looper, p pVar, q qVar, r rVar) {
        super(context, looper, 41, pVar, qVar, rVar);
        this.t = new AtomicReference();
    }

    @Override // com.google.android.libraries.navigation.internal.lh.k
    public final boolean B() {
        return true;
    }

    public final void G(l lVar, l lVar2, com.google.android.libraries.navigation.internal.le.m mVar) throws RemoteException {
        j jVar = new j((f) u(), mVar, lVar2);
        if (lVar != null) {
            ((f) u()).h(lVar, jVar);
        } else if (lVar2 == null) {
            mVar.f();
        } else {
            ((f) u()).f(lVar2, jVar);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lh.k
    public final com.google.android.libraries.navigation.internal.lc.d[] J() {
        return com.google.android.libraries.navigation.internal.mf.g.f;
    }

    @Override // com.google.android.libraries.navigation.internal.lh.ab, com.google.android.libraries.navigation.internal.lh.k, com.google.android.libraries.navigation.internal.ld.i
    public final int a() {
        return 12600000;
    }

    @Override // com.google.android.libraries.navigation.internal.lh.k
    protected final /* synthetic */ IInterface b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.usagereporting.internal.IUsageReportingService");
        return iInterfaceQueryLocalInterface instanceof f ? (f) iInterfaceQueryLocalInterface : new e(iBinder);
    }

    @Override // com.google.android.libraries.navigation.internal.lh.k
    protected final String c() {
        return "com.google.android.gms.usagereporting.internal.IUsageReportingService";
    }

    @Override // com.google.android.libraries.navigation.internal.lh.k
    protected final String d() {
        return "com.google.android.gms.usagereporting.service.START";
    }

    @Override // com.google.android.libraries.navigation.internal.lh.k, com.google.android.libraries.navigation.internal.ld.i
    public final void i() {
        try {
            l lVar = (l) this.t.getAndSet(null);
            if (lVar != null) {
                ((f) u()).g(lVar, new i());
            }
        } catch (RemoteException unused) {
        }
        super.i();
    }
}
