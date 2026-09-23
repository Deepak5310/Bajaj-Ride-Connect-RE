package com.google.android.libraries.navigation.internal.gn;

import com.google.android.libraries.navigation.internal.gp.r;
import com.google.android.libraries.navigation.internal.xm.x;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yz.fd;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o {
    public final com.google.android.libraries.navigation.internal.afo.a a;
    public final j b;
    public final com.google.android.libraries.navigation.internal.afo.a c;
    public final r d;
    public final x e;
    public final com.google.android.libraries.navigation.internal.gl.c f;
    public final com.google.android.libraries.navigation.internal.xm.h g;
    public final AtomicBoolean h = new AtomicBoolean(true);
    public final AtomicBoolean i = new AtomicBoolean(false);

    public o(final com.google.android.libraries.navigation.internal.afo.a aVar, j jVar, com.google.android.libraries.navigation.internal.afo.a aVar2, r rVar, x xVar, com.google.android.libraries.navigation.internal.gl.c cVar, com.google.android.libraries.navigation.internal.xm.h hVar) {
        this.a = com.google.android.libraries.navigation.internal.ih.a.b(new br() { // from class: com.google.android.libraries.navigation.internal.gn.n
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return fd.j((Map) aVar.a());
            }
        });
        this.b = jVar;
        this.c = aVar2;
        this.d = rVar;
        this.e = xVar;
        this.f = cVar;
        this.g = hVar;
    }
}
