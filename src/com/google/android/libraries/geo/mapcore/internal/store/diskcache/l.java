package com.google.android.libraries.geo.mapcore.internal.store.diskcache;

import com.google.android.libraries.navigation.internal.afm.ai;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class l implements com.google.android.libraries.navigation.internal.qv.b {
    static final long a = TimeUnit.DAYS.toMillis(45);
    public final g b;
    private final com.google.android.libraries.navigation.internal.mj.a c;

    public l(g gVar, com.google.android.libraries.navigation.internal.mj.a aVar) {
        this.b = gVar;
        this.c = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qv.b
    public final void a(ai aiVar) {
        if (aiVar != null) {
            com.google.android.libraries.navigation.internal.dm.j jVar = (com.google.android.libraries.navigation.internal.dm.j) com.google.android.libraries.navigation.internal.dm.k.a.q();
            com.google.android.libraries.navigation.internal.dm.h hVar = (com.google.android.libraries.navigation.internal.dm.h) com.google.android.libraries.navigation.internal.dm.i.a.q();
            int i = com.google.android.libraries.navigation.internal.dm.m.a;
            if (!hVar.b.H()) {
                hVar.v();
            }
            com.google.android.libraries.navigation.internal.dm.i iVar = (com.google.android.libraries.navigation.internal.dm.i) hVar.b;
            if (i == 0) {
                throw null;
            }
            iVar.c = i;
            iVar.b |= 1;
            String str = aiVar.c;
            if (!hVar.b.H()) {
                hVar.v();
            }
            com.google.android.libraries.navigation.internal.dm.i iVar2 = (com.google.android.libraries.navigation.internal.dm.i) hVar.b;
            str.getClass();
            iVar2.b |= 2;
            iVar2.d = str;
            if (!jVar.b.H()) {
                jVar.v();
            }
            com.google.android.libraries.navigation.internal.dm.k kVar = (com.google.android.libraries.navigation.internal.dm.k) jVar.b;
            com.google.android.libraries.navigation.internal.dm.i iVar3 = (com.google.android.libraries.navigation.internal.dm.i) hVar.t();
            iVar3.getClass();
            kVar.c = iVar3;
            kVar.b |= 1;
            long epochMilli = this.c.f().toEpochMilli() + a;
            if (!jVar.b.H()) {
                jVar.v();
            }
            com.google.android.libraries.navigation.internal.dm.k kVar2 = (com.google.android.libraries.navigation.internal.dm.k) jVar.b;
            kVar2.b |= 8;
            kVar2.e = epochMilli;
            if (!jVar.b.H()) {
                jVar.v();
            }
            com.google.android.libraries.navigation.internal.dm.k kVar3 = (com.google.android.libraries.navigation.internal.dm.k) jVar.b;
            kVar3.b |= 2;
            kVar3.d = "";
            try {
                this.b.i((com.google.android.libraries.navigation.internal.dm.k) jVar.t(), aiVar.m());
            } catch (IOException unused) {
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1233)).p("Failed to insert resource:");
            }
        }
    }
}
