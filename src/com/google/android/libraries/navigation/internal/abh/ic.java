package com.google.android.libraries.navigation.internal.abh;

import android.content.Context;
import com.google.android.datatransport.BuildConfig;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ic extends com.google.android.libraries.navigation.internal.wd.e {
    private static final String f = "ic";
    private final com.google.android.libraries.navigation.internal.wx.c g;

    public ic(Context context, com.google.android.libraries.navigation.internal.ky.o oVar, com.google.android.libraries.navigation.internal.wx.c cVar) {
        super(context, com.google.android.libraries.navigation.internal.zp.ax.b, BuildConfig.VERSION_NAME, oVar);
        this.g = cVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.wd.e
    public final com.google.android.libraries.navigation.internal.zp.ar g(com.google.android.libraries.navigation.internal.abx.b bVar, int i, int i2) {
        com.google.android.libraries.navigation.internal.zp.ar arVarG = super.g(bVar, i, i2);
        if (com.google.android.libraries.navigation.internal.afu.g.c()) {
            try {
                String str = (String) this.g.a().get();
                if (!str.isEmpty()) {
                    com.google.android.libraries.navigation.internal.aeu.a aVar = (com.google.android.libraries.navigation.internal.aeu.a) com.google.android.libraries.navigation.internal.aeu.b.a.q();
                    if (!aVar.b.H()) {
                        aVar.v();
                    }
                    com.google.android.libraries.navigation.internal.aeu.b bVar2 = (com.google.android.libraries.navigation.internal.aeu.b) aVar.b;
                    str.getClass();
                    bVar2.b |= 4;
                    bVar2.c = str;
                    com.google.android.libraries.navigation.internal.aeu.b bVar3 = (com.google.android.libraries.navigation.internal.aeu.b) aVar.t();
                    if (!arVarG.b.H()) {
                        arVarG.v();
                    }
                    com.google.android.libraries.navigation.internal.zp.ay ayVar = (com.google.android.libraries.navigation.internal.zp.ay) arVarG.b;
                    com.google.android.libraries.navigation.internal.zp.ay ayVar2 = com.google.android.libraries.navigation.internal.zp.ay.a;
                    bVar3.getClass();
                    ayVar.x = bVar3;
                    ayVar.b |= 1073741824;
                }
            } catch (InterruptedException | ExecutionException unused) {
                com.google.android.libraries.navigation.internal.abf.p.f(f, 6);
            }
        }
        return arVarG;
    }

    @Override // com.google.android.libraries.navigation.internal.wd.e
    public final void i(final com.google.android.libraries.navigation.internal.zp.ay ayVar) {
        com.google.android.libraries.navigation.internal.me.w wVarA = ht.a();
        if (wVarA != null) {
            wVarA.j(new com.google.android.libraries.navigation.internal.me.u() { // from class: com.google.android.libraries.navigation.internal.abh.ib
                @Override // com.google.android.libraries.navigation.internal.me.u
                public final void d(Object obj) {
                    this.a.m(ayVar, (com.google.android.libraries.navigation.internal.mf.o) obj);
                }
            });
        }
    }

    public final /* synthetic */ void m(com.google.android.libraries.navigation.internal.zp.ay ayVar, com.google.android.libraries.navigation.internal.mf.o oVar) {
        if (oVar.a()) {
            super.i(ayVar);
        }
    }
}
