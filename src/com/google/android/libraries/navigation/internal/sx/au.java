package com.google.android.libraries.navigation.internal.sx;

import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bh;
import com.google.android.libraries.navigation.internal.zr.cu;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class au implements com.google.android.libraries.navigation.internal.yx.aa {
    @Override // com.google.android.libraries.navigation.internal.yx.aa
    public final /* synthetic */ Object ak(Object obj) {
        com.google.android.libraries.navigation.internal.tq.a aVar = (com.google.android.libraries.navigation.internal.tq.a) obj;
        if (aVar.b != cu.OKAY) {
            ar arVar = new ar();
            arVar.a = com.google.android.libraries.navigation.internal.adr.at.NO_ROUTES_FOUND;
            arVar.d = aVar.b;
            return new as(arVar);
        }
        ar arVar2 = new ar();
        arVar2.a = com.google.android.libraries.navigation.internal.adr.at.SUCCESS;
        bg bgVar = aVar.a;
        com.google.android.libraries.navigation.internal.yx.ar.q(bgVar);
        arVar2.b = bh.g(bgVar);
        arVar2.d = aVar.b;
        return new as(arVar2);
    }
}
