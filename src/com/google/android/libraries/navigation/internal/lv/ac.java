package com.google.android.libraries.navigation.internal.lv;

import com.google.android.libraries.navigation.internal.le.aq;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ac extends com.google.android.libraries.navigation.internal.lu.o {
    private aq a;

    public ac(aq aqVar) {
        this.a = aqVar;
    }

    final synchronized void b() {
        this.a.a();
    }

    final synchronized void c(aq aqVar) {
        aq aqVar2 = this.a;
        if (aqVar2 != aqVar) {
            aqVar2.a();
            this.a = aqVar;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lu.p
    public final void e(com.google.android.libraries.navigation.internal.lu.f fVar) {
        aq aqVar;
        synchronized (this) {
            aqVar = this.a;
        }
        aqVar.b(new ab(fVar));
    }
}
