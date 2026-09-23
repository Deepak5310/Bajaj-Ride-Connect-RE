package com.google.android.libraries.navigation.internal.afx;

import com.mappls.sdk.navigation.util.SavingTrackHelper;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class af {
    public final String a;
    public final ae b;
    public final long c;
    public final al d;
    public final al e;

    public af(String str, ae aeVar, long j, al alVar) {
        this.a = str;
        com.google.android.libraries.navigation.internal.yx.ar.r(aeVar, "severity");
        this.b = aeVar;
        this.c = j;
        this.d = null;
        this.e = alVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof af) {
            af afVar = (af) obj;
            if (com.google.android.libraries.navigation.internal.yx.am.a(this.a, afVar.a) && com.google.android.libraries.navigation.internal.yx.am.a(this.b, afVar.b) && this.c == afVar.c) {
                al alVar = afVar.d;
                if (com.google.android.libraries.navigation.internal.yx.am.a(null, null) && com.google.android.libraries.navigation.internal.yx.am.a(this.e, afVar.e)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, Long.valueOf(this.c), null, this.e});
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        akVarB.g(SavingTrackHelper.POINT_COL_DESCRIPTION, this.a);
        akVarB.g("severity", this.b);
        com.google.android.libraries.navigation.internal.yx.ak akVarD = akVarB.d("timestampNanos", this.c);
        akVarD.g("channelRef", null);
        akVarD.g("subchannelRef", this.e);
        return akVarD.toString();
    }
}
