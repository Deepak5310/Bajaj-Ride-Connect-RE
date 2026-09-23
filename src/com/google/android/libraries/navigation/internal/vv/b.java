package com.google.android.libraries.navigation.internal.vv;

import com.google.android.libraries.navigation.internal.bp.ck;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public final ck a;
    public final List b;

    public b(ck ckVar, List list) {
        this.a = ckVar;
        this.b = list;
        ar.b(!list.isEmpty(), "A RouteSegment must contain at least one LatLng");
    }
}
