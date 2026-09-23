package com.google.android.libraries.navigation.internal.sd;

import androidx.mediarouter.media.MediaRouteProviderProtocol;
import com.google.android.libraries.navigation.internal.bp.bw;
import com.google.android.libraries.navigation.internal.db.y;
import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.al;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class b implements com.google.android.libraries.navigation.internal.ic.a {
    public final bw a;
    public final int b;
    public final int c;
    public final y d;
    public final long e;
    private final int f;

    public b(bw bwVar, int i, int i2, int i3, y yVar, long j) {
        this.a = bwVar;
        this.b = i;
        this.f = i2;
        this.c = i3;
        this.d = yVar;
        this.e = j;
    }

    @Override // com.google.android.libraries.navigation.internal.ic.a
    public final /* synthetic */ boolean a() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.ic.a
    public final /* synthetic */ boolean aj() {
        return false;
    }

    public final String toString() {
        ak akVarB = al.b(this);
        akVarB.g("guidance", this.a);
        ak akVarC = akVarB.c("metersToStep", this.b).c("stepMetersFromStart", this.f).c("furthestStepMetersFromEnd", this.c);
        akVarC.g("locationProbabilityBall", this.d);
        return akVarC.d(MediaRouteProviderProtocol.CLIENT_DATA_ROUTE_ID, this.e).toString();
    }
}
