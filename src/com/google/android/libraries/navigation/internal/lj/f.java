package com.google.android.libraries.navigation.internal.lj;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.libraries.navigation.internal.le.au;
import com.google.android.libraries.navigation.internal.le.r;
import com.google.android.libraries.navigation.internal.lh.ab;
import com.google.android.libraries.navigation.internal.lh.bq;
import com.google.android.libraries.navigation.internal.lh.p;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f extends ab {
    private final bq t;

    public f(Context context, Looper looper, p pVar, bq bqVar, r rVar, au auVar) {
        super(context, looper, 270, pVar, rVar, auVar);
        this.t = bqVar;
    }

    @Override // com.google.android.libraries.navigation.internal.lh.k
    public final com.google.android.libraries.navigation.internal.lc.d[] J() {
        return com.google.android.libraries.navigation.internal.lb.a.b;
    }

    @Override // com.google.android.libraries.navigation.internal.lh.ab, com.google.android.libraries.navigation.internal.lh.k, com.google.android.libraries.navigation.internal.ld.i
    public final int a() {
        return 203400000;
    }

    @Override // com.google.android.libraries.navigation.internal.lh.k
    protected final /* synthetic */ IInterface b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        return iInterfaceQueryLocalInterface instanceof b ? (b) iInterfaceQueryLocalInterface : new a(iBinder);
    }

    @Override // com.google.android.libraries.navigation.internal.lh.k
    protected final String c() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    @Override // com.google.android.libraries.navigation.internal.lh.k
    protected final String d() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    @Override // com.google.android.libraries.navigation.internal.lh.k
    protected final Bundle t() {
        return new Bundle();
    }

    @Override // com.google.android.libraries.navigation.internal.lh.k
    protected final boolean z() {
        return true;
    }
}
