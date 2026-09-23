package com.google.android.libraries.navigation.internal.mb;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.libraries.navigation.internal.ld.q;
import com.google.android.libraries.navigation.internal.ld.r;
import com.google.android.libraries.navigation.internal.lh.ab;
import com.google.android.libraries.navigation.internal.lh.p;
import com.google.android.libraries.navigation.internal.ma.n;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i extends ab {
    public i(Context context, Looper looper, p pVar, q qVar, r rVar) {
        super(context, looper, 51, pVar, qVar, rVar);
    }

    @Override // com.google.android.libraries.navigation.internal.lh.k
    public final com.google.android.libraries.navigation.internal.lc.d[] J() {
        return n.j;
    }

    @Override // com.google.android.libraries.navigation.internal.lh.ab, com.google.android.libraries.navigation.internal.lh.k, com.google.android.libraries.navigation.internal.ld.i
    public final int a() {
        return 9410000;
    }

    @Override // com.google.android.libraries.navigation.internal.lh.k
    protected final /* synthetic */ IInterface b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.phenotype.internal.IPhenotypeService");
        return iInterfaceQueryLocalInterface instanceof h ? (h) iInterfaceQueryLocalInterface : new g(iBinder);
    }

    @Override // com.google.android.libraries.navigation.internal.lh.k
    protected final String c() {
        return "com.google.android.gms.phenotype.internal.IPhenotypeService";
    }

    @Override // com.google.android.libraries.navigation.internal.lh.k
    protected final String d() {
        return "com.google.android.gms.phenotype.service.START";
    }
}
