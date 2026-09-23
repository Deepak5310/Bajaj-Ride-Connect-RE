package com.google.android.libraries.navigation.internal.lh;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i extends b {
    public final IBinder g;
    final /* synthetic */ k h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(k kVar, int i, IBinder iBinder, Bundle bundle) {
        super(kVar, i, bundle);
        this.h = kVar;
        this.g = iBinder;
    }

    @Override // com.google.android.libraries.navigation.internal.lh.b
    protected final void a(com.google.android.libraries.navigation.internal.lc.a aVar) {
        aa aaVar = this.h.r;
        if (aaVar != null) {
            aaVar.a(aVar);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lh.b
    protected final boolean c() {
        IInterface iInterfaceB;
        try {
            IBinder iBinder = this.g;
            be.j(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            k kVar = this.h;
            if (!kVar.c().equals(interfaceDescriptor) || (iInterfaceB = kVar.b(this.g)) == null) {
                return false;
            }
            if (!this.h.y(2, 4, iInterfaceB) && !this.h.y(3, 4, iInterfaceB)) {
                return false;
            }
            k kVar2 = this.h;
            kVar2.m = null;
            z zVar = kVar2.q;
            if (zVar != null) {
                zVar.a.b();
            }
            return true;
        } catch (RemoteException unused) {
            return false;
        }
    }
}
