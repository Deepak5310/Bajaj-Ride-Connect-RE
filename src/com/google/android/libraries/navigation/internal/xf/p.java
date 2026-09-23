package com.google.android.libraries.navigation.internal.xf;

import android.content.Context;
import com.adobe.internal.xmp.options.PropertyOptions;
import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.ky.aw;
import com.google.android.libraries.navigation.internal.yx.aq;
import com.google.android.libraries.navigation.internal.zp.ar;
import com.google.android.libraries.navigation.internal.zp.ay;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class p implements com.google.android.libraries.navigation.internal.wd.g {
    private static final com.google.android.libraries.navigation.internal.zb.j b = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.xf.p");
    public final com.google.android.libraries.navigation.internal.wd.e a;
    private final com.google.android.libraries.navigation.internal.xh.c c;
    private final com.google.android.libraries.navigation.internal.wx.c d;
    private final Executor e;

    public p(Context context, int i, com.google.android.libraries.navigation.internal.ky.p pVar, com.google.android.libraries.navigation.internal.xh.c cVar, com.google.android.libraries.navigation.internal.wx.c cVar2, Executor executor) {
        Context applicationContext = context.getApplicationContext();
        List list = com.google.android.libraries.navigation.internal.ky.o.o;
        this.a = new com.google.android.libraries.navigation.internal.wd.e(context, i, "6.1.0", ((com.google.android.libraries.navigation.internal.ky.l) ((com.google.android.libraries.navigation.internal.ky.l) new com.google.android.libraries.navigation.internal.ky.l(applicationContext, "MAPS_API").b(aw.b)).a(pVar)).d());
        this.c = cVar;
        this.d = cVar2;
        this.e = executor;
    }

    @Override // com.google.android.libraries.navigation.internal.wd.g
    public final com.google.android.libraries.navigation.internal.wd.f a(com.google.android.libraries.navigation.internal.abx.b bVar) {
        return b(bVar, null);
    }

    @Override // com.google.android.libraries.navigation.internal.wd.g
    public final com.google.android.libraries.navigation.internal.wd.f b(com.google.android.libraries.navigation.internal.abx.b bVar, String str) {
        o oVar = new o(this, bVar);
        this.a.h(oVar);
        return oVar;
    }

    @Override // com.google.android.libraries.navigation.internal.wd.g
    public final void c(com.google.android.libraries.navigation.internal.abx.b bVar) {
        this.a.c(bVar);
    }

    @Override // com.google.android.libraries.navigation.internal.wd.g
    public final void d() {
        this.a.d();
    }

    @Override // com.google.android.libraries.navigation.internal.wd.g
    public final void e() {
        this.a.j();
    }

    @Override // com.google.android.libraries.navigation.internal.wd.g
    public final void f(com.google.android.libraries.navigation.internal.abx.b bVar, int i) {
        g(this.a.g(bVar, i, 0));
    }

    public final void g(final ar arVar) {
        com.google.android.libraries.navigation.internal.xh.c cVar = this.c;
        final bj bjVarA = this.d.a();
        final bj bjVarB = cVar.b();
        az.a(bjVarA, bjVarB).b(new Runnable() { // from class: com.google.android.libraries.navigation.internal.xf.n
            @Override // java.lang.Runnable
            public final void run() {
                com.google.android.libraries.navigation.internal.xh.b bVar = (com.google.android.libraries.navigation.internal.xh.b) com.google.android.libraries.navigation.internal.ww.a.a(bjVarB, null);
                String str = (String) com.google.android.libraries.navigation.internal.ww.a.a(bjVarA, null);
                ar arVar2 = arVar;
                if (bVar != null && bVar.a() != 0) {
                    long jA = bVar.a();
                    if (!arVar2.b.H()) {
                        arVar2.v();
                    }
                    ay ayVar = (ay) arVar2.b;
                    ay ayVar2 = ay.a;
                    ayVar.b |= PropertyOptions.DELETE_EXISTING;
                    ayVar.w = jA;
                }
                if (!aq.c(str)) {
                    com.google.android.libraries.navigation.internal.aeu.a aVar = (com.google.android.libraries.navigation.internal.aeu.a) com.google.android.libraries.navigation.internal.aeu.b.a.q();
                    if (!aVar.b.H()) {
                        aVar.v();
                    }
                    com.google.android.libraries.navigation.internal.aeu.b bVar2 = (com.google.android.libraries.navigation.internal.aeu.b) aVar.b;
                    str.getClass();
                    bVar2.b |= 4;
                    bVar2.c = str;
                    com.google.android.libraries.navigation.internal.aeu.b bVar3 = (com.google.android.libraries.navigation.internal.aeu.b) aVar.t();
                    if (!arVar2.b.H()) {
                        arVar2.v();
                    }
                    ay ayVar3 = (ay) arVar2.b;
                    ay ayVar4 = ay.a;
                    bVar3.getClass();
                    ayVar3.x = bVar3;
                    ayVar3.b |= 1073741824;
                }
                this.a.a.i((ay) arVar2.t());
            }
        }, this.e);
    }
}
