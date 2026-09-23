package com.google.android.libraries.navigation.internal.xf;

import android.os.SystemClock;
import com.google.android.libraries.navigation.internal.zp.ar;
import com.google.android.libraries.navigation.internal.zp.ay;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class o implements com.google.android.libraries.navigation.internal.wd.f {
    int a;
    final /* synthetic */ p b;
    private final com.google.android.libraries.navigation.internal.abx.b c;
    private final long d;
    private final com.google.android.libraries.navigation.internal.wd.d e;

    public o(p pVar, com.google.android.libraries.navigation.internal.abx.b bVar) {
        this.b = pVar;
        com.google.android.libraries.navigation.internal.wd.e eVar = pVar.a;
        Objects.requireNonNull(eVar);
        this.e = new com.google.android.libraries.navigation.internal.wd.d(eVar, bVar, null);
        this.c = bVar;
        this.d = SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.libraries.navigation.internal.wd.f
    public final com.google.android.libraries.navigation.internal.abx.b a() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.wd.f
    public final void b(int i) {
        if (this.b.a.l(this)) {
            this.b.a.k(this);
            int iElapsedRealtime = (int) (SystemClock.elapsedRealtime() - this.d);
            this.a = iElapsedRealtime;
            p pVar = this.b;
            ar arVarG = pVar.a.g(this.c, iElapsedRealtime, i);
            this.e.c(arVarG);
            int i2 = ((ay) arVarG.b).r;
            int i3 = ((ay) arVarG.b).s;
            this.b.g(arVarG);
        }
    }
}
