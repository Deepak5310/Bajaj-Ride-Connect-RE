package com.google.android.libraries.navigation.internal.uu;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class p {
    final /* synthetic */ q a;

    public p(q qVar) {
        this.a = qVar;
    }

    public final void a(boolean z) {
        q qVar = this.a;
        if (qVar.j == z) {
            return;
        }
        qVar.j = z;
        qVar.e.c();
        this.a.b();
        this.a.e.b();
        this.a.e.a();
    }

    public final void b(boolean z) {
        q qVar = this.a;
        if (qVar.k == z) {
            return;
        }
        qVar.k = z;
        qVar.f629n = true;
        qVar.e.b();
    }
}
