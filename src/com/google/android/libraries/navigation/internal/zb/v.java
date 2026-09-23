package com.google.android.libraries.navigation.internal.zb;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class v implements Runnable {
    final /* synthetic */ u a;
    final /* synthetic */ w b;

    public v(w wVar, u uVar) {
        this.a = uVar;
        this.b = wVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a.remove(this.a);
    }
}
