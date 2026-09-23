package com.google.android.libraries.navigation.internal.cv;

import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.mq;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public interface c {
    public static final fd h;

    static {
        ez ezVar = new ez();
        ezVar.f(a.TRAFFIC, fy.r(a.BICYCLING, a.TERRAIN, a.TRANSIT));
        ezVar.f(a.TRANSIT, fy.r(a.BICYCLING, a.TERRAIN, a.TRAFFIC));
        ezVar.f(a.BICYCLING, fy.q(a.TRAFFIC, a.TRANSIT));
        ezVar.f(a.SATELLITE, new mq(a.TERRAIN));
        ezVar.f(a.TERRAIN, fy.r(a.TRAFFIC, a.TRANSIT, a.SATELLITE));
        h = ezVar.d();
    }

    boolean b(a aVar);

    void c(e eVar);

    @Deprecated
    void d(a aVar, boolean z);
}
