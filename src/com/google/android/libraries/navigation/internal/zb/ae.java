package com.google.android.libraries.navigation.internal.zb;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ae extends ah {
    final /* synthetic */ ah a;
    final /* synthetic */ ah b;

    public ae(ah ahVar, ah ahVar2) {
        this.a = ahVar;
        this.b = ahVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.zb.ah
    public final void a() {
        try {
            this.a.a();
        } finally {
            this.b.a();
        }
    }
}
