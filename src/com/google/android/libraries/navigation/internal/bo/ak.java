package com.google.android.libraries.navigation.internal.bo;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ak implements com.google.android.libraries.navigation.internal.cq.z {
    final /* synthetic */ boolean a;
    final /* synthetic */ String b;
    final /* synthetic */ ao c;

    public ak(ao aoVar, boolean z, String str) {
        this.a = z;
        this.b = str;
        this.c = aoVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.as
    public final /* synthetic */ void C(Object obj) {
        String str = this.a ? this.b : null;
        ao aoVar = this.c;
        aoVar.p = str;
        aoVar.E.a(aoVar.p);
    }

    @Override // com.google.android.libraries.navigation.internal.ol.as
    public final /* bridge */ /* synthetic */ void D(Object obj) {
    }
}
