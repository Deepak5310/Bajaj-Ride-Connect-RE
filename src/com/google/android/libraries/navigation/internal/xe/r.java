package com.google.android.libraries.navigation.internal.xe;

import com.google.android.libraries.navigation.internal.adr.hs;
import com.google.android.libraries.navigation.internal.adr.hu;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class r extends o {
    private final hu d;

    public r(com.google.android.libraries.navigation.internal.aap.l lVar, hs hsVar, hu huVar, int i) {
        super(com.google.android.libraries.navigation.internal.aap.l.ROUNDABOUT_ENTER_AND_EXIT, hsVar, i);
        this.d = huVar;
        this.a = lVar;
    }

    @Override // com.google.android.libraries.navigation.internal.xe.o
    public final boolean a(com.google.android.libraries.navigation.internal.bp.bq bqVar) {
        com.google.android.libraries.navigation.internal.aap.l lVar = bqVar.d;
        if (lVar == com.google.android.libraries.navigation.internal.aap.l.ROUNDABOUT_EXIT) {
            return lVar == this.a;
        }
        return lVar == this.a && bqVar.f == this.d && bqVar.e == this.b;
    }

    public r(hs hsVar, hu huVar, int i) {
        this(com.google.android.libraries.navigation.internal.aap.l.ROUNDABOUT_ENTER_AND_EXIT, hsVar, huVar, i);
    }
}
