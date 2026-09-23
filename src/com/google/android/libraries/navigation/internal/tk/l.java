package com.google.android.libraries.navigation.internal.tk;

import android.content.Intent;
import com.google.android.libraries.navigation.internal.ace.hm;
import com.google.android.libraries.navigation.internal.nt.t;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class l implements com.google.android.libraries.navigation.internal.tl.a {
    public final com.google.android.libraries.navigation.internal.ia.e a;
    public final com.google.android.libraries.navigation.internal.rw.f b;
    public final q c;
    public final c d;
    public final Executor e;
    public boolean h;
    public boolean i;
    public final com.google.android.libraries.navigation.internal.av.a m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.google.android.libraries.navigation.internal.sj.a f599n;
    public final com.google.android.libraries.navigation.internal.vo.a o;
    private final hm p;
    public final t j = new g(this);
    public final k k = new k(this);
    public final t l = new h(this);
    public final i f = new i(this);
    public final j g = new j(this);

    public l(com.google.android.libraries.navigation.internal.av.a aVar, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.rw.f fVar, com.google.android.libraries.navigation.internal.sj.a aVar2, Executor executor, c cVar, q qVar, com.google.android.libraries.navigation.internal.vo.a aVar3, hm hmVar) {
        this.m = aVar;
        this.a = eVar;
        this.b = fVar;
        this.f599n = aVar2;
        this.e = executor;
        this.c = qVar;
        this.d = cVar;
        this.o = aVar3;
        this.p = hmVar;
    }

    @Override // com.google.android.libraries.navigation.internal.tl.a
    public final boolean a(Intent intent) {
        q qVar = this.c;
        if (intent.hasExtra("declinesuggestion")) {
            com.google.android.libraries.navigation.internal.ut.d dVar = qVar.p;
            if (dVar != null) {
                qVar.b(dVar.o(), false);
                return true;
            }
        } else {
            if (!intent.hasExtra("acceptsuggestion")) {
                return false;
            }
            com.google.android.libraries.navigation.internal.ut.d dVar2 = qVar.p;
            if (dVar2 instanceof com.google.android.libraries.navigation.internal.ut.a) {
                qVar.b(((com.google.android.libraries.navigation.internal.ut.a) dVar2).e(), true);
                return true;
            }
        }
        return true;
    }

    public final boolean b() {
        return this.p.l;
    }
}
