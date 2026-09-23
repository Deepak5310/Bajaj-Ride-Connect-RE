package com.google.android.libraries.navigation.internal.xe;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class aq implements com.google.android.libraries.navigation.internal.abh.bt {
    final /* synthetic */ as a;
    private int b;

    public aq(as asVar) {
        this.a = asVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.bt
    public final com.google.android.libraries.navigation.internal.pd.d b(long j, com.google.android.libraries.navigation.internal.pd.a aVar) {
        this.b = this.a.w.a(j, aVar);
        return aVar.a();
    }

    @Override // com.google.android.libraries.navigation.internal.abh.bt
    public final int i() {
        return this.b;
    }
}
