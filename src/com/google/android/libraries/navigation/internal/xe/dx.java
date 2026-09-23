package com.google.android.libraries.navigation.internal.xe;

import com.google.android.libraries.navigation.NavigationApi;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dx implements NavigationApi.OnTermsResponseListener {
    final /* synthetic */ ea a;
    final /* synthetic */ ef b;

    public dx(ea eaVar, ef efVar) {
        this.b = efVar;
        this.a = eaVar;
    }

    @Override // com.google.android.libraries.navigation.NavigationApi.OnTermsResponseListener
    public final void onTermsResponse(boolean z) {
        if (z) {
            this.a.b(this.b);
        } else {
            this.b.a(2);
        }
    }
}
