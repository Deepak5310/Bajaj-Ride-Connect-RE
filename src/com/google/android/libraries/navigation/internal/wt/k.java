package com.google.android.libraries.navigation.internal.wt;

import android.os.SystemClock;
import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.ca;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class k implements Runnable {
    public final long a;
    public final String b;
    public final ca c = new ca();
    final /* synthetic */ m d;
    public final f e;
    private long f;

    public k(m mVar, String str, f fVar, long j) {
        this.d = mVar;
        this.e = fVar;
        this.a = j;
        this.b = str;
    }

    public final void a() {
        SystemClock.elapsedRealtime();
        this.d.c();
    }

    @Override // java.lang.Runnable
    public final void run() {
        bj bjVarG;
        this.f = SystemClock.elapsedRealtime();
        ca caVar = this.c;
        if (caVar.isDone()) {
            bjVarG = az.f();
        } else {
            try {
                bjVarG = this.d.a.submit(this.e.a);
            } catch (Exception e) {
                bjVarG = az.g(e);
            }
        }
        caVar.aA(bjVarG);
        this.c.l(new Runnable() { // from class: com.google.android.libraries.navigation.internal.wt.j
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a();
            }
        }, this.d.a);
    }
}
