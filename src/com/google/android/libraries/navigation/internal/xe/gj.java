package com.google.android.libraries.navigation.internal.xe;

import com.google.android.libraries.navigation.NavigationApi;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class gj {
    final /* synthetic */ com.google.android.libraries.navigation.internal.fu.a a;
    final /* synthetic */ NavigationApi.OnTermsResponseListener b;
    final /* synthetic */ gk c;

    public gj(gk gkVar, com.google.android.libraries.navigation.internal.fu.a aVar, NavigationApi.OnTermsResponseListener onTermsResponseListener) {
        this.a = aVar;
        this.b = onTermsResponseListener;
        this.c = gkVar;
    }

    public final void a(boolean z) {
        if (z) {
            com.google.android.libraries.navigation.internal.xf.i iVar = (com.google.android.libraries.navigation.internal.xf.i) this.a;
            com.google.android.libraries.navigation.internal.xf.i.f(iVar.a.c(true != iVar.g() ? 1 : 2));
            iVar.c.set(true);
            iVar.b.d(null);
        }
        NavigationApi.OnTermsResponseListener onTermsResponseListener = this.b;
        if (onTermsResponseListener != null) {
            onTermsResponseListener.onTermsResponse(z);
        }
        this.c.a.clear();
    }
}
