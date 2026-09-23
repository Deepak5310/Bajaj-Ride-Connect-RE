package com.google.android.libraries.navigation.internal.lv;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import androidx.collection.SimpleArrayMap;
import com.google.android.libraries.navigation.internal.le.au;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ah extends com.google.android.libraries.navigation.internal.lh.ab {
    public final SimpleArrayMap t;
    public final SimpleArrayMap u;
    private final SimpleArrayMap v;

    public ah(Context context, Looper looper, com.google.android.libraries.navigation.internal.lh.p pVar, com.google.android.libraries.navigation.internal.le.r rVar, au auVar) {
        super(context, looper, 23, pVar, rVar, auVar);
        this.v = new SimpleArrayMap();
        this.t = new SimpleArrayMap();
        this.u = new SimpleArrayMap();
        new SimpleArrayMap();
    }

    @Override // com.google.android.libraries.navigation.internal.lh.k
    public final boolean B() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.lh.k
    public final void F() {
        synchronized (this.v) {
            this.v.clear();
        }
        synchronized (this.t) {
            this.t.clear();
        }
        synchronized (this.u) {
            this.u.clear();
        }
    }

    public final boolean G(com.google.android.libraries.navigation.internal.lc.d dVar) {
        com.google.android.libraries.navigation.internal.lc.d dVar2;
        com.google.android.libraries.navigation.internal.lc.d[] dVarArrO = o();
        if (dVarArrO != null) {
            int i = 0;
            while (true) {
                if (i >= dVarArrO.length) {
                    dVar2 = null;
                    break;
                }
                dVar2 = dVarArrO[i];
                if (dVar.a.equals(dVar2.a)) {
                    break;
                }
                i++;
            }
            if (dVar2 != null && dVar2.a() >= dVar.a()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.lh.k
    public final com.google.android.libraries.navigation.internal.lc.d[] J() {
        return com.google.android.libraries.navigation.internal.lu.l.p;
    }

    @Override // com.google.android.libraries.navigation.internal.lh.ab, com.google.android.libraries.navigation.internal.lh.k, com.google.android.libraries.navigation.internal.ld.i
    public final int a() {
        return 11717000;
    }

    @Override // com.google.android.libraries.navigation.internal.lh.k
    protected final /* synthetic */ IInterface b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        return iInterfaceQueryLocalInterface instanceof l ? (l) iInterfaceQueryLocalInterface : new k(iBinder);
    }

    @Override // com.google.android.libraries.navigation.internal.lh.k
    protected final String c() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    @Override // com.google.android.libraries.navigation.internal.lh.k
    protected final String d() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }
}
