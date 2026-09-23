package com.google.android.libraries.navigation.internal.abe;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.libraries.navigation.internal.abf.p;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class b extends com.google.android.libraries.navigation.internal.abg.c {
    final /* synthetic */ g a;
    final /* synthetic */ c b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar, g gVar) {
        super(cVar);
        this.a = gVar;
        this.b = cVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.abg.c
    public final /* bridge */ /* synthetic */ void a(IInterface iInterface) throws RemoteException {
        try {
            try {
                p.f(c.a, 4);
                c cVar = this.b;
                Bundle bundle = new Bundle(4);
                bundle.putString("PACKAGE_NAME", cVar.c);
                bundle.putString("API_KEY", cVar.b);
                bundle.putBoolean("IS_GMM10_RENDERER", true);
                bundle.putInt("CLIENT_TYPE", 5);
                this.b.c(iInterface.e(bundle), this.a);
            } catch (RemoteException | RuntimeException unused) {
                p.f(c.a, 6);
                ((f) this.a).d();
            }
        } finally {
            this.b.d();
        }
    }
}
