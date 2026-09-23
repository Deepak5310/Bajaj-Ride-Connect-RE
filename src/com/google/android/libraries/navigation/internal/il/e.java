package com.google.android.libraries.navigation.internal.il;

import android.app.Application;
import com.google.android.libraries.navigation.internal.afl.io;
import com.google.android.libraries.navigation.internal.afr.f;
import com.google.android.libraries.navigation.internal.afr.g;
import com.google.android.libraries.navigation.internal.fr.l;
import com.google.android.libraries.navigation.internal.xf.i;
import com.google.android.libraries.navigation.internal.xf.j;
import com.google.android.libraries.navigation.internal.yx.an;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.agl.a c;
    private final com.google.android.libraries.navigation.internal.agl.a d;
    private final com.google.android.libraries.navigation.internal.agl.a e;
    private final com.google.android.libraries.navigation.internal.agl.a f;
    private final com.google.android.libraries.navigation.internal.agl.a g;
    private final com.google.android.libraries.navigation.internal.agl.a h;
    private final com.google.android.libraries.navigation.internal.agl.a i;
    private final com.google.android.libraries.navigation.internal.agl.a j;
    private final com.google.android.libraries.navigation.internal.agl.a k;
    private final com.google.android.libraries.navigation.internal.agl.a l;
    private final com.google.android.libraries.navigation.internal.agl.a m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final com.google.android.libraries.navigation.internal.agl.a f450n;

    public e(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, com.google.android.libraries.navigation.internal.agl.a aVar4, com.google.android.libraries.navigation.internal.agl.a aVar5, com.google.android.libraries.navigation.internal.agl.a aVar6, com.google.android.libraries.navigation.internal.agl.a aVar7, com.google.android.libraries.navigation.internal.agl.a aVar8, com.google.android.libraries.navigation.internal.agl.a aVar9, com.google.android.libraries.navigation.internal.agl.a aVar10, com.google.android.libraries.navigation.internal.agl.a aVar11, com.google.android.libraries.navigation.internal.agl.a aVar12, com.google.android.libraries.navigation.internal.agl.a aVar13, com.google.android.libraries.navigation.internal.agl.a aVar14) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
        this.e = aVar5;
        this.f = aVar6;
        this.g = aVar7;
        this.h = aVar8;
        this.i = aVar9;
        this.j = aVar10;
        this.k = aVar11;
        this.l = aVar12;
        this.m = aVar13;
        this.f450n = aVar14;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        Application application = (Application) ((g) this.a).a;
        com.google.android.libraries.navigation.internal.iv.f fVar = (com.google.android.libraries.navigation.internal.iv.f) this.b.a();
        i iVarA = ((j) this.c).a();
        com.google.android.libraries.navigation.internal.jb.c cVar = (com.google.android.libraries.navigation.internal.jb.c) this.d.a();
        io ioVar = (io) this.e.a();
        l lVar = (l) this.f.a();
        String str = (String) ((g) this.g).a;
        com.google.android.libraries.navigation.internal.gf.c cVar2 = (com.google.android.libraries.navigation.internal.gf.c) this.i.a();
        com.google.android.libraries.navigation.internal.gf.a aVar = (com.google.android.libraries.navigation.internal.gf.a) this.j.a();
        com.google.android.libraries.navigation.internal.au.b bVarA = ((com.google.android.libraries.navigation.internal.au.d) this.k).a();
        com.google.android.libraries.navigation.internal.in.b bVar = (com.google.android.libraries.navigation.internal.in.b) this.l.a();
        com.google.android.libraries.navigation.internal.afo.a aVarC = com.google.android.libraries.navigation.internal.afr.e.c(this.f450n);
        return d.i(fVar, iVarA, application, cVar, ioVar, lVar, str, this.h, cVar2, an.j(aVar), bVarA, bVar, this.m, aVarC);
    }
}
