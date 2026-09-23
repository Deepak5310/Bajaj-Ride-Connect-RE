package com.google.android.libraries.navigation.internal.ck;

import com.google.android.libraries.navigation.internal.adg.da;
import com.google.android.libraries.navigation.internal.adg.db;
import com.google.android.libraries.navigation.internal.adg.fj;
import com.google.android.libraries.navigation.internal.adg.fk;
import com.google.android.libraries.navigation.internal.adg.fx;
import com.google.android.libraries.navigation.internal.adg.ga;
import com.google.android.libraries.navigation.internal.adg.ic;
import com.google.android.libraries.navigation.internal.adg.id;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p implements k {
    private final com.google.android.libraries.navigation.internal.ol.ax a;
    private final Lazy b;
    private final Lazy c;

    public p(com.google.android.libraries.navigation.internal.ol.ax styles) {
        Intrinsics.checkNotNullParameter(styles, "styles");
        this.a = styles;
        this.b = LazyKt.lazy(new l(this));
        this.c = LazyKt.lazy(new n(this));
        LazyKt.lazy(new m(this));
        LazyKt.lazy(new o(this));
    }

    public final com.google.android.libraries.navigation.internal.ol.aq b(boolean z) {
        fx fxVar = (fx) ga.a.q();
        da daVar = (da) db.a.q();
        if (!daVar.b.H()) {
            daVar.v();
        }
        db dbVar = (db) daVar.b;
        dbVar.b |= 1;
        dbVar.c = 0;
        fj fjVar = (fj) fk.a.q();
        if (!fjVar.b.H()) {
            fjVar.v();
        }
        int i = true != z ? 180001 : 180010;
        fk fkVar = (fk) fjVar.b;
        fkVar.b |= 4;
        fkVar.g = i;
        ic icVar = (ic) id.a.q();
        if (!icVar.b.H()) {
            icVar.v();
        }
        int i2 = true != z ? -9796649 : -15784203;
        id idVar = (id) icVar.b;
        idVar.b |= 1;
        idVar.c = i2;
        if (!icVar.b.H()) {
            icVar.v();
        }
        id idVar2 = (id) icVar.b;
        idVar2.b |= 8;
        idVar2.e = 72;
        fjVar.c(icVar);
        ic icVar2 = (ic) id.a.q();
        if (!icVar2.b.H()) {
            icVar2.v();
        }
        int i3 = true != z ? -4403461 : -15772673;
        id idVar3 = (id) icVar2.b;
        idVar3.b = 1 | idVar3.b;
        idVar3.c = i3;
        if (!icVar2.b.H()) {
            icVar2.v();
        }
        id idVar4 = (id) icVar2.b;
        idVar4.b |= 8;
        idVar4.e = 48;
        fjVar.c(icVar2);
        if (!daVar.b.H()) {
            daVar.v();
        }
        com.google.android.libraries.navigation.internal.ol.ax axVar = this.a;
        db dbVar2 = (db) daVar.b;
        fk fkVar2 = (fk) fjVar.t();
        fkVar2.getClass();
        dbVar2.f = fkVar2;
        dbVar2.b |= 8;
        fxVar.c(daVar);
        com.google.android.libraries.navigation.internal.ol.s sVarA = axVar.a((ga) fxVar.t());
        Intrinsics.checkNotNullExpressionValue(sVarA, "createMapStyle(...)");
        return sVarA;
    }

    public final com.google.android.libraries.navigation.internal.ol.aq c(boolean z) {
        fx fxVar = (fx) ga.a.q();
        da daVar = (da) db.a.q();
        if (!daVar.b.H()) {
            daVar.v();
        }
        db dbVar = (db) daVar.b;
        dbVar.b |= 1;
        dbVar.c = 0;
        fj fjVar = (fj) fk.a.q();
        if (!fjVar.b.H()) {
            fjVar.v();
        }
        int i = true != z ? 180001 : 180010;
        fk fkVar = (fk) fjVar.b;
        fkVar.b |= 4;
        fkVar.g = i;
        ic icVar = (ic) id.a.q();
        if (!icVar.b.H()) {
            icVar.v();
        }
        int i2 = true != z ? -6684775 : -16711936;
        id idVar = (id) icVar.b;
        idVar.b = 1 | idVar.b;
        idVar.c = i2;
        if (!icVar.b.H()) {
            icVar.v();
        }
        id idVar2 = (id) icVar.b;
        idVar2.b |= 8;
        idVar2.e = 24;
        fjVar.d((id) icVar.t());
        if (!daVar.b.H()) {
            daVar.v();
        }
        com.google.android.libraries.navigation.internal.ol.ax axVar = this.a;
        db dbVar2 = (db) daVar.b;
        fk fkVar2 = (fk) fjVar.t();
        fkVar2.getClass();
        dbVar2.f = fkVar2;
        dbVar2.b |= 8;
        fxVar.c(daVar);
        com.google.android.libraries.navigation.internal.ol.s sVarA = axVar.a((ga) fxVar.t());
        Intrinsics.checkNotNullExpressionValue(sVarA, "createMapStyle(...)");
        return sVarA;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.k
    public final com.google.android.libraries.navigation.internal.ol.aq a(boolean z) {
        return z ? (com.google.android.libraries.navigation.internal.ol.aq) this.b.getValue() : (com.google.android.libraries.navigation.internal.ol.aq) this.c.getValue();
    }
}
