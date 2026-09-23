package com.google.android.libraries.navigation.internal.la;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.libraries.navigation.internal.ky.aq;
import com.google.android.libraries.navigation.internal.lh.ab;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j extends ab {
    public j(Context context, Looper looper, com.google.android.libraries.navigation.internal.lh.p pVar, com.google.android.libraries.navigation.internal.ld.q qVar, com.google.android.libraries.navigation.internal.ld.r rVar) {
        super(context, looper, 40, pVar, qVar, rVar);
    }

    @Override // com.google.android.libraries.navigation.internal.lh.k
    public final com.google.android.libraries.navigation.internal.lc.d[] J() {
        return new com.google.android.libraries.navigation.internal.lc.d[]{aq.a};
    }

    @Override // com.google.android.libraries.navigation.internal.lh.ab, com.google.android.libraries.navigation.internal.lh.k, com.google.android.libraries.navigation.internal.ld.i
    public final int a() {
        return 11925000;
    }

    @Override // com.google.android.libraries.navigation.internal.lh.k
    protected final /* synthetic */ IInterface b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
        return iInterfaceQueryLocalInterface instanceof r ? (r) iInterfaceQueryLocalInterface : new q(iBinder);
    }

    @Override // com.google.android.libraries.navigation.internal.lh.k
    protected final String c() {
        return "com.google.android.gms.clearcut.internal.IClearcutLoggerService";
    }

    @Override // com.google.android.libraries.navigation.internal.lh.k
    protected final String d() {
        return "com.google.android.gms.clearcut.service.START";
    }
}
