package com.google.android.libraries.navigation.internal.fr;

import com.google.android.libraries.navigation.internal.acd.ml;
import com.google.maps.android.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    public final boolean a;
    public final int b;
    private final Integer c;

    public /* synthetic */ c(boolean z, int i, int i2) {
        this.a = z;
        this.b = (i2 & 2) != 0 ? 0 : i;
        this.c = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.a != cVar.a || this.b != cVar.b) {
            return false;
        }
        Integer num = cVar.c;
        return Intrinsics.areEqual((Object) null, (Object) null);
    }

    public final int hashCode() {
        int i = this.b;
        return (((true != this.a ? 1237 : 1231) * 31) + (i == 0 ? 0 : ml.a(i))) * 31;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ConnectivityState(connected=");
        sb.append(this.a);
        sb.append(", networkType=");
        int i = this.b;
        sb.append((Object) (i != 0 ? ml.toString$ar$edu$9bc04cb6_0(i) : BuildConfig.TRAVIS));
        sb.append(", downstreamBandwidthKbps=null)");
        return sb.toString();
    }
}
