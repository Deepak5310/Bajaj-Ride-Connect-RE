package com.google.android.libraries.navigation.internal.da;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c {
    final /* synthetic */ d a;

    public c(d dVar) {
        this.a = dVar;
    }

    public final void a() {
        synchronized (this.a.c) {
            d dVar = this.a;
            if (dVar.e) {
                return;
            }
            dVar.e = true;
            if (dVar.d) {
                dVar.c();
            }
        }
    }
}
