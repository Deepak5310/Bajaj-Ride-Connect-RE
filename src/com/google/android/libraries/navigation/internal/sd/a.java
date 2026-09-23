package com.google.android.libraries.navigation.internal.sd;

import androidx.mediarouter.media.MediaRouteProviderProtocol;
import com.google.android.libraries.navigation.internal.bp.bw;
import com.google.android.libraries.navigation.internal.db.y;
import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.al;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class a implements com.google.android.libraries.navigation.internal.ic.a {
    public final bw a;
    public final int b;
    public final y c;
    public final long d;

    public a(bw bwVar, int i, y yVar, long j) {
        this.a = bwVar;
        this.b = i;
        this.c = yVar;
        this.d = j;
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
        ak akVarC = akVarB.c("metersFromGuidanceEventToStep", this.b);
        akVarC.g("locationProbabilityBall", this.c);
        return akVarC.d(MediaRouteProviderProtocol.CLIENT_DATA_ROUTE_ID, this.d).toString();
    }
}
