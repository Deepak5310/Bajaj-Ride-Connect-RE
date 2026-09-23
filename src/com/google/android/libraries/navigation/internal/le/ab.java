package com.google.android.libraries.navigation.internal.le;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ab implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ ae b;

    public ab(ae aeVar, int i) {
        this.a = i;
        this.b = aeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.k(this.a);
    }
}
