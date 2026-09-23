package com.google.android.libraries.navigation.internal.sg;

import com.google.android.libraries.navigation.internal.agh.ea;
import com.google.android.libraries.navigation.internal.agh.eb;
import com.google.android.libraries.navigation.internal.agh.ec;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static final a a;
    private final ea b;

    static {
        eb ebVar = ec.a;
        Intrinsics.checkNotNullExpressionValue(ebVar, "emptyMap(...)");
        a = new a(ebVar);
    }

    public a(ea laneAwareRoutePolylineMap) {
        Intrinsics.checkNotNullParameter(laneAwareRoutePolylineMap, "laneAwareRoutePolylineMap");
        this.b = laneAwareRoutePolylineMap;
    }

    public final com.google.android.libraries.navigation.internal.be.a a() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && Intrinsics.areEqual(this.b, ((a) obj).b);
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "LaneAwarePolylineChangedEvent(laneAwareRoutePolylineMap=" + this.b + ")";
    }
}
