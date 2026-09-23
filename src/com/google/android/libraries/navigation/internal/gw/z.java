package com.google.android.libraries.navigation.internal.gw;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Picture;
import com.google.android.libraries.navigation.internal.yx.br;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class z {
    private final u a;

    public z(u uVar) {
        this.a = uVar;
    }

    public final Picture a(final Resources resources, final int i) {
        Object objA;
        br brVar = new br() { // from class: com.google.android.libraries.navigation.internal.gw.y
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                g gVar = new g(resources, i);
                com.google.android.libraries.navigation.internal.afn.e eVar = new com.google.android.libraries.navigation.internal.afn.e();
                eVar.b();
                eVar.a = gVar.a.openRawResource(gVar.b);
                eVar.b = true;
                return eVar.a().a;
            }
        };
        c cVar = new c(new Configuration(resources.getConfiguration()), i);
        u uVar = this.a;
        synchronized (uVar.a) {
            objA = (Picture) uVar.a.f(cVar);
            if (objA == null) {
                objA = (Picture) uVar.c.b(cVar);
                if (objA == null) {
                    objA = brVar.a();
                }
                uVar.a.m(cVar, objA);
            }
            uVar.c.c(cVar, objA);
        }
        return (Picture) objA;
    }
}
