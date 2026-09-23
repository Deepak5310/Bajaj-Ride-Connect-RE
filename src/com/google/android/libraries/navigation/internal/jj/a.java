package com.google.android.libraries.navigation.internal.jj;

import com.google.android.libraries.navigation.internal.afl.oa;
import com.google.android.libraries.navigation.internal.afl.oe;
import com.google.android.libraries.navigation.internal.gg.i;
import com.google.android.libraries.navigation.internal.gg.o;
import com.google.android.libraries.navigation.internal.nc.j;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a implements com.google.android.libraries.navigation.internal.gg.e {
    final /* synthetic */ f a;

    public a(f fVar) {
        this.a = fVar;
    }

    private final void c(oe oeVar, com.google.android.libraries.navigation.internal.fw.g gVar) {
        if (this.a.q.a()) {
            if (oeVar == null || gVar != null) {
                f fVar = this.a;
                fVar.g = fVar.d.getString(com.google.android.libraries.navigation.internal.jl.b.i);
                this.a.h = j.g(com.google.android.libraries.navigation.internal.f.d.m);
                this.a.f = com.google.android.libraries.navigation.internal.ji.a.EnumC0033a.ERROR;
            } else if (oeVar.b.isEmpty()) {
                f fVar2 = this.a;
                fVar2.g = fVar2.d.getString(com.google.android.libraries.navigation.internal.jl.b.f);
                this.a.f = com.google.android.libraries.navigation.internal.ji.a.EnumC0033a.LOADED;
            } else {
                oa oaVar = (oa) oeVar.b.get(0);
                this.a.R(com.google.android.libraries.navigation.internal.tt.d.H(oaVar));
                String str = oaVar.r;
                if (!str.isEmpty()) {
                    String str2 = oaVar.s;
                    if (!str2.isEmpty()) {
                        f fVar3 = this.a;
                        fVar3.i = str;
                        fVar3.j = str2;
                    }
                }
                this.a.f = com.google.android.libraries.navigation.internal.ji.a.EnumC0033a.LOADED;
            }
            f fVar4 = this.a;
            fVar4.e.a(fVar4);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.gg.e
    public final void a(i iVar, o oVar) {
        c(null, oVar.p);
    }

    @Override // com.google.android.libraries.navigation.internal.gg.e
    public final /* bridge */ /* synthetic */ void b(i iVar, Object obj) {
        c((oe) obj, null);
    }
}
