package com.google.android.libraries.navigation.internal.abm;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.os.StrictMode;
import com.google.android.libraries.navigation.internal.abh.fv;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class aq {
    private static bm a;
    private static com.google.android.libraries.navigation.internal.ow.k b;

    public static synchronized com.google.android.libraries.navigation.internal.ow.k a(com.google.android.libraries.navigation.internal.abh.be beVar, com.google.android.libraries.navigation.internal.abh.m mVar, fv fvVar) {
        d(beVar);
        if (b == null) {
            c(beVar, mVar, fvVar);
        }
        return b;
    }

    public static synchronized bm b() {
        return a;
    }

    private static synchronized void c(com.google.android.libraries.navigation.internal.abh.be beVar, com.google.android.libraries.navigation.internal.abh.m mVar, fv fvVar) {
        StrictMode.ThreadPolicy threadPolicyC = com.google.android.libraries.navigation.internal.abf.w.a.c();
        if (com.google.android.libraries.navigation.internal.afu.m.a.a().a()) {
            com.google.android.libraries.navigation.internal.afr.k kVar = v.a;
            i iVar = new i();
            com.google.android.libraries.navigation.internal.afr.j.b(beVar);
            iVar.a = beVar;
            com.google.android.libraries.navigation.internal.afr.j.b(mVar);
            iVar.b = mVar;
            iVar.c = fvVar;
            com.google.android.libraries.navigation.internal.afr.j.a(iVar.a, com.google.android.libraries.navigation.internal.abh.be.class);
            com.google.android.libraries.navigation.internal.afr.j.a(iVar.b, com.google.android.libraries.navigation.internal.abh.m.class);
            com.google.android.libraries.navigation.internal.afr.j.a(iVar.c, fv.class);
            p pVar = new p(iVar.a, iVar.b, iVar.c);
            a = pVar;
            b = pVar;
        } else {
            Context baseContext = beVar.a;
            while (baseContext instanceof ContextWrapper) {
                baseContext = ((ContextWrapper) baseContext).getBaseContext();
            }
            Context applicationContext = baseContext.getApplicationContext();
            String packageName = beVar.a.getPackageName();
            Resources resourcesJ = beVar.j();
            com.google.android.libraries.navigation.internal.yx.an anVarJ = com.google.android.libraries.navigation.internal.yx.an.j(new b(mVar.g));
            com.google.android.libraries.navigation.internal.kk.f fVar = new com.google.android.libraries.navigation.internal.kk.f();
            g gVar = new g(beVar);
            com.google.android.libraries.navigation.internal.om.q qVar = mVar.i;
            Cdo cdo = new Cdo(fvVar);
            com.google.android.libraries.navigation.internal.ov.n nVar = new com.google.android.libraries.navigation.internal.ov.n(resourcesJ, gVar, qVar);
            com.google.android.libraries.navigation.internal.ov.al alVar = new com.google.android.libraries.navigation.internal.ov.al();
            com.google.android.libraries.navigation.internal.iv.n nVarB = com.google.android.libraries.navigation.internal.iv.n.B(applicationContext);
            com.google.android.libraries.navigation.internal.mk.c cVar = new com.google.android.libraries.navigation.internal.mk.c();
            com.google.android.libraries.navigation.internal.ni.b bVar = new com.google.android.libraries.navigation.internal.ni.b();
            com.google.android.libraries.navigation.internal.afr.k kVar2 = com.google.android.libraries.navigation.internal.ov.g.a;
            com.google.android.libraries.navigation.internal.ov.a aVar = new com.google.android.libraries.navigation.internal.ov.a();
            aVar.c = anVarJ;
            com.google.android.libraries.navigation.internal.afr.j.b(applicationContext);
            aVar.b = applicationContext;
            com.google.android.libraries.navigation.internal.afr.j.b(packageName);
            aVar.a = packageName;
            aVar.d = fVar;
            aVar.f = nVar;
            aVar.e = alVar;
            aVar.g = nVarB;
            aVar.j = new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.ov.j
                @Override // com.google.android.libraries.navigation.internal.yx.br
                public final Object a() {
                    return com.google.android.libraries.navigation.internal.yx.a.a;
                }
            };
            aVar.h = cVar;
            aVar.i = bVar;
            aVar.k = com.google.android.libraries.navigation.internal.yx.an.i(cdo);
            com.google.android.libraries.navigation.internal.afr.j.a(aVar.a, String.class);
            com.google.android.libraries.navigation.internal.afr.j.a(aVar.b, Context.class);
            com.google.android.libraries.navigation.internal.afr.j.a(aVar.c, com.google.android.libraries.navigation.internal.yx.an.class);
            com.google.android.libraries.navigation.internal.afr.j.a(aVar.d, com.google.android.libraries.navigation.internal.kl.b.class);
            com.google.android.libraries.navigation.internal.afr.j.a(aVar.e, com.google.android.libraries.navigation.internal.ov.al.class);
            com.google.android.libraries.navigation.internal.afr.j.a(aVar.f, com.google.android.libraries.navigation.internal.ov.n.class);
            com.google.android.libraries.navigation.internal.afr.j.a(aVar.g, com.google.android.libraries.navigation.internal.iv.f.class);
            com.google.android.libraries.navigation.internal.afr.j.a(aVar.h, com.google.android.libraries.navigation.internal.mj.e.class);
            com.google.android.libraries.navigation.internal.afr.j.a(aVar.i, com.google.android.libraries.navigation.internal.ni.a.class);
            com.google.android.libraries.navigation.internal.afr.j.a(aVar.j, com.google.android.libraries.navigation.internal.yx.br.class);
            com.google.android.libraries.navigation.internal.afr.j.a(aVar.k, com.google.android.libraries.navigation.internal.yx.an.class);
            b = new com.google.android.libraries.navigation.internal.ov.b(aVar.f, aVar.e, aVar.a, aVar.b, aVar.c, aVar.d, aVar.g, aVar.h, aVar.i, aVar.j, aVar.k);
        }
        com.google.android.libraries.navigation.internal.afu.d.a.a().F();
        com.google.android.libraries.navigation.internal.abf.w.a.d(threadPolicyC);
    }

    private static synchronized void d(com.google.android.libraries.navigation.internal.abh.be beVar) {
        if (b == null) {
            try {
                b = (com.google.android.libraries.navigation.internal.ow.k) Class.forName("com.google.android.libraries.navigation.environment.NavApiEnvironmentManager").getMethod("getOrCreate", Application.class).invoke(null, com.google.android.libraries.navigation.internal.abf.b.a(beVar.a));
            } catch (ReflectiveOperationException unused) {
            }
        }
    }
}
