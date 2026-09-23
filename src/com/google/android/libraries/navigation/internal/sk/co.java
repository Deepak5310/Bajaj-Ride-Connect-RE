package com.google.android.libraries.navigation.internal.sk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class co implements com.google.android.libraries.navigation.internal.sl.c {
    final /* synthetic */ com.google.android.libraries.navigation.internal.bp.bq a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ String d;
    final /* synthetic */ ct e;

    public co(ct ctVar, com.google.android.libraries.navigation.internal.bp.bq bqVar, int i, int i2, String str) {
        this.a = bqVar;
        this.b = i;
        this.c = i2;
        this.d = str;
        this.e = ctVar;
    }

    @Override // com.google.android.libraries.navigation.internal.sl.c
    public final void a(long j) {
        this.e.c.a(new com.google.android.libraries.navigation.internal.sm.e(j, this.a, this.b, this.c, this.d));
    }

    @Override // com.google.android.libraries.navigation.internal.sl.c
    public final void b(int i) {
        this.e.c.a(new com.google.android.libraries.navigation.internal.sm.c(i, this.a, this.c, this.d));
    }
}
