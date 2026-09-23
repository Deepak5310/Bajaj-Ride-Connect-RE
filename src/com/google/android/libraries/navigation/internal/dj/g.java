package com.google.android.libraries.navigation.internal.dj;

import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.ca;
import com.google.android.libraries.navigation.internal.hj.i;
import com.google.android.libraries.navigation.internal.hj.k;
import com.google.android.libraries.navigation.internal.nt.m;
import com.google.android.libraries.navigation.internal.nt.p;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g implements com.google.android.libraries.navigation.internal.di.b {
    private final Executor b;
    private final p d;
    public final ca a = new ca();
    private final p c = new p(com.google.android.libraries.navigation.internal.hj.c.a);

    public g(Executor executor, com.google.android.libraries.navigation.internal.jf.a aVar) {
        int i = ev.d;
        new p(lv.a);
        this.d = new p();
        this.b = executor;
        k.a = aVar;
        k.b = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.di.a
    public final void a() {
    }

    @Override // com.google.android.libraries.navigation.internal.di.b
    public final i b(String str) {
        if (str.equals(com.google.android.libraries.navigation.internal.hj.c.a.c)) {
            return com.google.android.libraries.navigation.internal.hj.c.a;
        }
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.di.b
    public final i c() {
        return com.google.android.libraries.navigation.internal.hj.c.a;
    }

    @Override // com.google.android.libraries.navigation.internal.di.b
    public final m d() {
        return this.d.a;
    }

    @Override // com.google.android.libraries.navigation.internal.di.b
    public final m e() {
        return this.c.a;
    }

    @Override // com.google.android.libraries.navigation.internal.di.b
    public final bj f() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.di.b
    public final void g() {
    }

    final void h() {
        this.b.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.dj.f
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a.d(null);
            }
        });
    }
}
