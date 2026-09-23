package com.google.android.libraries.navigation.internal.rl;

import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.br;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.function.Function;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class n {
    public int a = 0;
    public ev b;
    public ev c;
    public final com.google.android.libraries.navigation.internal.pm.a d;
    private final ev e;

    public n(ev evVar, com.google.android.libraries.navigation.internal.pm.a aVar) {
        this.e = evVar;
        this.d = aVar;
    }

    final synchronized l a() {
        ev evVar;
        if (this.a == 0) {
            final q qVar = new q(this.d);
            this.c = (ev) this.e.stream().map(new Function() { // from class: com.google.android.libraries.navigation.internal.rl.m
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((k) obj).a(qVar);
                }
            }).collect(br.a);
            this.b = ev.o(qVar.a);
        }
        this.a++;
        evVar = this.c;
        ar.q(evVar);
        return new l(evVar, this);
    }
}
