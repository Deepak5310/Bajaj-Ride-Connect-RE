package com.google.android.libraries.navigation.internal.us;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class v implements com.google.android.libraries.navigation.internal.sl.c {
    boolean a = false;
    final /* synthetic */ y b;

    public v(y yVar) {
        this.b = yVar;
    }

    @Override // com.google.android.libraries.navigation.internal.sl.c
    public final void a(long j) {
        if (this.b.l) {
            return;
        }
        y yVar = this.b;
        long jH = yVar.h(yVar.u);
        if (j != -1) {
            jH = Math.max(j, jH);
            this.b.d();
            this.a = true;
        }
        this.b.t.g(jH);
    }

    @Override // com.google.android.libraries.navigation.internal.sl.c
    public final void b(int i) {
        com.google.android.libraries.navigation.internal.ut.d.InterfaceC0038d interfaceC0038d;
        y yVar = this.b;
        if (yVar.l) {
            return;
        }
        yVar.t.i();
        if (((i == com.google.android.libraries.navigation.internal.sl.b.b && !this.a) || i == com.google.android.libraries.navigation.internal.sl.b.a) && !this.b.t.j()) {
            y yVar2 = this.b;
            yVar2.t.g(yVar2.h(yVar2.u));
        }
        if (this.a) {
            int[] iArr = x.a;
            int i2 = i - 1;
            if (i == 0) {
                throw null;
            }
            int i3 = iArr[i2];
        }
        y yVar3 = this.b;
        yVar3.v = true;
        if (!yVar3.t.i() || (interfaceC0038d = this.b.p) == null) {
            return;
        }
        interfaceC0038d.a();
    }
}
