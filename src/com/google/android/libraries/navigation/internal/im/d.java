package com.google.android.libraries.navigation.internal.im;

import com.google.android.libraries.navigation.internal.afr.j;
import com.google.android.libraries.navigation.internal.fw.l;
import com.google.android.libraries.navigation.internal.fw.m;
import com.google.android.libraries.navigation.internal.yz.fw;
import com.google.android.libraries.navigation.internal.yz.fy;
import io.grpc.internal.GrpcUtil;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.agl.a c;

    public d(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        ((m) this.a).a();
        ((com.google.android.libraries.navigation.internal.gi.b) this.b).a();
        Set set = (Set) ((com.google.android.libraries.navigation.internal.afr.g) this.c).a;
        fw fwVar = new fw();
        fwVar.c(c.a(com.google.android.libraries.navigation.internal.gi.a.b("https://mobilemaps-pa.googleapis.com:443")));
        fwVar.c(c.a(l.b()));
        fwVar.c(new com.google.android.libraries.navigation.internal.aag.c("any.googlevideo.com", GrpcUtil.DEFAULT_PORT_SSL, GrpcUtil.DEFAULT_PORT_SSL));
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            fwVar.c(com.google.android.libraries.navigation.internal.aag.l.d((String) it2.next()));
        }
        fy fyVarI = fwVar.i();
        j.d(fyVarI);
        return fyVarI;
    }
}
