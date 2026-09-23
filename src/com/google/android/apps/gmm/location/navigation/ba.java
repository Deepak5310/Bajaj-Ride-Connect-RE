package com.google.android.apps.gmm.location.navigation;

import com.google.android.libraries.navigation.internal.afl.dr;
import com.google.android.libraries.navigation.internal.yz.fz;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public class ba implements com.google.android.libraries.navigation.internal.cw.i {
    public static final long a;
    private static final com.google.android.libraries.navigation.internal.zb.j g = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.apps.gmm.location.navigation.ba");
    public final com.google.android.libraries.navigation.internal.mj.a b;
    public final av c;
    boolean d;
    public float e;
    final List f;
    private final az h;
    private final ay i;
    private final ax j;
    private final aw k;
    private final List l;
    private final List m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final List f42n;
    private final List o;

    static {
        TimeUnit.SECONDS.toMillis(30L);
        TimeUnit.MINUTES.toMillis(2L);
        a = TimeUnit.MINUTES.toMillis(1L);
        TimeUnit.SECONDS.toMillis(10L);
        TimeUnit.SECONDS.toMillis(30L);
    }

    public ba(com.google.android.libraries.navigation.internal.fz.d dVar, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.kl.a aVar, com.google.android.libraries.navigation.internal.mj.a aVar2) {
        az azVar = new az(this);
        this.h = azVar;
        ay ayVar = new ay(this);
        this.i = ayVar;
        ax axVar = new ax(this);
        this.j = axVar;
        aw awVar = new aw(this);
        this.k = awVar;
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.f42n = new ArrayList();
        this.o = new ArrayList();
        new ArrayList();
        new ArrayList();
        this.d = false;
        new ArrayList();
        this.e = 25.0f;
        this.f = new ArrayList();
        this.b = aVar2;
        dr drVar = dVar.F().e;
        drVar = drVar == null ? dr.a : drVar;
        boolean z = drVar.b;
        boolean z2 = drVar.d;
        boolean z3 = drVar.g;
        dr drVar2 = dVar.F().e;
        int i = (drVar2 == null ? dr.a : drVar2).h;
        boolean z4 = drVar.e;
        float f = drVar.c;
        if (f != 0.0f) {
            this.e = f;
        }
        fz fzVar = new fz();
        fzVar.b(com.google.android.libraries.navigation.internal.pr.a.class, new be(com.google.android.libraries.navigation.internal.pr.a.class, azVar, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
        eVar.c(azVar, fzVar.a());
        fz fzVar2 = new fz();
        fzVar2.b(com.google.android.libraries.navigation.internal.dh.ai.class, new bd(com.google.android.libraries.navigation.internal.dh.ai.class, ayVar, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
        eVar.c(ayVar, fzVar2.a());
        fz fzVar3 = new fz();
        fzVar3.b(com.google.android.libraries.navigation.internal.da.h.class, new bc(com.google.android.libraries.navigation.internal.da.h.class, axVar, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
        eVar.c(axVar, fzVar3.a());
        fz fzVar4 = new fz();
        fzVar4.b(com.google.android.libraries.navigation.internal.n.b.class, new bb(0, com.google.android.libraries.navigation.internal.n.b.class, awVar, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
        fzVar4.b(com.google.android.libraries.navigation.internal.ds.c.class, new bb(1, com.google.android.libraries.navigation.internal.ds.c.class, awVar, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
        eVar.c(awVar, fzVar4.a());
        this.c = new av(aVar);
    }

    @Override // com.google.android.libraries.navigation.internal.cw.i
    public final void a(com.google.android.libraries.navigation.internal.db.q qVar) {
        qVar.a();
    }
}
